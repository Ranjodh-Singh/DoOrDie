package edu.princeton.test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LightSource {
	public static void main(String[] args) {
		BST bst = new BST();
		bst.addNode(55);
		bst.addNode(65);
		bst.addNode(75);
		bst.addNode(45);
		bst.addNode(5);
		bst.addNode(23);
		bst.addNode(67);
		bst.addNode(1);
		bst.addNode(88);
		System.out.println("Level Order tree nodes: ");
		Queue<Node> queue = bst.LevelOrderTree();
		 //System.out.println("Level Order tree nodes: ");
		 for (Node node : queue) {
		 System.out.println(node.value);
		 }
	}

	public static class BST {
		Node root;

		public BST() {

		}

		public void addNode(int value) {

			if (root == null) {
				root = new Node(value);
				return;
			}
			Node node = root;
			Stack<Node> stack = new Stack<>();
			stack.push(node);
			Node temp;
			
			while ((temp = stack.pop()) != null) {
				if (temp.value > value) {
					if (temp.left == null) {
						temp.left = new Node(value);
						return;
					}
					stack.push(temp.left);

				} else if (temp.value < value) {
					if (temp.right == null) {
						temp.right = new Node(value);
						return;
					}
					stack.push(temp.right);
					// node = node.right;
				}
			}
			/*
			 * if (node == null) { node = new Node(value); }
			 */

		}

		public Queue<Node> LevelOrderTree() {
			Queue<Node> queue = new LinkedList<Node>();
			levelOderTree(root, queue);
			return queue;
		}

		private void levelOderTree(Node root2, Queue<Node> queue) {
			if (root2 != null) {
				Node node = root2;
				int level  = 0;
				queue.add(root2);
				System.out.println(" "+node.value+" level :"+level);
				node = queue.poll();
				while (node != null) {
					level++;
					//queue.add(node);
					if (node.left != null){
						queue.add(node.left);
					System.out.println("adding node :"+node.left.value+" level :"+level);
					}
					if (node.right != null){
						queue.add(node.right);
						System.out.println("adding node :"+node.right.value+" level :"+level);
					}
//					for (Node node1 : queue) {
//						System.out.println(" " + node1.value);
//					}
					node = queue.poll();

				}

				/*
				 * 
				 * if(root2.left !=null) queue.add(root2.left); if(root2.right
				 * !=null) queue.add(root2.right);
				 * 
				 * levelOderTree(root2.right, queue);
				 * 
				 * 
				 * System.out.println(root2.value);
				 * 
				 * levelOderTree(root2.left, queue);
				 */}

		}
	}

	public static class Node implements Comparable<Node> {
		int value;
		Node left, right;

		public Node(int value) {
			this.value = value;
		}

		@Override
		public int compareTo(Node o) {
			if (this.value > o.value) {
				return 1;
			} else if (this.value < o.value) {
				return -1;
			}
			return 0;
		}

	}
}
