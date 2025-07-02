import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int roundsPlayed = 0;
        int roundsWon = 0;
        final int MAX_ATTEMPTS = 7;

        System.out.println(" Welcome to the Number Guessing Game!");

        boolean playAgain = true;
        while (playAgain) {
            int numberToGuess = random.nextInt(100) + 1;
            int attempts = 0;
            boolean hasWon = false;

            System.out.println("\n Guess the number between 1 and 100. You have " + MAX_ATTEMPTS + " attempts!");

            while (attempts < MAX_ATTEMPTS) {
                System.out.print("Attempt " + (attempts + 1) + ": Enter your guess: ");
                
                if (!scanner.hasNextInt()) {
                    System.out.println(" Invalid input. Please enter a number.");
                    scanner.next(); // Clear invalid input
                    continue;
                }

                int guess = scanner.nextInt();
                attempts++;

                if (guess == numberToGuess) {
                    System.out.println(" Correct! You guessed the number in " + attempts + " attempts.");
                    hasWon = true;
                    roundsWon++;
                    break;
                } else if (guess < numberToGuess) {
                    System.out.println("Too low!");
                } else {
                    System.out.println("Too high!");
                }
            }

            if (!hasWon) {
                System.out.println(" You've run out of attempts. The correct number was: " + numberToGuess);
            }

            roundsPlayed++;

            System.out.print("\n Do you want to play another round? (yes/no): ");
            String response = scanner.next().toLowerCase();
            if (!response.equals("yes") && !response.equals("y")) {
                playAgain = false;
            }
        }

        System.out.println("\n Game Over!");
        System.out.println(" Rounds played: " + roundsPlayed);
        System.out.println("Rounds won: " + roundsWon);
        double winRate = roundsPlayed > 0 ? (roundsWon * 100.0 / roundsPlayed) : 0;
        System.out.printf(" Win rate: %.2f%%\n", winRate);

        scanner.close();
    }
}
