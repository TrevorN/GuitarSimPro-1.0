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
		first = capactity - 1;
		last = 0;
	}

	public void enqueue(double x)
	{
		buffy[last] = x;
		last = last++ % size;
	}

	public double dequeue()
	{
		double ret = buffy[first];
		buffy[first] = 0;
		first = first++ % size;
		return ret;
	}

	public double peek()
	{
		return buffy[first];
	}
}
