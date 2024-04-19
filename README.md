# Connect 4 Game
Console game programmed in java that simulates the functionality of the famous _connect 4_ board game. The program has the next features: 
- [X] Player Vs Player
- [X] Player Vs AI
- [X] Animated board
- [X] Game saving option
- [X] Saving of best times

## AI Algorithm
For this type of games, programmers usually use usually use `minimax` algorithm, and in fact it's the standard algorithm to solve this type of games.

In this case, I developed my own algorithm, which is based in the `DFS`(Depth First Search) algorithm. I search for the best move that the player can do, and I also test the best moves that the **PC** can do in his turn. Then, based in that information, I take the decision of what is the best possible move in that position.

The algorithm is far from being perfect, but it certainly does a pretty great job.

### Explanation of DFS
**First step:** Finding best possible opponent move.
```java
for (int i = 0; i < board.length; i++) {
    for (int j = 0; j < board[0].length; j++) {
        if (board[i][j] == tokenPlayer) {
            DFS_Algorithm(maxCounter, 0, tokenPlayer, i, j, 0, 1, coords);
            DFS_Algorithm(maxCounter, 0, tokenPlayer, i, j, 0, -1, coords);
            DFS_Algorithm(maxCounter, 0, tokenPlayer, i, j, -1, 0, coords);
            DFS_Algorithm(maxCounter, 0, tokenPlayer, i, j, -1, -1, coords);
            DFS_Algorithm(maxCounter, 0, tokenPlayer, i, j, 1, 1, coords);
            DFS_Algorithm(maxCounter, 0, tokenPlayer, i, j, 1, -1, coords);
            DFS_Algorithm(maxCounter, 0, tokenPlayer, i, j, -1, 1, coords);
        }
    }
}   
```
A **nested for loop** loops through the matrix looking for the player tokens, if we find them, then we are going to look in every direction to see where is the longest string of tokens that the player already connected.

*For example*: If the player has a vertical chain of two tokens, and a diagonal chain of three tokens, the computer is going to give priority to the most dangerous play that the player can do.

But, how does **DFS** works?, well, first of all, we validate if the actual position is on board to avoid possible *out of range* errors:

```java
if (isInBoard(posFila, posColumna))
```
If the actual position falls inside the board, then we are going to look if the char in that position is the same as the player token, if yes, then we are going to continue looking recursively in that direction, otherwise, we are going to compare the actual counter of tokens with the global maximium to see if the counter from that recursive call is greater than the global counter of all the other directions:
```java
if(board[posFila][posColumna]==token){
    DFS_Algorithm(maxCounter, counter + 1, token, posFila + dirFila, posColumna + dirColumna, dirFila, dirColumna, coords);
} else {
    if((maxCounter[0] < counter)&&
    existSupportCell(posFila, posColumna, dirFila, dirColumna)&&
    board[posFila][posColumna]==' '){
        maxCounter[0] = counter;
        coords[0] = posFila;
        coords[1] = posColumna;
    } else return;
}
```