import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;

public class Sudoku {

    protected static MaskFormatter createFormatter(String s) {
        MaskFormatter formatter = null;
        try {
            formatter = new MaskFormatter(s);
        } catch (java.text.ParseException exc) {
            System.err.println("formatter is bad: " + exc.getMessage());
            System.exit(-1);
        }
        return formatter;
    }

    public static void addComponentsToPane(Container pane){

        pane.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();


        JFormattedTextField tab [][] = new JFormattedTextField[9][9];

        for(int i = 0; i < 9 ; i++) {
            for (int j = 0; j < 9; j++) {
                JFormattedTextField f = new JFormattedTextField( createFormatter("#") );
                c.gridy = i;
                c.gridx = j;
                c.ipadx = 10;
                c.insets = new Insets(2,2,0,0);  //padding
                if (i%3 == 0)
                    c.insets = new Insets(12,2,0,0);  //padding
                if (j%3 == 0)
                    c.insets = new Insets(2,12,0,0);  //padding
                if (i%3 == 0 && j%3 == 0)
                    c.insets = new Insets(12,12,0,0);  //padding
                pane.add(f, c);
                tab[i][j] = f;
            }
        }

        JButton button = new JButton("s o l v e");
        c.gridx = 2;
        c.gridy = 10;
        c.gridwidth = 5;
        c.weighty = 1.0;
        pane.add(button,c);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("s u d o k u");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        addComponentsToPane(frame.getContentPane());

        frame.setSize(300,300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
