package dataStruct;

/**
 * This class implements Singly linked list node for Priority Queue
 * 
 */
public class prioQslnkNode {
	private Object data;
	private int priority;
	private prioQslnkNode next;

	/**
	 * @param data
	 * @param priority
	 * @param next
	 */
	public prioQslnkNode(Object data, int priority, prioQslnkNode next) {
		this.data = data;
		this.priority = priority;
		this.next = next;
	}

	/**
	 * @return the data
	 */
	public Object getData() {
		return data;
	}

	/**
	 * @param data
	 *            the data to set
	 */
	public void setData(Object data) {
		this.data = data;
	}

	/**
	 * @return the priority
	 */
	public int getPriority() {
		return priority;
	}

	/**
	 * @param priority
	 *            the priority to set
	 */
	public void setPriority(int priority) {
		this.priority = priority;
	}

	/**
	 * @return the next
	 */
	public prioQslnkNode getNext() {
		return next;
	}

	/**
	 * @param next
	 *            the next to set
	 */
	public void setNext(prioQslnkNode next) {
		this.next = next;
	}
}
