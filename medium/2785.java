/*
2785. Sort Vowels in a Sting

Approach:
1. Identify vowels
  We only care about characters 'a','e','i','o','u' (both uppercase and lowercase).
  Consonants will remain fixed in their positions.

2. Collect all vowels
  Traverse the string once and extract all vowels into a list/array.

3. Sort the vowels
  Sort that list by ASCII value (so uppercase letters will come before lowercase, e.g., 'E' < 'O' < 'a').

4. Reconstruct the string
  Traverse the string again.
  If the character is a consonant → keep it as it is.
  If it is a vowel → replace it with the next smallest vowel from the sorted list.

5. Return the new string

*/

class Solution {
    public String sortVowels(String s) {
        // Step 1: Extract vowels
        List<Character> vowels = new ArrayList<>();
        for (char c : s.toCharArray()) {
            if (isVowel(c)) vowels.add(c);
        }

        // Step 2: Sort vowels by ASCII value
        Collections.sort(vowels);

        // Step 3: Rebuild string with sorted vowels
        StringBuilder result = new StringBuilder();
        int vowelIndex = 0;
        for (char c : s.toCharArray()) {
            if (isVowel(c)) {
                result.append(vowels.get(vowelIndex++));
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }

    private boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }
}
