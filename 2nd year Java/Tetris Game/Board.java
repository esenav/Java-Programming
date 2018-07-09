package tetris;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.*;
import javax.swing.*;
import tetris.Shape.Tetrominoes;


public class Board extends JPanel implements ActionListener {

    int Game_Width = 10;
    int Game_Height = 20;
    Timer timer;
    boolean isFallingFinished = false;
    boolean Started = false;
    boolean Paused = false;
    int numLinesRemoved = 0;    // Important variables for game to be played
    int current_X = 0;
    int current_Y = 0;
    JLabel Game_score;
    Shape current_Piece;
    Tetrominoes[] board;



    public Board(Tetris parent) {

        setFocusable(true); // using for keyboard inputs
        current_Piece = new Shape();
        timer = new Timer(1000, this); // Timer call actionPerformed every 1000ms
        timer.start();
        Game_score =  parent.getStatusBar();
        board = new Tetrominoes[Game_Width * Game_Height];
        addKeyListener(new MyKeyListener());
        clearBoard();
        addMouseListener(new MyMouseListener());
    }

    public void actionPerformed(ActionEvent e) { // Checks if falling has finished
        if (isFallingFinished) {
            isFallingFinished = false;
            newPiece(); // if true tries to create new Tetrominoe
        } else {
            oneLineDown(); // normaly piece drops down
        }
    }


    int squareWidth() {
        return (int) getSize().getWidth() / Game_Width; } // Getting size of Tetroeminoes depending on windown size.
    int squareHeight() {
        return (int) getSize().getHeight() / Game_Height; }
    Tetrominoes shape_location(int x, int y) {
        return board[(y * Game_Width) + x]; }


    public void start() // Starts the game
    {
        if (Paused)
            return;

        Started = true;
        isFallingFinished = false;
        numLinesRemoved = 0;
        clearBoard();
        newPiece();
        timer.start();
    }

    private void pause() // Pauses the game
    {
        if (!Started)
            return;

        Paused = !Paused;
        if (Paused) {
            timer.stop();
            Game_score.setText("paused");
        } else {
            timer.start();
            Game_score.setText(String.valueOf(numLinesRemoved));
        }
        repaint();
    }

    public void paint(Graphics g)
    {
        super.paint(g);

        Dimension size = getSize();
        int boardTop = (int) size.getHeight() - Game_Height * squareHeight();

        // First we paint all shapes which had been dropped down
        for (int i = 0; i < Game_Height; ++i) {
            for (int j = 0; j < Game_Width; ++j) {
                Tetrominoes shape = shape_location(j, Game_Height - i - 1);
                if (shape != Tetrominoes.NoShape)
                    drawSquare(g, j * squareWidth(),
                            boardTop + i * squareHeight(), shape);
            }
        }
        // Secondly painting falling tetrominoe
        if (current_Piece.getShape() != Tetrominoes.NoShape) {
            for (int i = 0; i < 4; ++i) {
                int x = current_X + current_Piece.x(i);
                int y = current_Y - current_Piece.y(i);
                drawSquare(g, x * squareWidth(),
                        boardTop + (Game_Height - y - 1) * squareHeight(),
                        current_Piece.getShape());
            }
        }
    }

    public void dropDown() // Dropping the piece to the bottom or until collision
    {
        int newY = current_Y;
        while (newY > 0) {
            if (!tryMove(current_Piece, current_X, newY - 1))
                break;
            --newY;
        }
        pieceDropped();
    }

    private void oneLineDown() // Dropping piece one line down
    {
        if (!tryMove(current_Piece, current_X, current_Y - 1))
            pieceDropped();
    }


    private void clearBoard() // FIlls Panel with empty tetrominoes , used at collisions
    {
        for (int i = 0; i < Game_Height * Game_Width; ++i)
            board[i] = Tetrominoes.NoShape;
    }

    private void pieceDropped()
    {   // puts new Tetrominoes to array and holds them
        for (int i = 0; i < 4; ++i) {
            int x = current_X + current_Piece.x(i);
            int y = current_Y - current_Piece.y(i);
            board[(y * Game_Width) + x] = current_Piece.getShape();
        }
        // Checks if any lines are full
        removeFullLines();
        // Creating new piece if we can
        if (!isFallingFinished)
            newPiece();
    }

