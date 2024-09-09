public class Number_of_Enclaves_flood_fill_implementation_multisource {
    // using DFS

    static void dfs(int[][] array,int[][] visit,int row,int col,int[]drow,int[]dcol){
        visit[row][col] = 1;
        for (int i = 0; i < 4; i++) {
            int nrow = row + drow[i];
            int ncol = col + dcol[i];
            if (nrow >= 0 && nrow < array.length && ncol >= 0 && ncol < array[0].length && array[nrow][ncol] == 1 && visit[nrow][ncol] == 0)
                dfs(array,visit,nrow,ncol,drow,dcol);
        }
    }
    static int numEnclaves(int[][] array) {
        int m = array.length;
        int n = array[0].length;
        int[][] visit = new int[m][n];
        int[] drow = {-1,0,1,0};
        int[] dcol = {0,1,0,-1};
        for (int j = 0; j < n; j++) {
            if (array[0][j] == 1 && visit[0][j] == 0)dfs(array,visit,0,j,drow,dcol);
            if (array[m-1][j] == 1 && visit[m-1][j] == 0)dfs(array,visit,m-1,j,drow,dcol);
        }
        for (int i = 0; i < m; i++) {
            if (array[i][0] == 1 && visit[i][0] == 0)dfs(array,visit,i,0,drow,dcol);
            if (array[i][n-1] == 1 && visit[i][n-1] == 0)dfs(array,visit,i,n-1,drow,dcol);
        }
        int total_One = 0,visited_One = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (array[i][j] == 1)total_One++;
                if (visit[i][j] == 1)visited_One++;
            }
        }
        return total_One - visited_One;
    }

    public static void main(String[] args) {

    }
}
