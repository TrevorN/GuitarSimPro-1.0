import java.util.Random;
public class GuitarString{
	RingQueue myQueue;
	Random myRandom = new Random();
	int length;
	GuitarString(double freq){
		length = freq/44100;
		myQueue = new RingQueue(length);
		
		for(int i = 0; i < length; i++){
			myQueue.enqueue(0);
		}

	}

	void pluck(){

		for(int i = 0; i < length; i++){

			myQueue.enqueue(myRandom.nextFloat()-.5);

		}

	}

}

