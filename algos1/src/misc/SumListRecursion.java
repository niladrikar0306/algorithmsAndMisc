package misc;

public class SumListRecursion {

	public static void main(String[] args) {
		
		int[] a = new int[]{2, 5, 8, 9};
		
		int res = sum(a);
		
		System.out.println(res);

	}

	private static int sum(int[] a) {
		int res = sumUtil(a, 0);
		return res;
	}

	private static int sumUtil(int[] a, int i) {
		
		if(i==a.length){
			return 0;
		}
		
		return a[i]+sumUtil(a, ++i);
		
	}

}
