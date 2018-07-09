package tetris;

import java.util.Random;

/**
 * Created by Evaldas on 2015-12-06.
 */
public class Shape { // enum because they hold all seven tetris shapes, DO NOT touch

    enum Tetrominoes { NoShape, ZShape, SShape, LineShape,
        TShape, SquareShape, LShape, MirroredLShape}

    private Tetrominoes pieceShape;
    private int coords[][];
    private int[][][] ShapesTable;


    public Shape() {       // Shape class constructor

        coords = new int[4][2]; // coords array holds actual coordinates of tetrominoes.
        setShape(Tetrominoes.NoShape);

    }

    public void setShape(Tetrominoes shape) {

        ShapesTable = new int[][][] {
                { { 0, 0 },   { 0, 0 },   { 0, 0 },   { 0, 0 } },
                { { 0, -1 },  { 0, 0 },   { -1, 0 },  { -1, 1 } },
                { { 0, -1 },  { 0, 0 },   { 1, 0 },   { 1, 1 } },
                { { 0, -1 },  { 0, 0 },   { 0, 1 },   { 0, 2 } },   // Array holds all possible coordinate values
                { { -1, 0 },  { 0, 0 },   { 1, 0 },   { 0, 1 } },   // all newly created pieces tha their coordinate values
                { { 0, 0 },   { 1, 0 },   { 0, 1 },   { 1, 1 } },
                { { -1, -1 }, { 0, -1 },  { 0, 0 },   { 0, 1 } },
                { { 1, -1 },  { 0, -1 },  { 0, 0 },   { 0, 1 } }
        };

        for (int i = 0; i < 4 ; i++) {
            for (int j = 0; j < 2; ++j) {
                coords[i][j] = ShapesTable[shape.ordinal()][i][j]; //Ordinal method because can return enum type object position
            }
        }
        pieceShape = shape;

    }

    private void setX(int index, int x) { coords[index][0] = x; } //setX and setY for rotational purposes
    private void setY(int index, int y) { coords[index][1] = y; }
    public int x(int index) { return coords[index][0]; }
    public int y(int index) { return coords[index][1]; }
    Tetrominoes getShape()  { return pieceShape; }

    public void setRandomShape() // Getting random tetrominoe shape
    {
        Random r = new Random();
        int x = Math.abs(r.nextInt()) % 7 + 1;
        Tetrominoes[] values = Tetrominoes.values();
        setShape(values[x]);
    }


    public int minY() // retuning minimal Y value
    {
        int m = coords[0][1];
        for (int i=0; i < 4; i++) {
            m = Math.min(m, coords[i][1]);
        }
        return m;
    }

    public Shape rotate()  // Tetrominoes shape being rotated
    {
        if (pieceShape == Tetrominoes.SquareShape)
            return this;

        Shape result = new Shape();
        result.pieceShape = pieceShape;

        for (int i = 0; i < 4; ++i) {
            result.setX(i, -y(i));
            result.setY(i, x(i));
        }
        return result;
    }
}

