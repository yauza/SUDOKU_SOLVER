public class sudokualgo {

    int[][] arr = new int[9][9];

    public sudokualgo(){
       for (int i = 0; i < 9; i++){
           for (int j = 0; j < 9; j++){
               arr[i][j] = 0;
           }
       }
    }

    public void getValues(int[][] array){
        for (int i = 0; i < 9; i++){
            for( int j = 0; j < 9; j++){
                arr[i][j] = array[i][j];
            }
        }
    }

    public void printtab(){
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public boolean possible(int row, int col, int k){
        for(int i=0; i<9; i++){
            //col
            if(i != row && arr[i][col] == k) {
                return false;
            }
            //row
            if(i != col && arr[row][i] == k) {
                return false;
            }
        }
        //square
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(3*(row/3) + i != row && 3*(col/3) + j  != col && arr[ 3*(row/3) + i ][ 3*(col/3) + j ] == k) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean solveAux(int freeFields[][], int n, int i) {
        int row = freeFields[i+1][0];
        int col = freeFields[i+1][1];
        //last field
        if(i+1 == n-1) {
            for (int k = 1; k < 10; k++) {
                if (possible(row, col, k)) {
                    arr[row][col] = k;
                    return true;
                }
            }
            return false;
        }
        for (int k = 1; k < 10; k++) {
            if (possible(row, col, k)) {
                arr[row][col] = k;
                if (solveAux(freeFields, n, i+1))
                    return true;
            }
        }
        arr[row][col] = 0;
        return false;
    }

    public boolean solve(){
        //entry
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if (arr[i][j] != 0) {
                    if (!possible (i, j, arr[i][j])) {
                        return false;
                    }
                }
            }
        }



        int countZero = 0;
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if (arr[i][j] == 0)
                    countZero += 1;
            }
        }
        int[][] freeFields  = new int [countZero][2];
        int counter = 0;
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++) {
                if (arr[i][j] == 0) {
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
            if ( possible(row, col, k) ) {
                arr[row][col] = k;
                if (solveAux(freeFields, countZero, 0))
                    return true;
            }
        }
        return false;
    }


}