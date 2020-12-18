public class RotateList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println("Original head:");
        ListNode temp = head;
        while (temp != null){
            System.out.print(temp.num + " ");
            temp = temp.next;
        }
        System.out.println("\nRotated head by 2:");
        temp = rotateRight(head,2);
        while (temp != null){
            System.out.print(temp.num + " ");
            temp = temp.next;
        }
    }
    public static ListNode rotateRight(ListNode head, int k) {
        // handle special case length is 0 or 1
        if (head == null || head.next == null) return head;

        // calculate list length
        // we also need to find the tail node and point it to head at the end
        int length = 1;
        ListNode tail = head;
        while (tail.next != null)
        {
            tail = tail.next;
            length ++;
        }
        //Now tail is 5, length is 5

        //calcualte k so rotate at most length-1 steps
        k = k % length;
        if (k == 0) return head;

        //split the list to two lists.
        ListNode newHead = head;
        ListNode newTail = head;
        while (length > k)
        {
            newTail = newHead;
            newHead = newHead.next;
            length --;
        }
        newTail.next = null;
//        System.out.println("newTail = " + newTail.num + " " + newTail.next);
//        System.out.println("newHead = " + newHead.num + " " + newHead.next.num);
        tail.next = head;
        return newHead;
    }
}

class ListNode {
    public ListNode(int num) {
        this.num = num;
    }

    int num;
    ListNode next = null;
}
