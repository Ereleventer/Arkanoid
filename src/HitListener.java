/**
 * @author 315009449.
 * @version 1.0
 * @since 2020-05-26
 */
public interface HitListener {

    /**
     * This method is called whenever the beingHit object is hit.
     * The hitter parameter is the Ball that's doing the hitting.
     *
     * @param beingHit is the block that is being hit,
     * @param hitter   is the hitter ball.
     */
    void hitEvent(Block beingHit, Ball hitter);
}