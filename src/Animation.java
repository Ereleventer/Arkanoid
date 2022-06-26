import biuoop.DrawSurface;

/**
 * @author 315009449.
 * @version 1.0
 * @since 2020-04-24
 */
public interface Animation {
    /**
     * @param d is the drawsurface,
     *          the function do one frame of the animation -
     *          draw what needed in the specific animation.
     */
    void doOneFrame(DrawSurface d);

    /**
     * @return true if the animation should stop,
     * false if the animation should keep running.
     */
    boolean shouldStop();
}