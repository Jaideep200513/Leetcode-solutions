/*
1518. Water Bottles

Approach :
1. Start with numBottles full bottles → drink them → they become empty.
2. While empty bottles ≥ numExchange, exchange them for new full bottles.
3. Keep track of total bottles drunk.
4. Finally, return total.

*/

class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int total = numBottles;
        int empty = numBottles;

        while (empty >= numExchange) {
            int newBottles = empty / numExchange; // how many full bottles we can get
            total += newBottles;
            empty = empty % numExchange + newBottles; // leftover empty + new empty
        }

        return total;
    }
}
