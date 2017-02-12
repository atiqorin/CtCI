import java.util.*;

public class Intersect {
    public static LinkedListNode intersection(LinkedListNode l1, LinkedListNode l2){
        Result tail1 = getTailAndLength(l1);
        Result tail2 = getTailAndLength(l2);
        
        if(tail1.tail != tail2.tail){
            return null;
        }

        LinkedListNode shorter = (tail1.length < tail2.length) ? l1 : l2;
        LinkedListNode longer = (tail1.length < tail2.length) ? l2 : l1;
        for(int i = 0; i < Math.abs(tail1.length - tail2.length); i++){
            longer = longer.next;
        }

        while(shorter != longer){
            shorter = shorter.next;
            longer = longer.next;
        }
        return longer;
    }
    public static Result getTailAndLength(LinkedListNode head){
        int len = 1;
        while(head.next != null){
            len++;
            head = head.next;
        }
        return new Result(head, len);
    }
    public static void main(String[] args){
        int len1 = 4 + (int)(Math.random()*5);
        int len2 = 4 + (int)(Math.random()*5);
        LinkedListNode l1 = new LinkedListNode((int)(Math.random()*50));
        LinkedListNode l2 = new LinkedListNode((int)(Math.random()*50));
        LinkedListNode node = l1;
        for(int i = 1; i < len1; i++){
            node.next = new LinkedListNode((int)(Math.random()*50));
            node = node.next;
        }
        node.next = null;
        node = l2;
        for(int i = 1; i < len2; i++){
            node.next = new LinkedListNode((int)(Math.random()*50));
            node = node.next;
        }
        node.next = null;

        System.out.println(l1.PrintList());
        System.out.println(l2.PrintList());

        LinkedListNode intersectNode = null;
        if((int)(Math.random()*2) == 0){
            System.out.println("\nMaking intersect\n");
            len1 = (int)(Math.random()*4);
            len2 = (int)(Math.random()*4);
            LinkedListNode cur1 = l1;
            LinkedListNode cur2 = l2;
            for(int i = 0; i < len1-1; i++){
                cur1 = cur1.next;
            }
            for(int i = 0; i < len2; i++){
                cur2 = cur2.next;
            }
            cur1.next = cur2;
            intersectNode = intersection(l1, l2);
        }
        if(intersectNode != null){
            System.out.println("Intersect Node: "+ intersectNode.data);
        }
        System.out.println(l1.PrintList());
        System.out.println(l2.PrintList());
    }
}
class Result {
     int length;
     LinkedListNode tail;
     public Result(LinkedListNode tail, int length){
         this.tail = tail;
         this.length = length;
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
