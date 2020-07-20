public class sudokualgo {
    public static void printtab(int [][] array){
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static boolean possible(int array[][],int row,int col, int k){
        for(int i=0; i<9; i++){
            //col
            if(array[i][col] == k)
                return false;
            //row
            if(array[row][i] == k)
                return false;
        }
        //square
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(array[ 3*(row/3) + i ][ 3*(col/3) + j ] == k)
                    return false;
            }
        }
        return true;
    }

    public static boolean solveAux(int array[][], int freeFields[][], int n, int i) {
        int row = freeFields[i+1][0];
        int col = freeFields[i+1][1];

        //last field
        if(i+1 == n-1) {
            for (int k = 1; k < 10; k++) {
                if (possible(array, row, col, k)) {
                    array[row][col] = k;
                    return true;
                }
            }
            return false;
        }
        for (int k = 1; k < 10; k++) {
            if (possible(array, row, col, k)) {
                array[row][col] = k;
                if (solveAux(array, freeFields, n, i+1))
                    return true;
            }
        }
        array[row][col] = 0;
        return false;
    }

    public static boolean solve(int[][] array){
        int countZero = 0;
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if (array[i][j] == 0)
                    countZero += 1;
            }
        }
        int[][] freeFields  = new int [countZero][2];
        int counter = 0;
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++) {
                if (array[i][j] == 0) {
                    freeFields[counter][0] = i;
                    freeFields[counter][1] = j;
                    counter += 1;
                }
            }
        }
        //solving the problem
        int row = freeFields[0][0];
        int col = freeFields[0][1];
        for (int k = 1; k < 10; k++) {
            if ( possible(array, row, col, k) ) {
                array[row][col] = k;
                if (solveAux(array, freeFields, countZero, 0))
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int array[][] = {
            {3,0,4,0,0,6,0,2,5},
            {0,0,0,0,0,0,0,0,6},
            {2,0,0,1,5,0,0,8,0},
            {0,2,0,0,9,1,0,7,8},
            {0,5,7,8,0,3,0,0,2},
            {0,0,0,0,0,0,0,0,0},
            {0,6,0,0,0,0,0,0,0},
            {0,0,1,4,2,0,9,0,0},
            {0,3,2,0,0,5,8,4,0}};

        if( solve(array) ){
            printtab(array);
        }else{
            System.out.println(" I M P O S S I B L E");
        }

    };
}
