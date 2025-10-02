/*
3100. Water Bottles II

Approach :
1. Start by drinking all numBottles and store that count.

2. Each time you exchange numExchange empty bottles for 1 full bottle:
      Decrease empty by numExchange
      Increase numExchange by 1
      Increase total drunk count by 1
      The exchanged full bottle becomes empty after drinking, so empty++

3. Repeat while you have enough empty bottles.

*/

class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int drunk = numBottles;  // total bottles drunk
        int empty = numBottles;  // empty bottles after drinking

        while (empty >= numExchange) {
            // Exchange empty bottles for 1 full bottle
            empty -= numExchange;
            numExchange++; // increase requirement after each exchange
            drunk++;       // drink the newly obtained bottle
            empty++;       // new bottle becomes empty after drinking
        }

        return drunk;
    }
}
