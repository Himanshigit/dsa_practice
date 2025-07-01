class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        int[] parent=new int[n+1];
        for(int i=0;i<n+1;i++){
            parent[i]=i;
        }

        for(int[] edge: edges){
            int u=edge[0];
            int v=edge[1];
            if(find(parent,u)==find(parent,v)){
                return edge;
            }else{
                union(parent,v,u);
            }
        }
        return new int[0];
    }
    public int find(int[] parent, int node){
        if(parent[node]!=node){
            parent[node]=find(parent,parent[node]);
        }
        return parent[node];
    }

    public void union(int[] parent, int u,int v){
        int pu=find(parent,u);
        int pv=find(parent,v);
        parent[pu]=pv;
    }
}