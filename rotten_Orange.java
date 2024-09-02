import java.util.LinkedList;
import java.util.Queue;
class Tuple{
    int row;
    int col;
    int t;
    Tuple(int row,int col,int t){
        this.row = row;
        this.col = col;
        this.t = t;
    }
}
public class rotten_Orange {
    static int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int fresh_Orange = 0;
        Queue<Tuple> q = new LinkedList<>();
        int[][] visit = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2){
                    visit[i][j] = 2;
                    q.add(new Tuple(i,j,0));
                }
                if (grid[i][j] == 1)fresh_Orange++;
            }
        }
        int tm = 0,count_one = 0;
        int [] drow = {-1,0,1,0};
        int [] dcol = {0,1,0,-1};
        while (!q.isEmpty()){
            int r = q.peek().row;
            int c = q.peek().col;
            int t = q.peek().t;
            tm = Math.max(tm,q.peek().t);
            q.poll();
            for (int i = 0; i < 4; i++) {
                int nrow = r + drow[i];
                int ncol = c + dcol[i];
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == 1 && visit[nrow][ncol] == 0){
                    visit[nrow][ncol] = 2;
                    q.add(new Tuple(nrow,ncol,t+1));
                    count_one++;
                }
            }
        }
        if (count_one != fresh_Orange)return -1;
        return tm;
    }
    public static void main(String[] args) {

    }
}
