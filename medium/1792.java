/*
1792. Maximum Average Pass Ratio

Approach:
1. Observation:
  Adding an extra student to a class [pass, total] increases its pass ratio.
  The improvement (gain) is:

      Δ  = ((pass + 1) / (total + 1)) - (pass / total)

	  This gain tells us how much benefit we get by adding one extra student to this class.

2. Greedy Choice:
  Always assign the next extra student to the class with the largest gain.
  This ensures we maximize the average pass ratio step by step.

3. Data Structure:
  Use a max heap (priority queue) where each class is stored with its current gain.
    Extract the class with the highest gain.
    Add one student to it (update pass & total).
    Recalculate its new gain and push it back into the heap.

4. Final Calculation:
  After all extra students are assigned, compute the sum of pass ratios of all classes and divide by the number of classes to get the final average.
  
*/

import java.util.*;

class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        // Max heap: sort by gain
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));
        
        // Push all classes with their current gain
        for (int[] c : classes) {
            int pass = c[0], total = c[1];
            double gain = gain(pass, total);
            pq.offer(new double[]{gain, pass, total});
        }
        
        // Assign extra students
        while (extraStudents-- > 0) {
            double[] top = pq.poll();
            int pass = (int) top[1];
            int total = (int) top[2];
            
            pass++;
            total++;
            
            double newGain = gain(pass, total);
            pq.offer(new double[]{newGain, pass, total});
        }
        
        // Calculate final average
        double sum = 0.0;
        while (!pq.isEmpty()) {
            double[] curr = pq.poll();
            sum += curr[1] / curr[2];
        }
        
        return sum / classes.length;
    }
    
    // Gain formula
    private double gain(int pass, int total) {
        return ((double)(pass + 1) / (total + 1)) - ((double) pass / total);
    }
}
