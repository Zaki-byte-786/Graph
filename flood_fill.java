import java.util.*;

class floodDfs {
    void dfs(int[][] image,int[][] ans,int sr,int sc,int newcolor,int initcolor,int[]drow,int[]dcol){
        if(initcolor == newcolor)return;
        ans[sr][sc] = newcolor;
        for(int i = 0;i < 4;i++){
            int nrow= sr + drow[i];
            int ncol = sc + dcol[i];
            if(nrow >= 0 && nrow < image.length && ncol >= 0 && ncol < image[0].length && image[nrow][ncol] == initcolor && ans[nrow][ncol] == initcolor){
                dfs(image,ans,nrow,ncol,newcolor,initcolor,drow,dcol);
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int newcolor) {
        int[][] ans = new int[image.length][image[0].length];
        for(int i = 0;i < image.length;i++){
            for(int j = 0; j < image[0].length;j++) {
                ans[i][j] = image[i][j];
            }
        }
        int[]drow = {-1,0,1,0};
        int[]dcol = {0,1,0,-1};
        int initcolor = image[sr][sc];
        dfs(image,ans,sr,sc,newcolor,initcolor,drow,dcol);
        return ans;
    }
}

// BFS for flood fill


class Pair{
    int row;
    int col;
    Pair(int row,int col){
        this.row = row;
        this.col = col;
    }
}
public class flood_fill {
    static int[][] floodFillBFS(int[][] image, int sr, int sc, int newColor){
        int initcolor = image[sr][sc];
        int r = image.length;
        int c = image[0].length;
        int[][] ans = new int[r][c];
        Queue<Pair> q = new LinkedList<>();
        for(int i = 0;i < r;i++){
            for(int j = 0; j < c;j++) {
                ans[i][j] = image[i][j];
            }
        }
        if(newColor == initcolor)return ans;
        int[]drow = {-1,0,1,0};
        int[]dcol = {0,1,0,-1};
        q.add(new Pair(sr,sc));
while (!q.isEmpty()){
int row = q.peek().row;
int col = q.peek().col;
q.poll();
    ans[row][col] = newColor;
    for (int i = 0; i < 4; i++) {
        int nrow = row + drow[i];
        int ncol = col + dcol[i];
        if(nrow >= 0 && nrow < r && ncol >= 0 && ncol < c && image[nrow][ncol] == initcolor
                && ans[nrow][ncol] == initcolor){
            ans[nrow][ncol] = newColor;
            q.add(new Pair(nrow,ncol));
        }
    }
}
return ans;
    }
    public static void main(String[] args) {

    }
}
