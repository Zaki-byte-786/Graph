import java.util.*;
public class Cycle_Detection_in_Directed_Graph_DFS {
//    static boolean dfs(ArrayList<ArrayList<Integer>> adj,int[] visit,int[]pathVisit,int node){
//        visit[node] = 1;
//        pathVisit[node] = 1;
//        for (int x : adj.get(node)){
//            if (visit[x] == 0){
//               if (dfs(adj,visit,pathVisit,x))return true;
//            }
//            else {
//                if (pathVisit[x] == 1)return true;
//            }
//        }
//        pathVisit[node] = 0;
//        return false;
//    }
//    static boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
//        int[] visit = new int[V];
//        int[] pathVisit = new int[V];
//        for (int i = 0; i < V; i++) {
//            if (visit[i] == 0){
//                if(dfs(adj,visit,pathVisit,i))return true;
//            }
//        }
//        return false;
//    }

//    using only visited array
static boolean dfs(ArrayList<ArrayList<Integer>> adj,int[] visit,int node){
    visit[node] = 2;
    for (int x : adj.get(node)){
        if (visit[x] == 0){
            if (dfs(adj,visit,x))return true;
        }
        else {
            if (visit[x] == 2)return true;
        }
    }
    visit[node] = 1;
    return false;
}
    static boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] visit = new int[V];
        for (int i = 0; i < V; i++) {
            if (visit[i] == 0){
                if(dfs(adj,visit,i))return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {

    }
}
