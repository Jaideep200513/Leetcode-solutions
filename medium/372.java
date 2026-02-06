/*
372. Super Pow

Approach :
1. The exponent b is extremely large, so it cannot be converted to an integer.
2. Use the property of exponents in base-10 form:
      If b = [d1, d2, d3, ...], then
          a^b = ((a^d1)^10 * a^d2)^10 * a^d3)...
3. Start with result = 1.
4. For each digit d in b:
      Raise current result to power 10
      Multiply by a^d
      Take modulo 1337 at every step to keep numbers small.
5. Use fast modular exponentiation (binary exponentiation) to compute powers efficiently.

KEY FORMULA USED :
(x * y)mod m = ((x mod m)(y mod m))mod m
*/

class Solution {
    private static final int MOD = 1337;

    public int superPow(int a, int[] b) {
        a %= MOD;
        int result = 1;

        for (int digit : b) {
            result = modPow(result, 10) * modPow(a, digit) % MOD;
        }
        return result;
    }

    private int modPow(int a, int k) {
        int res = 1;
        a %= MOD;
        while (k > 0) {
            if ((k & 1) == 1) res = res * a % MOD;
            a = a * a % MOD;
            k >>= 1;
        }
        return res;
    }
}

