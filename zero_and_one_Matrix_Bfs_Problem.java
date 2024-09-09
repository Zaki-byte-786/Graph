import java.util.*;
class tuple{
    int row;
    int col;
    int step;
    tuple(int row,int col,int step){
        this.row = row;
        this.col = col;
        this.step = step;
    }
}
public class zero_and_one_Matrix_Bfs_Problem {
    static  int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] visit = new int[m][n];
        int[][] stepArray = new int[m][n];
        Queue<tuple> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0){
                    q.add(new tuple(i,j,0));
                    visit[i][j] = 1;
                }
            }
        }
        int[] drow = {1,0,-1,0};
        int[] dcol = {0,-1,0,1};
        while (!q.isEmpty()){
            int row = q.peek().row;
            int col = q.peek().col;
            int step = q.peek().step;
            stepArray[row][col] = step;
            q.remove();
            for (int i = 0; i < 4; i++) {
                int nrow = row + drow[i];
                int ncol = col + dcol[i];
                if (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && visit[nrow][ncol] == 0){
                    q.add(new tuple(nrow,ncol,step + 1));
                    visit[nrow][ncol] = 1;
                }
            }
        }
        return stepArray;
    }
    public static void main(String[] args) {

    }
}
