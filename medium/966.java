/*
966. owel Spellchecker

Approach:
We need to check each query word against the wordlist under 3 levels of matching rules (priority order):
1. Exact match (case-sensitive)
  If the query word is in wordlist exactly, return it.

2. Case-insensitive match
  Store a map from lowercase(word) → first word in wordlist.
  If query.toLowerCase() is found, return that original word.

3. Vowel-error-insensitive match
  Replace all vowels (a,e,i,o,u) with a special marker (say "*").
  Store a map from this devoweled lowercase word → first word in wordlist.
  If query after devowel transformation matches, return that original word.

4. Otherwise return "".
*/

import java.util.*;

class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> exactSet = new HashSet<>();
        Map<String, String> caseMap = new HashMap<>();
        Map<String, String> vowelMap = new HashMap<>();

        // Build dictionaries
        for (String word : wordlist) {
            exactSet.add(word);

            String lower = word.toLowerCase();
            caseMap.putIfAbsent(lower, word);

            String devowel = devowel(lower);
            vowelMap.putIfAbsent(devowel, word);
        }

        String[] result = new String[queries.length];

        for (int i = 0; i < queries.length; i++) {
            String q = queries[i];

            if (exactSet.contains(q)) {
                result[i] = q; // exact match
            } else {
                String lower = q.toLowerCase();
                if (caseMap.containsKey(lower)) {
                    result[i] = caseMap.get(lower); // case-insensitive
                } else {
                    String devowel = devowel(lower);
                    result[i] = vowelMap.getOrDefault(devowel, ""); // vowel error
                }
            }
        }

        return result;
    }

    // Replace vowels with '*'
    private String devowel(String word) {
        StringBuilder sb = new StringBuilder();
        for (char c : word.toCharArray()) {
            if ("aeiou".indexOf(c) >= 0) {
                sb.append('*');
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
