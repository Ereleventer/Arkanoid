
/**
 * @author 315009449.
 * @version 1.0
 * @since 2020-04-24
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Rectangle class is the class that defines the blocks and the paddle.
 */
public class Rectangle {
    private Point upperLeft;
    private double width, height;
    private Line left, up, down, right;

    /**
     * Create a new rectangle with location and width/height.
     *
     * @param upperLeft is the upper left point of the Rectangle,
     * @param width     is the paddle's width
     * @param height    is the paddle's height
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
        //define the limits of the rectangle.
        this.left = new Line(this.upperLeft, new Point(this.upperLeft.getX(), (this.upperLeft.getY() + this.height)));
        this.up = new Line(this.upperLeft, new Point((this.upperLeft.getX() + this.width), this.upperLeft.getY()));
        this.down = new Line(new Point(this.upperLeft.getX(), upperLeft.getY() + height),
                new Point((this.upperLeft.getX() + this.width), this.upperLeft.getY() + height));
        this.right = new Line(new Point((this.upperLeft.getX() + this.width), this.upperLeft.getY())
                , new Point(this.upperLeft.getX() + this.width, this.upperLeft.getY() + this.height));
    }

    /**
     * @return the bottom line of the line.
     */
    public Line getDown() {
        return this.down;
    }

    /**
     * @return the left line of the line.
     */
    public Line getLeft() {
        return this.left;
    }

    /**
     * @return the right line of the line.
     */
    public Line getRight() {
        return this.right;
    }

    /**
     * @return the top line of the line.
     */
    public Line getUp() {
        return this.up;
    }

    /**
     * @param upperLeftPoint is the new point to set
     */
    public void setUpperLeft(Point upperLeftPoint) {
        this.upperLeft = upperLeftPoint;
    }

    /**
     * @return Return a (possibly empty) List of intersection points
     * with the specified line.
     */
    private Line[] outlines() {
        Line[] walls = new Line[4];
        Point topRight = new Point(this.upperLeft.getX() + width, this.upperLeft.getY());
        Point bottomLeft = new Point(this.upperLeft.getX(), this.upperLeft.getY() + height);
        Point bottomRight = new Point(this.upperLeft.getX() + width, this.upperLeft.getY() + height);
        walls[0] = new Line(this.upperLeft, topRight);
        walls[1] = new Line(bottomLeft, bottomRight);
        walls[2] = new Line(this.upperLeft, bottomLeft);
        walls[3] = new Line(topRight, bottomRight);
        return walls;
    }

    /**
     * @param line is the line to check the intersection Points of,
     * @return list of all the interaction Points.
     */
    public java.util.List<Point> intersectionPoints(Line line) {
        Line[] walls = outlines();
        List<Point> intersectionPoints = new ArrayList<>();
        for (Line outline : walls) {
            if (line.isIntersecting(outline)) {
                Point intersectionPoint = outline.intersectionWith(line);
                if (intersectionPoint != null) {
                    intersectionPoints.add(intersectionPoint);
                }

            }
        }
        return intersectionPoints;
    }


    /**
     * @return the width of the rectangle
     */
    public double getWidth() {
        return this.width;
    }

    /**
     * @return the height of the rectangle
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * @return the upper-left point of the rectangle.
     */
    public Point getUpperLeft() {
        return this.upperLeft;
    }


}