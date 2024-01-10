class Solution {
    public int findCircleNum(int[][] arr) {
        // self connected components
        // TC => O(N) + O(V+2E)
        // SC => O(N) + O(N)
        int V = arr.length;
        boolean isVisited[] = new boolean[V];
        int count = 0;

        for (int i = 0; i < V; i++) {
            if (!isVisited[i]) {
                count++;
                dfs(arr, i, isVisited);
            }
        }
        return count;
    }

    public void dfs(int arr[][], int i, boolean isVisited[]) {
        for (int j = 0; j < arr.length; j++) {
            if (!isVisited[j] && arr[i][j] == 1) {
                isVisited[j] = true;
                dfs(arr, j, isVisited);
            }
        }
    }
}