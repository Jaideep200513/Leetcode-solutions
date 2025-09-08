/*
1317. Convert Integer to the Sum of two No-Zero Integers.

Approach:

1. We need two numbers a and b such that a + b = n.
2. Just pick one number (say a = 1).
3. Then the other number is b = n - 1.
4. If either a or b has a 0 inside → keep increasing a until both are “no-zero”.

*/

class Solution {
    public int[] getNoZeroIntegers(int n) {
        for (int a = 1; a < n; a++) {
            int b = n - a;
            if (isNoZero(a) && isNoZero(b)) {
                return new int[]{a, b};
            }
        }
        return new int[]{};
    }

    private boolean isNoZero(int num) {
        while (num > 0) {
            if (num % 10 == 0) return false;
            num /= 10;
        }
        return true;
    }
}
