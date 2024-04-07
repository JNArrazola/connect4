package connect4;

import org.checkerframework.checker.units.qual.s;

public class Board {
    private char[][] board = null;

    // constructor
    Board() {
        board = new char[6][7];
        resetBoard();
    }

    public int getNumRows() {
        return board.length;
    }

    public int getColumns() {
        return board[0].length;
    }

    /**
     * Function that fills the board with empty chars
     */
    public void resetBoard() {
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++)
                board[i][j] = ' ';
    }

    /**
     * Function that prints the entire board
     */
    public void printBoard() {
        System.out.println();
        System.out.println();
        for (int i = 0; i < board[0].length * (2) + 1; i++)
            System.out.print("-");

        System.out.println();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++)
                if (j == 0)
                    System.out.print("|" + board[i][j] + "|");
                else
                    System.out.print(board[i][j] + "|");
            System.out.println();
            for (int j = 0; j < board[0].length * (2) + 1; j++)
                System.out.print("-");

            System.out.println();
        }

        System.out.println();
        for (int i = 0; i < board[0].length; i++)
            if (i == 0)
                System.out.print("|" + (i + 1) + "|");
            else
                System.out.print((i + 1) + "|");

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
    public boolean makeMove(int column, char token) {
        column--;

        if (column < 0 || column >= (board[0].length))
            return false;
        if (board[0][column] != ' ')
            return false;

        board[0][column] = token;
        boolean placed = false;

        for (int i = 0; i < board.length - 1; i++) {
            if (board[i + 1][column] == ' ') {
                Utilities.clearScreen();
                printBoard();
                //Utilities.sleep(500);
                board[i][column] = ' ';
                board[i + 1][column] = token;
            } else {
                placed = true;
                break;
            }
        }

        if (!placed) {
            board[board.length - 2][column] = ' ';
            board[board.length - 1][column] = token;
        }

        return true;
    }

    /**
     * Function that iterates through the board to see if there is a winner
     * 
     * @param token
     * @return boolean
     */
    public boolean checkWin(char token) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == token)
                    if (validateWin(0, token, i, j, 0, 1) // Vertical de arriba hacia abajo
                            || validateWin(0, token, i, j, 1, 0) // Horizontal de izquierda a derecha
                            || validateWin(0, token, i, j, -1, 1) // 
                            || validateWin(0, token, i, j, 1, 1)) // D
                        return true;
            }
        }
        return false;
    }

    /**
     * Recursive function that validates if there is a winner combination on board
     * 
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
    private boolean validateWin(int counter, char token, int posFila, int posColumna, int dirFila, int dirColumna) {
        if (counter == 4)
            return true;

        if (isInBoard(posFila, posColumna))
            if (board[posFila][posColumna] == token)
                return validateWin(counter + 1, token, posFila + dirFila, posColumna + dirColumna, dirFila, dirColumna);
            else
                return false;
        return false;
    }

    public void PcMove(char tokenPlayer, char tokenRival) {
        int[] maxCounter = new int[1];
        maxCounter[0] = 0;

        int[] coords = new int[2];
        coords[0] = -1;
        coords[1] = -1;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == tokenPlayer) {
                    DFS_Algorithm(maxCounter, 0, tokenPlayer, i, j, 0, -1, coords);
                    DFS_Algorithm(maxCounter, 0, tokenPlayer, i, j, 0, 1, coords);
                    DFS_Algorithm(maxCounter, 0, tokenPlayer, i, j, 1, -1, coords);
                    DFS_Algorithm(maxCounter, 0, tokenPlayer, i, j, -1, 0, coords);
                    DFS_Algorithm(maxCounter, 0, tokenPlayer, i, j, -1, -1, coords);
                }
            }
        }

        board[coords[0]][coords[1]] = tokenRival;
    }

    private boolean isInBoard(int posFila, int posColumna){
        return posFila < board.length && posColumna < board[0].length && posFila >= 0 && posColumna >= 0;
    }

    private boolean existSupportCell(int posFila, int posColumna, int dirFila, int dirColumna){
        if(dirFila==-1&&dirColumna==-1){
            return isInBoard(posFila, posColumna + 1)&&
            board[posFila][posColumna + 1]!=' ';
        } else if(dirFila==1&&dirColumna==-1){
            return isInBoard(posFila, posColumna + 1)&&
            board[posFila][posColumna + 1]!=' ';
        } else if(dirFila==-1&&dirColumna==0){
            return isInBoard(posFila - 1, posColumna);
        } else if(dirFila==0&&dirColumna==1){
            return ((isInBoard(posFila + 1, posColumna + 1) && board[posFila + 1][posColumna + 1] != ' ')
            || ((posFila == board.length - 1) && isInBoard(posFila, posColumna + 1) && board[posFila][posColumna + 1] == ' '));
        } else if(dirFila==0&&dirColumna==-1){
            return ((isInBoard(posFila - 1, posColumna + 1) && board[posFila - 1][posColumna + 1] != ' ')
            || ((posFila == board.length - 1) && isInBoard(posFila, posColumna - 1) && board[posFila][posColumna - 1] == ' '));
        }
        return false;
    }

    private void DFS_Algorithm(int[] maxCounter, int counter, char token, int posFila, int posColumna, int dirFila, int dirColumna, int[] coords){
        if (isInBoard(posFila, posColumna)){
            if(board[posFila][posColumna]==token){
                DFS_Algorithm(maxCounter, counter + 1, token, posFila + dirFila, posColumna + dirColumna, dirFila, dirColumna, coords);
            } else {
                if((maxCounter[0] < counter)&&
                existSupportCell(posFila, posColumna, dirFila, dirColumna)&&
                board[posFila][posColumna]==' '){
                    coords[0] = posFila;
                    coords[1] = posColumna;
                    maxCounter[0] = counter;
                } else return;
            }
        } else return;
    }
}
