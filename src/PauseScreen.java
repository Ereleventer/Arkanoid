import biuoop.DrawSurface;
import java.awt.Color;

/**
 * @author 315009449.
 * @version 1.0
 * @since 2020-05-26
 */
public class PauseScreen implements Animation {

    /**
     * @param d is the drawsurface,
     *          the function do one frame of the animation.
     *          in this animation it draws the Pause screen.
     */
    public void doOneFrame(DrawSurface d) {
        d.setColor(Color.white);
        d.fillRectangle(0, 0, 800, 600);
        d.setColor(Color.blue);
        d.fillCircle(380, 150, 100);
        d.setColor(Color.white);
        d.fillCircle(380, 150, 80);
        d.setColor(Color.blue);
        d.fillRectangle(350, 110, 20, 80);
        d.fillRectangle(390, 110, 20, 80);
        d.setColor(Color.black);
        d.drawText(300, d.getHeight() / 2 + 40, "Paused", 52);
        d.drawText(200, d.getHeight() / 2 + 110, "Press space to continue", 32);

    }

    /**
     *
     * @return true because the Pause Screen always runs.
     */
    public boolean shouldStop() {
        return true;
    }
}