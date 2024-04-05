package connect4;


public class Game {
    private Board board = null;
    
    public void start(){
        System.out.println("Ingresa el número de filas: ");
        int rows = Utilities.validateNumberBoard();  
        
        System.out.println("Ingresa el número de columnas: ");
        int columns = Utilities.validateNumberBoard();

        board = new Board(rows, columns);

        do {
            System.out.println("¿Qué modalidad desea jugar?");
            System.out.println("1) Jugador contra jugador");
            System.out.println("2) Jugador contra IA");
            int opt = Utilities.validateNumber();

            switch (opt) {
                case 1: // Jugador contra Jugador
                    PlayerVsPlayer();
                    break;
                case 2: // Jugador contra máquina

                    break;
                default:
                    break;
            }
        } while (true);
    }

    private Player createPlayer(int numPlayer){
        System.out.println("Ingresa el nombre del jugador: ");
        String nombre = Utilities.validateString();

        return new Player(nombre, ((numPlayer == 1) ? '1' : '2'), ((numPlayer == 1)) ? true : false);
    }

    private void swipeTurns(Player one, Player two){
        if(one.getIsTurn()){
            one.setIsTurn(false);
            two.setIsTurn(true);
        } else {
            two.setIsTurn(false);
            one.setIsTurn(true);
        }
    }

    private void PlayerVsPlayer(){
        board.resetBoard();
        
        Player playerOne = createPlayer(1);
        Player playerTwo = createPlayer(2);
        
        Player winner = null;
        do {
            // Clear screen
            Utilities.clearScreen();
            
            // Print board
            board.printBoard();

            // Who's in turn? 
            Player playerToMove = ((playerOne.isIsTurn()) ? playerOne : playerTwo);
            
            // What move?
            System.out.println("Ingresa la columna de " + playerToMove.getName() + "(" + playerToMove.getToken()+ "): ");
            int play = Utilities.validateNumber();

            // Make play and validate if there is a winner
            if(board.makeMove(play, playerToMove.getToken())){
                if(board.checkWin(playerToMove.getToken())){
                    Utilities.clearScreen();
                    winner = playerToMove;
                    break;
                }

                // Swipe turns of players
                swipeTurns(playerOne, playerTwo);
            } 
        } while (true);

        Utilities.clearScreen();
        board.printBoard();
        System.out.println("¡Gana el jugador: " + winner.getName() + "(" + winner.getToken() + ")!");
        System.out.println();
        System.out.println();
    }


}
