package mathgame1;

import java.util.Random;

/**
 * Simple JokeQuestion class which asks surprise funny question to player
 * with correct scoring value.
 *
 * @author Heena Heena
 */
public class JokeQuestion extends Question {

    public JokeQuestion(Random rand) {
        super(rand);
    }

    public JokeQuestion(int v1, int v2, String op) {
        super(v1, v2, op);
    }

    @Override
    public void showQuestion() {
        System.out.printf("How many Liverpool fans does it take to screw in a lightbulb? ");
    }

    @Override
    public boolean checkAnswer(int response) {
        System.out.println("They don't, they just talk about how good the old one was.\n");
        return true;
    }
}