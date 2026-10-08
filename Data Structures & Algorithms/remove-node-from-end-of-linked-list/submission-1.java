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
        if(head==null){
            return null;
        }
        ListNode fast = head;
        while(n>0){
            fast=fast.next;
            n--;
        }
        if(fast==null){
            return head.next;
        }
        ListNode slow=head;
        ListNode prev=null;
        while(fast!=null){
            fast=fast.next;
            prev=slow;
            slow=slow.next;
        }
        prev.next=slow.next;
        slow.next=null;
        return head;
    }
}
