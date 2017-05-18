package abc;

public class Fibonnacci {

	public static void main(String args[]) {
		int n = 5;
		
		System.out.println(getFibo(n));
	}
	
	private static int getFibo(int n) {
	
		if(n==0) {
			return 1;
		}
		
		if(n==1) {
			return 1;
		}
		
		return getFibo(n-1) + getFibo(n-2);
		
	}

}