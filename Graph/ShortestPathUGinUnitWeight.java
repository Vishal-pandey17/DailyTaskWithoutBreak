class Solution {

    public int[] shortestPath(int[][] arr, int n, int m, int src) {
        int dis[] = new int[n];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            adj.get(arr[i][0]).add(arr[i][1]);
            adj.get(arr[i][1]).add(arr[i][0]);
        }

        for (int i = 0; i < n; i++) {
            dis[i] = (int) (1e9);
        }
        dis[src] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(src);

        while (!q.isEmpty()) {
            int node = q.peek();
            q.remove();

            for (int it : adj.get(node)) {
                if (dis[node] + 1 < dis[it]) {
                    dis[it] = 1 + dis[node];
                    q.add(it);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (dis[i] == 1e9) {
                dis[i] = -1;
            }
        }
        return dis;
    }
}