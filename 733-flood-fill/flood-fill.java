class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // boolean[][] visit=new boolean[][];
        int x=image[sr][sc];
        if(x==color) return image;
        dfs(sr,sc,color,image,x);
        return image;
    }
    public void dfs(int sr,int sc,int color,int[][] image,int x){
        if(sr<0 ||sc<0 || sr>=image.length || sc>=image[0].length) return;
        if(image[sr][sc]!=x) return;
        image[sr][sc]=color;
        dfs(sr+1,sc,color,image,x);
        dfs(sr,sc+1,color,image,x);
        dfs(sr,sc-1,color,image,x);
        dfs(sr-1,sc,color,image,x);
        return ;
    }
}