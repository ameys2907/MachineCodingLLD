package org.amey.tictactoe.controller;

import org.amey.tictactoe.enums.Symbol;
import org.amey.tictactoe.enums.TurnResult;
import org.amey.tictactoe.models.Board;
import org.amey.tictactoe.models.Player;
import org.amey.tictactoe.strategies.DefaultWinningStrategy;

import java.util.LinkedList;
import java.util.Scanner;

public class GameController
{
    private LinkedList<Player> players;
    private Board board;
    private Scanner sc;

    public GameController()
    {
        sc = new Scanner(System.in);
        System.out.println("Provide board size: ");
        int size = sc.nextInt();

        this.board = new Board(size, new DefaultWinningStrategy());
        players = new LinkedList<>();
    }

    public void start()
    {
        System.out.println("Enter user 1 ID:");
        String userId1 = sc.next();
        Player player1 = new Player(userId1, Symbol.X);

        System.out.println("Enter user 2 ID:");
        String userId2 = sc.next();
        Player player2 = new Player(userId2, Symbol.O);

        players.add(player1);
        players.add(player2);

        while(true)
        {
            showBoard();
            Player player = players.pollFirst();
            System.out.println("User: " + player.getId() + " select row and col for Ex: 1 2");
            int row = sc.nextInt();
            int col = sc.nextInt();

            boolean isGameOver = false;
            TurnResult tr = board.turn(row, col, player);
            switch (tr)
            {
                case INVALID_CELL: {
                    System.out.println("Invalid cell location!");
                    players.addFirst(player);
                    break;
                }
                case CELL_USED: {
                    System.out.println("Cell is already used!");
                    players.addFirst(player);
                    break;
                }
                case CONTINUE: {
                    players.addLast(player);
                    break;
                }
                case WIN: {
                    System.out.println("User: " + player.getId() + " won !");
                    isGameOver = true;
                    break;
                }
                case DRAW: {
                    System.out.println("The game is a draw :(");
                    isGameOver = true;
                    break;
                }
            }
            if(isGameOver)
            {
                System.out.println("Thank you for playing");
                sc.close();
                break;
            }
        }
    }

    private void showBoard()
    {
        Symbol[][] cells = board.getBoardState();
        int size = cells.length;
        for(int i=0; i<size; ++i)
        {
            for(int j=0; j<size; ++j)
                System.out.print((cells[i][j] == null ? "-" : cells[i][j]) + " ");
            System.out.println("");
        }
    }
}
