import java.util.ArrayList;

public class Graph_implementation {
    static void addElementInMatrix(int[][] array,int i,int j){
        array[i][j] = 1;
        array[j][i] = 1;
    }
    static void addElementInArrayList(ArrayList<ArrayList<Integer>> arl, int i, int j){
        arl.get(i).add(j);
        arl.get(j).add(i);
    }
    public static void main(String[] args) {
        // using 2D array
        int v = 3;
        int e = 3;
        int[][] array = new int[v+1][v+1];
        addElementInMatrix(array,1,2);
        System.out.println(array[1][2]);

        // using arraylist of arraylist
        ArrayList<ArrayList<Integer>> arl = new ArrayList<>();
        for (int i = 0; i <= v; i++) {
            ArrayList<Integer> al = new ArrayList<>();
            arl.add(al);
        }
        System.out.println(arl);
        addElementInArrayList(arl,2,3);
        System.out.println(arl);
        addElementInArrayList(arl,1,2);
        System.out.println(arl);
        System.out.println(arl.get(2));
    }
}
