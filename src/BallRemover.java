
/**
 * BallRemover  is in charge of removing balls, and updating an availabe-balls counter.
 *
 * @author 315009449.
 * @version 1.0
 * @since 2020-05-26
 */
public class BallRemover implements HitListener {
    private Counter ballCounter;
    private GameLevel game;

    /**
     * @param game        is the current game,
     * @param ballCounter is the number of balls right now in the game.
     */
    public BallRemover(GameLevel game, Counter ballCounter) {
        this.game = game;
        this.ballCounter = ballCounter;
    }

    /**
     * @return the ball counter.
     */
    public Counter getBallCounter() {
        return ballCounter;
    }

    /**
     * @param beingHit is the block that's being hit (the "death-region block in this case)
     * @param hitter   is the hitter ball.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        ballCounter.decrease(1);
        hitter.removeFromGame(game);
    }
}
