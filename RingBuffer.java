public class RingBuffer
{
	
	private double[] buffy;
	private int size;
	private int first;
	private int last;

	public RingBuffer(int capactity)
	{
		buffy = new double[capactity];
		size = capactity;
		first = capacity - 1;
		last = 0;
	}

	boolean isEmpty()
	{
		if(first + 1 % size = last)
		{
			return true;
		}

		return false;
	}

	void enqueue(double x)
	{
		buffy[last] = x;
		last = last++ % size;
	}

	void dequeue()
	{
		double ret = buffy[first];
		buffy[first] = 0;
		first = first++ % size;
		return ret;
	}
