import java.util.*;
/**
 * URLify 
 */
public class URLify  {
    public static void replaceSpaces(char[] str) {
        int fullLength = findLastChar(str) + 1;
        int spaceCount = 0;

        for(int i = 0; i < fullLength; i++) {
            if(str[i] == ' ') {
                spaceCount++;
            }
        }

        int index = fullLength + 2 * spaceCount - 1;
        for(int i = fullLength - 1; i >= 0; i--) {
            if(str[i] == ' ') {
                str[index] = '0';
                str[index - 1] = '2';
                str[index - 2] = '%';
                index -= 3;
            } else {
                str[index] = str[i];
                index--;
            }
        }
    }

    public static int findLastChar(char[] str) {
        
        for(int i = str.length - 1; i >= 0; i--) {
            if(str[i] != ' ') {
                return i;
            }
        }
        return -1;
    }
    public static String charToString(char[] chars) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < chars.length; i++) {
            sb.append(chars[i]);
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String str = new Scanner(System.in).nextLine();
        char[] chars = str.toCharArray();
        replaceSpaces(chars);
        System.out.println(charToString(chars));
    }
}