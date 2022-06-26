/**
 * @author 315009449.
 * @version 1.0
 * @since 2020-04-24
 */

import biuoop.DrawSurface;

import java.awt.Color;

/**
 * Ball (actually, a circle). Balls have size (radius), color, and location (a Point).
 * Balls also know how to draw themselves on a DrawSurface.
 */
public class Ball implements Sprite {
    private Point center;
    private int r;
    private java.awt.Color color;
    private Velocity velocity;
    private GameEnvironment gameEnvironment;
    public static final Color BALLCOLOR = new Color(158, 152, 211);

    /**
     * constructor.
     *
     * @param center is the center point
     * @param r      is the radios
     * @param color  is the ball color
     */
    public Ball(Point center, int r, java.awt.Color color) {
        this.center = center;
        this.r = r;
        this.color = color;
    }

    /**
     * @param x     is the x location of the center point
     * @param y     is the y location of the center point
     * @param r     is the radios of the ball
     * @param color is the ball color
     */
    public Ball(double x, double y, int r, java.awt.Color color) {
        this.center = new Point(x, y);
        this.r = r;
        this.color = color;
    }


    /**
     * accessors.
     *
     * @return the x point of the center of the ball.
     */
    public int getX() {
        return (int) this.center.getX();
    }

    /**
     * @return the y point of the center of the ball.
     */
    public int getY() {
        return (int) this.center.getY();
    }

    /**
     * @return the radios of the ball.
     */
    public int getSize() {
        return this.r;
    }

    /**
     * @return the color of the ball.
     */
    public java.awt.Color getColor() {
        return this.color;
    }


    /**
     * draw the ball on the given DrawSurface.
     *
     * @param surface is the given surface to draw the ball.
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(color);
        surface.fillCircle((int) this.center.getX(), (int) this.center.getY(), this.getSize());
        surface.setColor(Color.black);
        surface.drawCircle((int) this.center.getX(), (int) this.center.getY(), this.getSize());
    }

    /**
     * @param v is the given velocity to define
     */
    public void setVelocity(Velocity v) {
        this.velocity = v;
    }

    /**
     * @param dx is the velocity dx
     * @param dy is the velocity dy
     *           the function defines the new velocity according to the given dx&dy.
     */
    public void setVelocity(double dx, double dy) {
        this.velocity = new Velocity(dx, dy);
    }

    /**
     * @return the Velocity of the ball.
     */
    public Velocity getVelocity() {
        return this.velocity;
    }

    /**
     * the function is moving the ball one step forward by calcuating the new Velocity.
     */
    /**
     * the function is moving the ball one step forward by calcuating the new Velocity.
     */

    public void moveOneStep() {
        // Compute the ball.
        Line trajectory = new Line(center, velocity.applyToPoint(center));
        // Check if moving on this trajectory will hit anything.
        CollisionInfo collisionInfo = gameEnvironment.getClosestCollision(trajectory);
        Point collisionPoint = null;
        if (collisionInfo != null) {
            // Update the hit object that a collision occurred.
            collisionPoint = collisionInfo.collisionPoint();
            if (collisionPoint != null) {
                this.velocity = collisionInfo.collisionObject().hit(this, collisionInfo.collisionPoint(), velocity);
            }
        } else {
            this.center = velocity.applyToPoint(this.center);
        }

    }

    /**
     * @param left  is the left limit of the ball moving area
     * @param right is the right limit of the ball moving area
     * @param up    is the top limit of the ball moving area
     * @param down  is the bottom limit of the ball moving area
     *              the function set the limit of the ball moves-
     *              it prevents the ball to escape from the defined frame.
     *              we will check if the next move of the ball suppost to exceed the limits-
     *              and change the ball direction accordingly.
     */
    public void moveOneStep(int left, int right, int up, int down) {
        moveOneStep();
        //define the new velocity.
        double vx = this.velocity.getDx();
        double vy = this.velocity.getDy();
        if ((this.center.getX() + this.r) > right || (this.center.getX() - this.r) < left) {
            vx = (-1) * vx;
        }
        if ((this.center.getY() + this.r) > down || (this.center.getY() - this.r) < up) {
            vy = (-1) * vy;
        }
        //set the new velocity.
        setVelocity(vx, vy);
    }

    /**
     * @param gameEnv is the game Environment to set,
     *                and the function sets new value to it.
     */
    public void setGameEnvironment(GameEnvironment gameEnv) {
        this.gameEnvironment = gameEnv;
    }

    /**
     * .
     * notify the sprite that time has passed,
     * in this case- perform the moveOneStep function to move the ball to the next position.
     */
    public void timePassed() {
        moveOneStep();
    }

    /**
     * @param g is the Game and the function adds Sprites to the game.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }

    /**
     * @param g is the Game and the function remove Sprites from the game.
     */
    public void removeFromGame(GameLevel g) {
        g.removeSprite(this);
    }
}