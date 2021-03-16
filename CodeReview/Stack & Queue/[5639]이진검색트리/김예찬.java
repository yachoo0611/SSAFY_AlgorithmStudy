package ssafy.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Boj_5639 { 
		static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		static Node root;
		static String str;
		static ArrayList<Integer> postorderArray = new ArrayList<>();


		static class Node{
			int name;
			public Node(int name){
				this.name = name;
			}
			Node left;
			Node right;
		}
		
		public static void main(String[] args) throws Exception {
			

			root = new Node(Integer.parseInt(br.readLine()));
			
			while((str = br.readLine()) != null && str.length() != 0) {
				Node node = new Node(Integer.parseInt(str));
				putNode(root, node); 
			}
			
			postorder(root);
			for(int i : postorderArray)
				System.out.println(i);
		
		}
		
		/// 트리에 노드 박기 
		private static void putNode(Node start, Node input) {
			if( start.name > input.name) {
				if( start.left != null) {
					putNode(start.left, input);
				}else {
					start.left = input;
				}
			}
			
			if( start.name < input.name) {
				if( start.right != null) {
					putNode(start.right, input);
				}else {
					start.right = input;
				}
			}
		}
		
		private static void postorder(Node node) {
			if(node.left != null)
				postorder(node.left);
			if(node.right != null) 
				postorder(node.right);
			postorderArray.add(node.name);
		}
	}
