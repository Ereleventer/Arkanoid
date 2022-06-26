/**
 * ScoreTrackingListener is updating the counter when blocks are being hit and removed.
 *
 * @author 315009449.
 * @version 1.0
 * @since 2020-05-26
 */
public class ScoreTrackingListener implements HitListener {
    private Counter currentScore;

    /**
     * constructor.
     */
    public ScoreTrackingListener() {
        this.currentScore = new Counter();
    }

    /**
     * @return the current Score.
     */
    public Counter getCurrentScore() {
        return currentScore;
    }

    /**
     * the function in updating the score once the block is being hit-
     * increase the score in 5 points.
     *
     * @param beingHit is the block that is hitted,
     * @param hitter   is the hitter ball.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        currentScore.increase(5);
    }
}