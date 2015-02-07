package edu.princeton.cs.test;

public class MirrorTree {

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

	}

	static class BST {
		Node root;

		public BST() {

		}

		public void addChild(int key) {
			root = addChild(root, key);
		}

		private Node addChild(Node root2, int key) {
			/*Node node;*/
			if (root2 == null) {
				root2 = new Node(key);
			} else if (root2.key < key) {
				root2.right = addChild(root2.right, key);
			} else if (root2.key > key) {
				root2.left = addChild(root2.right, key);
			}

			return root2;
		}
		public void TraverseTree(){
			Node node = root;
			printNode(node);
		}

		private void printNode(Node root2) {
			if(root2 != null){
				printNode(root2.left);
				System.out.println(root2.key);
				printNode(root2.right);
			}
			
		}
	}

	static class Node implements Comparable<Node> {
		int key;
		Node left, right, parent;

		public Node(int key) {
			this.key = key;
		}

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
