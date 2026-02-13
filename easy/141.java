/*
141. Linked List Cycle

Approach :
1. We use Floyd's Cycle Detection Algorithm

2.Initialize both slwptr and fstptr to head.

3. Traverse the list while:
      fstptr != null
      fstptr.next != null

4. Move:
      slwptr = slwptr.next
      fstptr = fstptr.next.next

5. If at any point:
      slwptr == fstptr → return true (cycle detected).

6. If loop ends → return false (no cycle).
*/

public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slwptr = head;
        ListNode fstptr = head;

        while (fstptr != null && fstptr.next != null) {
            fstptr = fstptr.next.next;
            slwptr = slwptr.next;

            if (fstptr == slwptr) {
                return true;
            }
        }
        return false;
    }
}
