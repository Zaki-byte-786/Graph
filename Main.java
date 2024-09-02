import java.util.*;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
//    static void addElementInArrayList(ArrayList<ArrayList<Integer>> arl,int i,int j){
//        arl.get(i).add(j);
//        arl.get(j).add(i);
//    }
    public static void main(String[] args) {
//        ArrayList<ArrayList<Integer>> arl = new ArrayList<>();
//        int v = 3;
//        int e = 3;
//        for (int i = 0; i <= v; i++) {
//            ArrayList<Integer> al = new ArrayList<>();
//            arl.add(al);
//        }
//        System.out.println(arl);
//        addElementInArrayList(arl,2,3);
//        System.out.println(arl);
//        addElementInArrayList(arl,1,2);
//        System.out.println(arl);
        int[][] array2D = new int[5][5];
        array2D[1][2] = 1;
        array2D[2][1] = 1;
        array2D[1][4] = 1;
        array2D[4][1] = 1;
        array2D[2][3] = 1;
        array2D[3][2] = 1;
        array2D[3][4] = 1;
        array2D[4][3] = 1;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(array2D[i][j]+" ");
            }
            System.out.println();
        }
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if ( array2D[i][j] == 1){
                    adj.get(i).add(j);
                }
            }
        }
        System.out.println(adj);
    }
}