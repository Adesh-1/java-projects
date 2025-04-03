import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToe {
    private JFrame frame;
    private JButton[][] buttons;
    private char currentPlayer;
    private boolean gameOver;
    
    public TicTacToe() {
        frame = new JFrame("Tic-Tac-Toe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new BorderLayout());
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 3));
        buttons = new JButton[3][3];
        currentPlayer = 'X';
        gameOver = false;
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton("");
                buttons[i][j].setFont(new Font("Arial", Font.BOLD, 60));
                buttons[i][j].setFocusPainted(false);
                final int row = i, col = j;
                buttons[i][j].addActionListener(e -> makeMove(row, col));
                panel.add(buttons[i][j]);
            }
        }
        
        JButton resetButton = new JButton("Restart");
        resetButton.addActionListener(e -> resetGame());
        
        frame.add(panel, BorderLayout.CENTER);
        frame.add(resetButton, BorderLayout.SOUTH);
        
        frame.setVisible(true);
    }
    
    private void makeMove(int row, int col) {
        if (!gameOver && buttons[row][col].getText().equals("")) {
            buttons[row][col].setText(String.valueOf(currentPlayer));
            if (checkWin(currentPlayer)) {
                JOptionPane.showMessageDialog(frame, "Player " + currentPlayer + " wins!");
                gameOver = true;
            } else if (isBoardFull()) {
                JOptionPane.showMessageDialog(frame, "It's a tie!");
                gameOver = true;
            } else {
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }
        }
    }
    
    private boolean checkWin(char player) {
        for (int i = 0; i < 3; i++) {
            if (buttons[i][0].getText().equals(String.valueOf(player)) &&
                buttons[i][1].getText().equals(String.valueOf(player)) &&
                buttons[i][2].getText().equals(String.valueOf(player))) return true;
            
            if (buttons[0][i].getText().equals(String.valueOf(player)) &&
                buttons[1][i].getText().equals(String.valueOf(player)) &&
                buttons[2][i].getText().equals(String.valueOf(player))) return true;
        }
        
        if (buttons[0][0].getText().equals(String.valueOf(player)) &&
            buttons[1][1].getText().equals(String.valueOf(player)) &&
            buttons[2][2].getText().equals(String.valueOf(player))) return true;
        
        if (buttons[0][2].getText().equals(String.valueOf(player)) &&
            buttons[1][1].getText().equals(String.valueOf(player)) &&
            buttons[2][0].getText().equals(String.valueOf(player))) return true;
        
        return false;
    }
    
    private boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (buttons[i][j].getText().equals("")) {
                    return false;
                }
            }
        }
        return true;
    }
    
    private void resetGame() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText("");
            }
        }
        currentPlayer = 'X';
        gameOver = false;
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(TicTacToe::new);
    }
}
