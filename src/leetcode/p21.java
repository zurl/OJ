package leetcode;

public class p21 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode now = dummy;
        while( l1 != null && l2 != null){
            if( l1.val < l2.val ) {
                now.next = new ListNode(l1.val);
                now = now.next;
                l1 = l1.next;
            }
            else{
                now.next = new ListNode(l2.val);
                now = now.next;
                l2 = l2.next;
            }
        }
        while( l1 != null){
            now.next = new ListNode(l1.val);
            now = now.next;
            l1 = l1.next;
        }
        while( l2 != null){
            now.next = new ListNode(l2.val);
            now = now.next;
            l2 = l2.next;
        }
        return dummy.next;
    }

}
