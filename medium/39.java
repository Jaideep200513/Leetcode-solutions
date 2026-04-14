/*
39. Combination Sum

Approach : 
1. Goal
    Find all combinations of numbers that sum to target.
2. Backtracking
    Recursively try adding elements to the current combination.
3. Parameters
    t → remaining target
    com → current combination
    fl → start index (to avoid duplicates)
4. Base Case
    If t == 0 → add current combination to result.
5. Recursive Step
    Loop from index fl to end:
    If arr[i] <= t:
      Add element to com
      Recurse with reduced target (t - arr[i])
      Remove last element (backtrack)
6. Key Idea
    Same element can be reused → pass i again (not i+1).
*/

class Solution {
    private void sum(int t, int[] arr, List<Integer> com, List<List<Integer>> res, int fl){
        if(t==0){
            res.add(new ArrayList<>(com));
            return;
        }
        for(int i=fl; i<arr.length; i++){
            if(arr[i] <= t){
                com.add(arr[i]);
                sum(t-arr[i], arr, com, res, i);
                com.remove(com.size()-1);
            }
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        sum(target, candidates, new ArrayList<>(), res, 0);
        return res;
    }
}
