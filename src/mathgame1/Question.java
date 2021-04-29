package mathgame1;

import java.util.Random;

/**
 * Simple Question class which asks player a question and calculates answer.
 *
 * @author Heena Heena
 *
 */
public class Question {

    private int value1;
    private int value2;
    private String operator;
    private int answer;

    /**
     * This method shows the question on console
     */
    public void showQuestion() {
        System.out.printf("What is %2d %s %2d? ", value1, operator, value2);
    }

    /**
     * Parameterized constructor to initialize Question object with two values and
     * an operator.
     *
     * @param v1 First operand value
     * @param v2 Second operand value
     * @param op An arithmetic operator
     */
    public Question(int v1, int v2, String op) {
        value1 = v1;
        value2 = v2;
        operator = op;

        /*
         * if (value1 != 0 && op.equals("/")) { value1 = value1 * value2; }
         */
    }

    /**
     * Parameterized constructor to initialize Question object with random values.
     *
     * @param rand Random object
     */
    public Question(Random rand) {
        // generate random value from 0 to 12
        value1 = rand.nextInt(13);
        value2 = rand.nextInt(13);

        // generate random value from 0 to 3
        // 0 for addition, 1 for subtraction, 2 for multiplication and 3 for division
        int op = rand.nextInt(4);
        if (op == 0)
            operator = "+";
        else if (op == 1)
            operator = "-";
        else if (op == 2)
            operator = "*";
        else
            operator = "/";

        if (operator.equals("/")) {
            // To avoid divide by zero error, use first value for both operand
            if (value2 == 0) {
                value2 = value1;
            }

            // using product of both operands for first operand to avoid floating point
            // answer
            value1 = value1 * value2;
        }
    }

    /**
     * This method checks and returns true if given response is same as answer
     * otherwise false.
     *
     * @param response An input response from user
     * @return true if response is correct otherwise false
     */
    public boolean checkAnswer(int response) {
        if (operator.equals("+"))
            answer = value1 + value2;
        else if (operator.equals("-"))
            answer = value1 - value2;
        else if (operator.equals("*"))
            answer = value1 * value2;
        else if (operator.equals("/"))
            answer = value1 / value2;

        if (response == answer) {
            System.out.println("Congratulations! Correct answer.\n");
            return true;
        } else {
            System.out.println("Sorry! Incorrect answer. The correct answer was " + answer + ".\n");
            return false;
        }
    }
}