import java.util.*;

public class KthToLastRecursive {
    public static LinkedListNode KthToLast(LinkedListNode head, int k){
        Index idx = new Index();
        return KthToLast(head, k, idx);
    }
    public static LinkedListNode KthToLast(LinkedListNode head, int k, Index idx){
        if(head == null){
            return null;
        }
        LinkedListNode node = KthToLast(head.next, k, idx);
        idx.value = idx.value + 1;
        if(idx.value == k){
            return head;
        }
        return node;
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

class Index {
    public int value = 0;
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
