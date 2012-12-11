
class GuitarHeroLite {
	public static void main(String[] args) {

		// create two guitar strings, for concert A and C
		GuitarString[] strings = new GuitarString[37];
		String keys = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";

		for(int i = 0; i < 37; i++)
		{
			double thing = (880.0 - 110.0) / 36.0;
			strings[i] = new GuitarString((int) 110 + (thing * i));
		}

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

			// advance the simulation of each guitar string by one step.
			for(int i = 0; i < 37; i++)
			{
				strings[i].tic();
			}
		}
	}
}
