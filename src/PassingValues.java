import javax.swing.*;

public class PassingValues{
    int[][] array = new int[9][9];

    public static Integer tryParse(String text) {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public void gettingValues(JFormattedTextField[] fields){

        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){
                int temp;
                if (fields[(9*i + j)].getText() == null){
                    temp = 0;
                } else {
                    temp = tryParse(fields[(9*i + j)].getText());
                }
                array[i][j] = temp;
            }
        }

    }
}