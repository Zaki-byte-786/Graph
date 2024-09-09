import java.util.*;
class pair2{
    int node;
    int parent;
    pair2(int node,int parent){
        this.node = node;
        this.parent =  parent;
    }
}
class Solution2 {
    boolean cycleDetection(int node,int parent,int[] visit,ArrayList<ArrayList<Integer>> adj){
        visit[node] = 1;
        for(int adjacentNode : adj.get(node)){
            if(visit[adjacentNode] == 0){
                if(cycleDetection(adjacentNode,node,visit,adj))return true;
            }
            else if(adjacentNode != parent)return true;
        }
        return false;
    }
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int[] visit = new int[V];
        for(int i = 0;i < V;i++){
            if(visit[i] == 0){
                if(cycleDetection(i,-1,visit,adj))return true;
            }
        }
        return false;
    }
}
public class cycle_Detection_DFS {
}
