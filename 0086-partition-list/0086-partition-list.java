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
    public ListNode partition(ListNode head, int x) {
        ListNode left = new ListNode(-1);
        
        ListNode leftcurr = left;
        ListNode right = new ListNode(-1);
        
        ListNode rightcurr = right;
        ListNode curr = head;
        
        while(curr!=null){
            if(curr.val>=x){
                rightcurr.next = curr;
                rightcurr = rightcurr.next;
            }
            else{
                 leftcurr.next = curr;
                leftcurr = leftcurr.next;
            }
            curr = curr.next;

        }
        leftcurr.next = right.next;
        rightcurr.next =null;
        return left.next;
    }
}