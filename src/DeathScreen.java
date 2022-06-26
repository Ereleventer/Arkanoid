import biuoop.DrawSurface;
import java.awt.Color;

/**
 * @author 315009449.
 * @version 1.0
 * @since 2020-05-26
 */
public class DeathScreen implements Animation {
    private ScoreIndicator scoreView;

    /**
     * constructor.
     *
     * @param scoreView is the score to view of the game.
     */
    public DeathScreen(ScoreIndicator scoreView) {
        this.scoreView = scoreView;

    }

    /**
     * @param d is the drawsurface,
     *          the function do one frame of the animation -
     *          in this case draw the death screen.
     */
    public void doOneFrame(DrawSurface d) {
        d.setColor(Color.white);
        d.fillRectangle(0, 0, 800, 600);
        d.setColor(Color.red);
        d.drawText(300, d.getHeight() / 2, "YOU DIED", 52);
        d.drawText(300, d.getHeight() / 2 + 70, "your score is:" + scoreView.getScoreCounter().getValue(), 32);
    }

    /**
     * @return true because the DeathScreen always runs.
     */
    public boolean shouldStop() {
        return true;
    }
}