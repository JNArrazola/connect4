package connect4;

public class Board {
    private char[][] board = null;

    // constructor
    Board(int x, int y){
        board = new char[x][y];
        fillBoard();
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
        for(int i = 0; i < board.length; i++)
            for(int j = 0; j < board[0].length; j++)
                if(j==0)
                    System.out.print("|" + board[i][j] + "|");
                else 
                    System.out.print(board[i][j] + "|");
            System.out.println();
        
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
}
