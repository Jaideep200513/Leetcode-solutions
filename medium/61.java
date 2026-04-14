/*
61. Rotate List

Approach :
1. Edge Case
    If head == null → return head.
2, Find Length
    Traverse list to get length and last node (dummy).
3. Normalize k
    Compute k % length to avoid extra rotations.
    If result is 0 → return head.
4. Find Break Point
    Move to (length - k - 1)th node.
5. Rotate
    newHead = current.next
    Break link → current.next = null
    Connect last node to head → dummy.next = head
6. Return
    Return newHead.
7 Key Idea
Convert to circular → break at correct position.
*/

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return head;

        int length = 1;
        ListNode dummy = head;

        while (dummy.next != null) {
            dummy = dummy.next;
            length++;
        }

        int position = k % length;
        if (position == 0) return head;

        ListNode current = head;
        for (int i = 0; i < length - position - 1; i++) {
            current = current.next;
        }

        ListNode newHead = current.next;
        current.next = null;
        dummy.next = head;

        return newHead;        
    }
}
