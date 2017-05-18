package graph;

import java.util.ArrayList;
import java.util.LinkedList;

public class Graph {

	int[] v;
	ArrayList<LinkedList<Integer>> adv;

	public Graph(int v) {

		this.v = new int[v];
		adv = new ArrayList<LinkedList<Integer>>(v);
		for (int i = 0; i < v; i++) {
			adv.add(i, new LinkedList<Integer>());
		}

	}
	
	public void addEdge(int u, int v){
		adv.get(u).add(v);
	}

	public int[] getV() {
		return v;
	}

	public void setV(int[] v) {
		this.v = v;
	}

	public ArrayList<LinkedList<Integer>> getAdv() {
		return adv;
	}

	public void setAdv(ArrayList<LinkedList<Integer>> adv) {
		this.adv = adv;
	}

}
