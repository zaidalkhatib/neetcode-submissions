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
        if(lists.length==0||(lists.length==1&&lists[0]==null)){
            return null;
        }
        Queue<ListNode> queue = new PriorityQueue<>((a,b)->(a.val-b.val));
        for(ListNode node : lists){
            if(node==null){
                continue;
            }
            queue.add(node);
        }
        ListNode dummy = new ListNode(-1);
        ListNode head=dummy;
        while(!queue.isEmpty()){
            ListNode top = queue.remove();
            head.next=top;
            head=head.next;
            ListNode next=top.next;
            if(next!=null){
                queue.add(next);
            }
        }
        return dummy.next;
    }
}
