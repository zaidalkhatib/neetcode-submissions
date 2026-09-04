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
             ListNode curr = head;
        int length = 0;
        while (curr != null) {
            length++;
            curr = curr.next;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode reversed = reverse(slow);
        curr = head;

        while (reversed != null) {
            ListNode next = null;
            if (curr != null) {
                next = curr.next;
                curr.next = reversed;
            }
            curr = next;
            ListNode reversedNext = reversed.next;
            reversed.next = curr;
            reversed = reversedNext;
        }
        if (length % 2 == 0) {
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

2,4,6,8

2,4,6,8,10
*/