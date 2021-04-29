package mathgame1;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * This is a simple math game for grades 3-5.
 *
 * @author Heena Heena
 */

public class Main {
    // Score of each game
    private int score = 0;

    // Highest score out of all games played
    private HighScores highScores = new HighScores();

    // Stores all questions
    ArrayList<Question> questions;

    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {
       // System.out.println(3 / 0);
        Main main = new Main();
        main.playMultipleGames();
    }

    /**
     * This method keeps playing game till player wants to.
     */
    public void playMultipleGames() {
        // For reading from console
        Scanner input = new Scanner(System.in);

        boolean playing = true;
        while (playing) {
            score = 0;
            playGame();

            // Check the current score if its highest so far
            if (highScores.checkNewHighScore(score)) {
                System.out.printf("Your new high score is %d%n", highScores.getHighScore());
            }

            System.out.print("\nWould you like to play another game? Enter 1 for yes: ");
            int response = input.nextInt();
            if (response != 1)
                playing = false;
        }
        input.close();
    }

    /**
     * This method starts and plays a game.
     */
    public void playGame() {
        // For reading input from console
        Scanner input = new Scanner(System.in);

        // For generating random number
        Random rand = new Random();

        // create and store 9 questions into questions list
        questions = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            Question q = new Question(rand);
            questions.add(q);
        }

        // Add additional one joke question and adding at 6th position into questions
        // list
        JokeQuestion jokeQuestion = new JokeQuestion(rand);
        questions.add(5, jokeQuestion);

        long start = System.currentTimeMillis();

        // Ask all questions one by one from questions list
        for (int i = 0; i < questions.size(); i++) {
            Question q = questions.get(i);

            System.out.printf("Current Score %d: %n", score);
            q.showQuestion();

            int response = input.nextInt();
            boolean good = q.checkAnswer(response);
            if (good) {
                // increment score only for first time correct answers only
                if (i <= 10)
                    score++;
            } else {
                questions.add(q);
            }
        }

        System.out.printf("You scored %d out of 10.%n", score);
        if (score <= 4) {
            System.out.printf("Good start. Can you practice to improve your score?%n");
        } else if (score <= 7) {
            System.out.printf("Well done. Keep going.%n");
        } else {
            System.out.printf("Congratulations! You have passed this test.%n", score);
        }

        long end = System.currentTimeMillis();
        long time = end - start;
        long seconds = time / 1000;

        if (seconds < 10) {
            System.out.printf("Well done! You took %d seconds to complete the test.%n", seconds);
        }
    }
}