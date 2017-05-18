package misc;

import java.util.HashMap;
import java.util.Map;

public class ArrayToBST {
	
	class Node {
		Node left;
		Node right;
		Node Parent;
		int info;
		public Node(int i) {
			info = i;
		}
	}
	
	public Node getTree(int[][] tuple) {
		
		Node root = null;
		
		Map<Integer, Node> tree = new HashMap<>();
		
		for(int i=0; i<tuple.length;i++){
			
			Node p = null;
			Node c = null;
			
			if(tree.containsKey(tuple[i][0])) {
				p = tree.get(tuple[i][0]);
			} else {
				p = new Node(tuple[i][0]);
				tree.put(tuple[i][0], p);
			}
			
			if(tree.containsKey(tuple[i][1])) {
				c = tree.get(tuple[i][1]);
			} else {
				c = new Node(tuple[i][1]);
				tree.put(tuple[i][1], c);
			}
			
			if(root==null || root==c) {
				root=p;
			}
			
			if(p.left==null){
				p.left = c;
				
			} else {
				p.right = c;
			}
			
			c.Parent = p;
			
		}
		
		Node cur = root.Parent;
		
		while(cur!=null){
			root = cur;
			cur = cur.Parent;
		}
		
		
		return root;
		
	}
	
	public static void main(String[] args) {
		
	}

}
