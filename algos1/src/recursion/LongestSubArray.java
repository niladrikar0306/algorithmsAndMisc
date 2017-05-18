package recursion;

public class LongestSubArray {

	static Integer length1 = 0, length2 = 0;

	public static void main(String[] args) {

		int[] arr = new int[] { 10, 12, 11 };
		
		int i = Math.round(5.5f);
		System.out.println(i);

		System.out.println(longestSubarray(arr));
	}

	private static int longestSubarray(int[] arr) {

		sUtil(arr, 0, false);

		return length1;
	}

	private static void sUtil(int[] arr, int i, boolean holdingSeq) {

		if (i == arr.length) {
			return;
		}

		if ((i - 1) > 0 && arr[i - 1] + 1 == arr[i]) {
			if (!holdingSeq)
				length2 += 2;
			else
				length2++;
			if (length1 < length2)
				length1 = length2;
			i++;
			sUtil(arr, i, true);
		} else {
			i++;
			length2=0;
			sUtil(arr, i, false);
		}

	}

}
