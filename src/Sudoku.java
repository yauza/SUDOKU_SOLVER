import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.util.Map;



public class Sudoku {

    //A convenience method for creating a MaskFormatter.
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

    static Map<String, JFormattedTextField> fields;

    public static void addComponentsToPane(Container pane) {

        pane.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        for (int i = 0; i < 81; i++){
            JFormattedTextField f = new JFormattedTextField(createFormatter("#"));
            String temp = Integer.toString(i);
            fields.put(temp, f);
        }


        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                String temp = Integer.toString(i);
                JFormattedTextField f;
                f = fields.get(temp);

                c.gridy = i;
                c.gridx = j;
                c.ipadx = 10;
                c.insets = new Insets(2, 2, 0, 0);  //padding
                if (i % 3 == 0)
                    c.insets = new Insets(12, 2, 0, 0);  //padding
                if (j % 3 == 0)
                    c.insets = new Insets(2, 12, 0, 0);  //padding
                if (i % 3 == 0 && j % 3 == 0)
                    c.insets = new Insets(12, 12, 0, 0);  //padding
                pane.add(f, c);

            }
        }

        JButton button = new JButton("s o l v e");
        c.gridx = 2;
        c.gridy = 10;
        c.gridwidth = 5;
        c.weighty = 1.0;
        pane.add(button, c);
    }

    /*
    private static JFormattedTextField createTextField(String fieldName){
        JFormattedTextField field = new JFormattedTextField(createFormatter("#"));
        fields.put(field, fieldName);
        return field;
    }
     */

    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("s u d o k u");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Set up the content pane.
        addComponentsToPane(frame.getContentPane());

        //Display the window.
        frame.setSize(300, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
