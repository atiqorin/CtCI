import java.util.*;
/**
 * PalindromePermutation
 */
public class PalindromePermutation {
    public static boolean checkPalindrome(String str){
        int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
        int totalOdd = 0;
        for(char c : str.toCharArray()){
            int index = Character.getNumericValue(c) - Character.getNumericValue('a');
            table[index]++;
            if(table[index] % 2 == 1){
                totalOdd++;
            } else {
                totalOdd--;
            }
       }
       return totalOdd <= 1;
    }

    public static void main(String[] args) {
        String str = new Scanner(System.in).nextLine();

        System.out.println(checkPalindrome(str) ? "Palindrome Permutation" : "Not Palindrome Permutation");
    }
}