/*
1493. Longest Subarray of 1's After Deleting One Element

Approach:
1. We must delete one element
  That means the longest valid subarray will always be: a window that contains at most one 0.

2. Use sliding window technique
  Maintain two pointers: left and right.
  Expand right across the array.
  Keep track of how many zeros are inside the current window (zeroCount).

3. Condition: At most one zero
  If zeroCount > 1, shrink the window from the left until there is at most one zero inside.

4. Update the maximum length
  At each step, compute the window size (right - left + 1).
  This represents the subarray length including at most one zero.

5. Subtract 1
  Since we must delete one element (either the zero inside or a one if the array has no zero at all),
  the final answer is maxLen - 1.
  */

class Solution {
    public int longestSubarray(int[] nums) {
        int left = 0;
        int zeroCount = 0;
        int maxLen = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                zeroCount++;
            }

            while (zeroCount > 1) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }

            // window length, but we must delete one element
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen - 1;  // must delete one
    }
}
