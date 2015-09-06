package dataStruct;

/**
 * This class implements Priority Queue based on a Singly linked list 
 * 
 */

public class PrioQueue {
	private prioQslnkNode head;
	private int size;

	/**
	 * initialize empty queue
	 */
	public PrioQueue() {
		head = null;
		size = 0;
	}

	public int size() {
		return size;
	}

	/*
	 * add new node in front of the queue (head of the singly linked list)
	 */
	public void add(Object data, int priority) {
		prioQslnkNode n = new prioQslnkNode(data, priority, head);
		head = n;
		size++;
	}

	/*
	 * delete the last node with minimum priority in queue and return the data
	 */
	public Object deleteMin() {
		// return null is queue is empty
		if (head == null)
			return null;
		// return the only item in queue
		if (head.getNext() == null) {
			size = 0;
			head = null;
			return head.getData();
		}
		// cursor that refers to the current node in the list while looping 
		prioQslnkNode curr = head.getNext();
		// save the previous node, so we can delete the current node
		prioQslnkNode pre = head;
		// start to check from head 
		prioQslnkNode n = head;
		prioQslnkNode npre = null;
		// loop through the linked list
		while (curr != null) {
			if (curr.getPriority() <= n.getPriority()) {
				npre = pre;
				n = curr;
			}
			pre = curr;
			curr = curr.getNext();
		}
		// delete the node from the list
		if (n == head) {
			head = n.getNext();
		} else {
			npre.setNext(n.getNext());
		}
		size--;
		return n.getData();
	}

	/*
	 * print the entire queue
	 */
	public void printQue() {
		if (head == null) {
			System.out.printf("Empty Queue\n");
			return;
		} else {
			System.out.printf("Queue size: %d\n", size);
		}
		prioQslnkNode curr = head;
		while (curr != null) {
			System.out.printf("pri: %d, data: %s\n", curr.getPriority(), curr
					.getData().toString());
			curr = curr.getNext();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PrioQueue pq = new PrioQueue();
		pq.printQue();
		pq.add("a1", 2);
		pq.add("a2", 2);
		pq.add("a3", 2);
		pq.add("a4", 1);
		pq.add("a5", 1);
		pq.add("a6", 0);
		pq.printQue();
		System.out.printf("delete %s from queue\n", pq.deleteMin());
		System.out.printf("delete %s from queue\n", pq.deleteMin());
		System.out.printf("delete %s from queue\n", pq.deleteMin());
		System.out.printf("delete %s from queue\n", pq.deleteMin());
		pq.printQue();
	}

}
