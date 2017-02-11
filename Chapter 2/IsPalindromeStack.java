import java.util.*;

public class IsPalindromeStack {
    public static boolean isPalindrome(LinkedListNode head){
        Stack<Integer> stack = new Stack<>();
        LinkedListNode slow = head;
        LinkedListNode fast = head;
        while(fast != null && fast.next != null){
            stack.add(slow.data);
            slow = slow.next;
            fast = fast.next.next;
        }
        // fast will be null if Linked List is of even length. For odd slow will be the middle, so we need to skip that
        if(fast != null){
            slow = slow.next;
        }
        while(slow != null){
            int cur = stack.pop();
            if(cur != slow.data){
                return false;
            }
            slow = slow.next;
        }
        return true;
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
class LinkedListNode{
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
