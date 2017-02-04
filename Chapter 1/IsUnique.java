import java.util.*;

public class IsUnique {
    public static boolean isUniqueChars(String str) {
        if(str.length() > 128) {
            return false;
        }
        boolean[] flags = new boolean[128];
        for(int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if(flags[val] == true) {
                return false;
            }
            flags[val] = true;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(isUniqueChars(sc.next()) == true ? "Unique" : "Not Unique");
    }
}
