/*
2221. Find Triangular Sum of an Array

Approach :
1. Start with the given nums.
2. Iteratively replace each element with (nums[i] + nums[i+1]) % 10.
3. Shrink the array size by 1 each round.
4. Continue until only one number remains, which is the triangular sum.

*/

class Solution {
    public int triangularSum(int[] nums) {
        int n = nums.length;
        // Keep reducing the array until only one element remains
        for (int size = n; size > 1; size--) {
            for (int i = 0; i < size - 1; i++) {
                nums[i] = (nums[i] + nums[i + 1]) % 10;
            }
        }
        return nums[0];
    }
}
