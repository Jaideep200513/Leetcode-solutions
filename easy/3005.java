/*
3005. Count Elements with Maximum Frequency

Approach :
1. Count how many times each number appears.
  Since nums[i] ≤ 100, we can just use an array of size 101 to store frequencies.
  
2. Find the maximum frequency among all numbers.

3. Add up the frequencies of all numbers that have this maximum frequency.
*/

import java.util.*;

public class Solution {
    public int maxFrequencyElements(int[] nums) {
        // Count frequency of each number
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Find maximum frequency
        int maxFreq = 0;
        for (int f : freq.values()) {
            maxFreq = Math.max(maxFreq, f);
        }

        // Count total elements that have this maximum frequency
        int total = 0;
        for (int f : freq.values()) {
            if (f == maxFreq) {
                total += f;
            }
        }

        return total;
    }

    // Example test
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums1 = {1, 2, 2, 3, 1, 4};
        int[] nums2 = {1, 2, 3, 4, 5};

        System.out.println(sol.maxFrequencyElements(nums1)); // Output: 4
        System.out.println(sol.maxFrequencyElements(nums2)); // Output: 5
    }
}
