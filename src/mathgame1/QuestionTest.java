package mathgame1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This class tests various arithmetic operations and custom output for question
 * on Question class.
 *
 * @author Prakash
 *
 */
public class QuestionTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    void testCreate() {
        Question q = new Question(3, 4, "+");
        assertFalse(q.checkAnswer(0));
        assertTrue(q.checkAnswer(7));

        q = new Question(12, 8, "-");
        assertFalse(q.checkAnswer(5));
        assertTrue(q.checkAnswer(4));

        q = new Question(6, 7, "*");
        assertFalse(q.checkAnswer(56));
        assertTrue(q.checkAnswer(42));

        q = new Question(15, 5, "/");
        assertFalse(q.checkAnswer(15));
        assertTrue(q.checkAnswer(3));
    }

    @Test
    public void testShowQuestion() {
        Question q = new Question(12, 8, "-");
        q.showQuestion();
        assertNotEquals("What is  12 - 8? ", outContent.toString());
        assertEquals("What is 12 -  8? ", outContent.toString());
    }
}
