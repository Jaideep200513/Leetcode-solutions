/*
328. Odd Even Linked List

Appraoch :
1. Maintain two pointers: odd (starting at head) and even (starting at head.next), and store evenHead to reconnect later.

2. Traverse the list while even and even.next are not null:
      Link current odd node to the next odd node (odd.next = odd.next.next)
      Link current even node to the next even node (even.next = even.next.next)
      Move both pointers forward
      
3. After traversal, attach the even list after the odd list using odd.next = evenHead.

4. Return head.
*/

class Solution {
    public ListNode oddEvenList(ListNode head) {
        
        if (head == null || head.next == null) 
            return head;

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            odd = odd.next;

            even.next = even.next.next;
            even = even.next;  
        }

        odd.next = evenHead;
        return head;
    }
}
