/**
 * The RectangleB class represents a 2D axis aligned integral rectangles.
 *
 * @author Yuval Pinhas, ID: 213598535
 * @version 19.11.2021
 */

public class RectangleB {
    private Point _pointSW;
    private Point _pointNE;

    /**
     * Auxiliary method that check the width/height and returns the fixed width/height according to the guidelines in maman 12.
     * 
     * @param x Represents the width/height.
     * @return The fixed width/height according to the guidelines in maman 12.
     */
    private int fixToPositive(int x) {
        if (x > 0) {
            return x;
        } else {
            return 1;
        }

    }
    
    /**
     * First constructor for objects of class RectangleB Constructs a new rectangle with the specified width, height and it's south west corner is (0,0)
     * 
     * @param w The rectangle width.
     * @param h The rectangle height.
     */
    public RectangleB(int w, int h) {
        _pointSW = new Point(0,0);
        _pointNE = new Point(fixToPositive(w), fixToPositive(h));
    }
    
    /**
     * Second constructor for objects of class RectangleB Construct a new rectangle with the specified width, height and south west vertex point.
     * 
     * @param p The south western vertex.
     * @param w The rectangle width.
     * @param h The rectangle width.
     */
    public RectangleB(Point p, int w, int h) {
        _pointSW = new Point(p);
        _pointNE = new Point(_pointSW.getX() + fixToPositive(w), _pointSW.getY() + fixToPositive(h));
    }
    
    /**
     * Third constructor for objects of class RectangleB Construct a new rectangle with the specified south west vertex and north east vertex.
     * 
     * @param sw The south western vertex.
     * @param ne The north eastern vertex.
     */
    public RectangleB(Point sw, Point ne) {
        _pointSW = new Point(sw);
        _pointNE = new Point(ne);
    }
    
    /**
     * Copy constructor for objects of class RectangleB Constructs a rectangle using another rectangle.
     * 
     * @param r The rectangle from which to construct the new object
     */
    public RectangleB(RectangleB r) {
        _pointSW = new Point(r._pointSW);
        _pointNE = new Point(r._pointNE);
    }
    
    
    /**
     * Returns the width of the rectangle.
     * 
     * @return The width of the rectangle.
     */
    public int getWidth() {
        return _pointNE.getX() - _pointSW.getX();
    }
    
    /**
     * Returns the height of the rectangle.
     * 
     * @return The height of the rectangle.
     */
    public int getHeight() {
        return _pointNE.getY() - _pointSW.getY();
    }
    
    /**
     * Returns the South-West point of the rectangle.
     * 
     * @return A copy of the s-w point of the rectangle.
     */
    public Point getPointSW() {
        return new Point(_pointSW);
    }
    
    /**
     * Sets the width of the rectangle.
     * 
     * @param w The width of the rectangle to set to.
     */
    public void setWidth(int w) {
        if (w > 0) {
            _pointNE = new Point(_pointSW.getX() + w, _pointNE.getY());
        }
    }
    
    /**
     * Sets the height of the rectangle.
     * 
     * @param h The height of the rectangle to set to.
     */
    public void setHeight(int h) {
        if (h > 0) {
            _pointNE = new Point(_pointNE.getX(), _pointSW.getY() + h);
        }
    }
    
    /**
     * Sets the South-West point of the rectangle.
     * 
     * @param p The S-W point of the rectangle to set to.
     */
    public void setPointSW(Point p) {
        int width = this.getWidth();
        int height = this.getHeight();
        _pointSW = new Point(p);
        _pointNE = new Point(_pointSW.getX() + width, _pointSW.getY() + height);
    }
    
    /**
     * Returns a string representation of the rectangle.
     * 
     * @return A string represent the rectangle For example: Width=4 Height=6 PointSW=(1,2).
     */
    public String toString() {
        return "Width="+this.getWidth()+" Height="+this.getHeight()+" PointSW="+_pointSW.toString();
    }
    
