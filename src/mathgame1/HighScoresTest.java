package mathgame1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.jupiter.api.Test;

/**
 * This class tests Highscores with various game scores.
 *
 * @author Heena Heena
 *
 */
public class HighScoresTest {

    @Test
    public void testShowQuestion() {
        HighScores highScores = new HighScores();
        highScores.checkNewHighScore(1);

        assertNotEquals(highScores.getHighScore(), 0);
        assertEquals(highScores.getHighScore(), 1);

        highScores.checkNewHighScore(5);
        assertNotEquals(highScores.getHighScore(), 1);
        assertEquals(highScores.getHighScore(), 5);

        highScores.checkNewHighScore(3);
        assertNotEquals(highScores.getHighScore(), 3);
        assertEquals(highScores.getHighScore(), 5);

        highScores.checkNewHighScore(8);
        assertNotEquals(highScores.getHighScore(), 5);
        assertEquals(highScores.getHighScore(), 8);

        highScores.checkNewHighScore(10);
        assertNotEquals(highScores.getHighScore(), 8);
        assertEquals(highScores.getHighScore(), 10);

        highScores.checkNewHighScore(7);
        assertNotEquals(highScores.getHighScore(), 7);
        assertEquals(highScores.getHighScore(), 10);
    }
}

