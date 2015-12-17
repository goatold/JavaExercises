package dataStruct;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree<T extends Comparable<T>> {
	private BSTNode<T> root;

	public BinarySearchTree() {
		this.root = null;
	}

	public BSTNode<T> getRoot() {
		return root;
	}

	public void remove(T data) {
		root = remove(root, data);
	}

	private BSTNode<T> remove(BSTNode<T> root, T data) {
		if (root == null)
			return null;
		int comp = root.compareTo(data);
		if (comp == 0) {
			if (root.getLeft() == null)
				return root.getRight();
			if (root.getRight() == null)
				return root.getLeft();
			// find max on left. assuming this tree is in order
			BSTNode<T> max = root.getLeft();
			BSTNode<T> maxParent = root;
			while (max != null && max.getRight() != null) {
				maxParent = max;
				max = max.getRight();
			}
			// swap max to root
			root.setData(max.getData());
			if (maxParent == root) {
				root.setLeft(max.getLeft());
			} else {
				maxParent.setRight(max.getLeft());
			}
		} else if (comp > 0) {
			root.setLeft(remove(root.getLeft(), data));
		} else if (comp < 0) {
			root.setRight(remove(root.getRight(), data));
		}
		return root;
	}

	public void add(T data) {
		root = add(this.root, data);
	}

	private BSTNode<T> add(BSTNode<T> root, T data) {
		if (data == null)
			return root;
		if (root == null) {
			return new BSTNode<T>(data);
		} else {
			int comp = root.getData().compareTo(data);
			if (comp > 0) {
				root.setLeft(add(root.getLeft(), data));
			} else if (comp < 0) {
				root.setRight(add(root.getRight(), data));
			}
		}
		return root;
	}

	public boolean isBST() {
		return isBST(root, null, null);
	}

	private boolean isBST(BSTNode<T> root, T min, T max) {
		if (root == null)
			return true;
		if (min != null && root.getData().compareTo(min) <= 0)
			return false;
		if (max != null && root.getData().compareTo(max) >= 0)
			return false;
		return isBST(root.getRight(), root.getData(), max)
				&& isBST(root.getLeft(), min, root.getData());
	}

	public void levelOrderTraverse() {
		if (this.root == null)
			return;
		Queue<BSTNode<T>> q = new LinkedList<BSTNode<T>>();
		q.add(this.root);
		while (!q.isEmpty()) {
			BSTNode<T> current = q.remove();
			current.visit();
			if (current.getLeft() != null)
				q.add(current.getLeft());
			if (current.getRight() != null)
				q.add(current.getRight());
		}
	}

	public void preOrderTraverse() {
		preOrderTraverse(root);
	}

	private void preOrderTraverse(BSTNode<T> root) {
		if (root == null)
			return;
		root.visit();
		preOrderTraverse(root.getLeft());
		preOrderTraverse(root.getRight());
	}

	public void inOrderTraverse() {
		inOrderTraverse(root);
	}

	private void inOrderTraverse(BSTNode<T> root) {
		if (root == null)
			return;
		inOrderTraverse(root.getLeft());
		root.visit();
		inOrderTraverse(root.getRight());
	}

	public void postOrderTraverse() {
		postOrderTraverse(root);
	}

	private void postOrderTraverse(BSTNode<T> root) {
		if (root == null)
			return;
		postOrderTraverse(root.getLeft());
		postOrderTraverse(root.getRight());
		root.visit();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinarySearchTree<Integer> bsti = new BinarySearchTree<Integer>();
		bsti.add(5);
		bsti.add(9);
		bsti.add(3);
		System.out.printf("BST: root %d, left %d, right %d\n", bsti.getRoot()
				.getData(), bsti.getRoot().getLeft().getData(), bsti.getRoot()
				.getRight().getData());
		System.out.printf("is BST? %s\n", bsti.isBST());
		bsti.getRoot().setData(1);
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
		System.out.printf("is BST? %s\n", bsts.isBST());

		System.out.printf("BST: level order traversal\n");
		bsts.levelOrderTraverse();
		System.out.printf("BST: preorder traversal\n");
		bsts.preOrderTraverse();
		System.out.printf("BST: postorder traversal\n");
		bsts.postOrderTraverse();

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
