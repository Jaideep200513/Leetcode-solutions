/*
1935. Maximum Number of Words You Can Type

Approach:
1. Split the text into words (using space " ").
2. For each word, check every character.
3. If any character is in brokenLetters, that word cannot be typed.
4. Otherwise, count it as typeable.
5. Return the total count of typeable words.
*/

class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        // Store broken letters in a set for quick lookup
        boolean[] broken = new boolean[26];
        for (char c : brokenLetters.toCharArray()) {
            broken[c - 'a'] = true;
        }
        
        String[] words = text.split(" ");
        int count = 0;

        for (String word : words) {
            boolean canType = true;
            for (char c : word.toCharArray()) {
                if (broken[c - 'a']) {
                    canType = false;
                    break;
                }
            }
            if (canType) count++;
        }

        return count;
    }
}
