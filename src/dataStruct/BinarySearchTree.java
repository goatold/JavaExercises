package dataStruct;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree<T> {
	private Comparable<T> data;
	private BinarySearchTree<T> left;
	private BinarySearchTree<T> right;

	public BinarySearchTree(){
		this.data = null;
		this.left = null;
		this.right = null;
	}

	public void remove(Comparable<T> data) {
		if (data == null || this.data == null) return;
		int comp = this.data.compareTo((T)data);
		if (comp == 0) {
			if (left == null && right == null) { 
				this.data = null;
				return;
			}
			if (left == null) {
				this.data = right.data;
				this.left = right.left;
				this.right = right.right;
			} else if (right == null) {
				this.data = left.data;
				this.right = left.right;
				this.left = left.left;
			} else {
				// find max on left
				BinarySearchTree<T> max = left;
				BinarySearchTree<T> maxParent = null;
				while (max != null && max.right != null) {
					maxParent = max;
					max = max.right;
				}
				this.data = max.data;
				if (maxParent == null) {
					left = max.left;
				} else {
					maxParent.right = max.left;
				}
			}
		} else if (comp > 0 ) {
			if (this.left == null) return;
			this.left.remove(data);
			if (left.data == null) left = null;
		} else if (comp < 0 ) {
			if (this.right == null) return;
			this.right.remove(data);
			if (right.data == null) right = null;
		}
	}
	
	public void add(Comparable<T> data) {
		if (data == null) return;
		if (this.data == null ) {
			this.data = data;
		} else {
			int comp =this.data.compareTo((T)data);
			if (comp > 0) {
				if (this.left == null) this.left = new BinarySearchTree();
				this.left.add(data);
			} else if (comp < 0) {
				if (this.right == null) this.right = new BinarySearchTree();
				this.right.add(data);
			} else if (comp == 0) {
				this.data = data;
			}
		}
	}
	
	public boolean isBST() {
		return (left == null && right == null) ||
				(left == null && right.data.compareTo((T)data) > 0 && right.isBST()) ||
				(right == null && left.data.compareTo((T)data) < 0 && left.isBST()) ||
				(left.data.compareTo((T)data) < 0 && left.isBST() && right.data.compareTo((T)data) > 0 && right.isBST());
	}
	
	public void visit() {
		if (data == null) {
			System.out.printf("Null node\n");
		} else {
			System.out.printf("node class:%s, data: %s\n", data.getClass(), data.toString());
		}
	}
	
	public void levelOrderTraverse() {
		Queue<BinarySearchTree> q = new LinkedList<BinarySearchTree>();
		if (this.data == null) return;
		q.add(this);
		while(!q.isEmpty()) {
			BinarySearchTree current = q.remove();
			current.visit();
			if (current.left != null) q.add(current.left);
			if (current.right != null) q.add(current.right);
		}
	}

	public void preOrderTraverse() {
		if (this.data == null) return;
		visit();
		if (left != null) left.preOrderTraverse();
		if (right != null) right.preOrderTraverse();
	}

	public void inOrderTraverse() {
		if (this.data == null) return;
		if (left != null) left.inOrderTraverse();
		visit();
		if (right != null) right.inOrderTraverse();
	}

	public void postOrderTraverse() {
		if (this.data == null) return;
		if (left != null) left.postOrderTraverse();
		if (right != null) right.postOrderTraverse();
		visit();
	}

	/**
	 * @return the data
	 */
	public Comparable<T> getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(Comparable<T> data) {
		this.data = data;
	}

	/**
	 * @return the left
	 */
	public BinarySearchTree<T> getLeft() {
		return left;
	}

	/**
	 * @param left the left to set
	 */
	public void setLeft(BinarySearchTree<T> left) {
		this.left = left;
	}

	/**
	 * @return the right
	 */
	public BinarySearchTree<T> getRight() {
		return right;
	}

	/**
	 * @param right the right to set
	 */
	public void setRight(BinarySearchTree<T> right) {
		this.right = right;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinarySearchTree<Integer> bsti = new BinarySearchTree<Integer>();
		bsti.add(5);
		bsti.add(9);
		bsti.add(3);
		System.out.printf("BST: root %d, left %d, right %d\n", bsti.getData(), bsti.getLeft().getData(), bsti.getRight().getData());
		System.out.printf("is BST? %s\n", bsti.isBST());
		BinarySearchTree<Character> bsts = new BinarySearchTree<Character>();
		bsts.add('j');
		bsts.add('c');
		bsts.add('n');
		bsts.add('f');
		bsts.add('i');
		bsts.add('g');
		bsts.add('x');
		bsts.add('s');
		bsts.add('h');
		bsts.add('l');
		bsts.add('e');
		bsts.add('d');
		bsts.add('b');
/*
		System.out.printf("is BST? %s\n", bsts.isBST());
		System.out.printf("BST: level order traversal\n");
		bsts.levelOrderTraverse();
		System.out.printf("BST: preorder traversal\n");
		bsts.preOrderTraverse();
		System.out.printf("BST: postorder traversal\n");
		bsts.postOrderTraverse();
*/
		System.out.printf("BST: inorder traversal\n");
		bsts.inOrderTraverse();
		bsts.remove('j');
		System.out.printf("remove j\n");
		bsts.inOrderTraverse();

		bsts.remove('x');
		System.out.printf("remove x\n");
		bsts.inOrderTraverse();
		bsts.remove('d');
		System.out.printf("remove d\n");
		bsts.inOrderTraverse();
		bsts.remove('i');
		System.out.printf("remove i\n");
		bsts.inOrderTraverse();
		bsts.remove('b');
		System.out.printf("remove b\n");
		bsts.inOrderTraverse();
}

}
