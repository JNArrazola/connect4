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
                    jugadorContraJugador();
                    break;
                case 2: // Jugador contra máquina

                    break;
                default:
                    break;
            }
        } while (true);
    }

    private Jugador crearJugador(int numJugador){
        System.out.println("Ingresa el nombre del jugador: ");
        String nombre = utilities.validateString();

        return new Jugador(nombre, ((numJugador == 1) ? '1' : '2'), ((numJugador == 1)) ? true : false);
    }

    private void jugadorContraJugador(){
        Jugador jugadorUno = crearJugador(1);
        Jugador jugadorDos = crearJugador(2);

        do {
            // Impresión del teclado
            board.printBoard();

            // Turno actual
            Jugador jugadorEnTurno = ((jugadorUno.isIsTurn()) ? jugadorUno : jugadorDos);
            
            System.out.println("Ingresa la columna de " + jugadorEnTurno.getNombre() + ": ");
            int play = utilities.validateNumber();

            makeMove(play);
        } while (true);
    }

    private void makeMove(int column){
        if(column < (board.getColumns() + 1)||column > (board.getColumns()+1)){
            System.out.println("Movimiento inválido");
            System.out.println("Column: " + column);
            System.out.println("board.getCo: " + board.getColumns()+1);
            return;
        }
    }
}
