package com.example.list;

class BinaryNode {
	private Integer value;
	private BinaryNode leftNode = null;
	private BinaryNode rightNode = null;

	public BinaryNode(Integer value) {
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public BinaryNode getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(BinaryNode leftNode) {
		this.leftNode = leftNode;
	}

	public BinaryNode getRightNode() {
		return rightNode;
	}

	public void setRightNode(BinaryNode rightNode) {
		this.rightNode = rightNode;
	}
}

/**
 * The Class BinarySearchTree.
 */
public class BinarySearchTree {

	/** The root node. */
	private static BinaryNode rootNode = null;

	/**
	 * Adds the recursive.
	 *
	 * @param current the current
	 * @param value   the value
	 * @return the binary node
	 */
	private static BinaryNode addRecursive(BinaryNode current, Integer value) {
		if (current == null) {
			current = new BinaryNode(value);
		} else {
			if (current.getValue() > value) {
				current.setLeftNode(addRecursive(current.getLeftNode(), value));
			} else if (current.getValue() < value) {
				current.setRightNode(addRecursive(current.getRightNode(), value));
			} else {
				// Nothing;
			}
		}
		return current;
	}

	/**
	 * Adds the.
	 *
	 * @param value the value
	 * @return the binary node
	 */
	public static BinaryNode add(Integer value) {
		return addRecursive(rootNode, value);
	}

	/**
	 * Search node value.
	 *
	 * @param current     the current
	 * @param searchValue the search value
	 * @return the boolean
	 */
	private static Boolean searchNodeValue(BinaryNode current, Integer searchValue) {
		if (current == null) {
			return false;
		}

		if (current.getValue() == searchValue) {
			return true;
		}

		return searchValue < current.getValue() ? searchNodeValue(current.getLeftNode(), searchValue)
				: searchNodeValue(current.getRightNode(), searchValue);

	}

	/**
	 * Search node.
	 *
	 * @param searchValue the search value
	 * @return true, if successful
	 */
	public static boolean searchNode(Integer searchValue) {
		return searchNodeValue(rootNode, searchValue);
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		BinarySearchTree.add(10);
		BinarySearchTree.add(5);
		BinarySearchTree.add(15);
		BinarySearchTree.add(2);
		BinarySearchTree.add(7);
		BinarySearchTree.add(13);
		System.out.println("Is 7 value available in tree ? " + searchNode(7));
		System.out.println("Is 27 value available in tree ? " + searchNode(27));
		System.out.println("Is 3 value available in tree ? " + searchNode(3));
	}
}
