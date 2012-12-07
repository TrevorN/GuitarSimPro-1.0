import java.util.Random;
public class GuitarString{
	RingBuffer myBuffer;
	Random myRandom = new Random();
	int time = 0;
	int length;
	final double decay = (double) 0.994;
	GuitarString(double freq){
		length = (int) (44100.0/freq);
		myBuffer = new RingBuffer(length);
		
		for(int i = 0; i < length; i++){
			myBuffer.enqueue(0);
		}

	}

	void pluck(){

		for(int i = 0; i < length; i++){

			myBuffer.enqueue(myRandom.nextFloat()-.5);

		}

	}

	void tic(){

		double a = myBuffer.dequeue();
		double b = myBuffer.peek();
		myBuffer.enqueue((decay*0.5)*(a+b));
		time++;

	}

	double sample(){

		return myBuffer.peek();

	}

	int time(){

		return time;

	}


}

