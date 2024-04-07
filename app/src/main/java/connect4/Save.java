package connect4;

import java.io.Serializable;

public class Save implements Serializable {
    private final Player playerOne;
    private final Player playerTwo;
    private final Board board;

    Save(Player playerOne, Player playerTwo, Board board){
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.board = board;
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
}
