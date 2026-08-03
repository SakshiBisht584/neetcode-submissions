class Solution {
    public void dfs(boolean[] vis, int node, List<List<Integer>> adj){
        vis[node]=true;
        for(int nei:adj.get(node)){
            if(!vis[nei]) dfs(vis,nei,adj);
        }
    }
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adj= new ArrayList<>();
        boolean[] vis=new boolean[n];
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int[] edg: edges){
            adj.get(edg[0]).add(edg[1]);
            adj.get(edg[1]).add(edg[0]);
        }
        int res=0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                res++;
                dfs(vis,i,adj);
            }
        }
        return res;
    }
}
