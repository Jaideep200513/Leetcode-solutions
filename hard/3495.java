/*
3495. Minimum Operations to Make Array Elements Zero

Approach:
1. To reduce a number `x` to `0`, count how many times you divide by 4 → call it `steps(x)`.  
   - Example: `20 → 5 → 1 → 0` → 3 steps

2. For a range `[l, r]`, the total work = `steps(l) + steps(l+1) + ... + steps(r)`.

3. Each operation processes 2 numbers at once →  
   `answer = ceil(totalSteps / 2)`

4. Optimization:  
   - Numbers in `[1..3]` → always 1 step  
   - `[4..15]` → always 2 steps  
   - `[16..63]` → always 3 steps  
   - General rule: `[4^(k-1) .. 4^k - 1]` → `k` steps  

   Count numbers from `[l..r]` falling in each block and multiply by `k`.

5. Sum results for all queries.

*/
public class Solution {
    public long minOperations(int[][] queries) {
        long total = 0;
        for (int[] q : queries) {
            int l = q[0], r = q[1];
            long sumSteps = stepsSum(r) - stepsSum(l - 1);
            total += (sumSteps + 1) / 2;  // ceil division by 2
        }
        return total;
    }

    // Compute sum of steps for all numbers in [1..n]
    private long stepsSum(long n) {
        if (n <= 0) return 0;
        long sum = 0;
        long start = 1;
        int step = 1;
        while (start <= n) {
            long end = Math.min(n, (1L << (2 * step)) - 1); // 4^step - 1 = (1 << 2*step) - 1
            long count = end - start + 1;
            sum += count * step;
            start <<= 2; // move to next block (start = 4^step)
            step++;
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] q1 = {{1,2},{2,4}};
        System.out.println(sol.minOperations(q1)); // 3

        int[][] q2 = {{2,6}};
        System.out.println(sol.minOperations(q2)); // 4

        int[][] q3 = {{1, 1000000000}};
        System.out.println(sol.minOperations(q3)); // runs fast even for big ranges
    }
}
