import java.util.Random;
        import java.util.Scanner;

public class Number_game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Scanner object to read user input
        Random random = new Random(); // Random object to generate random numbers
        boolean continuePlaying = true; // Flag to control game continuation
        int totalScore = 0; // Variable to keep track of total score

        // Main game loop
        while (continuePlaying) {
            int targetNumber = random.nextInt(100) + 1; // Generate a random number between 1 and 100
            int attempts = 0; // Variable to count the number of attempts
            int maxAttempts = 10; // Maximum number of attempts allowed
            boolean correctGuess = false; // Flag to check if the user has guessed correctly

            System.out.println("I've picked a number between 1 and 100. Can you guess it?");

            // Loop for user attempts
            while (attempts < maxAttempts && !correctGuess) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt(); // Read user's guess
                attempts++; // Increment the attempt counter

                // Check if the guess is correct, too high, or too low
                if (userGuess == targetNumber) {
                    System.out.println("Great job! You guessed it!");
                    correctGuess = true; // Set flag to true if guess is correct
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low. Try again.");
                } else {
                    System.out.println("Too high. Try again.");
                }

                // Check if the user has used all attempts
                if (attempts == maxAttempts && !correctGuess) {
                    System.out.println("Out of attempts! The number was " + targetNumber);
                }
            }

            totalScore += maxAttempts - attempts; // Update the total score based on attempts
            System.out.println("Score this round: " + (maxAttempts - attempts));
            System.out.println("Total score: " + totalScore);

            // Ask the user if they want to play again
            System.out.print("Do you want to play again? (yes/no): ");
            String response = scanner.next();
            continuePlaying = response.equalsIgnoreCase("yes"); // Update flag based on user's response
        }

        System.out.println("Thanks for playing! Your final score is: " + totalScore);
        scanner.close(); // Close the scanner
    }
}

