/*

166. Fraction to Recurring Decimal

Approach :
1. Handle sign
  If numerator and denominator have different signs, the result will be negative.

2. Integer part
  Divide numerator by denominator to get the integer part.
  Append it to the result.

3. Remainder check
  If there is no remainder, return the integer part as the answer (no decimal).

4. Decimal part
  Start long division: multiply remainder by 10, divide by denominator, and append quotient digits.

5. Detect repeating part
  Use a map (remainder → index in result string).
  If the same remainder appears again, it means digits started repeating.
  Insert "(" at the first occurrence index and append ")" at the end.

6. Return result
  If no repeating remainder is found, just return the constructed number.
  
*/

import java.util.*;

class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";

        StringBuilder result = new StringBuilder();

        // Check if result should be negative
        if ((numerator < 0) ^ (denominator < 0)) {
            result.append("-");
        }

        // Convert to long to avoid overflow
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        // Append the integer part
        result.append(num / den);
        long remainder = num % den;

        if (remainder == 0) {
            return result.toString();
        }

        result.append(".");

        // Map to store remainder and its corresponding index in result
        Map<Long, Integer> map = new HashMap<>();

        while (remainder != 0) {
            if (map.containsKey(remainder)) {
                int index = map.get(remainder);
                result.insert(index, "(");
                result.append(")");
                break;
            }

            map.put(remainder, result.length());
            remainder *= 10;
            result.append(remainder / den);
            remainder %= den;
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.fractionToDecimal(1, 2));   // "0.5"
        System.out.println(sol.fractionToDecimal(2, 1));   // "2"
        System.out.println(sol.fractionToDecimal(4, 333)); // "0.(012)"
        System.out.println(sol.fractionToDecimal(1, 6));   // "0.1(6)"
    }
}
