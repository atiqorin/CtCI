import java.util.*;

public class StringRotation {
    public static boolean isRotation(String s1, String s2){
        if(s1.length() != s2.length()){
            return false;
        }
        String s1s1 = s1 + s1;
        return isSubstring(s1s1, s2);
    }
    public static boolean isSubstring(String s1, String s2){
        return s1.indexOf(s2) != -1;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println(isRotation(sc.next(), sc.next()) ? "Rotation" : "Not Rotation");
    }
}