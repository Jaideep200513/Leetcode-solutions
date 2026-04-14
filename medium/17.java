/*
17. Letter Combinations of a Phone Number

Approach : 
1. Edge Case
    If digits is empty → return empty list.
2. Mapping
    Store digit-to-letter mappings (2–9) using a HashMap.
3. Backtracking
    Use recursion to build all combinations.
4. Base Case
    If idx == digits.length() → add current combination to result.
5. Recursive Step
    Get letters for current digit.
    For each letter:
      Append to current combination
      Recurse for next index (idx + 1)
      Remove last character (backtrack)
6. Idea
    Try all possible letters for each digit and explore all paths.
*/

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        
        if (digits == null || digits.length() == 0) {
            return res;
        }
        
        Map<Character, String> digitToLetters = new HashMap<>();
        digitToLetters.put('2', "abc");
        digitToLetters.put('3', "def");
        digitToLetters.put('4', "ghi");
        digitToLetters.put('5', "jkl");
        digitToLetters.put('6', "mno");
        digitToLetters.put('7', "pqrs");
        digitToLetters.put('8', "tuv");
        digitToLetters.put('9', "wxyz");
        
        backtrack(digits, 0, new StringBuilder(), res, digitToLetters);
        
        return res;        
    }

    private void backtrack(String digits, int idx, StringBuilder comb, List<String> res, Map<Character, String> digitToLetters) {
        if (idx == digits.length()) {
            res.add(comb.toString());
            return;
        }
        
        String letters = digitToLetters.get(digits.charAt(idx));
        for (char letter : letters.toCharArray()) {
            comb.append(letter);
            backtrack(digits, idx + 1, comb, res, digitToLetters);
            comb.deleteCharAt(comb.length() - 1);
        }
    }    
}
