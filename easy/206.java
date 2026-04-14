/*
206. Reverse Linked List

Approach :
1. Goal
    Reverse a singly linked list.
2. Initialize
    prev = null, current = head
3. Iterate
    While current != null:
      Store next node → next = current.next
      Reverse link → current.next = prev
      Move prev forward → prev = current
      Move current forward → current = next
4. Return
    prev becomes the new head of reversed list.
5. Key Idea
    Reverse pointers one by one while traversing.
*/

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;  
        ListNode current = head;
    
        
        while(current != null) { 
            ListNode next = current.next; 
            current.next = prev;
            prev = current;
            current = next;
        }
       return prev; 
    }
}
