import javax.swing.*;

public class DisplayingValues {
    int[][] a = new int[9][9];

    public void gettingValues(JFormattedTextField[] fields){

        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){
                int temp = Integer.parseInt(fields[(9*i + j)].getText());
                a[i][j] = temp;
            }
        }

    }
}
