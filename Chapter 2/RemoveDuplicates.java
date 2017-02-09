import java.util.*;

public class RemoveDuplicates {
    public static void removeDups(LinkedListNode node){
        HashSet<Integer> set = new HashSet<>();
        LinkedListNode prev = null;

        while(node != null){
            if(set.contains(node.data)){
                prev.next = node.next;
            } else {
                set.add(node.data);
                prev = node;
            }
            node = node.next;
        }
    }
    public static void main(String[] args){
        LinkedListNode curNode = new LinkedListNode(0);
        LinkedListNode head = curNode;
        LinkedListNode nextNode = curNode;

        for(int i = 1; i < 16; i++){
            nextNode = new LinkedListNode( i % 3);
            curNode.next = nextNode;
            curNode = nextNode;
        }
        System.out.println(head.PrintList());
        removeDups(head);
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
