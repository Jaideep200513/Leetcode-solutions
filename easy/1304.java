/*
1304. Find N Unique Integers Sum upto Zero

Approach:
1. If n is even:
    Just take pairs like 1, -1, 2, -2, ... until you have n numbers.
    Example: n = 4 → [1, -1, 2, -2].

2. If n is odd:
    Do the same as above for n-1 numbers, then add 0 at the end.
    Example: n = 5 → [1, -1, 2, -2, 0].
    
*/

class Solution {
    public int[] sumZero(int n) {
        int[] result = new int[n];
        int index = 0;

        // Fill pairs of numbers (i and -i)
        for (int i = 1; i <= n / 2; i++) {
            result[index++] = i;
            result[index++] = -i;
        }

        // If n is odd, add 0 in the middle
        if (n % 2 == 1) {
            result[index] = 0;
        }

        return result;
    }
}