    /**
     * Calculates the perimeter of the rectangle.
     * 
     * @return The perimeter of the rectangle.
     */
    public int getPerimeter() {
        return (this.getWidth() * 2) + (this.getHeight() * 2);
    }
    
    /**
     * Calculates the area of the rectangle.
     * 
     * @return The area of the rectangle.
     */
    public int getArea() {
        return this.getWidth() * this.getHeight();
    }
    
    /**
     * Move the rectangle by deltaX in x direction and deltaY in y direction.
     * 
     * @param deltaX translate the rectangle deltaX in the x direction.
     * @param deltaY translate the rectangle deltaY in the y direction.
     */
    public void move(int deltaX, int deltaY) {
        _pointSW.move(deltaX, deltaY);
        _pointNE.move(deltaX, deltaY);
    }
    
    /**
     * Returns true iff the given rectangle is equal to this rectangle.
     * 
     * @param other The rectangle to check equality with.
     * @return true iff other and this rectangle are equal
     */
    public boolean equals(RectangleB other) {
        return (_pointSW.equals(other._pointSW)) && (_pointNE.equals(other._pointNE));
    }
    
    /**
     * Returns the length of the rectangle diagonal.
     * 
     * @return The length of the diagonal of the Rectangle.
     */
    public double getDiagonalLength() {
        return _pointSW.distance(_pointNE);
    }
    
    /**
     * Returns true if the current rectangle is larger than the parameter rectangle.
     * 
     * @param other Another Rectangle to compare with 
     * @return true - if the current Rectangle's area is larger than the other Rectangle which recieved as parameter, false - otherwise
     */
    public boolean isLarger(RectangleB other) {
        return this.getArea() > other.getArea();
    }
    
    /**
     * Returns the North-East point of the rectangle.
     * 
     * @return A copy of the North-East point of the Rectangle.
     */
    public Point getPointNE() {
        return new Point(_pointNE);
    }
    
    /**
     * Changes the width to height and vice versa.
     */
    public void changeSides() {
        _pointNE = new Point(_pointSW.getX() + this.getHeight(), _pointSW.getY() + this.getWidth());
    }
    
    /**
     * Returns true if the current rectangle is in the parameter rectangle.
     * 
     * @param r Another Rectangle to check with.
     * @return true - if the current Rectangle's completly in the other Rectangle which recieved as parameter, false - otherwise.
     */
    public boolean isIn(RectangleB r) {
        //the explains are similar to the explains in 'RectangleA'
        
        boolean isPointSWIn = ( r._pointSW.isLeft(_pointSW) || (r._pointSW.getX() == _pointSW.getX()) ) && 
                              ( r._pointSW.isUnder(_pointSW) || (r._pointSW.getY() == _pointSW.getY()) ) &&
                                r._pointNE.isAbove(_pointSW) && 
                                r._pointNE.isRight(_pointSW);

        boolean isPointNEIn = ( r._pointNE.isAbove(_pointNE) || (r._pointNE.getY() == _pointNE.getY()) ) &&
                              ( r._pointNE.isRight(_pointNE) || (r._pointNE.getX() == _pointNE.getX()) );

        return isPointSWIn && isPointNEIn;
    }
    
    /**
     * Returns true if the current rectangle overlaps with the parameter rectangle.
     * 
     * @param r another Rectangle to check with.
     * @return true - if the current Rectangle's overlaps with the other Rectangle which recieved as parameter even by a single point, false - otherwise.
     */
    public boolean overlap(RectangleB r) {
        if ( r._pointSW.isRight(_pointNE) || r._pointSW.isAbove(_pointNE) ||
             r._pointNE.isLeft(_pointSW) || r._pointNE.isUnder(_pointSW) )
            return false;
        
        return true;
        
        // another way:
        // return !( r._pointSW.isRight(_pointNE) || r._pointSW.isAbove(_pointNE) ||
        //           r._pointNE.isLeft(_pointSW) || r._pointNE.isUnder(_pointSW) )
    }
} // end of class RectangleB