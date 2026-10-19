package org.amey.tictactoe.strategies;

import org.amey.tictactoe.enums.Symbol;

public interface WinningStrategy
{
    public boolean checkWin(int row, int col, Symbol s, Symbol[][] board);
}
