package GameSource;
import  java.util.Scanner;
import java.io.IOException;
import java.util.Random;
/**
 * @Created 19/02/2020
 * @Modified 04/06/2020
 */
public class GuessingGame {
    // setup your instance variables
    private Scanner scan;
    private int response;
    private int secretNumber;
    private int guessStart = 0;
    // setup contraints
    private static final int MAX_GUESSES = 6;
    private static final int UPPER_BOUND = 100;
    // program

    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to the Guessing Game");

        // create an instan
        GuessingGame hiLo = new GuessingGame();

        hiLo.start();

    }
    public void start()
    {
        String input; // Local variable within this method only
        scan = new Scanner(System.in); // Creates Scanner instance


        System.out.print("Do you want to play a game (y/n)?");

        input = scan.next(); // takes the input

        // if the input equals y it will run the game
        while(input.equals("y")){

            System.out.println("You responded: " + input);
            Random ranNum = new Random(); // creates an instance of the class Random
            secretNumber = ranNum.nextInt(UPPER_BOUND);

            // check if response not equal to secret number and not out of guesses
            while (response != secretNumber && guessStart < MAX_GUESSES){
                System.out.print("Please enter the secret number");
                response = scan.nextInt();
                guessStart++;

                // check if the response is close to the secet number
                if (response == secretNumber) {
                    System.out.println("You have guessed the number correctly");
                    input = "n";
                    break;
                }
                else if (response < secretNumber){
                    System.out.println("It is too low!");
                }
                else if (response > secretNumber){
                    System.out.println("It is too high!");
                }

            }
            if (guessStart == MAX_GUESSES){
                display();
                guessStart = 0;
                System.out.print("Do you want to play again? (y/n)");
                input = scan.next(); // takes the input
            }

            if (input.equals("n")){
                System.out.println("Goodbye");
            }


        } // end of control while loop

    }
    public void display()
    {
        System.out.println("You have failed the game, the secret number was " + secretNumber ); // only display if failed
    }
}
