import java.util.Random;
public class GuitarString{
	RingQueue myQueue;
	Random myRandom = new Random();
	int time = 0;
	int length;
	final float decay = .994;
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

	void tic(){

		myQueue.enqueue(decay*(myQueue.dequque()+myQueue.peek())/2);
		time++;

	}

	double sample(){

		return myQueue.peek();

	}

	int time(){

		return time;

	}


}

