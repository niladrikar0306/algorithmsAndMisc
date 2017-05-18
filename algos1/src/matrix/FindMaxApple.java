package matrix;

import java.util.ArrayList;
import java.util.Stack;

public class FindMaxApple {

	boolean[][] visited;
	Stack<Integer[]> s = new Stack<>();

	private boolean isSafeRight(int i, int j, int R, int C) {
		return j + 1 > C - 1 ? false : true;
	}

	private boolean isSafeFromLeft(int i, int j, int R, int C) {
		return j - 1 < 0 ? false : true;
	}

	private boolean isSafeFromDown(int i, int j, int R, int C) {
		return i + 1 > R - 1 ? false : true;
	}

	private boolean isSafeUp(int i, int j, int R, int C) {
		return i - 1 < 0 ? false : true;
	}

	public int collectApples(int[][] orchard) {

		if(orchard==null){
			return 0;
		}
		
		// if this is a vector
		int R = orchard.length, i, j;

		// If empty
		if (R == 0) {
			return 0;
		}

		int C = orchard[0].length;

		int length = R * C;

		if (length == 0) {
			return 0;
		}

		int srci = R - 1, srcj = 0, tgti = 0, tgtj = C - 1;
		// get topological ordering

		// init visited
		visited = new boolean[R][C];

		for (i = 0; i < R; i++) {
			for (j = 0; j < C; j++) {
				if (!visited[i][j]) {
					dfs(orchard, new int[] { i, j }, R, C);
				}
			}
		}

		System.out.println("The topological order is : ");
		// pop out and check the order
		ArrayList<Integer[]> order = new ArrayList<>();
		while (!s.isEmpty()) {
			Integer[] elem = s.pop();
			System.out.print("(" + elem[0] + "," + elem[1] + ") ");
			order.add(elem);
		}
		System.out.println("\nThe topological order display complete");

		// get longest value from topological ordering
		// initialize dist -1
		int[][] dist = new int[R][C];
		for (i = 0; i < R; i++) {
			for (j = 0; j < C; j++) {
				dist[i][j] = -1;
			}
		}

		dist[srci][srcj] = orchard[srci][srcj];

		// Traverse the order
		// start from src
		// calculate max distance for each node
		// until dest is reached
		int started = -1;

		for (Integer[] index : order) {
			i = index[0];
			j = index[1];
			if (started == -1 && srci == index[0] && srcj == index[1]) {
				started = 0;
				continue;
			} else if (started == -1) {
				continue;
			}

			int leftDis = 0;
			int rightDis = 0;
			if (isSafeFromLeft(i, j, R, C)) {
				leftDis = orchard[i][j] + dist[i][j - 1];
			}

			if (isSafeFromDown(i, j, R, C)) {
				rightDis = orchard[i][j] + dist[i + 1][j];
			}

			dist[i][j] = leftDis > rightDis ? leftDis : rightDis;

			if (tgti == i && tgtj == j)
				break;
		}

		return dist[tgti][tgtj];
	}

	private void dfs(int[][] m, int[] index, int R, int C) {

		int i = index[0], j = index[1];

		visited[i][j] = true;

		// find adjacent vertices

		if (isSafeRight(i, j, R, C) && !visited[i][j + 1]) {
			dfs(m, new int[] { i, j + 1 }, R, C);
		}

		if (isSafeUp(i, j, R, C) && !visited[i - 1][j]) {
			dfs(m, new int[] { i - 1, j }, R, C);
		}

		s.push(new Integer[] { i, j });

	}

	public static void main(String[] args) {
		int[][] m = { { 4, 0, 1 }, { 1, 0, 0 }, { 0, 4, 0 } };
		int res = new FindMaxApple().collectApples(m);

		System.out.println("Max distance is : " + res);
	}

}
