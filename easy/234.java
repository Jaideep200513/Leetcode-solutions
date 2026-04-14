/*
234. Palindrome Linked List

Approach : 
1. Goal
    Check if a linked list is a palindrome.
2. Convert to Array
    Traverse the list and store values in an ArrayList.
3. Two Pointers
    Use left = 0 and right = size - 1.
4. Compare
    While left < right:
      If values differ → return false
      Move both pointers inward
5. Return
    If all match → return true
6. Key Idea
    Convert to array for easy symmetric comparison.
*/

class Solution {
    public boolean isPalindrome(ListNode head) {
        List<Integer> arr = new ArrayList<>();

        while (head != null) {
            arr.add(head.val);
            head = head.next;
        }

        int left = 0;
        int right = arr.size() - 1;

        while (left < right) {
            if (!arr.get(left).equals(arr.get(right))) {
                return false;
            }
            left++;
            right--;
        }

        return true;        
    }
}
