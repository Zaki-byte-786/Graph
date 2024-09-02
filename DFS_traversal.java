import java.util.*;
class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    void dfs(int v,int[] visit,ArrayList<ArrayList<Integer>> adj,ArrayList<Integer> ans){
        visit[v] = 1;
        ans.add(v);
        for(Integer x : adj.get(v)){
            if(visit[x] == 0){
                dfs(x,visit,adj,ans);
            }
        }
        return;
    }
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> ans = new ArrayList<>();
        int[] visit = new int[V];
        dfs(0,visit,adj,ans);
        return ans;
    }
}
public class DFS_traversal {
    public static void main(String[] args) {

    }
}
