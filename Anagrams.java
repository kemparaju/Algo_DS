import java.util.Scanner;
import java.util.HashMap;

class Anagrams {
	public static void main(String[] args) {
		String a, b;
		Scanner s = new Scanner(System.in);
		a = s.nextLine();
		b = s.nextLine();

		if( Solution.checkAnagram( a.toCharArray(), b.toCharArray() ) ) {
			System.out.println("Strings are anagrams");
    } else {
        System.out.println("Strings are not anagrams");
    }
		
}
}

class Solution {
	static boolean checkAnagram(char[] a, char[] b) {
		HashMap<Character, Integer> h1 = new HashMap<>();
        HashMap<Character, Integer> h2 = new HashMap<>();

		if(a.length != b.length) {
			return false;
        }

        for(int i=0; i<a.length; i++) {
            h1.put(a[i], ( h1.get(a[i]) == null ? 0 : h1.get(a[i]) ) + 1 );
            h2.put(b[i], ( h2.get(b[i]) == null ? 0 : h2.get(b[i]) ) + 1 );
        }

        for( char ch : h1.keySet() ) {
            if( !h2.containsKey(ch) ) {
                return false;
            }

            if( h1.get(ch) != h2.get(ch) ) {
                return false;
            }
        }

        return true;
    }
}
