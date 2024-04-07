package connect4;

/**
 * Class that represents a pair of coordenates to search for the best play on board
  */
public class Pair {
    private int coordX;
    private int coordY;

    public Pair(int coordX, int coordY){
        this.coordX = coordX;
        this.coordY = coordY;
    }

    public int getCoordX() {
        return coordX;
    }

    public int getCoordY() {
        return coordY;
    }
}
