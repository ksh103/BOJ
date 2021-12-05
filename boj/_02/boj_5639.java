package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* boj 5639번 이진 검색 트리 */
public class boj_5639 {
	
	static Node root;
	static String str;
	static ArrayList<Integer> list = new ArrayList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		root = new Node(Integer.parseInt(br.readLine()));
		
		while((str = br.readLine()) != null && str.length() != 0) {
			Node node = new Node(Integer.parseInt(str));
			search(root, node);
		}
		postOrder(root);
		for (int n : list) {
			System.out.println(n);
		}
	}
	
	// 노드 순회
	static void search(Node now, Node next) {
		// 노드의 왼쪽 서브트리에 있는 모든 노드의 키는 노드의 키보다 작다.
		if(now.n > next.n) {
			if(now.left != null) search(now.left, next);
			else now.left = next;
		}
		// 노드의 오른쪽 서브트리에 있는 모든 노드의 키는 노드의 키보다 크다.
		if(now.n < next.n) {
			if(now.right != null) search(now.right, next);
			else now.right = next;
		}
	}
	
	// 후위 순회
	static void postOrder(Node node) {
		if(node.left != null) postOrder(node.left);
		if(node.right != null) postOrder(node.right);
		
		list.add(node.n);
	}
	
	static class Node{
		int n;
		public Node(int n) {
			this.n = n;
		}
		
		Node left;
		Node right;
	}
}
