package mathgame1;


import java.util.Random;

/**
 * Simple Math Question class which performs arithmetic operations (addition,
 * subtraction, multiplication and division) on two integer values.
 *
 * @author Heena Heena
 *
 */
public class MathQuestion extends Question {

    public MathQuestion(int v1, int v2, String op) {
        super(v1, v2, op);
    }

    public MathQuestion(Random rand) {
        super(rand);
    }
}