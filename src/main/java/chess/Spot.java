package chess;
import pieces.Piece;

/**
 * Spot is the class which gives information about any particular square on the chessboard.
 * @author Ayush Patel
 * @author Kirtan Patel
 *
 */
public class Spot {
    /**
     * the x-coordinate of this Spot
     */
    int x;
    /**
     * the y-coordinate of this Spot
     */
    int y;
    /**
     * the ChessPiece that resides in this Spot
     */
    Piece piece;

    /**
     * Constructor with 2 arguments
     *
     * @param x the x-coordinate of the Spot
     * @param y the y-coordinate of the Spot
     * @param piece the ChessPiece that resides in this Spot
     */
    public Spot(int x, int y, Piece piece) {
        this.x = x;
        this.y = y;
        this.piece = piece;

    }
    /**
     * getPiece method is used to get the Piece at a particular spot
     * @return  The chesspiece at that spot
     */
    public Piece getPiece()

    {
        return this.piece;
    }
    /**
     * setPiece method is used to set a chesspiece to a particular spot
     * @param p   The chessPiece to be placed
     */
    public void setPiece(Piece p)

    {
        this.piece = p;
    }

    /**
     * isEmpty method tells us if no ChessPiece exists at this Spot
     *
     * @return true if there is no ChessPiece, false otherwise
     */
    public boolean isEmpty() { return piece == null;}

    /**
     * getXCoordinate method is used to get x coordinate of This Spot
     *
     * @return The x coordinate of the spot
     */
    public int getXCoordinate()

    {
        return this.x;
    }

    /**
     * getYCoordinate method is used to get y coordinate of this Spot
     *
     * @return  The y coordinate of the spot
     */
    public int getYCoordinate()

    {
        return this.y;
    }

}