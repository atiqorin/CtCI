import java.util.*;

public class DeleteMiddle {

    public static void deleteNode(LinkedListNode node){
        if(node == null || node.next == null){
            return;
        }
        LinkedListNode next = node.next;
        node.data = next.data;
        node.next = next.next;
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

        int n = sc.nextInt();
        LinkedListNode node = head;

        for(int i = 0; i < n; i++){
            if(node == null) break;;
            node = node.next;
        }
        deleteNode(node);
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
