/*
2327. Number of People Aware of a Sedret

Approach:
1. Track how many people learn the secret each day.
  Let’s say dp[i] = number of people who learn the secret on day i.

2. Day 1:
  Only one person knows the secret → dp[1] = 1.

3. When can a person share?
  If someone learns the secret on day x, they start sharing from day x + delay until day x + forget - 1.
  On each of those days, they create the same number of new people as dp[x].

4. Simulation:
  For each day i, distribute dp[i] into future days [i + delay, i + forget - 1].
  This way we know exactly how many new people learn the secret each day.

5. Final count:
  At the end of day n, not everyone still remembers.
  A person who learned the secret on day i will forget on day i + forget.
  So, only those who learned on days [n - forget + 1 ... n] still know it.
  Sum up dp[i] for those days.

*/

class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int MOD = 1_000_000_007;
        long[] dp = new long[n + 1];
        dp[1] = 1;  // Day 1: first person knows the secret

        long sharing = 0; // people who can share on day i
        for (int day = 2; day <= n; day++) {
            // Add people who just became eligible to share today
            if (day - delay >= 1) {
                sharing = (sharing + dp[day - delay]) % MOD;
            }
            // Remove people who forget today (they can't share anymore)
            if (day - forget >= 1) {
                sharing = (sharing - dp[day - forget] + MOD) % MOD;
            }
            // Number of people learning the secret today
            dp[day] = sharing;
        }

        // Final answer = sum of people who still remember on day n
        long ans = 0;
        for (int i = n - forget + 1; i <= n; i++) {
            if (i >= 1) ans = (ans + dp[i]) % MOD;
        }
        return (int) ans;
    }
}

