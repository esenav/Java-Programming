package tetris;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Created by Evaldas on 2015-12-06.
 */

public class Tetris extends JApplet {

    JLabel Game_score;
    JButton Start;          // Variables to be accessed in Tetris()
    JButton Drop;

    public Tetris() {

        Game_score = new JLabel(" 0");
        Start = new JButton("Start Game");
        Drop = new JButton("Drop Down");
        JPanel panel2 = new JPanel();
        panel2.add(Start);
        panel2.add(Drop);
        panel2.add(Game_score);
        add(panel2, BorderLayout.SOUTH);
        final Board board = new Board(this);    // Accessing Board class
        add(board);
        board.start(); // Starts the Game once window is open.

        Start.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {   //Initialising new game round.
                if (ae.getSource() == Start){
                    board.start();
                    Game_score.setText("0");
                }
            }
        });
        Drop.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {    // Drop button handler
                if (e.getSource()==Drop){
                    board.dropDown();
                }

            }
        });
    }

    public JLabel getStatusBar() {  // Getting JLabel
        return Game_score;
    }
}