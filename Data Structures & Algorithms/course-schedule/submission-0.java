class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int [] indegree = new int[numCourses];

        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());

        }

        for(int [] prerequisite : prerequisites){
            adj.get(prerequisite[0]).add(prerequisite[1]);
            indegree[prerequisite[1]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }

        int courseCount=0;
        while(!q.isEmpty()){
            int front = q.remove();
            courseCount++;

            for(int i=0;i<adj.get(front).size();i++){
                indegree[adj.get(front).get(i)]--;
                if(indegree[adj.get(front).get(i)]==0){
                    q.add(adj.get(front).get(i));
                }
            }
        }
        if(courseCount==numCourses){
            return true;
        }
        return false;
    }
}
