
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Evaldas on 2015-10-31.
 */
public class ButtonHandler implements ActionListener {

    public CE203_2015_Ex1 Applet;

    ButtonHandler(CE203_2015_Ex1 e){
        Applet = e;             //Constructor
    }
    int input1;
    int input2;     //Variables to be accessed in whole class
    int input3;

    public void actionPerformed(ActionEvent a){
        try{
            input1=Integer.parseInt(Applet.in1.getText());
            if (input1<0){
                input1=150;
                Applet.in1.setText("150");
            }                               //First try block for first text field to be checked
            if(input1>255){
                input1=255;
                Applet.in1.setText("255");
            }
        }
        catch (NumberFormatException b){
            Applet.in1.setText(null);       //If exception cached it will null the first text field and send out a message.
            Applet.name.setText("Invalid input");
        }
        try{
            input2=Integer.parseInt(Applet.in2.getText());
            if(input2<0){
                input2=150;
                Applet.in2.setText("150");
            }                               //Second try block for second text field to be checked
            if(input2>255){
                input2=255;
                Applet.in2.setText("255");
            }
        }
        catch (NumberFormatException z){
            Applet.in2.setText(null);        //Same as previous catch
            Applet.name.setText("Invalid input");
        }
        try{
            input3=Integer.parseInt(Applet.in3.getText());
            if (input3<0){
                input3=150;
                Applet.in3.setText("150");
            }                               //Try block for third text field to be checked
            if(input3>255){
                input3=255;
                Applet.in3.setText("255");
            }
        }
        catch (NumberFormatException x){
            Applet.in3.setText(null);       //Same as previous catch
            Applet.name.setText("Invalid input");
        }
        try{

             Color newcolor = new Color(input1,input2, input3);
             if (a.getSource()==Applet.value)       //Getting all textfield inputs, making new color and setting it on name.
                 Applet.name.setForeground(newcolor);
        }
        catch (Exception v){            //Trying to catch any exception available
            Applet.name.setText("Invalid color input");


        }
        try{
            if(a.getSource()==Applet.reset){
                Applet.in1.setText(null);
                Applet.in2.setText(null);           //Reset button setting all text field to null, and remaking JLabel name. repaint() method did not worked for some reason.
                Applet.in3.setText(null);
                Applet.name.setText("Evaldas Senavaitis 1402039");
                Applet.name.setForeground(Color.GREEN);
            }

        }
        catch (Exception u){        //Trying to get any possible exception
            Applet.name.setText("Invalid reset");
        }
    }

}
