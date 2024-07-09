# Prasunet_AD_04
 It is a Tic Tac Toe game app where two players can take turns to place their symbols (X or O) on a 3x3 grid. The objective is to form a horizontal, vertical, or diagonal line of three of their symbols to win the game.
 <br>
 Author- Srijita Dasgupta

 Explanation:

1. Swing Components:
   - JFrame, JButton, JLabel, and JPanel are used to create the main window, board grid, turn label, and reset button.

2. Board Initialization:
   - buttons array holds the buttons representing each cell on the board.
   - board array stores the game state with 'X', 'O', or '\0' (empty).

3. Button Listeners:
   - Each button on the board has an ActionListener that places the current player's symbol ('X' or 'O') when clicked, checks for a win, and updates the turn.

4. Win Condition:
   - The checkWin method verifies if the current player has achieved three in a row horizontally, vertically, or diagonally.

5. Reset Functionality:
   - The resetGame method resets the game state, clears the board, and resets the turn to Player 'X'.

6. Main Method:
   - The main method initializes the game on the Event Dispatch Thread (EDT) using SwingUtilities.invokeLater() for thread safety.

Running the Application:

1. Compile TicTacToeGame.java using javac TicTacToeGame.java.
2. Run the compiled class using java TicTacToeGame.
3. The Tic Tac Toe game window will appear.
4. Players can click on any cell to place their symbol ('X' or 'O').
5. The game will announce the winner or declare a draw when appropriate.
6. Use the "Reset" button to start a new game after a win or draw.

This implementation provides a complete and functional Tic Tac Toe game app in Java with GUI, player turns, win detection, and reset functionality.
