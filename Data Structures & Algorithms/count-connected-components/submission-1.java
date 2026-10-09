class Solution {
    private void dfs(int start, ArrayList<ArrayList<Integer>> adj, boolean [] visited, int n){
        visited[start] = true;

        for(int i=0;i<adj.get(start).size();i++){
            if(!visited[adj.get(start).get(i)]){
                dfs(adj.get(start).get(i), adj, visited, n);
            }
        }
    }
    public int countComponents(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int [] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        boolean [] visited = new boolean[n];
        int components=0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                components++;
                dfs(i,adj,visited,n);
            }
        }
        return components;
    }
}
