package edu.princeton.test;

/**
 * The Class BSTSuccessor.
 */
public class BSTSuccessor {

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 * @throws Exception
	 *             the exception
	 */
	public static void main(String[] args) throws java.lang.Exception {
		BST bst = new BST("Tree One");
		bst.addNode(55);
		bst.addNode(65);
		bst.addNode(75);
		bst.addNode(45);
		bst.addNode(5);
		bst.addNode(23);
		bst.addNode(67);
		bst.addNode(1);
		bst.addNode(88);
		bst.inOrder();
		System.out.println("\nSearching node :23");
		Node node = bst.searchNode(23);
		if (node != null)
			System.out.println(node.value);
		else
			System.out.println("NOT FOUND.");
		System.out.println(bst.searchMax(bst.root));
		int successor = bst.successor(65);
		System.out.println("Successor is  : " + successor + " and " + bst.successor(23));

	}

	/**
	 * The Class BST.
	 */
	public static class BST {

		/** The root. */
		Node root;

		/** The name. */
		String name;

		/**
		 * Instantiates a new bst.
		 *
		 * @param name
		 *            the name
		 */
		public BST(String name) {
			this.name = name;
		}

		/**
		 * Adds the node.
		 *
		 * @param value
		 *            the value
		 */
		public void addNode(int value) {
			root = addNode(root, value, null);
		}

		/**
		 * Adds the node.
		 *
		 * @param node
		 *            the node
		 * @param value
		 *            the value
		 * @param parent
		 *            the parent
		 * @return the node
		 */
		public Node addNode(Node node, int value, Node parent) {
			if (node == null) {
				node = new Node(value);
			} else {
				if (value > node.value) {
					node.right = addNode(node.right, value, node);
				} else if (value <= node.value) {
					node.left = addNode(node.left, value, node);
				}
			}
			node.parent = parent;
			return node;
		}

		/**
		 * In order.
		 */
		public void inOrder() {
			inOrder(root);
		}

		/**
		 * In order.
		 *
		 * @param node
		 *            the node
		 */
		public void inOrder(Node node) {
			if (node != null) {
				inOrder(node.left);
				System.out.print(" " + node.value);
				inOrder(node.right);
			}
		}

		/**
		 * Search node.
		 *
		 * @param value
		 *            the value
		 * @return the node
		 */
		public Node searchNode(int value) {
			Node node = searchNode(root, value);
			return node;

		}

		/**
		 * Search max.
		 *
		 * @param node
		 *            the node
		 * @return the int
		 */
		public int searchMax(Node node) {
			while (node.right != null) {
				node = node.right;
			}
			return node.value;
		}

		/**
		 * Search min.
		 *
		 * @param node
		 *            the node
		 * @return the int
		 */
		public int searchMin(Node node) {
			while (node.left != null) {
				node = node.left;
			}
			return node.value;
		}

		/**
		 * Successor.
		 *
		 * @param value
		 *            the value
		 * @return the int
		 */
		public int successor(int value) {
			Node node = searchNode(value);
			if (node.right != null) {
				return searchMin(node.right);
			}
			Node parent = node.parent;
			while (parent != null && parent.right == node) {
				node = node.parent;
				parent = node.parent;
			}
			if (parent == null)
				return -1;
			return parent.value;
		}

		/**
		 * Search node.
		 *
		 * @param root2
		 *            the root2
		 * @param value
		 *            the value
		 * @return the node
		 */
		private Node searchNode(Node root2, int value) {
			if (root2 == null)
				return null;
			if (value == root2.value)
				return root2;
			if (value > root2.value) {
				root2 = searchNode(root2.right, value);
			} else {
				root2 = searchNode(root2.left, value);
			}
			return root2;
		}
	}

	/**
	 * The Class Node.
	 */
	public static class Node implements Comparable<Node> {

		/** The value. */
		int value;

		/** The parent. */
		Node parent;

		/** The right. */
		Node left, right;

		/**
		 * Instantiates a new node.
		 *
		 * @param value
		 *            the value
		 */
		public Node(int value) {
			this.value = value;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Comparable#compareTo(java.lang.Object)
		 */
		public int compareTo(Node other) {
			if (this.value < other.value) {
				return -1;
			} else if (this.value > other.value) {
				return 1;
			} else {
				return 0;
			}
		}
	}
}
