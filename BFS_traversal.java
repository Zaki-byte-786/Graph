import java.util.*;
public class BFS_traversal {
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        int[] visitArray = new int[V];
        q.add(0);
        visitArray[0] = 1;
        while(!q.isEmpty()){
            Integer node = q.poll();
            ans.add(node);
            for(Integer x : adj.get(node)){
                if(visitArray[x] == 0){
                    q.add(x);
                    visitArray[x] = 1;
                }
            }
        }
        return ans;
    }
}
