/*
Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
*/
class Solution {
    int rows;
        int cols;
    public int numIslands(char[][] grid) {
        
     rows=grid.length;
     cols=grid[0].length;
     int islands=0;
     boolean[][] vis=new boolean[rows][cols];
     for(int i=0;i<rows;i++){
        for(int j=0;j<cols;j++){
            if(grid[i][j]=='1' && !vis[i][j]){
                dfs(i,j,grid,vis);
               islands++;
            }
        }

     }
     return islands;   
    }
    public void dfs(int row,int col,char[][]grid, boolean vis[][]){
         //ou of bound cSES
         if(row<0 || row>=rows || col<0 || col>=cols || grid[row][col]=='0' || vis[row][col]){
            return;
         }
         vis[row][col]=true;
         int adjList[][]={
            {row-1,col},{row+1,col},{row,col-1},{row,col+1}
         };
         for(int nei[]:adjList){
            dfs(nei[0], nei[1],grid,vis);
         }

    }

}