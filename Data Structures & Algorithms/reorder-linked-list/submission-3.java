/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode reversed = reverse(slow);
        ListNode curr = head;
        // while(curr!=null){
        //     System.out.print(curr.val);
        //     curr=curr.next;
        // }
        // while(reversed!=null){
        //     System.out.print(reversed.val);
        //     reversed=reversed.next;
        // }
        while (reversed != null) {
            ListNode next = null;
            if (curr != null) {
                next = curr.next;
                curr.next = reversed;
                curr = next;
            }
            ListNode reversedNext = reversed.next;
            reversed.next = curr;
            reversed = reversedNext;
        }
        if (curr != null) {
            curr.next = null;
        }
    }
    
    private static ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}


/*
//2,4,6,8,10
      s
          f
first = 2,4
second = 10,8,6
2->10->4->8->6


*/