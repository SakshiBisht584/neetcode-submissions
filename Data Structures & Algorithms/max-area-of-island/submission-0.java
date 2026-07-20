class Solution {
    class pair{
        int row;
        int col;
        pair(int r,int c){
            row=r;
            col=c;
        }
    }
    public int bfs(int row, int col, int[][] vis, int[][] grid){
        int n=grid.length;
        int m=grid[0].length;
        vis[row][col]=1;
        int count=1;
        Queue<pair> q=new LinkedList<>();
        q.add(new pair(row,col));
        while(!q.isEmpty()){
            int r=q.peek().row;
            int c=q.peek().col;
            q.poll();

            int[] di={0,-1,0,1};
            int[] dj={1,0,-1,0};
            for(int i=0;i<4;i++){
                int nrow=r+di[i];
                int ncol=c+dj[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0 && grid[nrow][ncol]==1){
                    vis[nrow][ncol]=1;
                    count++;
                    q.add(new pair(nrow,ncol));
                }
            }
        }
        return count;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] vis=new int[n][m];
        int max=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==0 && grid[i][j]==1){
                    max=Math.max(max,bfs(i,j,vis,grid));
                }
            }
        }
        return max;
    }
}
