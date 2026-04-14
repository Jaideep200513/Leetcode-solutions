/*
143. Reorder List

Approach : 
1. Goal
    Reorder list as: L0 → Ln → L1 → Ln-1 → ...
2. Find Middle
    Use slow (p1) and fast (p2) pointers to reach middle.
3. Reverse Second Half
    Reverse nodes after middle using in-place insertion.
4. Merge Two Halves
    Take one node from first half, then one from reversed second half.
    Repeat until middle is reached.
5. Key Idea
    Split → Reverse → Merge.
*/

class Solution {
    public void reorderList(ListNode head) {
        if(head==null||head.next==null) return;
            
        ListNode p1=head;
        ListNode p2=head;
        while(p2.next!=null&&p2.next.next!=null){ 
            p1=p1.next;
            p2=p2.next.next;
        }
        
        ListNode preMiddle=p1;
        ListNode preCurrent=p1.next;
        while(preCurrent.next!=null){
            ListNode current=preCurrent.next;
            preCurrent.next=current.next;
            current.next=preMiddle.next;
            preMiddle.next=current;
        }
            
        p1=head;
        p2=preMiddle.next;
        while(p1!=preMiddle){
            preMiddle.next=p2.next;
            p2.next=p1.next;
            p1.next=p2;
            p1=p2.next;
            p2=preMiddle.next;
        }
    }
}
