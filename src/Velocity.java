
/**
 * @author 315009449.
 * @version 1.0
 * @since 2020-04-24
 */

/**
 * Velocity specifies the change in position on the `x` and the `y` axes.
 */
public class Velocity {
    private double dx, dy;

    /**
     * constructor.
     *
     * @param dx is the x change of the ball.
     * @param dy is the y change of the ball.
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * @return the dx of the Velocity.
     */
    public double getDx() {
        return this.dx;
    }

    /**
     * @return the dy of the Velocity.
     */
    public double getDy() {
        return this.dy;
    }

    /**
     * the function sets new dx value.
     *
     * @param newDx is new dx to define.
     */
    public void setDx(double newDx) {
        this.dx = newDx;
    }

    /**
     * the function sets new dy value.
     *
     * @param newDy is the new dy to define.
     */
    public void setDy(double newDy) {
        this.dy = newDy;
    }

    /**
     * .
     * Take a point with position (x,y) and return a new point
     * with position (x+dx, y+dy)
     *
     * @param p is point we should add it's values to the new point
     * @return new point with x as the velocity dx+the point x,
     * the the y as the velocity dy+the point y,
     * in order to change the point to new location.
     */
    public Point applyToPoint(Point p) {
        Point x = new Point(this.getDx() + p.getX(), this.getDy() + p.getY());
        return x;
    }

    /**
     * @param angle is the angle we want to change the ball to
     * @param speed is the speed we want the ball to move
     * @return new defined velocity with the defined angle and speed.
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double dx = Math.cos(Math.toRadians(angle)) * speed;
        double dy = Math.sin(Math.toRadians(angle)) * speed;
        return new Velocity(dx, dy);
    }

    /**
     *
     * @param v is the velocity we want to calcuate the speed for,
     * @return the calcuated speed (pythagoras)
     */
    public double getSpeed(Velocity v) {
        return Math.sqrt(Math.pow(v.getDx(), 2) + Math.pow(v.getDy(), 2));
    }
}