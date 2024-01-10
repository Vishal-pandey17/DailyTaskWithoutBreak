class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public static void dfs(int node, boolean vis[], ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> al) {
        vis[node] = true;
        al.add(node);

        for (int it : adj.get(node)) {
            if (vis[it] == false) {
                dfs(it, vis, adj, al);
            }
        }
    }

    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean visited[] = new boolean[V + 1];
        visited[0] = true;
        ArrayList<Integer> ans = new ArrayList<>();
        dfs(0, visited, adj, ans);
        return ans;
    }
}