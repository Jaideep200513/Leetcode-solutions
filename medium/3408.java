/*

3408. Design Task Manager

Approach: 
1. A priority queue to always fetch the highest (priority, taskId) efficiently.

2. A map from taskId → (userId, priority) to allow fast updates and removals.

3. For edit and rmv, we just update/remove from the map, and rely on lazy deletion (ignore outdated entries when popped from the heap).

*/

import java.util.*;

class TaskManager {
    // Max-heap sorted by priority desc, then taskId desc
    private PriorityQueue<int[]> pq;
    private Map<Integer, int[]> taskMap; // taskId -> [userId, priority]

    public TaskManager(List<List<Integer>> tasks) {
        pq = new PriorityQueue<>((a, b) -> {
            if (a[1] != b[1]) return b[1] - a[1]; // higher priority first
            return b[0] - a[0]; // higher taskId if tie
        });
        taskMap = new HashMap<>();

        for (List<Integer> t : tasks) {
            int userId = t.get(0), taskId = t.get(1), priority = t.get(2);
            taskMap.put(taskId, new int[]{userId, priority});
            pq.offer(new int[]{taskId, priority});
        }
    }
    
    public void add(int userId, int taskId, int priority) {
        taskMap.put(taskId, new int[]{userId, priority});
        pq.offer(new int[]{taskId, priority});
    }
    
    public void edit(int taskId, int newPriority) {
        int userId = taskMap.get(taskId)[0];
        taskMap.put(taskId, new int[]{userId, newPriority});
        pq.offer(new int[]{taskId, newPriority}); // push updated version
    }
    
    public void rmv(int taskId) {
        taskMap.remove(taskId); // lazy removal (stale entries in pq ignored)
    }
    
    public int execTop() {
        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int taskId = top[0], priority = top[1];
            if (taskMap.containsKey(taskId) && taskMap.get(taskId)[1] == priority) {
                int userId = taskMap.get(taskId)[0];
                taskMap.remove(taskId); // remove executed task
                return userId;
            }
        }
        return -1;
    }
}
