import java.util.*;

public class LoopDetection {
    public static LinkedListNode detectLoop(LinkedListNode head){
        LinkedListNode slow = head;
        LinkedListNode fast = head;

        while(fast != null || fast.next == null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                break;
            }
        }
        if(fast == null || fast.next == null){
            return null;
        }

        slow = head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
    public static void main(String[] args){
        LinkedListNode l1 = new LinkedListNode((int)(Math.random()*50));
        LinkedListNode node = l1;
        for(int i = 1; i < 10; i++){
            node.next = new LinkedListNode((int)(Math.random()*50));
            node = node.next;
        }
        node.next = null;
        System.out.println(l1.PrintList());
        int len = 3 + (int)(Math.random()*5);
        LinkedListNode cur = l1;
        for(int i = 0; i < len; i++){
            cur = cur.next;
        }
        node.next = cur;
        LinkedListNode begins = detectLoop(l1);
        System.out.println("Loop begins at: " + begins.data);
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
