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
        List<ListNode> list = new ArrayList<>();
        while(head!=null){
            list.add(head);
            head=head.next;
        }
        for(int i=list.size()-1 ;i>=0 ;i--){
            n--;
            if(n==0){
                list.remove(list.get(i));
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode dummyHead = dummy;
        for(ListNode node : list){
            node.next=null;
            dummyHead.next=node;
            dummyHead=dummyHead.next;
        }
        return dummy.next;
    }
}

/*
1,2,3,4
    s
      f
*/