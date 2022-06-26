/**
 * @author 315009449.
 * @version 1.0
 * @since 2020-04-24
 */

/**
 * the Class contains all the Collision Info needed-
 * the point and the Collidable object.
 */
public class CollisionInfo {
    private Point point;
    private Collidable collidable;


    /**
     * constructor.
     *
     * @param point      is the point of the Collision,
     * @param collidable is the collidable object.
     */
    public CollisionInfo(Point point, Collidable collidable) {
        this.point = point;
        this.collidable = collidable;
    }

    /**
     * @return the point at which the collision occurs
     */
    public Point collisionPoint() {
        return this.point;
    }

    /**
     * @return the collidable object involved in the collision.
     */
    public Collidable collisionObject() {
        return this.collidable;
    }
}