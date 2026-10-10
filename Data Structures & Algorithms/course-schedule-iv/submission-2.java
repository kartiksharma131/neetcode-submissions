class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];
        for (int[] p : prerequisites) {
            adj.get(p[0]).add(p[1]);
            indegree[p[1]]++;
        }

        // isPrereq[v][u] will be true if u is a prerequisite of v
        boolean[][] isPrereq = new boolean[numCourses][numCourses];

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int curr = q.remove();

            for (int neighbor : adj.get(curr)) {
                // curr is a direct prerequisite of neighbor
                isPrereq[neighbor][curr] = true;
                
                // Inherit all prerequisites of curr
                for (int i = 0; i < numCourses; i++) {
                    if (isPrereq[curr][i]) {
                        isPrereq[neighbor][i] = true;
                    }
                }

                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }

        // Answer the queries using the matrix
        List<Boolean> ans = new ArrayList<>();
        for (int[] query : queries) {
            ans.add(isPrereq[query[1]][query[0]]);
        }
        
        return ans;
    }
}