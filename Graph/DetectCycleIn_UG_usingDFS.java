import java.util.List;

public class Solution {
    static class Graph {
        boolean detectCycle(int V, List<List<Integer>> adj) {
            int vis[] = new int[V];
            for (int i = 0; i < V; i++) {
                if (vis[i] == 0) {
                    if (dfs(i, -1, vis, adj)) {
                        return true;
                    }
                }
            }
            return false;
        }

        boolean dfs(int node, int parent, int vis[], List<List<Integer>> adj) {
            vis[node] = 1;
            // go to all adjacent nodes
            for (int adjacentNode : adj.get(node)) {
                if (vis[adjacentNode] == 0) {
                    if (dfs(adjacentNode, node, vis, adj) == true)
                        return true;
                }
                // if adjacent node is visited and is not its own parent node
                else if (adjacentNode != parent)
                    return true;
            }
            return false;
        }
    };
}
