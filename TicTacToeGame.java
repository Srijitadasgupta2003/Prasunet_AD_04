package Prasunet_AD_04;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeGame {
    private JFrame frame;
    private JButton[][] buttons;
    private JLabel turnLabel;
    private char[][] board;
    private char currentPlayer;
    private boolean gameEnded;

    public TicTacToeGame() {
        frame = new JFrame("Tic Tac Toe");
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel boardPanel = new JPanel(new GridLayout(3, 3));
        buttons = new JButton[3][3];
        board = new char[3][3];
        currentPlayer = 'X';
        gameEnded = false;
// Initialize the board buttons
for (int row = 0; row < 3; row++) {
    for (int col = 0; col < 3; col++) {
        buttons[row][col] = new JButton();
        buttons[row][col].setFont(new Font("Arial", Font.PLAIN, 80));
        buttons[row][col].setBackground(Color.WHITE);
        final int r = row;
        final int c = col;
        buttons[row][col].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!gameEnded && board[r][c] == '\0') { // If cell is empty and game is not ended
                    board[r][c] = currentPlayer;
                    buttons[r][c].setText(Character.toString(currentPlayer));
                    buttons[r][c].setForeground(currentPlayer == 'X' ? Color.BLUE : Color.RED);
                    if (checkWin(currentPlayer)) {
                        JOptionPane.showMessageDialog(frame, "Player " + currentPlayer + " wins!");
                        gameEnded = true;
                    } else if (isBoardFull()) {
                        JOptionPane.showMessageDialog(frame, "It's a draw!");
                        gameEnded = true;
                    } else {
                        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                        turnLabel.setText("Turn: Player " + currentPlayer);
                    }
                }
            }
        });
        boardPanel.add(buttons[row][col]);
    }
}

turnLabel = new JLabel("Turn: Player " + currentPlayer, JLabel.CENTER);
        turnLabel.setFont(new Font("Arial", Font.BOLD, 16));
        frame.add(turnLabel, BorderLayout.NORTH);
        frame.add(boardPanel, BorderLayout.CENTER);

        JButton resetButton = new JButton("Reset");
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetGame();
            }
        });
        frame.add(resetButton, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    private boolean checkWin(char player) {
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) ||
                (board[0][i] == player && board[1][i] == player && board[2][i] == player)) {
                return true;
            }
        }
        // Check diagonals
        if ((board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
            (board[0][2] == player && board[1][1] == player && board[2][0] == player)) {
            return true;
        }
        return false;
    }

    private boolean isBoardFull() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board[row][col] == '\0') {
                    return false; // Found an empty cell, game is not full
                }
            }
        }
        return true; // All cells are filled, game is full
    }

    private void resetGame() {
        currentPlayer = 'X';
        gameEnded = false;
        turnLabel.setText("Turn: Player " + currentPlayer);
        // Clear the board
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = '\0';
                buttons[row][col].setText("");
            }
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TicTacToeGame();
            }
        });
    }
}

