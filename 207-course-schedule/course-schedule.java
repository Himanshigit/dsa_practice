class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj= new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] num:prerequisites){
            adj.get(num[1]).add(num[0]);
        }
        
        boolean[] visited = new boolean[numCourses];
        boolean[] recstack = new boolean[numCourses];
        for(int i=0;i<numCourses;i++){
            if(!visited[i] && dfs(visited,recstack,i,adj)){
                return false;
            }
        }
        return true;
    }
    public boolean dfs(boolean[] visited, boolean[] recstack,int node, ArrayList<ArrayList<Integer>> adj){
        visited[node]=true;
        recstack[node]=true;
        for(int neighbour:adj.get(node)){
            if(!visited[neighbour] && dfs(visited,recstack,neighbour,adj)){
                return true;
            }else if(recstack[neighbour]){
                return true;
            }
        }
        recstack[node]=false;
        return false;
    }
    
}