/*
22. Generate Parentheses

Appraoch : 
1. Goal
    Generate all valid parentheses combinations of length 2n.
2. Backtracking
    Build the string step by step using recursion.
3. Parameters
    left → number of ( used
    right → number of ) used
    s → current string
4. Base Case
    If s.length() == 2 * n → add to result.
5. Add (
    If left < n → add "(" and recurse.
6. Add )
    If right < left → add ")" and recurse
    (ensures valid parentheses)
7. Idea
    Always keep the string valid while building.
*/

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        recurse(res, 0, 0, "", n);
        return res;
    }
    
    public void recurse(List<String> res, int left, int right, String s, int n) {
        if (s.length() == n * 2) {
            res.add(s);
            return;
        }
        
        if (left < n) {
            recurse(res, left + 1, right, s + "(", n);
        }
        
        if (right < left) {
            recurse(res, left, right + 1, s + ")", n);
        }
    }
}
