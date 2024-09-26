import java.util.*;
class pair3{
    int row;
    int col;
    pair3(int row,int col){
        this.row = row;
        this.col = col;
    }
}
public class Number_of_Enclaves_flood_fill_implementation_multisource_BFS {
    static int numEnclaves(int[][] array) {
        int m = array.length;
        int n = array[0].length;
        int[][] visit = new int[m][n];
        int[]drow = {-1,0,1,0};
        int[]dcol = {0,1,0,-1};
        Queue<pair3> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            if (array[i][0] == 1 && visit[i][0] == 0){
                q.add(new pair3(i,0));
                visit[i][0] = 1;
            }
            if (array[i][n-1] == 1 && visit[i][n-1] == 0){
                q.add(new pair3(i,n-1));
                visit[i][n-1] = 1;
            }
        }
        for (int j = 0; j < n; j++) {
            if (array[0][j] == 1 && visit[0][j] == 0){
                q.add(new pair3(0,j));
                visit[0][j] = 1;
            }
            if (array[m-1][j] == 1 && visit[m-1][j] == 0){
                q.add(new pair3(m-1,j));
                visit[m-1][j] = 1;
            }
        }
        while (!q.isEmpty()){
            int row = q.peek().row;
            int col = q.peek().col;
            q.remove();
            for (int i = 0; i < 4; i++) {
                int nrow = row + drow[i];
                int ncol = col + dcol[i];
                if (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && array[nrow][ncol] == 1 && visit[nrow][ncol] == 0){
                    q.add(new pair3(nrow,ncol));
                    visit[nrow][ncol] = 1;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (array[i][j] == 1 && visit[i][j] == 0)count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {

    }
}
