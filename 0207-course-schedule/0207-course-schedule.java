class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //Step 1: build a graph that store adjaceny lists for all vertex.
        //For example, let u be a vertex of the graph. Then graph[u] is the adjacency list of vertex u.
        //graph[u] = list of all courses that depend on u (u is the prerequisite to take them).
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            graph.add(new ArrayList<>());
        }

        //indegree[v] = number of prerequisites of course v
        int[] indegree = new int[numCourses];

        for(int[] pre : prerequisites){
            int course = pre[0];
            int prereq = pre[1];
            graph.get(prereq).add(course);
            indegree[course]++;
        }

        //Step 2: To complete all courses, the graph must have a topological sort -> the directed graph does not have a 
        //directed cycle -> check with BFS
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<numCourses; i++){
            if(indegree[i]==0){
                queue.offer(i);
            }
        }

        int finished = 0; //number of courses we can take
        while(!queue.isEmpty()){
            int cur = queue.poll();
            finished++;

            for(int next : graph.get(cur)){
                indegree[next]--;
                if(indegree[next]==0){
                    queue.offer(next);
                }
            }
        }

        return finished == numCourses;
    }
}