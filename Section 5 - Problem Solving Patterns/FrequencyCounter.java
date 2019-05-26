import java.util.HashMap;
import java.util.Scanner;
import java.util.stream.IntStream;

class FrequencyCounter {
	public static void main(String[] args) {
        Solution  counter = new Solution();

        Scanner scanner = new Scanner(System.in);
        int n;
        n = scanner.nextInt();

        int[] arrA = new int[n];
        int[] arrB = new int[n];

        for(int i=0; i<n; i++) {
            arrA[i] = scanner.nextInt();
        }

        for(int i=0; i<n; i++) {
            arrB[i] = scanner.nextInt();
        }

        if( counter.frequencyCounter3(arrA, arrB) == true ) 
            System.out.println("Frequency successfully counted");
        else 
            System.out.println("Frequency failed to count");
		
    }
}

class Solution {

    //method - 1; complexity 0(n2)
    public boolean frequencyCounter1(int[] a, int[] b) {
        // check if the length of the both arrays are same
        if( a.length != b.length ) {
            return false;
        }
        // Create 2 embedded for loops
        int i,j;
        for( i=0; i<a.length; i++ ) {
            for( j=0; j<b.length; j++) {
                if( b[j] == Math.pow(a[i], 2) ) {
                    b[j] = -1;
                    break;
                }
            }
            if( j == b.length ) {
                return false;
            }
        }
        if( i == a.length ) {
            return true;
        } else {
            return false;
        }
    }

    public boolean frequencyCounter2(int[] a, int[] b) {

        for(int i=0; i<a.length; i++) {
            int index = indexOf(b, (int)Math.pow(a[i], 2));

            if(index == -1) 
                return false;
            else {
                b = IntStream.range(0, a.length)
                    .filter(j -> j != index)
                    .map(j -> a[j])
                    .toArray();
            }
        }
        return true;
    }

    private int indexOf(int[] arr, int ele) {
        for(int i=0; i<arr.length; i++) {
            if(arr[i] == ele) 
                return i;
        }

        return -1;
    }

    public boolean frequencyCounter3(int[]a, int[] b) {
        HashMap<Integer, Integer> h1 = new HashMap<>();
        HashMap<Integer, Integer> h2 = new HashMap<>();

        for(int i=0; i<a.length; i++) {
            h1.put(a[i], (h1.get(a[i]) != null ? h1.get(a[i]) : 0 ) + 1 );
        }

        for(int i=0; i<b.length; i++) {
            h2.put(b[i], (h2.get(b[i]) != null ? h2.get(b[i]) : 0 ) + 1 );
        }

        for(int key : h1.keySet()) {
            if( !h2.containsKey( (int) Math.pow(key, 2)) ) {
                return false;
            }

            if(h1.get(key) != h2.get( (int) Math.pow(key, 2))) {
                return false;
            }
        }

        return true;

    }
}
