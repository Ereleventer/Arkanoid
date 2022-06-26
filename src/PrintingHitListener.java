/**
 * @author 315009449.
 * @version 1.0
 * @since 2020-05-26
 */
public class PrintingHitListener implements HitListener {
    /**
     *
     * @param beingHit gg
     * @param hitter gg
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        System.out.println("A Block was hit.");
    }
}