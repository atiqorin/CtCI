public class SumListsForward {
    public static int addLists(LinkedListNode l1, LinkedListNode l2){
        int len1 = length(l1);
        int len2 = length(l2);

        if(len1 > len2){
            l2 = padWithZeros(l2, len1 - len2);
        } else {
            l1 = padWithZeros(l1, len2 - len1);
        }
        return addLists(l1, l2, 0);
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
    public static int addLists(LinkedListNode l1, LinkedListNode l2, int cary){
        int sum = 0;
        if(l1 != null && l2 != null){
            sum = l1.data + l2.data;
            if(cary != 0){
                sum += cary * 10;
            }
        }
        if(l1.next != null && l2.next != null){
            sum = addLists(l1.next, l2.next, sum);
        }
        return sum;
    }
    public static int length(LinkedListNode head){
        int len = 0;
        while(head != null){
            len++;
            head = head.next;
        }
        return len;
    }
    public static LinkedListNode padWithZeros(LinkedListNode head, int padNum){
        while(padNum > 0){
            LinkedListNode zero = new LinkedListNode(0);
            zero.next = head;
            head = zero;
            padNum--;
        }
        return head;
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
