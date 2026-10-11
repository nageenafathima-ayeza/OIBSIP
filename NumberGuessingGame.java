import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int numberToGuess = rand.nextInt(100) + 1;
        int attempts = 0;
        int maxAttempts = 10;
        int score = 0;
        
        System.out.println("Welcome to Number Guessing Game!");
        System.out.println("I have selected a number between 1 and 100. You have 10 attempts.");
        
        while (attempts < maxAttempts) {
            System.out.print("Enter your guess: ");
            int guess = sc.nextInt();
            attempts++;
            
            if (guess == numberToGuess) {
                System.out.println("Congratulations! You guessed it in " + attempts + " attempts.");
                score = maxAttempts - attempts + 1;
                System.out.println("Your score: " + score);
                break;
            } else if (guess < numberToGuess) {
                System.out.println("Too low! Try higher.");
            } else {
                System.out.println("Too high! Try lower.");
            }
            System.out.println("Attempts left: " + (maxAttempts - attempts));
        }
        
        if (attempts == maxAttempts) {
            System.out.println("Game Over! The number was: " + numberToGuess);
        }
        sc.close();
    }
}
