class Solution {
    // Function to return list containing vertices in Topological order.
    static void dfs(int i, ArrayList<ArrayList<Integer>> adj, Stack<Integer> st, int vis[]) {
        vis[i] = 1;
        for (int it : adj.get(i)) {
            if (vis[it] == 0) {
                dfs(it, adj, st, vis);
            }
        }
        st.push(i);
    }

    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        int vis[] = new int[V];
        int ans[] = new int[V];
        Stack<Integer> st = new Stack<Integer>();
        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                dfs(i, adj, st, vis);
            }
        }
        int i = 0;
        while (!st.isEmpty()) {
            ans[i++] = st.peek();
            st.pop();
        }
        return ans;
    }
}
