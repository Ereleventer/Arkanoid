/**
 * @author 315009449.
 * @version 1.0
 * @since 2020-04-24
 */

import biuoop.DrawSurface;

/**
 * Sprite is a game object that can be drawn to the screen (and which is not just a background image).
 * Sprites can be drawn on the screen, and can be notified that time has passed
 * (so that they know to change their position / shape / appearance / etc).
 * In our design,
 * all of the game objects (Ball, Block, Paddle, ...) are Sprites -- they will implement the Sprite interface:
 */
public interface Sprite {

    /**
     * draw the sprite to the screen.
     *
     * @param d is the drawSurface to draw on.
     */
    void drawOn(DrawSurface d);

    /**
     * notify the sprite that time has passed.
     */
    void timePassed();
}