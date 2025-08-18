import java.util.Random;
import java.util.Scanner;
public class SCT_SD_02 {
        public static void main(String[] args) {
            // Generate random number between 1 and 100
            Random rand = new Random();
            int numberToGuess = rand.nextInt(100) + 1;

            Scanner scanner = new Scanner(System.in);
            int userGuess = 0;
            int attempts = 0;

            System.out.println("Welcome to the Number Guessing Game!");
            System.out.println("I'm thinking of a number between 1 and 100. Can you guess it?");

            while (userGuess != numberToGuess) {
                System.out.print("Enter your guess: ");
                userGuess = scanner.nextInt();
                attempts++;

                if (userGuess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else if (userGuess > numberToGuess) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Congratulations! You guessed the number in " + attempts + " tries.");
                }
            }

            scanner.close();
        }
    }