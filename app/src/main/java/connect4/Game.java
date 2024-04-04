package connect4;


public class Game {
    private Board board = null;
    
    public void start(){
        System.out.println("Ingresa el número de filas: ");
        int rows = utilities.validateNumberBoard();  

        System.out.println("Ingresa el número de columnas: ");
        int columns = utilities.validateNumberBoard();

        board = new Board(rows, columns);

        do {
            System.out.println("¿Qué modalidad desea jugar?");
            System.out.println("1) Jugador contra jugador");
            System.out.println("2) Jugador contra IA");
            int opt = utilities.validateNumber();

            switch (opt) {
                case 1: // Jugador contra Jugador
                    
                    break;
                case 2: // Jugador contra máquina
                    
                    break;
                default:
                    break;
            }
        } while (true);
    }
}
