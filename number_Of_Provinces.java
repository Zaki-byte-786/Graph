import java.util.ArrayList;

public class number_Of_Provinces {
    void dfs(ArrayList<ArrayList<Integer>> adj,int i,int[] visit){
        visit[i] = 1;
        for (Integer x : adj.get(i)){
            if (visit[x] == 0){
                dfs(adj,x,visit);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int count = 0;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[] visit = new int[isConnected.length];
        for (int i = 0; i < isConnected.length; i++) {
            ArrayList<Integer> arl = new ArrayList<>();
            adj.add(arl);
        }
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected.length; j++) {
                if (isConnected[i][j] == 1 && i != j)adj.get(i).add(j);
            }
        }
        for (int i = 0; i < isConnected.length ; i++) {
            if (visit[i] == 0){
                count++;
                dfs(adj,i,visit);
            }
        }
        return count;
    }
    public static void main(String[] args) {

    }
}
