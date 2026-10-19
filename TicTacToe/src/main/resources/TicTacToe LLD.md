Requirements:
1. There should be two Users to play tictactoe.
2. Users can select their own symbols X or O.
3. There will be a 3x3 board where users can put their symbols.
4. First player who makes a consecutive line of their symbols (3) is winner.
5. If users are out of places then its a draw.


Objects:
User
    - id
    - sym

    + chooseSymbol(Symbol s)

Board
    - size
    - cells
    LinkedList<User> users

    + Board 
    + turn(int row, int col, User s)
            - if its a draw
                - break, and mention game drawn
            - check if cell is not empty:
                - put player at the start of LL
                - break, message

            - set Symbol on board and check for win
            - if User win:
                - break and Message win
            put player at the end of LL

Symbols
    X,O

TicTacToeController/Main
    - users created with symbols
    - Board created with size 3
    - turnLoop
        - each player is asked to select a cell by row and col
        - board.turn(row, col)

