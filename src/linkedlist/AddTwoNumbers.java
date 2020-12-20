package linkedlist;

public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(3, new ListNode(4)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(7)));
        ListNode sum = addTwoNumbers(l1, l2);
        while (sum != null){
            System.out.print("["+sum.num+"]");
            sum = sum.next;
        }
        System.out.println();
    }
    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int l1_num = 0, l2_num = 0;
        while (l1 != null){
            l1_num += l1.num;
            l1 = l1.next;
            if (l1 != null) l1_num *= 10;
        }
        while (l2 != null){
            l2_num += l2.num;
            l2 = l2.next;
            if (l2 != null) l2_num *= 10;
        }
        int sum = l1_num + l2_num;
        ListNode sum_list = new ListNode(0);
        ListNode curr = sum_list;
        while (sum != 0){
            curr.next = new ListNode(sum%10);
            curr = curr.next;
            sum /= 10;
        }
        return sum_list.next;
    }
}
