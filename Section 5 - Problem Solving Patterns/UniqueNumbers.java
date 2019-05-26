import java.util.Scanner;

class UniqueNumbers {
	public static void main(String[] args) {
        int n;
        Scanner s = new Scanner(System.in);
        n = s.nextInt();

        int[] arr = new int[n];

        for(int i=0; i<n; i++) {
            arr[i] = s.nextInt();
        }
        System.out.println("Uniq digits:" + getUniqueDigits(arr));
    }

    private static int getUniqueDigits(int[] arr) {
        int uniqDigits = 1;

        if(arr.length == 0) {
            return 0;
        }

        int currentNum = arr[0];
        
        for(int i=1; i<arr.length; i++) {
            if(arr[i] != currentNum) {
                uniqDigits++;
                currentNum = arr[i];
            }
        }

        return uniqDigits;
    }
}
