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
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->a.val-b.val);
        for(ListNode list : lists){
            if(list!=null){
                pq.offer(list);
            }
        }

        ListNode res = null;
        ListNode head = null;
        while(!pq.isEmpty()){
            ListNode curr = pq.poll();
            if(res==null){
                res = curr;
                head = res;
            }
            else{
                res.next = curr;
                res = res.next; 
            }
            if(curr.next != null){
                pq.offer(curr.next);
            }
        }

        return head;

    }
}
