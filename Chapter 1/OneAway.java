import java.util.*;
/**
 * OneAway
 */
public class OneAway {
    public static boolean checkOneAway(String s1, String s2){
        if(Math.abs(s1.length() - s2.length()) > 1){
            return false;
        }
        if(s1.length() == s2.length()){
            return oneEditAway(s1, s2);
        } else if(s1.length() < s2.length()){
            return oneInsertAway(s1, s2);
        } else {
            return oneInsertAway(s2, s1);
        }
    }

    public static boolean oneEditAway(String s1, String s2){
        boolean oneDiffFound = false;
        for(int i = 0; i < s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)){
                if(oneDiffFound){
                    return false;
                }
                oneDiffFound = true;
            }
        }
        return true;
    }

    public static boolean oneInsertAway(String s1, String s2){
        int index1 = 0, index2 = 0;
        while(index1 < s1.length() && index2 < s2.length()){
            if(s1.charAt(index1) != s2.charAt(index2)){
                if(index1 != index2) {
                    return false;
                }
                index2++;
            } else {
                index1++;
                index2++;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        System.out.println(checkOneAway(s1, s2) ? "One edit away!" : "Not one edit away");
    }
}