import java.util.*;

public class KthToLastIterative {
    public static LinkedListNode KthToLast(LinkedListNode head, int k){
        LinkedListNode n1 = head;
        LinkedListNode n2 = head;
        for(int i = 0; i < k; i++){
            if(n2 == null){
                return null;
            }
            n2 = n2.next;
        }

        while(n2 != null){
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        LinkedListNode curNode = new LinkedListNode(0);
        LinkedListNode head = curNode;
        LinkedListNode nextNode = curNode;

        for(int i = 1; i < 16; i++){
            nextNode = new LinkedListNode(i);
            curNode.next = nextNode;
            curNode = nextNode;
        }
        System.out.println(head.PrintList());

        System.out.println(KthToLast(head, sc.nextInt()).data);
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
