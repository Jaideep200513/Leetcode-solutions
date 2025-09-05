/*
2749. Minimum Operations to Make the Integer Zero

Approach:
1. After doing k operations, the formula is:
    num1−k⋅num2=some sum of k powers of 2

2. That means:
    Let val = num1 - k * num2.
    For this to work:
      val >= k (since you need at least 1 per operation),
      bitcount(val) <= k (since binary form shows the minimum operations needed).

3. So the steps are:
  Loop k from 1 to 60.
  Compute val = num1 - k * num2.
  If both conditions hold → return k.
  If nothing works → return -1.
  
*/

class Solution {
    public int makeTheIntegerZero(int num1, int num2) {
        for (int k = 1; k <= 60; k++) {
            long val = (long) num1 - (long) num2 * k;  // Remaining value after k operations
            if (val < k) continue;                     // Need at least k to distribute
            if (Long.bitCount(val) <= k && k <= val) { // Feasible if #bits <= k
                return k;
            }
        }
        return -1;
    }
}
