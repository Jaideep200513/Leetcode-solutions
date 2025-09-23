/*
165. Compare Version Numbers

Approach :
1. Split both versions by "." → get arrays of revisions.

2. Loop through both arrays together up to the longest length.
  If one version has fewer parts, treat the missing part as 0.

3. Convert each revision to integer (this removes leading zeros).

4. Compare integers at the same position:
  If one is smaller → return -1.
  If one is larger → return 1.

5. If all parts are equal → return 0.

*/

class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        int n = Math.max(v1.length, v2.length);

        for (int i = 0; i < n; i++) {
            int num1 = i < v1.length ? Integer.parseInt(v1[i]) : 0;
            int num2 = i < v2.length ? Integer.parseInt(v2[i]) : 0;

            if (num1 < num2) return -1;
            if (num1 > num2) return 1;
        }

        return 0;
    }
}
