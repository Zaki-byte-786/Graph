public class Bipartite_Graph_DFS {
   static boolean dfs(int node,int col,int[][] array,int[]visit){
        visit[node] = col;
        for (int x : array[node]){
            if (visit[x] == 0){
                if (!dfs(x,-col,array,visit))return false;
            }
            else {
                if (visit[x] == col)return false;
            }
        }
        return true;
    }
    static boolean isBipartite(int[][] array) {
        int[] visit = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            if (visit[i] == 0){
                if (!dfs(i,1,array,visit))return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {

    }
}
