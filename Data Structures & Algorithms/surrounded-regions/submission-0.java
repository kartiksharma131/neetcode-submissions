class Solution {
    private void dfs(int row, int col, char[][] board, boolean[][] visited, int n, int m){
        visited[row][col] = true;
        int [] dx = {0,1,0,-1};
        int [] dy = {1,0,-1,0};
        for(int d=0;d<4;d++){
            int nrow = row + dx[d];
            int ncol = col + dy[d];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && !visited[nrow][ncol] && board[nrow][ncol]=='O'){
                dfs(nrow, ncol, board, visited, n,m);
            }
        }
    }
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        boolean [][] visited = new boolean[n][m];

        //top && bottom row
        for(int i=0;i<m;i++){
            if(board[0][i]=='O' && !visited[0][i]){
                dfs(0,i,board, visited, n,m);
            }

            if(board[n-1][i]=='O' && !visited[n-1][i]){
                dfs(n-1,i,board, visited,n,m);
            }
        }

        //first and last column
        for(int i=0;i<n;i++){
            if(board[i][0]=='O' && !visited[i][0]){
                dfs(i,0,board, visited, n,m);
            }

            if(board[i][m-1]=='O' && !visited[i][m-1]){
                dfs(i,m-1, board, visited, n, m);
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j] =='O' && !visited[i][j]){
                    board[i][j]='X';
                }
            }
        }
    }
}
