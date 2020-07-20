import javax.swing.*;

public class PassingValues{
    int[][] array = new int[9][9];

    public void gettingValues(JFormattedTextField[] fields){

        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){
                int temp;
                if (fields[(9*i + j)].getText() == null){
                    temp = Integer.parseInt(fields[(9*i + j)].getText());
                } else {
                    temp = 0;
                }
                array[i][j] = temp;
            }
        }

    }
}
