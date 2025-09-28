/*
976. Largest Perimeter Triangle

Approach :
1. Sort the array of side lengths.
2. Start checking from the largest three sides (since bigger sides give bigger perimeter).
3. For three sides a, b, c (where c is the largest), check the triangle condition:
4. If true, return a + b + c (largest perimeter).
5. If no such triplet exists, return 0.

*/
import java.util.Arrays;

class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);  // Sort the array in ascending order
        for (int i = nums.length - 1; i >= 2; i--) {
            // Check triangle inequality
            if (nums[i - 2] + nums[i - 1] > nums[i]) {
                return nums[i] + nums[i - 1] + nums[i - 2];
            }
        }
        return 0; // No valid triangle
    }
}
