/*
2197. Replace Non-Coprime Numbers in Array

Approach:

1. Start with the given array nums.
2. Scan from left to right, checking every pair of adjacent numbers:
    If they are non-coprime (gcd(a, b) > 1):
        Replace them with their LCM.
        Start scanning again from one step before (to check if new number merges further).
3. Keep repeating until no adjacent non-coprime pair is found.
4. Return the final array.
*/

import java.util.*;

class Solution {
    
    // Function to calculate GCD
    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Function to calculate LCM
    private long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }

    public List<Integer> replaceNonCoprimes(int[] nums) {
        Stack<Long> stack = new Stack<>();

        for (int num : nums) {
            long curr = num;
            
            // Keep merging while adjacent numbers are non-coprime
            while (!stack.isEmpty()) {
                long top = stack.peek();
                long g = gcd(top, curr);
                if (g == 1) break; // coprime, stop merging
                curr = lcm(top, curr); // merge
                stack.pop();
            }
            stack.push(curr);
        }

        // Convert stack back to list of integers
        List<Integer> result = new ArrayList<>();
        for (long val : stack) {
            result.add((int) val);
        }
        return result;
    }
}
