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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null)return null;
        if(head.next==null) return null;
        head = reversed(head);
        if(n==1){
            head=head.next;
            head=reversed(head);
            return head;
        }
        // ListNode slow=head;
        // ListNode fast=head;
        int counter=1;
        ListNode curr = head;
        while(counter!=n){
            curr=curr.next;
            counter++;
        }
        ListNode newCurr = head;
        while(newCurr!=null){
            if(newCurr.next==curr){
                ListNode next=newCurr.next.next;
                newCurr.next=next;
                break;
            }
            newCurr=newCurr.next;
        }
                head=reversed(head);
        return head;
    }


    private static ListNode reversed(ListNode head){
        ListNode prev=null;
        while(head!=null){
            ListNode next=head.next;
            head.next=prev;
            prev=head;
            head=next;
        }
        return prev;
    }
}

/*
1,2,3,4
    s
      f
*/