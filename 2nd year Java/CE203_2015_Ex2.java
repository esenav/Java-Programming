
import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

/**
 * Created by Evaldas on 2015-11-01.
 */
public class CE203_2015_Ex2 extends JApplet {

    JTextField field;
    JTextArea output;
    JButton add;
    JButton display;
    JButton search;
    JButton remf;           //Variables to be accessed
    JButton remall;
    JButton clear;
    LinkedList<String> list1;

    @Override
    public void init() {

        list1 = new LinkedList<String>();   //Creating linked list
        field = new JTextField(20);
        output = new JTextArea();       //Creating Text area which would be automatically set on size
        output.setEditable(false);
        JLabel input = new JLabel("Please enter String");
        JLabel result = new JLabel("Your Results");
        add = new JButton("Add");
        display = new JButton("Display with beginning");    //Creating labels and buttons
        search = new JButton("Search");
        remf = new JButton("Remove first");
        remall = new JButton("Remove all");
        clear = new JButton("Clear List");
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();           //Creating panels
        JPanel panel3 = new JPanel();
        panel1.add(input);
        panel1.add(field);
        panel2.add(result);
        panel2.add(output);
        panel3.add(add);                    //Adding variables to panels
        panel3.add(display);
        panel3.add(search);
        panel3.add(remf);
        panel3.add(remall);
        panel3.add(clear);
        add(panel1, BorderLayout.NORTH);
        add(panel2, BorderLayout.CENTER);       //Setting panels layouts
        add(panel3, BorderLayout.SOUTH);
        add.addActionListener(new ButtonHandler2(this));
        display.addActionListener(new ButtonHandler2(this));
        search.addActionListener(new ButtonHandler2(this));
        remf.addActionListener(new ButtonHandler2(this));       //Buttons action listeners
        remall.addActionListener(new ButtonHandler2(this));
        clear.addActionListener(new ButtonHandler2(this));

    }
}
