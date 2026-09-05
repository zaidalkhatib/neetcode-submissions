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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = null;
        for(ListNode list : lists){
            head=merge(head,list);
        }

        return head;
    }

    private ListNode merge(ListNode list1,ListNode list2){
        ListNode dummy = new ListNode();
        ListNode head = dummy;
        while(list1!=null||list2!=null){
            int val1 = list1==null?Integer.MAX_VALUE:list1.val;
            int val2 = list2==null?Integer.MAX_VALUE:list2.val;
            if(val1>val2){
                head.next=list2;
                list2=list2.next;
            }else{
                head.next=list1;
                list1=list1.next;
            }
            head=head.next;
        }
        return dummy.next;
    }
}
