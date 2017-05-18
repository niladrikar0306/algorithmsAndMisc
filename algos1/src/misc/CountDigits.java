package misc;

public class CountDigits {

	public static void main(String[] args) {

		int number = 10,d,digits=0;
		
		d=number;
		while(d>0) {
			
			d=d/10;
			digits++;
			
		}
		
		System.out.println("The number is of " + digits + " digits");
		
	}

}
