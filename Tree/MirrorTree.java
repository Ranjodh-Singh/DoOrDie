package edu.princeton.cs.test;


/**
 * The Class MirrorTree.
 * @see <a href="http://www.geeksforgeeks.org/write-an-efficient-c-function-to-convert-a-tree-into-its-mirror-tree/">similar question</a>
 */
public class MirrorTree {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		BST bstree = new BST();
		bstree.addChild(3);
		bstree.addChild(6);
		bstree.addChild(8);
		bstree.addChild(2);
		bstree.addChild(1);
		bstree.addChild(10);
		bstree.addChild(19);
		bstree.TraverseTree();
		System.out.println("##################################");
		BST mirror = bstree.getMirror();
		mirror.TraverseTree();

	}

	/**
	 * The Class BST.
	 */
	static class BST {
		
		/** The root. */
		Node root;

		/**
		 * Instantiates a new bst.
		 */
		public BST() {

		}

		/**
		 * Adds the child.
		 *
		 * @param key the key
		 */
		public void addChild(int key) {
			root = addChild(root, key);
		}

		/**
		 * Adds the child.
		 *
		 * @param root2 the root2
		 * @param key the key
		 * @return the node
		 */
		private Node addChild(Node root2, int key) {
			/* Node node; */
			if (root2 == null) {
				root2 = new Node(key);
			} else if (root2.key < key) {// could use comparaTo() instead of < , >
				root2.right = addChild(root2.right, key);
			} else if (root2.key > key) {
				root2.left = addChild(root2.left, key);
			} else {
				root2.key = key;
			}

			return root2;
		}

		/**
		 * Traverse tree.
		 */
		public void TraverseTree() {
			Node node = root;
			printNode(node);
		}

		/**
		 * Prints the node.
		 *
		 * @param root2 the root2
		 */
		private void printNode(Node root2) {
			if (root2 != null) {
				printNode(root2.left);
				System.out.println(root2.key);
				printNode(root2.right);
			}

		}

		/**
		 * Gets the mirror.
		 *
		 * @return the mirror
		 */
		public BST getMirror() {
			BST mirror = new BST();
			mirror.root = getMirror(mirror.root, root);
			return mirror;
		}

		/**
		 * Gets the mirror.
		 *
		 * @param root the root
		 * @param root2 the root2
		 * @return the mirror
		 */
		private Node getMirror(Node root, Node root2) {
			if (root2 == null) {
				return null;
			} else {
				root = new Node(root2.key);
				if (root2.left != null) {
					root.right = getMirror(root, root2.left);
				}
				if (root2.right != null) {
					root.left = getMirror(root, root2.right);
				}
			}
			return root;
		}
	}

	/**
	 * The Class Node.
	 */
	static class Node implements Comparable<Node> {
		
		/** The key. */
		int key;
		
		/** The parent. */
		Node left, right, parent;

		/**
		 * Instantiates a new node.
		 *
		 * @param key the key
		 */
		public Node(int key) {
			this.key = key;
		}

		/* (non-Javadoc)
		 * @see java.lang.Comparable#compareTo(java.lang.Object)
		 */
		@Override
		public int compareTo(Node o) {
			if (this.key < o.key) {
				return -1;
			} else if (this.key > o.key) {
				return 1;
			} else {
				return 0;
			}

		}
	}
}
