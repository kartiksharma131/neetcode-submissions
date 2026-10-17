class Solution {
    private class Pair{
        int row;
        int col;
        public Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean [][] visited = new boolean[n][m];
        int totalOranges = 0;
        int rottenCount=0;
        Queue<Pair> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j));
                }
                if(grid[i][j]!=0){
                    totalOranges++;
                }
            }
        }
        int [] dx = {0,1,0,-1};
        int [] dy = {1,0,-1,0};
        int minutes =0;
        while(!q.isEmpty()){
            int pendingNodes =q.size();
            rottenCount+=pendingNodes;
            for(int i=0;i<pendingNodes;i++){
                Pair front = q.remove();
                int row = front.row;
                int col =front.col;
                visited[row][col] = true;
                for(int d=0;d<4;d++){
                    int nrow= row+ dx[d];
                    int ncol = col + dy[d];
                    if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && !visited[nrow][ncol] && grid[nrow][ncol]==1){
                        visited[nrow][ncol]=true;
                        q.add(new Pair(nrow, ncol));
                    }
                }
            }
            if(!q.isEmpty()){
                minutes++;
            }
        }

        if(rottenCount!=totalOranges){
            return -1;
        }
        return minutes;
    }
}

// total = 6;
// queue ->[(1,1)]
// minutes =2
// rotten =3
