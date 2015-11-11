package dataStruct;
import java.util.Random;
public class RandomQueue {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RandomQueue rq = new RandomQueue(32);
		rq.add('a');
		rq.add('b');
		rq.add('c');
		rq.add('d');
		rq.add('e');
		rq.add('f');
		rq.add('g');
		rq.add('h');
		System.out.printf("delete %s from queue\n", rq.remove());
		System.out.printf("delete %s from queue\n", rq.remove());
		System.out.printf("delete %s from queue\n", rq.remove());
		System.out.printf("delete %s from queue\n", rq.remove());
		System.out.printf("delete %s from queue\n", rq.remove());
		System.out.printf("delete %s from queue\n", rq.remove());
		System.out.printf("delete %s from queue\n", rq.remove());
		System.out.printf("delete %s from queue\n", rq.remove());
	}
	private int size;
	private int capacity;
	private Object[] items;
	private Random rand;
	
	public RandomQueue(int cap) {
		if (cap <= 0) throw new RuntimeException("Invalid Capacity!");
		size = 0;
		capacity = cap;
		items = new Object[cap];
		rand = new Random();
	}
	public void add(Object o) {
		if (size >= capacity) throw new RuntimeException ("Capacity Exceeded!");
		items[size] = o;
		size++;
	}
	public Object remove() {
		if (size <= 0) throw new RuntimeException ("Empty Queue!");
		int i = rand.nextInt(size);
		Object rt = items[i]; 
		if (i != size-1) items[i] = items[size-1];
		size--;
		return rt;
	}

}
