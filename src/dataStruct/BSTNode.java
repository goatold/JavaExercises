package dataStruct;

public class BSTNode<T extends Comparable<T>> {
	private T data;
	private BSTNode<T> left;
	private BSTNode<T> right;

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

	public void visit() {
		if (data == null) {
			System.out.printf("Null data\n");
		} else {
			System.out.printf("data class:%s, data: %s\n", data.getClass(),
					data.toString());
		}
	}
}
