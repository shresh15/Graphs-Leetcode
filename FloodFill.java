/*
You are given an image represented by an m x n grid of integers image, where image[i][j] represents the pixel value of the image. You are also given three integers sr, sc, and color. Your task is to perform a flood fill on the image starting from the pixel image[sr][sc].

To perform a flood fill:

Begin with the starting pixel and change its color to color.
Perform the same process for each pixel that is directly adjacent (pixels that share a side with the original pixel, either horizontally or vertically) and shares the same color as the starting pixel.
Keep repeating this process by checking neighboring pixels of the updated pixels and modifying their color if it matches the original color of the starting pixel.
The process stops when there are no more adjacent pixels of the original color to update.
Return the modified image after performing the flood fill.
 */
class Solution {
    int rows;
    int cols;
    void dfs(int row,int col,int newColor, int curColor, int[][] image ){
        if(row<0 ||col<0 || row>=rows || col>=cols || image[row][col]!=curColor){
            return;
        }

        //COLORING THE NEW BLOCK
        image[row][col]=newColor;
        //Creating adjacency list
        int[][] adjList={
            {row-1,col},{row+1,col},{row,col-1},{row,col+1}           
        };
        for(int neighbour[]:adjList){
            dfs(neighbour[0],neighbour[1],newColor,curColor,image);
        }

    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        rows=image.length;
        cols=image[0].length;
         int startColor = image[sr][sc];

        //  Edge case check
        if (startColor == color) return image;
        dfs(sr,sc,color,startColor, image);
       return image;

    }
}