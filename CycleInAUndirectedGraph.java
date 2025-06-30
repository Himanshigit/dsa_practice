class Solution {
    private class Pair{
        int node,parent;
        Pair(int node,int parent){
            this.node=node;
            this.parent=parent;
        }
    }
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        boolean[] visit = new boolean[V];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++) adj.add(new ArrayList<>());
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        
        for(int i=0;i<V;i++){
            if(!visit[i]){
                if(bfs(adj,i,visit)) return true;
            }
        }
        return false;
        
    }
    
    public static boolean bfs(List<List<Integer>> adj,int i, boolean[] visit){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i,-1));
        visit[i]=true;
        while(!q.isEmpty()){
            Pair current=q.poll();
            int node=current.node;
            int parent=current.parent;
            
            for(int neighbour:adj.get(i)){
                if(!visit[neighbour]){
                    q.offer(new Pair(neighbour,node));
                    visit[neighbour]=true;
                }else if(neighbour!=parent){
                    return true;
                }
            }
        }
        return false;
    }
}
