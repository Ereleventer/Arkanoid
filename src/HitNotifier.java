/**
 * The HitNotifier interface indicate that objects that implement it send notifications when they are being hit.
 *
 * @author 315009449.
 * @version 1.0
 * @since 2020-05-26
 */
public interface HitNotifier {

    /**
     * Add hl as a listener to hit events.
     *
     * @param hl i the listener to add.
     */
    void addHitListener(HitListener hl);

    /**
     * emove hl from the list of listeners to hit events.
     *
     * @param hl the listener to remove.
     */
    void removeHitListener(HitListener hl);
}