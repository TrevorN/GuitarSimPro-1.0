class GuitarHeroLite {
	public static void main(String[] args) {

		// create two guitar strings, for concert A and C
		int visWidth = 500;
		GuitarString[] strings = new GuitarString[37];
		String keys = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";

		StdDraw.setCanvasSize(visWidth, 120);
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.setXscale(0, visWidth);
		StdDraw.setYscale(-1.2, 1.2);
		RingBuffer buffy = new RingBuffer(visWidth);

		for(int i = 0; i < 37; i++)
		{
			double thing = (880.0 - 110.0) / 36.0;
			strings[i] = new GuitarString((int) 110 + (thing * i));
		}

		Drawer draw = new Drawer(buffy, visWidth);

		draw.start();

		while (true) {

			// check if the user has typed a key; if so, process it   
			if (StdDraw.hasNextKeyTyped()) {
				char key = StdDraw.nextKeyTyped();
				int index = keys.indexOf(key);

				if(index != -1)
				{
					strings[index].pluck();
				}
			}

			// compute the superposition of samples
			double sample = 0;
			for(int i = 0; i < 37; i++)
			{
				sample += strings[i].sample();
			}

			// play the sample on standard audio
			StdAudio.play(sample);
			buffy.enqueue(sample);

			// advance the simulation of each guitar string by one step.
			for(int i = 0; i < 37; i++)
			{
				strings[i].tic();
			}
		}
	}
}

class Drawer extends Thread
{

	RingBuffer read;
	double [] xVals;

	public Drawer(RingBuffer source, int wid)
	{
		read = source;
		xVals = new double[wid];
		for(int i = 0; i < wid; i++)
		{
			xVals[i] = i;
		}
	}

	public void run()
	{
		while(true)
		{
			StdDraw.setPenColor(StdDraw.WHITE);
			StdDraw.filledRectangle(0, 0, 999, 5);
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.polyline(xVals, read.toArray());
			StdDraw.show();
			StdDraw.hide();
		}
	}

}
