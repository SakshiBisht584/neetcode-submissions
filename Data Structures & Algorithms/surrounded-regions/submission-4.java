class Solution {
    public void dfs(int r, int c, int[][] vis, char[][] grid){
        if(r<0 || r>grid.length-1 || c<0 || c>grid[0].length-1 || vis[r][c]==1 || grid[r][c]=='X') return;
        vis[r][c]=1;
        dfs(r,c-1,vis,grid);
        dfs(r-1,c,vis,grid);
        dfs(r,c+1,vis,grid);
        dfs(r+1,c,vis,grid);
    }
    public void solve(char[][] board) {
        int n=board.length;
        int m= board[0].length;
        int[][] vis=new int[n][m];
        
        for(int j=0;j<m;j++){
            if(board[0][j]=='O'){
                dfs(0,j,vis,board);
            }
        }
        for(int i=0;i<n;i++){
            if(board[i][0]=='O'){
                dfs(i,0,vis,board);
            }
        }

        for(int j=0;j<m;j++){
            if(board[n-1][j]=='O'){
                dfs(n-1,j,vis,board);
            }
        }
        for(int i=0;i<n;i++){
            if(board[i][m-1]=='O'){
                dfs(i,m-1,vis,board);
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='O' && vis[i][j]==0){
                    board[i][j]='X';
                }
            }
        }
    }
}
