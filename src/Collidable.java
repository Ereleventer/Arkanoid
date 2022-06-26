/**
 * @author 315009449.
 * @version 1.0
 * @since 2020-04-24
 */

/**
 * The Collidable interface will be used by things that can be collided with.
 * In this assignment, this means the Blocks and the Paddle
 */
interface Collidable {
    /**
     * @return the "collision shape" of the object.
     */
    Rectangle getCollisionRectangle();

    /**
     * Notify the object that we collided with it at collisionPoint with
     * a given velocity.
     * @param hitter is the hitter ball.
     * @param collisionPoint  is the current Collision Point to check if we need to change the velocity,
     * @param currentVelocity is the current Velocity of the object.
     * @return is the new velocity expected after the hit (based on
     * the force the object inflicted on us).
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}
