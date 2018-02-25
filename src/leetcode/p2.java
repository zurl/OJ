package leetcode;


public class p2 {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;
        while( !(l1 == null && l2 == null && carry == 0)){
            if (l1 != null) carry += l1.val;
            if (l2 != null) carry += l2.val;
            current.next = new ListNode(carry);
            current = current.next;
            carry = 0;
            if (current.val >= 10) {
                carry = 1;
                current.val -= 10;
            }
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        return dummy.next;
    }
}
