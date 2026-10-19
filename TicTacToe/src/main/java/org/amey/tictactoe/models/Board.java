package org.amey.tictactoe.models;

import org.amey.tictactoe.enums.Symbol;
import org.amey.tictactoe.enums.TurnResult;
import org.amey.tictactoe.strategies.WinningStrategy;

public class Board
{
    private int size;
    private Symbol[][] cells;
    private int used = 0;
    private WinningStrategy winningStrategy;

    public Board(int size, WinningStrategy ws) {
        this.size = size;
        this.cells = new Symbol[size][size];
        this.winningStrategy = ws;
    }

    public Symbol[][] getBoardState()
    {
        return cells;
    }

    public TurnResult turn(int row, int col, Player player)
    {
        if(row < 0 || col < 0 || row >= size || col >= size)
            return TurnResult.INVALID_CELL;

        if(cells[row][col] != null)
            return TurnResult.CELL_USED;

        cells[row][col] = player.getSymbol();
        if(winningStrategy.checkWin(row, col, player.getSymbol(), cells))
            return TurnResult.WIN;

        used++;
        if(used == size*size)
            return TurnResult.DRAW;
        return TurnResult.CONTINUE;
    }
}
