import java.util.*;
class pair{
    int node;
    int parent;
    pair(int node,int parent){
        this.node = node;
        this.parent =  parent;
    }
}
public class cycle_detection {
    boolean cycleDetection(int i,ArrayList<ArrayList<Integer>> adj,int[] visit){
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(i,-1));
        visit[i] = 1;
        while(!q.isEmpty()){
            int node = q.peek().node;
            int parent = q.peek().parent;
            q.remove();
            for(int adjacentNode : adj.get(node)){
                if(visit[adjacentNode] == 0){
                    q.add(new pair(adjacentNode,node));
                    visit[adjacentNode] = 1;
                }
                else if(parent != adjacentNode)return true;
            }
        }
        return false;
    }
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int[] visit = new int[V];
        for(int i = 0;i < V;i++){
            if(visit[i] == 0){
                if(cycleDetection(i,adj,visit))return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
    }
}
