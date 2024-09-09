import java.util.LinkedList;
import java.util.Queue;
class islandPair{
int row;
int col;
    islandPair(int row,int col){
        this.row = row;
        this.col = col;
    }
}
public class Number_of_Distinct_Islands {



    // BFS
    static void helperFunctionBFS(char[][] array,int[][] visit,int row,int col){
        int[]drow = {-1,-1,0,1,1,1,0,-1};
        int[]dcol = {  0,1,1,1,0,-1,-1,-1};
        Queue<islandPair> q = new LinkedList<>();
        q.add(new islandPair(row,col));
        while (!q.isEmpty()){
            row = q.peek().row;
            col = q.peek().col;
            q.poll();
            for (int i = 0; i < 8; i++) {
                int nrow = row + drow[i];
                int ncol = col + dcol[i];
                if (nrow >= 0 && nrow < array.length && ncol >= 0 && ncol < array[0].length &&
                        array[nrow][ncol] == '1' && visit[nrow][ncol] == 0){
                    q.add(new islandPair(nrow,ncol));
                    visit[nrow][ncol] = 1;
                }
            }
        }
    }
        static int numIslandsBFS(char[][] array) {
        // Code here
        int m = array.length;
        int n = array[0].length;
        int[][] visit = new int[m][n];
        int numberOfIsland = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (array[i][j] == '1' && visit[i][j] == 0){
                    numberOfIsland++;
                    visit[i][j] = 1;
                    helperFunctionBFS(array,visit,i,j);
                }
            }
        }
        return numberOfIsland;
    }




    // DFS

        static void helperFunctionDFS(char[][] array,int[][] visit,int row,int col){
        int[]drow = {-1,-1,0,1,1,1,0,-1};
        int[]dcol = {  0,1,1,1,0,-1,-1,-1};
        for (int i = 0; i < 8; i++) {
            int nrow = row + drow[i];
            int ncol = col + dcol[i];
            if (nrow >= 0 && nrow < array.length && ncol >= 0 && ncol < array[0].length
                    && array[nrow][ncol] == '1' && visit[nrow][ncol] == 0){
                visit[nrow][ncol] = 1;
                helperFunctionDFS(array,visit,nrow,ncol);
            }
        }
    }
    static int numIslandsDFS(char[][] array) {
        // Code here
        int m = array.length;
        int n = array[0].length;
        int[][] visit = new int[m][n];
        int numberOfIsland = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (array[i][j] == '1' && visit[i][j] == 0){
                    numberOfIsland++;
                    visit[i][j] = 1;
                    helperFunctionDFS(array,visit,i,j);
                }
            }
        }
        return numberOfIsland;
    }
    public static void main(String[] args) {

    }
}
