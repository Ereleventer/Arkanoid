/**
 * @author 315009449.
 * @version 1.0
 * @since 2020-04-24
 */

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.Color;

/**
 * paddle is the player of the game-
 * its a moving Rectangle.
 */
public class Paddle implements Sprite, Collidable {
    private biuoop.KeyboardSensor keyboard;
    private Rectangle paddle;
    public static final Color PADDLE_COLOR = new Color(247, 239, 205);

    /**
     * constructors.
     *
     * @param keyboard is the keyboard for the paddle,
     * @param paddle   is the paddle.
     */
    public Paddle(biuoop.KeyboardSensor keyboard, Rectangle paddle) {
        this.keyboard = keyboard;
        this.paddle = paddle;
    }

    /**
     * this function is moving the paddle to the left.
     */
    public void moveLeft() {
        //the condition is for avoiding the paddle to slip outside the frame.
        if (this.paddle.getUpperLeft().getX() > 0) {
            paddle.setUpperLeft(new Point(this.paddle.getUpperLeft().getX() - 5, this.paddle.getUpperLeft().getY()));
        }
    }

    /**
     * this function is moving the paddle to the right.
     */
    public void moveRight() {
        //the condition is for avoiding the paddle to slip outside the frame.
        if (this.paddle.getUpperLeft().getX() + this.paddle.getWidth() + 4 < Const.GUI_WIDTH) {
            paddle.setUpperLeft(new Point(this.paddle.getUpperLeft().getX() + 5, this.paddle.getUpperLeft().getY()));
        }
    }


    /**
     * Sprite update -
     * update the location of the paddle if the key is pressed.
     */
    public void timePassed() {
        if (keyboard.isPressed(KeyboardSensor.LEFT_KEY) || keyboard.isPressed("a")) {
            moveLeft();
        }
        if (keyboard.isPressed(KeyboardSensor.RIGHT_KEY) || keyboard.isPressed("d")) {
            moveRight();
        }
    }

    /**
     * draw the paddle to the screen.
     *
     * @param d is the drawSurface to draw on.
     */
    public void drawOn(DrawSurface d) {
        d.setColor(Color.BLACK);
        d.drawRectangle((int) paddle.getUpperLeft().getX() - 1, (int) paddle.getUpperLeft().getY() - 1
                , (int) paddle.getWidth() + 1, (int) paddle.getHeight() + 1);
        d.setColor(PADDLE_COLOR);
        d.fillRectangle((int) this.paddle.getUpperLeft().getX(), (int) this.paddle.getUpperLeft().getY()
                , (int) this.paddle.getWidth(), (int) this.paddle.getHeight());
    }

    /**
     * @return the paddle.
     */
    public Rectangle getCollisionRectangle() {
        return this.paddle;
    }

    /**
     * @param collisionPoint is the point the ballo should hit on the paddle,
     * @return the section that the ball should hit.
     * the paddle is divided to 5 sections.
     */
    public int paddleSection(Point collisionPoint) {
        double x = (this.paddle.getWidth() / 5);
        if (this.paddle.getUpperLeft().getX() <= collisionPoint.getX()
                && this.paddle.getUpperLeft().getX() + x > collisionPoint.getX()) {
            return 1;
        }
        if (this.paddle.getUpperLeft().getX() + x <= collisionPoint.getX()
                && this.paddle.getUpperLeft().getX() + (x * 2) > collisionPoint.getX()) {
            return 2;
        }
        if (this.paddle.getUpperLeft().getX() + (x * 2) <= collisionPoint.getX()
                && this.paddle.getUpperLeft().getX() + (x * 3) > collisionPoint.getX()) {
            return 3;
        }
        if (this.paddle.getUpperLeft().getX() + (x * 3) <= collisionPoint.getX()
                && this.paddle.getUpperLeft().getX() + (x * 4) > collisionPoint.getX()) {
            return 4;
        }
        if (this.paddle.getUpperLeft().getX() + (x * 4) <= collisionPoint.getX()
                && this.paddle.getUpperLeft().getX() + (x * 5) >= collisionPoint.getX()) {
            return 5;
        }
        return 0;
    }

    /**
     * @param hitter          is the hitter ball (not relevent for the paddle).
     * @param collisionPoint  is the current Collision Point to check if we need to change the velocity,
     * @param currentVelocity is the current Velocity of the object.
     * @return the new velocity after the hit.
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        //width is 60, dividing the paddle to 5.
        Velocity v = new Velocity(currentVelocity.getDx(), currentVelocity.getDy());
        //area 1
        if (paddleSection(collisionPoint) == 1) {
            return Velocity.fromAngleAndSpeed(210, currentVelocity.getSpeed(currentVelocity));
        }
        //area 2
        if (paddleSection(collisionPoint) == 2) {
            return Velocity.fromAngleAndSpeed(240, currentVelocity.getSpeed(currentVelocity));
        }
        //area 3
        if (paddleSection(collisionPoint) == 3) {
            v.setDy(v.getDy() * (-1));
            return v;
        }
        //area 4
        if (paddleSection(collisionPoint) == 4) {
            return Velocity.fromAngleAndSpeed(300, currentVelocity.getSpeed(currentVelocity));
        }
        //area 5
        if (paddleSection(collisionPoint) == 5) {
            return Velocity.fromAngleAndSpeed(330, currentVelocity.getSpeed(currentVelocity));
        }
        //if the paddle hit the corners - change the direction.
        if (this.paddle.getRight().isLegalPointOnLine(collisionPoint)
                || this.paddle.getLeft().isLegalPointOnLine(collisionPoint)) {
            v.setDx(v.getDx() * (-1));
            return v;
        }
        return v;
    }


    /**
     * Add this paddle to the game.
     *
     * @param g is the game we want to add to.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }
}