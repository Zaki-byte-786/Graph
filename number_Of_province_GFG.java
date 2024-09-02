import java.util.*;
public class number_Of_province_GFG {
    static void dfs(ArrayList<ArrayList<Integer>> adjl, int i, int[] visit) {
        visit[i] = 1;
        for (Integer x : adjl.get(i)) {
            if (visit[x] == 0) {
                dfs(adjl, x, visit);
            }
        }
    }

    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // code here
        int count = 0;
        ArrayList<ArrayList<Integer>> adjl = new ArrayList<>();
        int[] visit = new int[V];
        for (int i = 0; i < V; i++) {
            ArrayList<Integer> arl = new ArrayList<>();
            adjl.add(arl);
        }
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (adj.get(i).get(j) == 1 && i != j) {
                    adjl.get(i).add(j);


                }
            }

        }
        for (int i = 0; i < V; i++) {
            if (visit[i] == 0) {
                count++;
                dfs(adjl, i, visit);
            }
        }
        return count;
    }
}