public class Main {
    static sudokualgo ee = new sudokualgo();

    public static void main(String[] args){
        int[][] array = {
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,4,5,6,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0}};

        for(int i=0; i<9; i++){
            for(int j=0;j<9;j++){
                ee.arr[i][j] = array[i][j];
            }
        }
        System.out.println(ee.solve());
        ee.printtab();
    }


}
