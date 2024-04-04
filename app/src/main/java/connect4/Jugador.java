package connect4;

public class Jugador {
    private final String nombre;
    private final char token;
    private boolean isTurn;

    public String getNombre() {
        return this.nombre;
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

    public Jugador(String nombre, char token, boolean turn){
        this.nombre = nombre;
        this.token = token;
        this.isTurn = turn;
    }
}
