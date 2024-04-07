package connect4;

public class Player {
    private final String name;
    private final char token;
    private boolean isTurn;
    private final boolean isPc;

    public String getName() {
        return this.name;
    }

    public char getToken() {
        return this.token;
    }

    public boolean isIsTurn() {
        return this.isTurn;
    }

    public boolean getIsTurn() {
        return this.isTurn;
    }

    public void setIsTurn(boolean isTurn) {
        this.isTurn = isTurn;
    }

    public boolean getIsPc() {
        return isPc;
    }

    public Player(String nombre, char token, boolean turn, boolean isPc){
        this.name = nombre;
        this.token = token;
        this.isTurn = turn;
        this.isPc = isPc;
    }
}
