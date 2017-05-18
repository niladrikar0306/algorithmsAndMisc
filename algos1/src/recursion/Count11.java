package recursion;

public class Count11 {

	public static void main(String[] args) {
		count("11srrf111");

	}

	private static int count(String s) {

		char[] chars = s.toCharArray();

		Integer[] res = new Integer[] { 0 };
		countUtil(chars, 0, res, false);
		System.out.println(res[0].toString());
		return res[0];
	}

	private static void countUtil(char[] chars, int i, Integer[] res, boolean foundPrev) {


		if(i==chars.length){
			return;
		}
		
		if(!foundPrev && !(i-1<0) && chars[i-1]==chars[i] && chars[i]=='1'){
			res[0]=res[0]+1;
			countUtil(chars, ++i, res, true);
		} else {
			countUtil(chars, ++i, res, false);
		}
		
		
	}

}
