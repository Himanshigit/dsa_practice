class Solution {
    public int numEnclaves(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        int count=0;
        for(int i=0;i<row;i++){
            dfs(grid,i,0);
            dfs(grid,i,col-1);
        }
        for(int j=0;j<col;j++){
            dfs(grid,0,j);
            dfs(grid,row-1,j);
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==1){
                    count++;
                }
            }
        }
        return count;

    }
    private void dfs(int[][] grid, int i, int j){
        if(grid.length==0) return;
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]==0) return;
        grid[i][j]=0;
        dfs(grid,i+1,j);
        dfs(grid,i,j+1);
        dfs(grid,i-1,j);
        dfs(grid,i,j-1);
    }
}