    private void newPiece() // creating new tetrominoe shape
    {
        current_Piece.setRandomShape();
        current_X = Game_Width / 2 - 1;
        current_Y = Game_Height - 1 + current_Piece.minY();
        // If we can not move initial values game is over
        if (!tryMove(current_Piece, current_X, current_Y)) {
            current_Piece.setShape(Tetrominoes.NoShape);
            timer.stop();
            Started = false;
            Game_score.setText("Your Total Score is:"+" "+String.valueOf(numLinesRemoved)  );
        }
    }

    private boolean tryMove(Shape newPiece, int newX, int newY) // Tries to move Tetrominoe shape
    {   // its for board boundaries or it has reached collision
        for (int i = 0; i < 4; ++i) {
            int x = newX + newPiece.x(i);
            int y = newY - newPiece.y(i);
            if (x < 0 || x >= Game_Width || y < 0 || y >= Game_Height)
                return false;
            if (shape_location(x, y) != Tetrominoes.NoShape)
                return false;
        }

        current_Piece = newPiece;
        current_X = newX;
        current_Y = newY;
        repaint();
        return true;
    }

    private void removeFullLines() // Checks if there is any full lines in array, if true moves all lines above full row down.
    {
        int numFullLines = 0;

        for (int i = Game_Height - 1; i >= 0; --i) {
            boolean lineIsFull = true;

            for (int j = 0; j < Game_Width; ++j) {
                if (shape_location(j, i) == Tetrominoes.NoShape) {
                    lineIsFull = false;
                    break;
                }
            }

            if (lineIsFull) {
                numFullLines = numFullLines+10;
                for (int k = i; k < Game_Height - 1; ++k) {
                    for (int j = 0; j < Game_Width; ++j)
                        board[(k * Game_Width) + j] = shape_location(j, k + 1);
                }
            }
        }

        if (numFullLines > 0) {
            numLinesRemoved += numFullLines;
            Game_score.setText(String.valueOf(numLinesRemoved));
            isFallingFinished = true;
            current_Piece.setShape(Tetrominoes.NoShape);
            repaint();
        }
    }

    private void drawSquare(Graphics g, int x, int y, Tetrominoes shape)
    {
        Color colors[] = { new Color(0, 0, 0), new Color(204, 102, 102),
                new Color(102, 204, 102), new Color(102, 102, 204),
                new Color(204, 204, 102), new Color(204, 102, 204),
                new Color(102, 204, 204), new Color(218, 170, 0)
        };

        Color color = colors[shape.ordinal()]; // Ordinal method returns current position of enum type object

        g.setColor(color);
        g.fillRect(x + 1, y + 1, squareWidth() - 2, squareHeight() - 2);
        // Giving Tetrominoes 3D color effect
        g.setColor(color.brighter());
        g.drawLine(x, y + squareHeight() - 1, x, y);
        g.drawLine(x, y, x + squareWidth() - 1, y);

        g.setColor(color.darker());
        g.drawLine(x + 1, y + squareHeight() - 1,
                x + squareWidth() - 1, y + squareHeight() - 1);
        g.drawLine(x + squareWidth() - 1, y + squareHeight() - 1,
                x + squareWidth() - 1, y + 1);
    }
    // Getting Mouse Buttons and Keyboard buttons to work.
    class MyKeyListener extends KeyAdapter {
        public void keyPressed(KeyEvent e) {

            if (!Started || current_Piece.getShape() == Tetrominoes.NoShape) {
                return;
            }

            int key_input = e.getKeyCode();

            if (key_input == 'p' || key_input == 'P') {
                pause();
                return;
            }
            if (Paused)
                return;

            switch (key_input) {
                case 'd':
                    oneLineDown();
                    break;
                case 'D':
                    oneLineDown();
                    break;
            }

        }
    }
    class MyMouseListener extends MouseAdapter{
        public void mouseClicked(MouseEvent evt){
            if((evt.getModifiers()&InputEvent.BUTTON1_MASK)!=0){
                tryMove(current_Piece, current_X - 1, current_Y);
            }
            if ((evt.getModifiers()&InputEvent.BUTTON3_MASK)!=0){
                tryMove(current_Piece, current_X +1, current_Y);
            }
            if((evt.getModifiers()& InputEvent.BUTTON2_MASK)!=0){
                tryMove(current_Piece.rotate(), current_X, current_Y);
            }
        }
        /*public void mouseWheelMoved(MouseWheelEvent et){
            if(et.getWheelRotation()>0){
                tryMove(current_Piece.rotate(), current_X, current_Y);
            }
        }*/

    }

}