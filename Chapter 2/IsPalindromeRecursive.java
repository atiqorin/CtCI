import java.util.*;

public class IsPalindromeRecursive {
    public static boolean isPalindrome(LinkedListNode head){
        int len = length(head);
        Result res = isPalindrome(head, len);
        return res.result;
    }
    public static Result isPalindrome(LinkedListNode head, int length){
        if(head == null || length == 0){
            return new Result(head, true);
        } else if(length == 1){
            return new Result(head.next, true);
        }
        Result res = isPalindrome(head.next, length - 2);
        if(!res.result || res.node == null){
            return res;
        }
        res.result = (head.data == res.node.data);
        res.node = res.node.next;
        return res;
    }
    public static int length(LinkedListNode head){
        int len = 0;
        while(head != null){
            len++;
            head = head.next;
        }
        return len;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        LinkedListNode head = new LinkedListNode(sc.nextInt());
        LinkedListNode cur = head;
        for(int i = 1; i < len; i++){
            LinkedListNode node = new LinkedListNode(sc.nextInt());
            cur.next = node;
            cur = node;
        }
        System.out.println(head.PrintList());
        System.out.println(isPalindrome(head) ? "Palindrome" : "Not Palindrome");
    }
}
class Result {
    LinkedListNode node;
    boolean result;
    public Result(LinkedListNode node, boolean result){
        this.node = node;
        this.result = result;
    }
}
class LinkedListNode {
    public LinkedListNode next;
    public LinkedListNode prev;
    public int data;

    public LinkedListNode(int data, LinkedListNode next, LinkedListNode prev){
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
    public LinkedListNode(int data){
        this.data = data;
    }

    public String PrintList(){
        if(next != null){
            return data + "->" + next.PrintList();
        } else {
            return ""+data;
        }
    }
}
