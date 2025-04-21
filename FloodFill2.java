class Solution {
    int rows;
    int cols;
    
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        rows=image.length;
        cols=image[0].length;
         int startColor = image[sr][sc];

        Queue<int[]> queue=new LinkedList<>();
        // INSERT 
        queue.offer(new int[] {sr,sc});
        image[sr][sc]=color; // FILL

        while(!queue.isEmpty()){
            int node[]=queue.poll();
            int row=node[0];
            int col=node[1];

             int[][] adjList={
            {row-1,col},{row+1,col},{row,col-1},{row,col+1}           
        };

         for(int neighbour[]:adjList){
            int r=neighbour[0];
            int c=neighbour[1];
            
             if(r<0 ||c<0 || r>=rows || c>=cols || image[r][c]!=curColor || image[r][c]==color){
            continue;
        }
          queue.offer(new int[]{r,c});
          image[r][c]=color;
           
        }
        }

       return image;

    }
}