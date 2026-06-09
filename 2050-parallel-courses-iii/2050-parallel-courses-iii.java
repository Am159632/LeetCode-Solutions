import java.util.*;

public class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        // 1. Build the graph (Adjacency List) and track in-degrees
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        
        int[] inDegree = new int[n + 1];
        for (int[] rel : relations) {
            int prev = rel[0];
            int next = rel[1];
            adj.get(prev).add(next);
            inDegree[next]++;
        }
        
        // 2. DP table to track the maximum completion time for each course
        int[] maxTime = new int[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        
        // Initialization: Courses with no prerequisites can start at time 0
        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
                maxTime[i] = time[i - 1]; // time array is 0-indexed, courses are 1-indexed
            }
        }
        
        // 3. Process the graph using Kahn's Algorithm (Topological Sort BFS)
        while (!queue.isEmpty()) {
            int u = queue.poll();
            
            // Traverse all courses that depend on the current course 'u'
            for (int v : adj.get(u)) {
                // DP State Transition: A course can only start after ALL its prerequisites are done.
                // We update maxTime[v] to be the maximum completion time among its preceding paths.
                maxTime[v] = Math.max(maxTime[v], maxTime[u] + time[v - 1]);
                
                // Decrement the in-degree; if all prerequisites are completed, add to the queue
                inDegree[v]--;
                if (inDegree[v] == 0) {
                    queue.offer(v);
                }
            }
        }
        
        
        // 4. The final answer is the overall maximum time taken by any course sequence
        int totalMinTime = 0;
        for (int i = 1; i <= n; i++) {
            totalMinTime = Math.max(totalMinTime, maxTime[i]);
        }
        
        return totalMinTime;
    }
}