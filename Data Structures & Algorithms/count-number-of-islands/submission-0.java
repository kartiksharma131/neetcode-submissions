class Solution {
    private void dfs(int row, int col, char [][] grid, boolean [][] visited, int n, int m){
        visited[row][col] = true;
        int [] dx = {0,1,0,-1};
        int [] dy = {1,0,-1,0};
        for(int d=0;d<4;d++){
            int nrow = row + dx[d];
            int ncol = col + dy[d];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]=='1' && !visited[nrow][ncol]){
                dfs(nrow, ncol, grid, visited,n,m);
            }
        }
    }
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean [][] visited = new boolean[n][m];
        int numIslands=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1' && !visited[i][j]){
                    dfs(i,j,grid,visited,n,m);
                    numIslands++;
                }
            }
        }
        return numIslands;
    }
}
