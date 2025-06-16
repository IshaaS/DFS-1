// https://leetcode.com/problems/01-matrix/

// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// used bfs becuase if we take dfs, we might do unnecesary traversals even if the nearest
// 0 wasin the next immediate level.
// start bfs with all 0s in the matrix and move to next levels and keep updating the
// distance. 


// class Solution {
//     public int[][] updateMatrix(int[][] mat) {
//         int [][] dirs= new int [][] {{0,1},{1,0},{-1,0},{0,-1}};
//         if(mat==null || mat.length==0) return mat;
//         int m=mat.length;
//         int n=mat[0].length;
//         Queue<Integer> q= new LinkedList<>();
//         for(int i=0;i<m;i++){
//             for(int j=0;j<n;j++){
//                 if(mat[i][j]==0){
//                     q.add(i);
//                     q.add(j);
//                 }
//                 else mat[i][j]=-1;
//             }
//         }
//         int level=1;
//         while(!q.isEmpty()){
//             int size=q.size();
//             for(int i=0; i<size/2;i++){
//                 int cr=q.poll();
//                 int cc=q.poll();
//                 for(int[] dir: dirs){
//                     int r=dir[0]+cr;
//                     int c=dir[1]+cc;
//                     if(r>=0 && r<m&&c<n&&c>=0&&mat[r][c]==-1){
//                         mat[r][c]=level;
//                         q.add(r);
//                         q.add(c);
//                     }
//                 }
//             }
//             level++; 
//         } return mat;
//     }
// }

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int [][] dirs= new int [][] {{0,1},{1,0},{-1,0},{0,-1}};
        if(mat==null || mat.length==0) return mat;
        int m=mat.length;
        int n=mat[0].length;
        Queue<Integer> q= new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    q.add(i);
                    q.add(j);
                }
                else mat[i][j]=-1;
            }
        }
        while(!q.isEmpty()){
            int cr=q.poll();
            int cc=q.poll();
            for(int[] dir: dirs){
                int r=dir[0]+cr;
                int c=dir[1]+cc;
                if(r>=0 && r<m&&c<n&&c>=0&&mat[r][c]==-1){
                    mat[r][c]=mat[cr][cc]+1;
                    q.add(r);
                    q.add(c);
                }
            }
        }
        return mat;
    }
}