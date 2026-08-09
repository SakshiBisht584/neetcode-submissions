class Solution {
    public boolean dfs(int i,int parent, int[] vis, ArrayList<ArrayList<Integer>> al){
        vis[i]=1;
        for(int neigh: al.get(i)){
            if(neigh==parent) continue;
            if(vis[neigh]==1) return true;
            if(dfs(neigh,i,vis,al)) return true;
        }
        return false;
    }

    public boolean validTree(int n, int[][] edges) {
        int[] vis= new int[n];
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        for(int i=0;i<n;i++){
            al.add(new ArrayList<Integer>());
        }

        for(int i=0;i<edges.length;i++){
            al.get(edges[i][0]).add(edges[i][1]);
            al.get(edges[i][1]).add(edges[i][0]);
            
        }

        if(dfs(0,-1,vis,al)) return false;
        for(int i=0;i<n;i++){
            if(vis[i]==0){
                return false;
            }
        }
        return true;
    }
}
