// https://leetcode.com/problems/flood-fill/

// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


//used dfs
//for a node checked if neighbours are same as old color if yes, called dfs on it.

class Solution {
    int[][] dirs;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image==null|| image.length==0) return image;
        int m = image.length;
        int n=image[0].length;
        this.dirs=new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
        if(image[sr][sc]==color) return image;
        int oldColor = image[sr][sc];
        dfs(image, sr, sc, color, oldColor, m, n);
        return image;
    }
    private void dfs(int[][] image, int row, int coloumn, int color, int old, int m, int n){
        //base
        if(row<0 || coloumn<0 || row==m || coloumn ==n || image[row][coloumn]!=old ) return;
        //logic
        image[row][coloumn]= color;
        for(int [] dir: dirs){
            int nr=dir[0]+row;
            int nc=dir[1]+coloumn;
            dfs(image, nr, nc, color, old, m,n);
        }
    }
}

//used bfs
//adding nodes to queue if they have color equal to old color for the neighbours of 
// entire level, doing this until the queue is not empty.

class Solution {
    int[][] dirs;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image==null|| image.length==0) return image;
        int m = image.length;
        int n=image[0].length;
        this.dirs=new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
        if(image[sr][sc]==color) return image;
        int oldColor = image[sr][sc];
        Queue<Integer> q= new LinkedList<>();
        q.add(sr);
        q.add(sc);
        image[sr][sc]=color;
        while(!q.isEmpty()){
            int cr=q.poll();
            int cc=q.poll();
            for(int[] dir: dirs){
                int c= dir[1]+cc;
                int r = dir[0]+cr;
                if(c<n&&c>-1&&r>-1&&r<m&&image[r][c]==oldColor) {
                    q.add(dir[0]+cr);
                    q.add(dir[1]+cc);
                    image[dir[0]+cr][dir[1]+cc]=color;
                }
            }
        }
        return image;
    }
}