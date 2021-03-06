import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.Arrays;


public class Sudoku {


    public static MaskFormatter createFormatter(String s) {

        MaskFormatter formatter = null;
        try {
            formatter = new MaskFormatter(s);
        } catch (java.text.ParseException exc) {
            System.err.println("formatter is bad: " + exc.getMessage());
            System.exit(-1);
        }
        return formatter;
    }

    public static JFormattedTextField[] arr = new JFormattedTextField[81];

    public static void addComponentsToPane(Container pane) {

        pane.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        for (int i = 0; i < 81; i++){
            JFormattedTextField f = new JFormattedTextField(createFormatter("#"));
            arr[i] = f;
        }


        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                String temp = Integer.toString(9*i + j);
                int a = (9*i + j);
                JFormattedTextField f;
                f = arr[a];

                c.gridy = i;
                c.gridx = j;
                c.ipadx = 10;
                c.insets = new Insets(2, 2, 0, 0);
                if (i % 3 == 0)
                    c.insets = new Insets(12, 2, 0, 0);
                if (j % 3 == 0)
                    c.insets = new Insets(2, 12, 0, 0);
                if (i % 3 == 0 && j % 3 == 0)
                    c.insets = new Insets(12, 12, 0, 0);
                pane.add(f, c);

            }
        }

        JButton button = new JButton("s o l v e");
        c.gridx = 0;
        c.gridy = 10;
        c.gridwidth = 5;
        c.weighty = 1.0;
        pane.add(button, c);

        JButton button_reset = new JButton("r e s e t");
        c.gridx = 5;
        c.gridy = 10;
        c.gridwidth = 5;
        c.weighty = 1;
        pane.add(button_reset, c);

        JLabel label = new JLabel();
        c.gridx = 2;
        c.gridy = 14;
        c.gridwidth = 5;
        c.weighty = 1;
        pane.add(label, c);


        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PassingValues chart = new PassingValues();
                chart.gettingValues(arr);
                sudokualgo alg = new sudokualgo();
                alg.getValues(chart.array);
                if ( alg.solve() ){
                    for (int i = 0; i < 9; i++){
                        for (int j = 0; j < 9; j++){
                            String temp = Integer.toString(alg.arr[i][j]);
                            arr[(9*i + j)].setText(temp);
                        }
                    }
                    label.setText("S O L V E D");
                } else{
                    for(int i=0; i<81; i++){
                        arr[i].setText("");
                    }
                    label.setText("I M P O S S I B L E");
                }
            }
        });

        button_reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < 81; i++){
                    arr[i].setText("");
                }
                label.setText("");
            }
        });
    }


    private static void createAndShowGUI() {
        JFrame frame = new JFrame("s u d o k u");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        addComponentsToPane(frame.getContentPane());


        //Display the window.
        frame.setSize(300,400);
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
