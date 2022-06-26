/**
 * @author 315009449.
 * @version 1.0
 * @since 2020-04-02
 */

/**
 * A point has an x and a y value, and can measure the distance to other points,
 * and if it is equal to another point.
 */
public class Point {
    //x location of the point.
    private double x;
    //y location of the point.
    private double y;


    /**
     * .
     * constructor
     *
     * @param y is the x location of the point.
     * @param x is the y location of the point.
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }


    /**
     * @param other is other point,
     * @return the distance of this point to the other point.
     */
    public double distance(Point other) {
        double sum = ((getX() - other.getX()) * (getX() - other.getX()))
                + ((getY() - other.getY()) * (getY() - other.getY()));
        double root = Math.sqrt(sum);
        return root;
    }


    /**
     * @param other is other point,
     * @return true is the points are equal, false otherwise.
     */
    public boolean equals(Point other) {
        if (this.getX() == other.getX() && this.getY() == other.getY()) {
            return true;
        }
        return false;
    }


    /**
     * @return the x value of this point.
     */
    public double getX() {
        return this.x;
    }

    /**
     * @return the y value of this point.
     */
    public double getY() {
        return this.y;
    }


}