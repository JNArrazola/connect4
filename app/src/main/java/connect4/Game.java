package connect4;

import java.util.Scanner;

public class Game {
    private Board board;
    Save save = FileManagement.load();
    private final Scanner in = new Scanner(System.in);

    public void start(){
        gameFound();
        
        int opt;
        do {
            System.out.println("¿Qué modalidad desea jugar?");
            System.out.println("1) Jugador contra jugador");
            System.out.println("2) Jugador contra IA");
            System.out.println("3) Mostrar mejores puntajes");
            System.out.println("0) Salir");
            opt = Utilities.validateNumber();

            switch (opt) {
                case 1: // Jugador contra Jugador
                    PlayerVsPlayer();
                    break;
                case 2: // Jugador contra máquina
                    PlayerVSPc();
                    break;
                case 3 : // Mejores puntajes

                    break;
                default:
                    break;
            }
        } while (opt!=0);
    }

    /**
     * App executes this function if there is a game in memory
     * @param save
      */
    void gameFound(){
        if(save!=null){
            System.out.println("Hay una partida pendiente, ¿desea reanudarla? (y/n): ");
            String answ = Utilities.validateString();
            if(answ.toLowerCase().equals("y")){
                if(save.getPlayerTwo().getIsPc())
                    PlayerVSPc();
                else 
                    PlayerVsPlayer();
            } else {
                save = null;
                FileManagement.save(save);
                Utilities.clearScreen();
            }
        }
    }

    private Player createPlayer(int numPlayer){
        System.out.println("Ingresa el nombre del jugador: ");
        String nombre = Utilities.validateString();

        return new Player(nombre, ((numPlayer == 1) ? 'X' : 'O'), ((numPlayer == 1)) ? true : false, false);
    }

    /**
     * Function to swipe turns between players
     * @param one
     * @param two
     */
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
        Player playerOne;
        Player playerTwo;

        /**
         * We get info if there is a saved game
          */
        if(save==null){
            playerOne = createPlayer(1);
            playerTwo = createPlayer(2);
            board = new Board();
            board.resetBoard();
        } else {
            playerOne = save.getPlayerOne();
            playerTwo = save.getPlayerTwo();
            board = save.getBoard();
        }
        
        
        Player winner = null;
        do {
            
            // Clear screen
            Utilities.clearScreen();
            
            // Print board
            board.printBoard();

            if(board.isFilled()){
                System.out.println("El tablero se llenó");
                return;
            }

            // Who's in turn? 
            Player playerToMove = ((playerOne.isIsTurn()) ? playerOne : playerTwo);
            
            // What move?
            System.out.println("Ingresa la columna de " + playerToMove.getName() + "(" + playerToMove.getToken()+ ")[Ingresa -1 para guardar partida]: ");
            int play = Utilities.validateNumber();

            if(play==-1){
                FileManagement.save(new Save(playerOne, playerTwo, board, "PlayerVsPlayer"));
                System.exit(0);
            }

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
        System.out.println("Presiona ENTER para continuar");
        System.out.println();
        System.out.println();
        FileManagement.save(null);
        in.nextLine();
    }

    void PlayerVSPc(){
        Player playerOne;
        Player playerTwo; 

        /**
         * We get info if there is a saved game
          */
        if(save==null){
            playerOne = createPlayer(1);
            playerTwo = new Player("PC", 'O', false, true);
            board = new Board();
            board.resetBoard();
        } else {
            playerOne = save.getPlayerOne();
            playerTwo = save.getPlayerTwo();
            board = save.getBoard();
        }

        Player winner = null;
        char tokenJugador = playerOne.getToken();
        do {
            
            
            // Clear screen
            Utilities.clearScreen();

            // Print board
            board.printBoard();

            if(board.isFilled()){
                System.out.println("El tablero se llenó");
                return;
            }

            // Who's in turn?
            Player playerToMove = ((playerOne.isIsTurn()) ? playerOne : playerTwo);
            

            if(!playerToMove.getIsPc()){
                System.out.println("Ingresa la columna de " + playerToMove.getName() + "(" + playerToMove.getToken()+ ")[Ingresa -1 para guardar partida]: ");
                int play = Utilities.validateNumber();    

                if(play==-1){
                    FileManagement.save(new Save(playerOne, playerTwo, board, "PlayerVsPc"));
                    System.exit(0);
                }
    
                if(board.makeMove(play, playerToMove.getToken())){
                    if(board.checkWin(playerToMove.getToken())){
                        Utilities.clearScreen();
                        winner = playerToMove;
                        break;
                    }

                    swipeTurns(playerOne, playerTwo);
                } 
            } else {
                board.PcMove(tokenJugador, playerTwo.getToken()); 
                swipeTurns(playerOne, playerTwo);
                if(board.checkWin(playerToMove.getToken())){
                    Utilities.clearScreen();
                    winner = playerToMove;
                    break;
                }
            }
            
        } while (true);
            Utilities.clearScreen();
            board.printBoard();
            System.out.println("¡Gana el jugador: " + winner.getName() + "(" + winner.getToken() + ")!");
            System.out.println("Presiona ENTER para continuar");
            System.out.println();
            System.out.println();
            save = null;
            FileManagement.save(save);
            in.nextLine();
    }
}
