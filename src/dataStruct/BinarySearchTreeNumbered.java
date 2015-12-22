package dataStruct;

public class BinarySearchTreeNumbered<T extends Comparable<T>> extends
		BinarySearchTree {

	public BinarySearchTreeNumbered() {
		super();
	}

	public void preOrderNumber() {
		CollectionVisitor v = new CollectionVisitor();
		preOrderNumber(root, v);
	}

	private void preOrderNumber(BSTNode<T> root, CollectionVisitor v) {
		if (root == null)
			return;
		v.visit(root.getData());
		root.setPreOrderNub(v.getVcount());
		System.out.printf("set preOrder number of %s to %d\n", root.getData(), root.getPreOrderNub());
		preOrderNumber(root.getLeft(), v);
		preOrderNumber(root.getRight(), v);
	}

	public static void main(String[] args) {
		BinarySearchTreeNumbered<Character> bsts = new BinarySearchTreeNumbered<Character>();
		bsts.add('j');
		bsts.add('c');
		bsts.add('n');
		bsts.add('x');
		bsts.add('i');
		bsts.add('g');
		bsts.add('m');
		bsts.add('f');
		bsts.add('s');
		bsts.add('h');
		bsts.add('l');
		bsts.preOrderNumber();	
		bsts.preOrderTraverse();	
	}

}
