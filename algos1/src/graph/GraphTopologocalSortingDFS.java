package graph;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Stack;

public class GraphTopologocalSortingDFS {

	Stack<Integer> s = new Stack<>();
	Stack<Integer> recStack = new Stack<>();
	boolean[] visited;

	private void dfs(Graph g, int i) {

		
		System.out.print(i + ", ");
		visited[i]=true;

		LinkedList<Integer> l = g.getAdv().get(i);
		ListIterator<Integer> iter = l.listIterator();
		while (iter.hasNext()) {
			int adVertex = iter.next();
			if (!visited[adVertex]) {
				
				dfs(g, adVertex);
			}
		}
		
		recStack.push(i);

	}

	public Stack<Integer> getTopologocalOrdering(Graph g, int start) {

		int n = g.getV().length, i = 0;
		int[] v = g.getV();

		visited = new boolean[n];
		for (i = 0; i < n; i++) {
			visited[i] = false;
		}

		int count = 0;
		for (i=0;i<n;i++) {

			if (!visited[i]) {
				// Add source in the stack

				dfs(g, i);
			}
			
		}

		return recStack;

	}

	public static void main(String[] args) {

		Graph g = new Graph(8);
		g.addEdge(5, 2);
		g.addEdge(5, 0);
		g.addEdge(4, 0);
		g.addEdge(4, 1);
		g.addEdge(2, 6);
		g.addEdge(6, 7);
		g.addEdge(2, 3);
		g.addEdge(3, 1);

		GraphTopologocalSortingDFS ob = new GraphTopologocalSortingDFS();

		ob.getTopologocalOrdering(g, 5);

		while(!ob.recStack.isEmpty()) {
			System.out.print(ob.recStack.pop());
		}

	}

}
