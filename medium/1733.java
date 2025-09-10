/*
1733. Minimum Number of People to Teach.

Approach:
1. Go through each friendship.
  If both friends already share a common language → ignore.
  If not → mark both friends as "problematic users".

2. Now, for each language (1 to n):
  Count how many of those problematic users already know that language.
  Users who don’t know it → must be taught.

3. Answer = minimum number of people to teach across all languages.

*/

import java.util.*;

class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        int m = languages.length;

        // convert each user's languages into a set for quick lookup
        List<Set<Integer>> langs = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            Set<Integer> set = new HashSet<>();
            for (int lang : languages[i]) {
                set.add(lang);
            }
            langs.add(set);
        }

        // find all users in problematic friendships
        Set<Integer> problematic = new HashSet<>();
        for (int[] f : friendships) {
            int u = f[0] - 1; // convert to 0-based
            int v = f[1] - 1;
            if (Collections.disjoint(langs.get(u), langs.get(v))) {
                problematic.add(u);
                problematic.add(v);
            }
        }

        // if no problematic users → no teaching needed
        if (problematic.isEmpty()) {
            return 0;
        }

        int ans = Integer.MAX_VALUE;

        // try teaching each language
        for (int lang = 1; lang <= n; lang++) {
            int knows = 0;
            for (int user : problematic) {
                if (langs.get(user).contains(lang)) {
                    knows++;
                }
            }
            int needToTeach = problematic.size() - knows;
            ans = Math.min(ans, needToTeach);
        }

        return ans;
    }
}
