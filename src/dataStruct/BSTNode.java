package dataStruct;

public class BSTNode<T extends Comparable<T>> {
	private T data;
	private BSTNode<T> left;
	private BSTNode<T> right;
	private int preOrderNub;

	public int getPreOrderNub() {
		return preOrderNub;
	}

	public void setPreOrderNub(int preOrderNub) {
		this.preOrderNub = preOrderNub;
	}

	public BSTNode(T data) {
		super();
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public BSTNode<T> getLeft() {
		return left;
	}

	public void setLeft(BSTNode<T> left) {
		this.left = left;
	}

	public BSTNode<T> getRight() {
		return right;
	}

	public void setRight(BSTNode<T> right) {
		this.right = right;
	}

	public int compareTo(T data) {
		return this.data.compareTo(data);
	}
}
