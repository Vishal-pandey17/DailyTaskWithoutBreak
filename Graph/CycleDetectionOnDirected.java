class Solution {
    
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        int vis[] = new int[V];
        int pathVis[] = new int[V];
        
        for(int i=0;i<V;i++){
            if(vis[i] == 0){
                if(dfs(i, adj, vis, pathVis) == true){
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean dfs(int node, ArrayList<ArrayList<Integer>> adj, int vis[], int path[]){
       vis[node] = 1;
       path[node] = 1;
       
       for(int i : adj.get(node)){
           if(vis[i] == 0){
               if(dfs(i, adj, vis, path) == true){
                   return true;
               }
           }
           
           else if(path[i] == 1){
               return true;
           }
       }
       path[node] = 0;
       return false;
    }
}