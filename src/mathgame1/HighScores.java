package mathgame1;

/**
 * This class checks and stores the highest game score for player
 *
 * @author Heena Heena
 *
 */
public class HighScores {

    private int highScore;

    /**
     * This method checks and stores the highest game score so far.
     *
     * @param score Latest game score.
     * @return true if latest score was highest otherwise false
     */
    public boolean checkNewHighScore(int score) {
        if (score > highScore) {
            highScore = score;
            return true;
        }
        return false;
    }

    /**
     * @return the highest game score
     */
    public int getHighScore() {
        return highScore;
    }
}