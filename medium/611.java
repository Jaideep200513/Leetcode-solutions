/*
611. Valid Triangle Number

Approach:
1. Sort the array.

2. Fix the largest side (nums[k]).

3 Use two pointers (i and j) to find pairs such that nums[i] + nums[j] > nums[k].
    If valid, all values between i and j with j form a triangle, so add (j - i) to count.
    Move j--.
    Otherwise, move i++.

4. Return total count.

*/

import java.util.Arrays;

class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int count = 0;

        for (int k = n - 1; k >= 2; k--) {
            int i = 0, j = k - 1;
            while (i < j) {
                if (nums[i] + nums[j] > nums[k]) {
                    count += (j - i);
                    j--;
                } else {
                    i++;
                }
            }
        }
        return count;
    }
}
