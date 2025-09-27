/*
812. Largest Triangle Area

Approach :
1. Pick every combination of 3 points.

2. Use the shoelace formula to calculate the area of the triangle:
    Area = 1/2 * |x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)|

3. Keep track of the maximum area among all possible triangles.

4. Since the number of points is small (≤ 50), a brute force O(n³) solution is efficient enough.

*/

class Solution {
    public double largestTriangleArea(int[][] points) {
        double maxArea = 0.0;
        int n = points.length;
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    int[] p1 = points[i];
                    int[] p2 = points[j];
                    int[] p3 = points[k];
                    
                    double area = 0.5 * Math.abs(
                        p1[0] * (p2[1] - p3[1]) +
                        p2[0] * (p3[1] - p1[1]) +
                        p3[0] * (p1[1] - p2[1])
                    );
                    
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        
        return maxArea;
    }
}
