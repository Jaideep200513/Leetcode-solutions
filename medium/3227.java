/*
3227. Vowels Game in a String

Approach:

1. Understand the rules
  Alice must remove a substring with an odd number of vowels.
  Bob must remove a substring with an even number of vowels.
  If a player cannot move → that player loses.
  Alice starts first.

2. Key observation
  If the string has no vowels, Alice cannot move at all → she loses immediately.
  If the string has at least one vowel, Alice can always pick a substring with exactly 1 vowel on her first turn.
  This guarantees she always has a move and can eventually win.

3. Final conclusion
  If there is at least one vowel → Alice wins (true).
  If there are no vowels → Alice loses (false).
  
*/

class Solution {
    public boolean doesAliceWin(String s) {
        // Check if there is at least one vowel
        for (char c : s.toCharArray()) {
            if (isVowel(c)) {
                return true; // Alice can always win
            }
        }
        return false; // No vowels, Alice cannot move
    }

    private boolean isVowel(char c) {
        return "aeiou".indexOf(c) != -1;
    }
}
