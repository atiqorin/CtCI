import java.util.*;

/**
 * Partition
 */
public class Partition {
    public static LinkedListNode partition(LinkedListNode node, int x){
        LinkedListNode head = node;       
        LinkedListNode tail = node;       
        
        while(node != null){
            LinkedListNode next = node.next;
            if(node.data < x){
                node.next = head;
                head = node;
            } else {
                tail.next = node;
                tail = node;
            }
            node = next;
        }
        tail.next = null;
        return head;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedListNode curNode = new LinkedListNode(0);
        LinkedListNode head = curNode;
        LinkedListNode nextNode = curNode;

        for(int i = 1; i < 15; i++){
            curNode.next = new LinkedListNode((int)(Math.random()*10));
            curNode = curNode.next;
        }
        System.out.println(head.PrintList());
        head = partition(head, sc.nextInt());
        System.out.println(head.PrintList());
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
