/**
 * @author 315009449.
 * @version 1.0
 * @since 2020-05-26
 */
// a BlockRemover is in charge of removing blocks from the game, as well as keeping count
// of the number of blocks that remain.
public class BlockRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBlocks;

    /**
     * constructor.
     *
     * @param game          is the game
     * @param removedBlocks is the counter of the remaining blocks.
     */
    public BlockRemover(GameLevel game, Counter removedBlocks) {
        this.game = game;
        this.remainingBlocks = removedBlocks;
    }

    /**
     * @return the remaining blocks counter.
     */
    public Counter getRemainingBlocks() {
        return remainingBlocks;
    }

    /**
     * Blocks that are hit should be removed
     * from the game. Remember to remove this listener from the block
     * that is being removed from the game.
     *
     * @param beingHit is the block that is being hit,
     * @param hitter   is the hitter ball.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        remainingBlocks.decrease(1);
        beingHit.removeFromGame(game);
    }
}