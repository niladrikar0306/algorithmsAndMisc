package matrix;

public class FindMaxAppleFlopWithDisjiktra {

	private int[] getMax(int[][] w, int R, int C, Boolean[][] visited) {
		int max = -2, i = 0, j = 0;
		int[] index = new int[2];
		for (i = 0; i < R; i++) {

			for (j = 0; j < C; j++) {
				if (w[i][j] > max && !visited[i][j]) {
					max = w[i][j];
					index[0] = i;
					index[1] = j;
				}
			}
		}
		return index;
	}

	private boolean isSafeRight(int i, int j, int R, int C) {
		return j + 1 > C - 1 ? false : true;
	}

	private boolean isSafeUp(int i, int j, int R, int C) {
		return i - 1 < 0 ? false : true;
	}

	public int findMaxApple(int[][] m) {

		// if this is a vector
		int R = m.length;

		// If empty
		if (R == 0) {
			return 0;
		}

		int C = m[0].length;

		int length = R * C;

		if (length == 0) {
			return 0;
		}

		int count = 0, i = 0, j = 0;

		// Init

		Boolean[][] visited = new Boolean[R][C];
		for (i = 0; i < R; i++)
			for (j = 0; j < C; j++)
				visited[i][j] = false;

		// weights of each vertex
		int[][] w = new int[R][C];
		for (i = 0; i < R; i++)
			for (j = 0; j < C; j++)
				w[i][j] = -1;

		// Set the weight of src
		w[R - 1][0] = m[R - 1][0];

		// Repeat until all vertices are traversed
		for (count = 0; count < length; count++) {
			int[] index = getMax(w, R, C, visited);
			
			i=index[0];
			j=index[1];

			// set visited as true for max
			// at 1st pass it picks the source
			visited[index[0]][index[1]] = true;

			// update weight of all adjacent vertices
			// in this case always it can be at max 2
			if (isSafeRight(i, j, R, C) && !visited[i][j + 1]) {
				if (m[i][j + 1] + w[i][j] > w[i][j + 1]) {
					w[i][j + 1] = m[i][j + 1] + w[i][j];
				}
			}

			if (isSafeUp(i, j, R, C) && !visited[i - 1][j]) {
				if (m[i - 1][j] + w[i][j] > w[i - 1][j]) {
					w[i - 1][j] = m[i - 1][j] + w[i][j];
				}
			}

		}

		return w[0][C - 1];

	}

}
