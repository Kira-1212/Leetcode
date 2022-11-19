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
        if(lists==null || lists.length == 0) return null;
        if(lists.length == 1)return lists[0];
        ListNode head = merge(lists[0], lists[1]);
        for(int i = 2; i<lists.length; i++){
            head = merge(head, lists[i]);
        }
        return head;
    }
    
    private ListNode merge(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while(l1!= null && l2 != null){
            if(l1.val <= l2.val){
                curr.next = l1;
                l1 = l1.next;
            }
            else{
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        if(l1 == null)
            curr.next = l2;
        if(l2 == null)
            curr.next = l1;
        return dummy.next;
    }
}