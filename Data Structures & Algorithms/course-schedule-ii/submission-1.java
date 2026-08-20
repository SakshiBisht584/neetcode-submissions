class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj= new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }

        int[] indegree=new int[numCourses];
        for(int i=0;i<prerequisites.length;i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
            indegree[prerequisites[i][0]]++;
        }

        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0) q.add(i);
        }

        int[] res=new int[numCourses];
        int ind=0;
        while(!q.isEmpty()){
            int curr=q.poll();
            res[ind++]=curr;
            for(int neigh:adj.get(curr)){
                indegree[neigh]--;
                if(indegree[neigh]==0) q.add(neigh);
            }
        }

        if(ind==numCourses) return res;
        return new int[0];
        
    }
}