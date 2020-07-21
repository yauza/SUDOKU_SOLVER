import javax.swing.*;

public class PassingValues{
    int[][] array = new int[9][9];

    public void gettingValues(JFormattedTextField[] fields){

        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){

                String text = fields[(9*i + j)].getText();
                if (!text.equals(" ")){
                    array[i][j] = Integer.parseInt(text);
                } else {
                    array[i][j] = 0;
                }
            }
        }

    }
}
