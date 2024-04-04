package connect4;


public class Game {
    public void start(){
        System.out.println("Ingresa el número de filas: ");
        int rows = utilities.validateNumberBoard();  

        System.out.println("Ingresa el número de columnas: ");
        int columns = utilities.validateNumberBoard();

        Board board = new Board(rows, columns);
        board.printBoard();
    }
}
