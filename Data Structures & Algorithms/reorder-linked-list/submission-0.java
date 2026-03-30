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
        
        // find the middle of list 
        ListNode slow = head, fast = head ;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        //reverse from the middle
        ListNode prev = null, curr = slow;

        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        ListNode temp1 = head;
        ListNode temp2 = prev;
        while(temp2 != null && temp1 != null){
            ListNode next1 = temp1.next;
            ListNode next2 = temp2.next;

            temp1.next = temp2;
            temp2.next = next1;
            temp1 = next1;
            temp2 = next2;
        }
    }
}
