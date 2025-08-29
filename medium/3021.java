/*
3021. Alice and Bob Playing Flower Game

Approach:
Alice wins if total flowers (x + y) is odd.
So we just need to count pairs (x, y) where x + y is odd.
That happens only if:
  x is odd, y is even
  OR x is even, y is odd
Count odds and evens in [1..n] and [1..m], then multiply accordingly:

Answer = (odds in n × evens in m) + (evens in n × odds in m)

*/

class Solution {
    public long flowerGame(int n, int m) {
        long on = (n + 1L) / 2, en = n / 2;
        long om = (m + 1L) / 2, em = m / 2;
        return on * em + en * om;
    }
}
