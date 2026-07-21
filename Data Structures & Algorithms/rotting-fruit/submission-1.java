class Solution {
    class pair{
        int row;
        int col;
        int t;
        pair(int r,int c,int time){
            row=r;
            col=c;
            t=time;
        }
    }
    
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m= grid[0].length;
        int cntfresh=0;
        int[][] vis=new int[n][m];
        Queue<pair> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.add(new pair(i,j,0));
                    vis[i][j]=2;
                }
                else if(grid[i][j]==1) {
                    vis[i][j]=1;
                    cntfresh++;
                }
                else{
                    vis[i][j]=0;
                }
            }
        }
        int tm=0;
        int cnt=0;
        while(!q.isEmpty()){
            int ro=q.peek().row;
            int co=q.peek().col;
            int ti=q.peek().t;
            tm=Math.max(tm,ti);
            q.poll();

            int[] di={0,-1,0,1};
            int[] dj={-1,0,1,0};
            for(int i=0;i<4;i++){
                int nrow=ro+di[i];
                int ncol=co+dj[i];
                if(nrow>=0 && nrow<grid.length && ncol>=0 && ncol<grid[0].length && vis[nrow][ncol]==1 && grid[nrow][ncol]==1){
                    q.add(new pair(nrow,ncol,ti+1));
                    vis[nrow][ncol]=2;
                    cnt++;
                }
            }
        }
        if(cnt!=cntfresh) return -1;
        return tm;
    }
}
