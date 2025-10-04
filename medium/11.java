/*
11. Container wih Most Water

Approach :
1. Take two lines at indices i and j.
2. The width = j - i.
3. The height = min(height[i], height[j]).
4. Area = width * height.
5. Keep track of the maximum area.

*/

class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            // Calculate current area
            int width = right - left;
            int minHeight = Math.min(height[left], height[right]);
            int area = width * minHeight;

            // Update maximum area
            maxArea = Math.max(maxArea, area);

            // Move the pointer pointing to the shorter line
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}
