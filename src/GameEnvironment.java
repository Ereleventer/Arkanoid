/**
 * @author 315009449.
 * @version 1.0
 * @since 2020-04-24
 */

import java.util.ArrayList;
import java.util.List;

/**
 * The GameEnvironment class will be a collection of such things.
 * The ball will know the game environment, and will use it to check for collisions and direct its movement.
 */
public class GameEnvironment {
    private List<Collidable> collidables;

    /**
     * constructor.
     */
    public GameEnvironment() {
        collidables = new ArrayList<>();
    }

    /**
     * @param collidables is collidable list.
     */
    public GameEnvironment(List<Collidable> collidables) {
        this.collidables = collidables;
    }

    /**
     * add the given collidable to the environment.
     *
     * @param c is the collidable object to add.
     */
    public void addCollidable(Collidable c) {
        collidables.add(c);
    }

    /**
     * remove the given collidable to the environment.
     *
     * @param c is the collidable object to remove.
     */
    public void removeCollidable(Collidable c) {
        collidables.remove(c);
    }

    /**
     * Assume an object moving from line.start() to line.end().
     * If this object will not collide with any of the collidables
     * in this collection, return null. Else, return the information
     * about the closest collision that is going to occur.
     *
     * @param trajectory ..
     * @return ..
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        List<CollisionInfo> collidablesOnTrajectory = new ArrayList<>();
        List<Collidable> collidablesCopy = new ArrayList<Collidable>(this.collidables);
        for (Collidable collidable : collidablesCopy) {
            if (collidable.getCollisionRectangle().intersectionPoints(trajectory).size() != 0) {
                collidablesOnTrajectory.add(new CollisionInfo(trajectory.closestIntersectionToStartOfLine(
                        collidable.getCollisionRectangle()), collidable));
            }
        }
        CollisionInfo closestCollisionInfo = null;
        double minDistance = Double.MAX_VALUE;
        for (CollisionInfo collisionInfo : collidablesOnTrajectory) {
            double distance = collisionInfo.collisionPoint().distance(trajectory.start());
            if (minDistance > distance) {
                minDistance = distance;
                closestCollisionInfo = collisionInfo;
            }
        }
        return closestCollisionInfo;
    }
}