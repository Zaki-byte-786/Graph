import java.util.LinkedList;
import java.util.Queue;

public class Bipartite_Graph_BFS {
    static boolean bfs(int[][] array,int[] visit,int i,int col,Queue<Integer> q){
        visit[i] = col;
        q.add(i);
        while (!q.isEmpty()){
            int node = q.poll();
            col = visit[node];
            for (int x : array[node]){
                if (visit[x] == 0){
                    q.add(x);
                    visit[x] = -col;
                }
                else {
                    if (visit[x] == col)return false;
                }
            }
        }
        return true;
    }
    static boolean isBipartite(int[][] array){
        int V = array.length;
        int[] visit = new int[V];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (visit[i] == 0){
            if (!bfs(array,visit,i,1,q))return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {

    }
}
