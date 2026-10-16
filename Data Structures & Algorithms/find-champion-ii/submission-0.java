class Solution {
    public int findChampion(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int [] indegree = new int[n];
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int [] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            indegree[edge[1]]++;
        }

        int count=0;
        int ans=-1;
        for(int i=0;i<n;i++){
            if(indegree[i]==0 && count==0){
                count++;
                ans=i;
            }
            else if(indegree[i]==0 && count==1){
                return -1;
            }
        }
        return ans;

    }
}

// 0->{1}
// 1-> {}
// 2 -> {0,3}
// 3->{}

// indegree [0,0,0,0]
// q -> 3
// champions = 2, 0, 3 ,1
