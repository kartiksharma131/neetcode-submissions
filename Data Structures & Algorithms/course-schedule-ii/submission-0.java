class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> ans = new ArrayList<>();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }

        int [] indegree = new int[numCourses];
        for(int [] prerequisite : prerequisites){
            adj.get(prerequisite[0]).add(prerequisite[1]);
            indegree[prerequisite[1]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i< numCourses;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int front = q.remove();
            ans.add(front);

            for(int i =0; i< adj.get(front).size();i++){
                indegree[adj.get(front).get(i)]--;
                if(indegree[adj.get(front).get(i)]==0){
                    q.add(adj.get(front).get(i));
                }
            }
        }

        Collections.reverse(ans);
        if(ans.size()!=numCourses){
            return new int[0];
        }
        int[] result = new int[ans.size()];
        
        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }
        return result;
    }
}
