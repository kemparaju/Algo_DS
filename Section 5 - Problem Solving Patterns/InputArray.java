import java.util.Arrays;
import java.util.Scanner;

public class InputArray {

    public static void main(String[] args) {
        int n;

        Scanner s = new Scanner(System.in);

        n = s.nextInt();

        int[] arr = new int[n];

        for(int i=0; i<n; i++) {
            arr[i] = s.nextInt();
        }

        System.out.println(Arrays.toString(arr));
        
    }
}