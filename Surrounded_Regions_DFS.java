public class Surrounded_Regions_DFS {
    static void dfs(char[][] array,int[][] visit,int[] drow,int[] dcol,int row,int col ){
        visit[row][col] = 1;
        for (int i = 0; i < 4; i++) {
            int nrow = row + drow[i];
            int ncol = col + dcol[i];
            if (nrow >= 0 && nrow < array.length && ncol >= 0 && ncol < array[0].length && array[nrow][ncol] == 'O' && visit[nrow][ncol] == 0){
                dfs(array,visit,drow,dcol,nrow,ncol);
            }
        }
    }
    public void solve(char[][] array) {
        int m = array.length;
        int n = array[0].length;
        int[][] visit = new int[m][n];
        int[] drow = {-1,0,1,0};
        int[] dcol = {0,1,0,-1};
        for (int j = 0; j < n; j++) {
            if (array[0][j] == 'O' && visit[0][j] == 0){
                dfs(array,visit,drow,dcol,0,j);
            }
            if (array[m-1][j] == 'O' && visit[m-1][j] == 0){
                dfs(array,visit,drow,dcol,m-1,j);
            }
        }
        for (int i = 0; i < m; i++) {
            if (array[i][0] == 'O' && visit[i][0] == 0){
                dfs(array,visit,drow,dcol,i,0);
            }
            if (array[i][n-1] == 'O' && visit[i][n-1] == 0){
                dfs(array,visit,drow,dcol,i,n-1);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (array[i][j] == 'O' && visit[i][j] == 0)array[i][j] = 'X';
            }
        }
    }
    public static void main(String[] args) {

    }
}
