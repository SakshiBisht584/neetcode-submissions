class Solution {
    class pair{
        int r;
        int c;
        pair(int row, int col){
            r=row;
            c=col;
        }
    }
    public void bfs(int row, int col, int[][] vis, char[][] grid){
        vis[row][col]=1;
        Queue<pair> q=new LinkedList<>();
        q.offer(new pair(row,col));
        int n=grid.length;
        int m=grid[0].length;
        while(!q.isEmpty()){
            int r=q.peek().r;
            int c=q.peek().c;
            q.remove();

            int[] di={-1,0,1,0};
            int[] dj={0,1,0,-1};
            for(int i=0;i<4;i++){
                int nrow=r+di[i];
                    int ncol=c+dj[i];
                    if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0 && grid[nrow][ncol]=='1'){
                        vis[nrow][ncol]=1;
                        q.offer(new pair(nrow,ncol));
                    }
            }
        }
    }
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] vis=new int[n][m];
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==0 && grid[i][j]=='1'){
                    count++;
                    bfs(i,j,vis,grid);
                }
            }
        }
        return count;
    }
}
