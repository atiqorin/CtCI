import java.util.*;

public class StringCompression {
    public static String compress(String str){
        StringBuilder sb = new StringBuilder();
        int consecutiveCount = 0;
        for(int i = 0; i < str.length(); i++) {
            consecutiveCount++;

            if(i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)){
                sb.append(str.charAt(i));
                sb.append(consecutiveCount);
                consecutiveCount = 0;
            }
        }
        return sb.length() < str.length() ? sb.toString() : str;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(compress(str));
    }
}