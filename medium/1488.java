/*
1488. Avoid Flood in The City

Approach :
1. Use map to store last rain day of each lake.
2. Use TreeSet to store dry day indices.
3. When it rains on a full lake → pick the earliest available dry day after the last rain.
4. If no such dry day → return [].

*/

import java.util.*;

public class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] ans = new int[n];
        Map<Integer, Integer> fullLakes = new HashMap<>(); // lake -> last day it rained
        TreeSet<Integer> dryDays = new TreeSet<>(); // indices of dry days (0s)

        for (int i = 0; i < n; i++) {
            if (rains[i] == 0) {
                dryDays.add(i);
                ans[i] = 1; // default value, will adjust later
            } else {
                int lake = rains[i];
                ans[i] = -1; // raining day
                if (fullLakes.containsKey(lake)) {
                    // Find a dry day after last rain of this lake
                    Integer dryDay = dryDays.higher(fullLakes.get(lake));
                    if (dryDay == null) {
                        return new int[0]; // no valid dry day -> flood
                    }
                    ans[dryDay] = lake; // dry this lake
                    dryDays.remove(dryDay);
                }
                fullLakes.put(lake, i); // update last rain day
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] rains1 = {1, 2, 3, 4};
        System.out.println(Arrays.toString(sol.avoidFlood(rains1)));
        // Output: [-1, -1, -1, -1]

        int[] rains2 = {1, 2, 0, 0, 2, 1};
        System.out.println(Arrays.toString(sol.avoidFlood(rains2)));
        // Output: [-1, -1, 2, 1, -1, -1]

        int[] rains3 = {1, 2, 0, 1, 2};
        System.out.println(Arrays.toString(sol.avoidFlood(rains3)));
        // Output: []
    }
}
