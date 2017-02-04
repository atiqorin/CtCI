import java.util.*;
/**
* CheckPermutations
 */
public class CheckPermutations {
    public static boolean isPermutation(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        int[] letters = new int[128];

        for(int i = 0; i < s.length(); i++) {
            letters[s.charAt(i)]++;
        }

        for(int i = 0; i < t.length(); i++) {
            letters[t.charAt(i)]--;
            if(letters[t.charAt(i)] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(isPermutation(sc.next(), sc.next()) ? "\nPermutation!" : "\nNot Permutation");
    }
}