/*
3541. Find Most Frequent Vowel and Consonant

Approach:
1. Count frequencies of all characters in the string.
2. Check vowels (a, e, i, o, u) → keep track of the maximum frequency among them.
3. Check consonants (all other letters) → keep track of the maximum frequency among them.
4. Answer = max vowel frequency + max consonant frequency.
  If no vowels → vowel freq = 0
  If no consonants → consonant freq = 0
*/

class Solution {
    public int maxFreqSum(String s) {
        String vowels = "aeiou";
        int[] freq = new int[26];

        // count frequency
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        int maxVowel = 0, maxConsonant = 0;

        for (int i = 0; i < 26; i++) {
            char ch = (char)(i + 'a');
            if (vowels.indexOf(ch) != -1) { // it's a vowel
                maxVowel = Math.max(maxVowel, freq[i]);
            } else { // consonant
                maxConsonant = Math.max(maxConsonant, freq[i]);
            }
        }

        return maxVowel + maxConsonant;
    }
}
