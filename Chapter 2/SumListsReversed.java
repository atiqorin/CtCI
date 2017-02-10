import java.util.*;

public class SumListsReversed {
    public static int addLists(LinkedListNode l1, LinkedListNode l2){
        int sum = 0;
        int power = 1;
        while(l1 != null || l2 != null){
            if(l1 != null){
                sum += l1.data * power;
                l1 = l1.next;
            }
            if(l2 != null){
                sum += l2.data * power;
                l2 = l2.next;
            }
            power *= 10;
        }
        return sum;
    }

    public static void main(String[] args){
        LinkedListNode node = new LinkedListNode((int)(Math.random()*10));
        LinkedListNode l1 = node;

        for(int i = 0; i < 1+ (int)(Math.random() * 5); i++){
            node.next = new LinkedListNode((int)(Math.random() * 10));
            node = node.next;
        }

        node = new LinkedListNode((int)(Math.random()*10));
        LinkedListNode l2 = node;

        for(int i = 0; i < 1+ (int)(Math.random() * 5); i++){
            node.next = new LinkedListNode((int)(Math.random() * 10));
            node = node.next;
        }

        System.out.println(l1.PrintList());
        System.out.println(l2.PrintList());
        System.out.println(addLists(l1, l2));
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
