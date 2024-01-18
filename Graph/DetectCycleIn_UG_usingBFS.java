import java.util.*;

public class Solution {
    static class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    static class Graph {
        boolean isCycle(int src, int V, boolean vis[], List<List<Integer>> adj) {
            vis[src] = true;
            Queue<Pair> q = new LinkedList<>();
            q.add(new Pair(src, -1));
            while (!q.isEmpty()) {
                int node = q.peek().first;
                int parent = q.peek().second;
                q.remove();

                for (int adjencent : adj.get(node)) {
                    if (vis[adjencent] == false) {
                        vis[adjencent] = true;
                        q.add(new Pair(adjencent, node));
                    } else if (parent != adjencent) {
                        return true;
                    }
                }
            }
            return false;
        }

        boolean detectCycle(int V, List<List<Integer>> adj) {
            boolean vis[] = new boolean[V];
            for (int i = 0; i < V; i++) {
                if (vis[i] == false) {
                    if (isCycle(i, V, vis, adj)) {
                        return true;
                    }
                }
            }
            return false;
        }
    };
}
