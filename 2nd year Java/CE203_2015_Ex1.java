
import javax.swing.*;
import java.awt.*;

/**
 * Created by Evaldas on 2015-10-31.
 */
public class CE203_2015_Ex1 extends JApplet {
    JTextField in1;
    JTextField in2;
    JTextField in3;
    JLabel name;    //Variables are for Button handler to be accessible
    JButton reset;
    JButton value;
    public void init(){
        in1 = new JTextField(3);
        in2 = new JTextField(3);       //Create text fields with size of 3
        in3 = new JTextField(3);
        value = new JButton("Set Color");
        reset = new JButton("Reset");
        name = new JLabel("Evaldas Senavaitis 1402039");
        name.setForeground(Color.GREEN);
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();      //Create 3 panels for neat layout
        JPanel panel3 = new JPanel();
        panel1.add(in1);
        panel1.add(in2);
        panel1.add(in3);
        panel1.add(value);          //Adding variables to panels
        panel2.add(name);
        panel3.add(reset);
        add(panel1, BorderLayout.NORTH);
        add(panel2, BorderLayout.CENTER);       //Setting layouts for panels
        add(panel3, BorderLayout.SOUTH);
        value.addActionListener(new ButtonHandler(this));
        reset.addActionListener(new ButtonHandler(this));       //Adding action listeners for buttons
    }

}
