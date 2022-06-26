import java.util.List;
/**
 * @author 315009449.
 * @version 1.0
 * @since 2020-04-24
 */

/**
 * A line (actually a line-segment) connects two points -- a start point and an end point.
 * Lines have lengths, and may intersect with other lines.
 * It can also tell if it is the same as another line segment.
 */
public class Line {
    //define start point of the line
    private Point start;
    //define end point of the line
    private Point end;


    /**
     * constructors.
     *
     * @param start is the start point of the line.
     * @param end   is the end point of the line.
     */
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    /**
     * define line between value points.
     *
     * @param x1 is the start point x value.
     * @param y1 is the start point y value.
     * @param x2 is the end point x value.
     * @param y2 is the end point y value.
     */
    public Line(double x1, double y1, double x2, double y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }

    /**
     * @return the length of the line using the Point distance function.
     */
    public double length() {
        return this.start.distance(this.end);
    }

    /**
     * @return the middle point of the line
     */
    public Point middle() {
        double x = ((this.start.getX() + this.end.getX()) / 2);
        double y = ((this.start.getY() + this.end.getY()) / 2);
        Point middle = new Point(x, y);
        return middle;
    }

    /**
     * @return the start point of the line
     */
    public Point start() {
        return this.start;
    }

    /**
     * @return the end point of the line
     */
    public Point end() {
        return this.end;
    }

    /**
     * check if one of the lines is Parallel to the Y axis.
     *
     * @param other is other line
     * @return the intersection point if legal,
     * if not legal- return null.
     */
    public Point isParallelY(Line other) {
        Point p;
        if (this.start.getY() == this.end.getY()) {
            if (other.start.getX() == other.end.getX()) {
                p = new Point(other.start.getX(), this.start.getY());
                if (isLegalPoint(p, other)) {
                    return p;
                }
            }
        }
        if (other.start.getY() == other.end.getY()) {
            if (this.start.getX() == this.end.getX()) {
                p = new Point(this.start.getX(), other.start.getY());
                if (isLegalPoint(p, other)) {
                    return p;
                }
            }
        }
        return null;
    }

    /**
     * check if one of the lines is Parallel to the X axis.
     *
     * @param other is other line
     * @return the intersection point if legal,
     * if not legal- return null.
     */
    public Point isParallelX(Line other) {
        Point p;
        if (this.start.getX() == this.end.getX()) {
            double m2 = (other.end.getY() - other.start.getY()) / (other.end.getX() - other.start.getX());
            double b2 = other.start.getY() - (m2 * other.start.getX());
            double y2 = m2 * this.start.getX() + b2;
            p = new Point(this.start.getX(), y2);
            if (isLegalPoint(p, other)) {
                return p;
            }
        }

        if (other.start.getX() == other.end.getX()) {
            double m1 = (this.end.getY() - this.start.getY()) / (this.end.getX() - this.start.getX());
            double b1 = this.start.getY() - (m1 * this.start.getX());
            double y1 = m1 * this.start.getX() + b1;
            p = new Point(other.start.getX(), y1);
            if (isLegalPoint(p, other)) {
                return p;
            }
        }
        return null;
    }

    /**
     * @param other is the other line
     * @return the point of the intersection
     */
    public Point findPoint(Line other) {
        double x, y;
        //define new point
        Point p;
        //check if one of the lines is Parallel to the Y axis.
        p = isParallelY(other);
        if (p != null) {
            return p;
        }

        // check if one of the lines is Parallel to the X axis.
        p = isParallelX(other);
        if (p != null) {
            return p;
        }
        //check if the start points are equal and if the end is legal,
        // if not legal - means it can be on both of the lines - returns null.
        if (start.equals(other.start)) {
            if (!end.equals(other.end)) {
                if (isLegalPoint(other.end, other)) {
                    return null;
                }
                if (isLegalPoint(this.end, other)) {
                    return null;
                }
                return start;
            }
        }
        //Inclines of both lines
        double m1 = (this.end.getY() - this.start.getY()) / (this.end.getX() - this.start.getX());
        double m2 = (other.end.getY() - other.start.getY()) / (other.end.getX() - other.start.getX());
        double b1 = this.start.getY() - (m1 * this.start.getX());
        double b2 = other.start.getY() - (m2 * other.start.getX());
        // if both Incline are equal
        if (m1 == m2) {
            if (this.start.equals(other.end)) {
                return this.start;
            }
            if (this.end.equals(other.start)) {
                return this.end;
            }
            if (this.start.getX() != other.start.getX()) {
                return null;
            }
            if (this.end.getX() != other.end.getX()) {
                return null;
            }
        }
        //calculate the intersection point.
        x = (b2 - b1) / (m1 - m2);
        y = m1 * x + b1;
        return new Point(x, y);
    }

