/*
3000. Maximum Area of Longest Diagnal Rectangle 

Approach:
1. Loop through each rectangle.
2. Compute its diagonal length using Pythagoras theorem.
3. Keep track of the maximum diagonal found so far.
4. If diagonals are equal, choose the rectangle with the larger area.
5. Return the final maxArea.

*/  

class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        double maxDiagonal = 0;
        int maxArea = 0;

        for (int[] rect : dimensions) {
            int length = rect[0];
            int width = rect[1];
            double diagonal = Math.sqrt(length * length + width * width);
            int area = length * width;

            if (diagonal > maxDiagonal) {
                maxDiagonal = diagonal;
                maxArea = area;
            } else if (diagonal == maxDiagonal && area > maxArea) {
                maxArea = area;
            }
        }

        return maxArea;
    }
}
