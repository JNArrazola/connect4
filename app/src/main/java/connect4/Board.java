package connect4;

public class Board {
    private char[][] board = null;

    // constructor
    Board(){
        board = new char[6][7];
        resetBoard();
    }

    public int getNumRows(){
        return board.length;
    }

    public int getColumns(){
        return board[0].length;
    }

    /**
     * Function that fills the board with empty chars
      */
    public void resetBoard(){
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
            for(int j = 0; j < board[0].length*(2) + 1; j++)
                System.out.print("-");

            System.out.println();
        }
        
        System.out.println();
        for (int i = 0; i < board[0].length; i++)
            if(i==0)
                System.out.print("|" + (i+1) + "|");
            else 
                System.out.print((i+1) + "|");

        System.out.println();
        System.out.println();
    }

    /**
     * Function that makes a move, it also validates
     * if the move is in the grid
     * 
     * @param column
     * @param token
     * @return boolean
      */
    public boolean makeMove(int column, char token){
        column--;
        
        if(column < 0||column >= (board[0].length))
            return false;
        if(board[0][column]!=' ')
            return false;

        board[0][column] = token;
        boolean placed = false;

        for(int i = 0; i < board.length - 1; i++){
            if(board[i + 1][column]==' '){
                Utilities.clearScreen();
                printBoard();
                Utilities.sleep(500);
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

    /**
     * Function that iterates through the board to see if there is a winner
     * @param token
     * @return boolean
      */
    public boolean checkWin(char token){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j]==token)
                    if(validateWin(0, token, i, j, 0, 1)
                    ||validateWin(0, token, i, j, 1, 0)
                    ||validateWin(0, token, i, j, -1, 1)
                    ||validateWin(0, token, i, j, 1, 1))
                        return true;
            }
        }
        return false;
    }

    /**
     * Recursive function that validates if there is a winner combination on board
     * @param counter
     * @param token
     * @param posFila
     * @param posColumna
     * @param dirFila
     * @param dirColumna
     * @return boolean
     * 
     * @author Joshua Arrazola
      */
    private boolean validateWin(int counter, char token, int posFila, int posColumna, int dirFila, int dirColumna){
        if(counter==4)
            return true;
        
        if(posFila<board.length&&posColumna<board[0].length&&posFila>=0&&posColumna>=0)
            if(board[posFila][posColumna]==token)
                return validateWin(counter + 1, token, posFila + dirFila, posColumna + dirColumna, dirFila, dirColumna);
            else 
                return false;
        return false;
    }
}

