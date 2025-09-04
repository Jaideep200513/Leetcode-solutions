/*
3516. Find Closest Person

Approach:
1. Understand the task
  Three people are on a number line:
      Person 1 at x
      Person 2 at y
      Person 3 fixed at z
  Person 1 and 2 move toward Person 3 at the same speed.
  We need to check who reaches Person 3 first.

2. Key idea
  The person who is closer to z (in terms of distance) will reach first.
  Distance is just the absolute difference:
      dist1 = |x - z|
      dist2 = |y - z|

3. Decision
  If dist1 < dist2 → Person 1 reaches first → return 1.
  If dist2 < dist1 → Person 2 reaches first → return 2.
  If dist1 == dist2 → Both reach at the same time → return 0.

*/
class Solution {
    public int findClosest(int x, int y, int z) {
        int dist1 = Math.abs(x - z);
        int dist2 = Math.abs(y - z);

        if (dist1 < dist2) {
            return 1;
        } else if (dist2 < dist1) {
            return 2;
        } else {
            return 0;
        }
    }
}
