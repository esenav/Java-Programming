import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;

/**
 * Created by Evaldas on 2015-04-18.
 */
public class TestBelishaBeacon extends JFrame {
    public boolean flashes = true;
    JButton JFlash = new JButton("Flash");
    JButton JSteady = new JButton("Steady");
    JPanel panel1 = new JPanel();
    BelishaBeacon panel2 = new BelishaBeacon();
    java.util.Timer timer = new java.util.Timer();
public TestBelishaBeacon(){
    panel1.add(JFlash);
    panel1.add(JSteady);
    this.add(panel1,BorderLayout.SOUTH);
    this.add(panel2, BorderLayout.CENTER);
    JFlash.addActionListener(new TimerListener());
    JSteady.addActionListener(new TimerStopListener());
    timer.scheduleAtFixedRate(new flash(),0,500);


}
    public class flash extends TimerTask {
        public void run(){

            if(flashes){
                panel2.choseColor = !panel2.choseColor;
            } else {
                panel2.choseColor = true;
            }
            repaint();
        }
    }
    public static void main(String[] args){
        JFrame frame = new TestBelishaBeacon();
        frame.setSize(360, 600);
        frame.setTitle("Belisha Beacon");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    public class TimerListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {

            flashes = true;

        }
    }
    public class TimerStopListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {

            flashes = false;
        }
    }

}
