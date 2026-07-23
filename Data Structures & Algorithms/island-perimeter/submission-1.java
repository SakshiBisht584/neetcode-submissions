class Solution {
    public int dfs(int i,int j, int[][] vis,int[][] grid){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]==0) return 1;
        if(vis[i][j]==1) return 0;
        vis[i][j]=1;
        return dfs(i,j-1,vis,grid)+dfs(i-1,j,vis,grid)+dfs(i,j+1,vis,grid)+dfs(i+1,j,vis,grid);
    }
    public int islandPerimeter(int[][] grid) {
        int[][] vis=new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1 && vis[i][j]==0){
                    return dfs(i,j,vis,grid);
                }
            }
        }
        return 0;
    }
}