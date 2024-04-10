package connect4;

import java.io.Serializable;

public class Save implements Serializable {
    private final Player playerOne;
    private final Player playerTwo;
    private final Board board;
    private final String gamemode;
    private final Chronometer chronometer;

    Save(Player playerOne, Player playerTwo, Board board, String gamemode, Chronometer chronometer){
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.board = board;
        this.gamemode = gamemode;
        this.chronometer = chronometer;
    }

    public Board getBoard() {
        return board;
    }

    public Player getPlayerOne() {
        return playerOne;
    }

    public Player getPlayerTwo() {
        return playerTwo;
    }

    public String getGamemode() {
        return gamemode;
    }

    public Chronometer getChronometer() {
        return chronometer;
    }
}
