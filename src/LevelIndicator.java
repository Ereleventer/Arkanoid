import biuoop.DrawSurface;

import java.awt.Color;

/**
 * @author 315009449.
 * @version 1.0
 * @since 2020-05-26
 */
public class LevelIndicator implements Sprite {
    private String levelName;

    /**
     * constructor.
     *
     * @param levelName is the level name to define.
     */
    public LevelIndicator(String levelName) {
        this.levelName = levelName;
    }


    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.black);
        d.drawText(450, 14, "Level Name:" + levelName, 13);
    }

    /**
     * notify the sprite that time has passed.
     * the function is empty because the score is not moving,
     * so there is no meaning to the time passed.
     * we needed to implement this function because we needed the addToGame function.
     */
    public void timePassed() {

    }

    /**
     * @param g is the game to add the score to.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }
}
