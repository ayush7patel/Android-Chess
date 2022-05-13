package GameRecording;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

public class GameSave implements Serializable
{
    private static final long serialVersionUID = 1L;
    public String nameOfGame;
    public Calendar dateOfGame;
    private String winner;
    public ArrayList<String> movesOfGame;
    public GameSave(String gameName, String winner, ArrayList<String> moves)
    {
        this.nameOfGame = gameName;
        this.dateOfGame = Calendar.getInstance();
        this.winner = winner;
        this.movesOfGame = moves;
    }
    public String getNameOfGame()
    {
        return this.nameOfGame;
    }
    public Calendar getDateOfGame()
    {
        return this.dateOfGame;
    }
    public String getWinner()
    {
        return this.winner;
    }
    public ArrayList<String> getMovesOfGame()
    {
        return this.movesOfGame;
    }
    public String toString()
    {
        return this.getNameOfGame() + "|" + this.dateOfGame.toString() + "|" + this.getWinner();
    }
}