    /**
     * @param other is the other line
     * @return if the point is legal or not - if the point fits both of the lines.
     */
    public boolean isLegal(Line other) {
        boolean thisLegal = false, otherLegal = false;
        Point p = new Point(0, 0);
        p = this.findPoint(other);
        // if the find point function returns null - it means there is no
        if (p == null) {
            return false;
        }
        //check if the point is legal at this Line.
        double maxX1 = Math.max(this.start.getX(), this.end.getX());
        double minX1 = Math.min(this.start.getX(), this.end.getX());
        double maxY1 = Math.max(this.start.getY(), this.end.getY());
        double minY1 = Math.min(this.start.getY(), this.end.getY());
        if (minX1 <= p.getX() && maxX1 >= p.getX() && minY1 <= p.getY() && maxY1 >= p.getY()) {
            thisLegal = true;
        }
        //check if the point is legal at other Line.
        double maxX2 = Math.max(other.start.getX(), other.end.getX());
        double minX2 = Math.min(other.start.getX(), other.end.getX());
        double maxY2 = Math.max(other.start.getY(), other.end.getY());
        double minY2 = Math.min(other.start.getY(), other.end.getY());
        if (minX2 <= p.getX() && maxX2 >= p.getX() && minY2 <= p.getY() && maxY2 >= p.getY()) {
            otherLegal = true;
        }
        //if the point is legal at both lines - return true.
        if (thisLegal && otherLegal) {
            return true;
        }
        return false;
    }

    /**
     * @param p     is point to check if legal or not.
     * @param other if other line
     * @return true if the point is legal, false if point if not legal.
     */
    public boolean isLegalPoint(Point p, Line other) {
        boolean thisLegal = false, otherLegal = false;
        double maxX1 = Math.max(this.start.getX(), this.end.getX());
        double minX1 = Math.min(this.start.getX(), this.end.getX());
        double maxY1 = Math.max(this.start.getY(), this.end.getY());
        double minY1 = Math.min(this.start.getY(), this.end.getY());
        if (minX1 - Const.EPSILON <= p.getX() && maxX1 + Const.EPSILON >= p.getX()
                && minY1 - Const.EPSILON <= p.getY() && maxY1 + Const.EPSILON >= p.getY()) {
            thisLegal = true;
        }
        double maxX2 = Math.max(other.start.getX(), other.end.getX());
        double minX2 = Math.min(other.start.getX(), other.end.getX());
        double maxY2 = Math.max(other.start.getY(), other.end.getY());
        double minY2 = Math.min(other.start.getY(), other.end.getY());
        if (minX2 - Const.EPSILON <= p.getX() && maxX2 + Const.EPSILON >= p.getX()
                && minY2 - Const.EPSILON <= p.getY() && maxY2 + Const.EPSILON >= p.getY()) {
            otherLegal = true;
        }
        if (thisLegal && otherLegal) {
            return true;
        }
        return false;
    }


    /**
     * @param p is the point we want to check if is on the line,
     * @return true if the point is on the line,
     * false if the point is not on the line.
     */
    public boolean isLegalPointOnLine(Point p) {
        double maxX1 = Math.max(this.start.getX(), this.end.getX());
        double minX1 = Math.min(this.start.getX(), this.end.getX());
        double maxY1 = Math.max(this.start.getY(), this.end.getY());
        double minY1 = Math.min(this.start.getY(), this.end.getY());
        if (minX1 - Const.EPSILON - 1 <= p.getX() && maxX1 + Const.EPSILON + 1 >= p.getX()
                && minY1 - Const.EPSILON - 1 <= p.getY() && maxY1 + Const.EPSILON + 1 >= p.getY()) {
            return true;
        }
        return false;
    }


    /**
     * @param p1 is point to check.
     * @param p2 is point to check
     * @param p3 to check
     * @return if the lines are intersecting or not.
     */
    public boolean helpForIntersection(Point p1, Point p2, Point p3) {
        return (p3.getY() - p1.getY()) * (p2.getX() - p1.getX()) > (p2.getY() - p1.getY()) * (p3.getX() - p1.getX());
    }


    /**
     * @param other is other line
     * @return true is the lines are equal, false otherwise.
     */
    public boolean equals(Line other) {
        return this.start.equals(other.start) && this.end.equals(other.end);
    }

    /**
     * If this line does not intersect with the rectangle, return null.
     *
     * @param rect is the rectangle to check,
     * @return the closest intersection point to the
     * // start of the line.
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        List<Point> list = rect.intersectionPoints(this);
        if (list == null || list.size() == 0) {
            return null;
        }
        Point[] arr = list.toArray(new Point[list.size()]);
        Point closest = arr[0];
        double minDistance = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i].distance(closest) < minDistance) {
                closest = arr[i];
                minDistance = arr[i].distance(closest);
            }
        }
        return closest;
    }


    /**
     * @param other is other line,
     * @return true if the lines intersect, false otherwise
     */
    public boolean isIntersecting(Line other) {
        Point inter = this.findPoint(other);
        Point p1 = this.start;
        Point p2 = this.end;
        Point p3 = other.start;
        Point p4 = other.end;
        Boolean result = helpForIntersection(p1, p3, p4) != helpForIntersection(p2, p3, p4)
                && helpForIntersection(p1, p2, p3) != helpForIntersection(p1, p2, p4);
        //added here if not result so return false.
        if (inter == null || this.equals(other) || !result) {
            return false;
        }
        if (this.isLegal(other)) {
            return true;
        }
        if (result) {
            return true;
        }
        return false;
    }



    /**
     * @param other is other line to check
     * @return the intersection point if the lines intersect,
     * and null otherwise.
     */

    public Point intersectionWith(Line other) {
        Point inter = this.findPoint(other);
        if (inter == null) {
            return null;
        }
        if (this.isLegal(other)) {
            return inter;
        }
        return null;
    }
}