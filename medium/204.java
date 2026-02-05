/*
204. Count Primes

Approach :
1. We need count of primes strictly less than n.
2. Create a boolean array isPrime[n] and assume every number is prime.
3. Start from i = 2 up to √n:
      If i is prime, mark all its multiples (i*i, i*i+i, ...) as not prime.
4. Finally, count all numbers from 2 to n-1 still marked as prime.
5. Return the count.
*/

class Solution {
    public int countPrimes(int n) {
        if (n <= 2) return 0;

        boolean[] isPrime = new boolean[n];
        for (int i = 2; i < n; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) count++;
        }

        return count;
    }
}
