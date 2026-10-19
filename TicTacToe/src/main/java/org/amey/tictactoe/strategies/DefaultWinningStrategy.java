package org.amey.tictactoe.strategies;

import org.amey.tictactoe.enums.Symbol;

public class DefaultWinningStrategy implements WinningStrategy
{
    @Override
    public boolean checkWin(int row, int col, Symbol s, Symbol[][] board)
    {
        boolean rowWon = true;
        boolean colWon = true;
        boolean diagWon1 = true;
        boolean diagWon2 = true;
        for(int i=0; i<board.length; ++i)
        {
            if(board[row][i] != s) rowWon = false;
            if(board[i][col] != s) colWon = false;
            if(board[i][i] != s) diagWon1 = false;
            if(board[i][board.length - i - 1] != s) diagWon2 = false;
        }
        return rowWon || colWon || diagWon1 || diagWon2;
    }
}
