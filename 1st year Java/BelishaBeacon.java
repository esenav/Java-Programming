import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * Created by Evaldas on 2015-04-18.
 */
public class BelishaBeacon extends JPanel {
    public boolean choseColor = true;
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        if(choseColor){
            Ellipse2D.Double oval1 = new Ellipse2D.Double(143,55,55,55);
            g2.setColor(Color.ORANGE);
            g2.draw(oval1);
            g2.fill(oval1);
        }else{
            Ellipse2D.Double oval1 = new Ellipse2D.Double(143,55,55,55);
            g2.setColor(Color.LIGHT_GRAY);
            g2.draw(oval1);
            g2.fill(oval1);
        }
        Rectangle box1 = new Rectangle(165,110,10,30);
        g2.setColor(Color.BLACK);
        g2.draw(box1);
        g2.fill(box1);
        Rectangle box2 = new Rectangle(165,140,10,30);
        g2.draw(box2);
        Rectangle box3 = new Rectangle(165,170,10,30);
        g2.draw(box3);
        g2.fill(box3);
        Rectangle box4 = new Rectangle(165,200,10,30);
        g2.draw(box4);
        Rectangle box5 = new Rectangle(165,230,10,30);
        g2.draw(box5);
        g2.fill(box5);
        Rectangle box6 = new Rectangle(165,260,10,30);
        g2.draw(box6);
        Rectangle box7 = new Rectangle(165,290,10,30);
        g2.draw(box7);
        g2.fill(box7);
        Rectangle box8 = new Rectangle(165,320,10,30);
        g2.draw(box8);
        Rectangle box9 = new Rectangle(165,350,10,30);
        g2.draw(box9);
        g2.fill(box9);
        Rectangle box10 = new Rectangle(165,380,10,30);
        g2.draw(box10);
    }
}
