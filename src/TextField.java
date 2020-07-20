import javax.swing.*;


public class TextField {
    int x;
    int y;

    Sudoku a = new Sudoku();

    public TextField(int x, int y, String name){
        JFormattedTextField field = new JFormattedTextField(a.createFormatter("#"));
    }
}
