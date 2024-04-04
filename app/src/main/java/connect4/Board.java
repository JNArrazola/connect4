package connect4;

public class Board {
    private char[][] board = null;

    // constructor
    Board(int x, int y){
        board = new char[x][y];
        fillBoard();
    }

    public int getNumRows(){
        return board.length;
    }

    public int getColumns(){
        return board[0].length;
    }

    /**
     * Function that fills the board with ' ' chars
      */
    private void fillBoard(){
        for(int i = 0; i < board.length; i++)
            for(int j = 0; j < board[0].length; j++)
                board[i][j] = ' ';
    }

    /**
     * Function that prints the entire board
      */
    public void printBoard(){
        System.out.println();
        System.out.println();
        for(int i = 0; i < board[0].length*(2) + 1; i++)
            System.out.print("-");
        
        System.out.println();
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++)
                if(j==0)
                    System.out.print("|" + board[i][j] + "|");
                else 
                    System.out.print(board[i][j] + "|");
            System.out.println();
        }

        for(int i = 0; i < board[0].length*(2) + 1; i++)
            System.out.print("-");
        System.out.println();
        
        for (int i = 0; i < board[0].length; i++)
            if(i==0)
                System.out.print("|" + (i+1) + "|");
            else 
                System.out.print((i+1) + "|");

        System.out.println();
        System.out.println();
    }

    public boolean makeMove(int column, char token){
        column--;
        if(column < 0||column > (board[0].length)){
            System.out.println("Movimiento inválido");
            return false;
        }

        if(board[0][column]!=' '){
            System.out.println("La columna está llena");
            return false;
        }

        board[0][column] = token;
        boolean placed = false;

        for(int i = 0; i < board.length - 1; i++){
            if(board[i + 1][column]==' '){
                Utilities.clearScreen();
                printBoard();
                Utilities.sleep(1000);
                board[i][column] = ' ';
                board[i + 1][column] = token;
            } else {
                placed = true;
                break;
            }
        }
        
        if(!placed){
            board[board.length - 2][column] = ' ';
            board[board.length - 1][column] = token;
        }



        return true;
    }
}
