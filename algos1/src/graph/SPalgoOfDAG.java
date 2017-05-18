package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Stack;

import graph.ShortestPath.Graph;

// TODO: not working as expected
public class SPalgoOfDAG {

	class Graph {

		int[] v;
		ArrayList<LinkedList<Integer[]>> adv;

		public Graph(int v) {

			this.v = new int[v];
			adv = new ArrayList<LinkedList<Integer[]>>(v);
			for (int i = 0; i < v; i++) {
				adv.add(i, new LinkedList<Integer[]>());
			}

		}

		public void addEdge(int u, int v, int w) {
			adv.get(u).add(new Integer[] { v, w });
		}

		public int[] getV() {
			return v;
		}

		public void setV(int[] v) {
			this.v = v;
		}

		public ArrayList<LinkedList<Integer[]>> getAdv() {
			return adv;
		}

		public void setAdv(ArrayList<LinkedList<Integer[]>> adv) {
			this.adv = adv;
		}

	}

	Stack<Integer> s = new Stack<>();
	Stack<Integer> recStack = new Stack<>();
	boolean[] visited;

	private void dfs(Graph g, int i) {

		//System.out.print(i + ", ");
		visited[i] = true;

		LinkedList<Integer[]> l = g.getAdv().get(i);
		ListIterator<Integer[]> iter = l.listIterator();
		while (iter.hasNext()) {
			Integer[] data = iter.next();
			int adVertex = data[0];
			if (!visited[adVertex]) {

				dfs(g, adVertex);
			}
		}

		recStack.push(i);

	}

	public Stack<Integer> getTopologocalOrdering(Graph g) {

		int n = g.getV().length, i = 0;
		int[] v = g.getV();

		visited = new boolean[n];
		for (i = 0; i < n; i++) {
			visited[i] = false;
		}

		int count = 0;
		for (i = 0; i < n; i++) {

			if (!visited[i]) {
				// Add source in the stack

				dfs(g, i);
			}

		}

		return recStack;

	}

	public void getShortestPath(Graph g) {

		getTopologocalOrdering(g);
		int n = g.getV().length, i = 0, v = 0, u = 0, weight = 0;

		// Please not elements of the array of order are the vertices
		int[] order = new int[n];
		// However, index of dist is the verties
		int[] dist = new int[n];

		i = 0;
		// getting topological sorted order
		while (!recStack.isEmpty()) {
			order[i++] = recStack.pop();
		}

		System.out.println("Topological ordering is :");
		for(i=0;i<n;i++){
			System.out.print(order[i] + " ");
		}
		
		for (i = 0; i < n; i++) {
			dist[i] = Integer.MAX_VALUE;
		}

		dist[1] = 0;

		for (i = 0; i < n; i++) {
			u = order[i];
			LinkedList<Integer[]> l = g.getAdv().get(u);
			ListIterator<Integer[]> iter = l.listIterator();
			while (iter.hasNext()) {
				Integer[] data = iter.next();
				v = data[0];
				weight = data[1];
				if (dist[u] != Integer.MAX_VALUE && (dist[u] + weight) < dist[v]) {
					dist[v] = dist[u] + weight;
				}
			}
		}

		System.out.println("Distance array is : ");
		for (int dis : dist)
			System.out.print(dis + ", ");
		System.out.println("End of distance array");

	}

	public static void main(String[] args) {

		SPalgoOfDAG ob = new SPalgoOfDAG();

		Graph g = ob.new Graph(6);
        g.addEdge(0, 1, 5);
        g.addEdge(0, 2, 3);
        g.addEdge(1, 3, 6);
        g.addEdge(1, 2, 2);
        g.addEdge(2, 4, 4);
        g.addEdge(2, 5, 2);
        g.addEdge(2, 3, 7);
        g.addEdge(3, 4, -1);
        g.addEdge(4, 5, -2);

		ob.getShortestPath(g);

		while (!ob.recStack.isEmpty()) {
			System.out.print(ob.recStack.pop());
		}

	}

}
