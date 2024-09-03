import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class NumberGuessingGameGUI {
    private static final int MIN = 1;
    private static final int MAX = 100;
    private static int numberToGuess;
    private static boolean hasGuessedCorrectly;

    public static void main(String[] args) {
        
        JFrame frame = new JFrame("Number Guessing Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new java.awt.FlowLayout());

        
        JButton startButton = new JButton("Start Game");
        frame.add(startButton);

        
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startGame();
            }
        });

        
        frame.setVisible(true);
    }

    private static void startGame() {
        
        Random random = new Random();
        numberToGuess = random.nextInt(MAX - MIN + 1) + MIN;
        hasGuessedCorrectly = false;

       
        while (!hasGuessedCorrectly) {
            
            String userInput = JOptionPane.showInputDialog(null, "Enter your guess (between " + MIN + " and " + MAX + "):");

            
            if (userInput == null) {
                JOptionPane.showMessageDialog(null, "Game cancelled.");
                return;
            }

            
            int userGuess;
            try {
                userGuess = Integer.parseInt(userInput);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a number.");
                continue;
            }

            
            if (userGuess < numberToGuess) {
                JOptionPane.showMessageDialog(null, "Too low! Try again.");
            } else if (userGuess > numberToGuess) {
                JOptionPane.showMessageDialog(null, "Too high! Try again.");
            } else {
                JOptionPane.showMessageDialog(null, "Congratulations! You guessed the number.");
                hasGuessedCorrectly = true;
            }
        }
    }
}
