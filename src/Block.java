/**
 * @author 315009449.
 * @version 1.0
 * @since 2020-04-24
 */

import biuoop.DrawSurface;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * Block class is the blocks in the game, that doesn't move
 * and the ball should hit them.
 */
public class Block implements Collidable, Sprite, HitNotifier {
    private Rectangle rectangle;
    private List<HitListener> hitListeners;
    private Color color;
    public static final Color BACKGROUND = new Color(224, 254, 254);

    /**
     * @param rectangle is the block rectangle.
     */
    public Block(Rectangle rectangle) {
        this.rectangle = rectangle;
        color = BACKGROUND;
        this.hitListeners = new ArrayList<HitListener>();
    }

    /**
     *
     * @param rectangle is the rectangle to define the blocks,
     * @param color is the rectangle color.
     */
    public Block(Rectangle rectangle, Color color) {
        this.rectangle = rectangle;
        this.color = color;
        this.hitListeners = new ArrayList<HitListener>();
    }

    /**
     * @return the block rectangle.
     */
    public Rectangle getCollisionRectangle() {
        return this.rectangle;
    }

    /**
     * @param c is Block color to set.
     */
    public void setColor(Color c) {
        color = c;
    }

    /**
     * @param hitter is the ball that hits the block.
     * @param collisionPoint  is the collision point the ball should hit,
     * @param currentVelocity is the current velocity of the ball
     * @return the new velocity - if the ball hits the right or left lines of the block,
     * the dx changes to -dx, and if the ball hits the top or left bottom of the block,
     * the dy changes to -dy.
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        Velocity v = new Velocity(currentVelocity.getDx(), currentVelocity.getDy());
        this.notifyHit(hitter);
        if ((this.rectangle.getRight().isLegalPointOnLine(collisionPoint))
                || (this.rectangle.getLeft().isLegalPointOnLine(collisionPoint))) {
            v.setDx(v.getDx() * (-1));
            return v;
        }
        if ((this.rectangle.getUp().isLegalPointOnLine(collisionPoint))
                || (this.rectangle.getDown().isLegalPointOnLine(collisionPoint))) {
            v.setDy(v.getDy() * (-1));
            return v;

        }
        return null;
    }


    /**
     * @param surface is the drawing surface,
     *                the function draw the block on the draw surface.
     */
    // draw the ball on the given DrawSurface
    public void drawOn(DrawSurface surface) {
        surface.setColor(color);
        Point topLeft = rectangle.getUpperLeft();
        int width = (int) rectangle.getWidth();
        int height = (int) rectangle.getHeight();
        int topLeftX = (int) topLeft.getX();
        int topLeftY = (int) topLeft.getY();

        surface.fillRectangle(topLeftX, topLeftY, width, height);
        surface.setColor(Color.black);
        surface.drawRectangle(topLeftX, topLeftY, width, height);

        if (rectangle.getUpperLeft().getX() == 0 || rectangle.getUpperLeft().getY() == 0) {
            surface.setColor(Color.black);
        }
    }

    /**
     * notify the sprite that time has passed.
     * the function is empty because the block is not moving,
     * so there is no meaning to the time passed.
     * we needed to implement this function because we needed the addToGame function.
     */
    public void timePassed() {

    }

    /**
     * @param g is the game to add the Sprites and the Collidables to.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }

    /**
     *
     * @param game is the game to remove the Sprites and the Collidables to.
     */
    public void removeFromGame(GameLevel game) {
        game.removeSprite(this);
        game.removeCollidable(this);
        this.hitListeners.removeAll(hitListeners);
    }

    @Override
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);
    }

    @Override
    public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);
    }

    /**
     * the function notifies the listeners that hit evert occurred.
     * @param hitter is the ball that hits the block
     */
    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }
}

