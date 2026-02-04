/*
190. Reverse Bits

Approach :
1. Initialize result = 0.
2. Loop 32 times:
      Left shift result to make space.
      Extract last bit of n using (n & 1).
      Add it to result.
      Right shift n.
3. Return result.
*/

class Solution {
    public int reverseBits(int n) {
        int res = 0;
        
        for (int i = 0; i < 32; i++) {
            res <<= 1;          
            res |= (n & 1);    
            n >>= 1;           
        }
        
        return res;
    }
}
