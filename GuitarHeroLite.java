
class GuitarHeroLite {
	public static void main(String[] args) {

		// create two guitar strings, for concert A and C
		double CONCERT_A = 440.0;
		double CONCERT_C = CONCERT_A * Math.pow(1.05956, 3.0);
		GuitarString[] strings = new GuitarString[37];
		String keys = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";

		for(int i = 0; i < 37; i++)
		{
			double thing = (880 - 110)/37;

		while (true) {

			// check if the user has typed a key; if so, process it   
			if (StdDraw.hasNextKeyTyped()) {
				char key = StdDraw.nextKeyTyped();
				if      (key == 'a') { stringA.pluck(); }
				else if (key == 'c') { stringC.pluck(); }
			}

			// compute the superposition of samples
			double sample = stringA.sample() + stringC.sample();

			// play the sample on standard audio
			StdAudio.play(sample);

			// advance the simulation of each guitar string by one step   
			stringA.tic();
			stringC.tic();
		}
	}
}
