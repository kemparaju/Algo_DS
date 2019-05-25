import java.util.Arrays;
import java.util.Scanner;
class SumZero {
	public static void main(String args[]) {
		int n;
        
		Scanner s = new Scanner(System.in);
        n = s.nextInt();
        
		int[] arr = new int[n];

		for(int i=0; i<n; i++) {
			arr[i] = s.nextInt();
        }

        System.out.println("output:"+ Arrays.toString(Solution.findSumZeroElems(arr)));
    }
}
class Solution {
	static int[] findSumZeroElems(int[] arr) {
		int ptr1 = 0;
		int ptr2 = arr.length - 1;

		for( int i=0; i<arr.length; i++) {
            if(ptr1 >= ptr2) {
                return new int[0];
            }

			int diff = arr[ptr1] + arr[ptr2];
			
			if(diff == 0) {
				return new int[]{ arr[ptr1], arr[ptr2] };
            }

            if(diff < 0) {
                ptr1++;
            } else {
                ptr2--;
            }
        }

        return new int[0];
    }
}
