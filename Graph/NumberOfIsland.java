class Pair{
    int f;
    int s;
    public Pair(int first,int second){
        this.f = first;
        this.s = second;
    }
}
class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] vis = new int[n][m];
        int count = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(vis[i][j] == 0 && grid[i][j] == '1'){
                    bfs(i,j,vis,grid);
                    count++;
                }
            }
        }
        return count;
    }
    public void bfs(int row,int col,int[][] vis,char[][] grid){
        vis[row][col] = 1;

        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(row,col));
        int n = grid.length,m = grid[0].length;

        while(!q.isEmpty()){
            int r = q.peek().f;
            int c = q.peek().s;
            q.poll();

            for(int drow=-1; drow<=1; drow++){
                for(int dcol=-1; dcol<=1; dcol++){
                    int nrow = r + drow;
                    int ncol = c + dcol;

                    if((Math.abs(drow-dcol) == 1) && (nrow >= 0 && nrow < n) && (ncol >= 0 && ncol < m) && 
                        vis[nrow][ncol] == 0 && grid[nrow][ncol] == '1'){
                        vis[nrow][ncol] = 1;
                        q.add(new Pair(nrow,ncol));
                    }
                }
            }
        }
    }
}