/**
 * The RectangleA class represents a 2D axis aligned integral rectangles.
 *
 * @author Yuval Pinhas, ID: 213598535
 * @version 19.11.2021
 */

public class RectangleA {
    private int _width;
    private int _height;
    private Point _pointSW;
    
    
    /**
     * First constructor for objects of class RectangleA Constructs a new rectangle with the specified width, height and it's south west corner is (0,0)
     * 
     * @param w The rectangle width.
     * @param h The rectangle height.
     */
    public RectangleA(int w, int h) {
        _pointSW = new Point(0,0);

        if (w > 0) {
            _width = w;
        } else {
            _width = 1;
        }

        if (h > 0) {
            _height = h;
        } else {
            _height = 1;
        }
    }

    /**
     * Second constructor for objects of class RectangleA Construct a new rectangle with the specified width, height and south west vertex point.
     * 
     * @param p The south western vertex.
     * @param w The rectangle width.
     * @param h The rectangle width.
     */
    public RectangleA(Point p, int w, int h) {
        _pointSW = new Point(p);

        if (w > 0) {
            _width = w;
        } else {
            _width = 1;
        }

        if (h > 0) {
            _height = h;
        } else {
            _height = 1;
        }        
    }

    /**
     * Third constructor for objects of class RectangleA Construct a new rectangle with the specified south west vertex and north east vertex.
     * 
     * @param sw The south western vertex.
     * @param ne The north eastern vertex.
     */
    public RectangleA(Point sw, Point ne) {
        _pointSW = new Point(sw);
        _width = ne.getX() - sw.getX();
        _height = ne.getY() - sw.getY();
    }

    /**
     * Copy constructor for objects of class RectangleA Constructs a rectangle using another rectangle.
     * 
     * @param r The rectangle from which to construct the new object
     */
    public RectangleA(RectangleA r) {
        _pointSW = new Point(r._pointSW);
        _width = r._width;
        _height = r._height;
    }
    
    
    /**
     * Returns the width of the rectangle.
     * 
     * @return The width of the rectangle.
     */
    public int getWidth() {
        return _width;
    }

    /**
     * Returns the height of the rectangle.
     * 
     * @return The height of the rectangle.
     */
    public int getHeight() {
        return _height;
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
            _width = w;
        }
    }

    /**
     * Sets the height of the rectangle.
     * 
     * @param h The height of the rectangle to set to.
     */
    public void setHeight(int h) {
        if (h > 0) {
            _height = h;
        }
    }

    /**
     * Sets the South-West point of the rectangle.
     * 
     * @param p The S-W point of the rectangle to set to.
     */
    public void setPointSW(Point p) {
        _pointSW = new Point(p);
    }

    /**
     * Returns a string representation of the rectangle.
     * 
     * @return A string represent the rectangle For example: Width=4 Height=6 PointSW=(1,2).
     */
    public String toString() {
        return "Width="+_width+" Height="+_height+" PointSW="+_pointSW.toString();
    }

    /**
     * Calculates the perimeter of the rectangle.
     * 
     * @return The perimeter of the rectangle.
     */
    public int getPerimeter() {
        return (_width * 2) + (_height * 2);
    }

    /**
     * Calculates the area of the rectangle.
     * 
     * @return The area of the rectangle.
     */
    public int getArea() {
        return _width * _height;
    }

    /**
     * Move the rectangle by deltaX in x direction and deltaY in y direction.
     * 
     * @param deltaX translate the rectangle deltaX in the x direction.
     * @param deltaY translate the rectangle deltaY in the y direction.
     */
    public void move(int deltaX, int deltaY) {
        _pointSW.move(deltaX, deltaY);
    }

    /**
     * Returns true iff the given rectangle is equal to this rectangle.
     * 
     * @param other The rectangle to check equality with.
     * @return true iff other and this rectangle are equal
     */
    public boolean equals(RectangleA other) {
        return (_pointSW.equals(other._pointSW)) && (_width == other._width) && (_height == other._height);
    }

    /**
     * Returns the length of the rectangle diagonal.
     * 
     * @return The length of the diagonal of the Rectangle.
     */
    public double getDiagonalLength() {
        Point thispointNE = this.getPointNE();
        return _pointSW.distance(thispointNE);

        /* second way:
         * return Math.sqrt((_width * _width) + (_height * _height));
         * because I think that the question wants from us to use the class Point I did the first way 
         */
    }

    /**
     * Returns true if the current rectangle is larger than the parameter rectangle.
     * 
     * @param other Another Rectangle to compare with 
     * @return true - if the current Rectangle's area is larger than the other Rectangle which recieved as parameter, false - otherwise
     */
    public boolean isLarger(RectangleA other) {
        return this.getArea() > other.getArea();
    }

    /**
     * Returns the North-East point of the rectangle.
     * 
     * @return A copy of the North-East point of the Rectangle.
     */
    public Point getPointNE() {
        Point pointNE = new Point((_pointSW.getX() + _width), (_pointSW.getY() + _height));
        return new Point(pointNE);
    }

    /**
     * Changes the width to height and vice versa.
     */
    public void changeSides() {
        int temp = _width;
        _width = _height;
        _height = temp;

        /* tricky way:
         * _width += _height;
         * _height = _width - _height;
         * _width -= _height
         */
    }

    /**
     * Returns true if the current rectangle is in the parameter rectangle.
     * 
     * @param r Another Rectangle to check with.
     * @return true - if the current Rectangle's completly in the other Rectangle which recieved as parameter, false - otherwise.
     */
    public boolean isIn(RectangleA r) {
        Point thisPointNE = this.getPointNE();
        Point rPointNE = r.getPointNE();

        // isPointSWIn -> is the SW point of the parameter (r) is in 'this' rectangle
        boolean isPointSWIn = ( r._pointSW.isLeft(_pointSW) || (r._pointSW.getX() == _pointSW.getX()) ) && 
                              ( r._pointSW.isUnder(_pointSW) || (r._pointSW.getY() == _pointSW.getY()) ) &&
                                rPointNE.isAbove(_pointSW) && 
                                rPointNE.isRight(_pointSW);   
        /* explain for 'isPointSWIn':
         * --------------------------
         * let: r._pointSW = (a,b)
         *      this._pointSW = (c,d) = _pointSW
         *      rPointNE = (e,f)
         * 
         * To check if 'this' rectangle is sub of rectangle 'r', 
         * one of the thing is that we need to check if this._pointSW is in 'r' rectangle by these rools:
         * I. ( r._pointSW.isLeft(_pointSW) || (r._pointSW.getX() == _pointSW.getX()) ) -> check if a <= c
         * II. ( r._pointSW.isUnder(_pointSW) || (r._pointSW.getY() == _pointSW.getY()) ) -> check if b <= d
         * III. rPointNE.isAbove(_pointSW) -> f > d (and f != d)
         * IV. rPointNE.isRight(_pointSW) -> e > c (and e != c)
         * 
         * if all the rules above exsit so this._pointSW is in 'r' rectangle.
         */

        // isPointNEIn -> is the NE point of the parameter (r) is in 'this' rectangle
        boolean isPointNEIn = ( rPointNE.isAbove(thisPointNE) || (rPointNE.getY() == thisPointNE.getY()) ) &&
                              ( rPointNE.isRight(thisPointNE) || (rPointNE.getX() == thisPointNE.getX()) );
        /* explain for 'isPointNEIn':
         * --------------------------
         * let: r._pointSW = (a,b)
         *      rPointNE = (c,d)
         *      thisPointNE = (e,f)
         * 
         * Because of the definition of the constructors of the class RectangleA there is no way that: 
         * (c <= a) || (d <= b)
         * 
         * That means that: c > a && d > b
         * and in the logical statment in 'isPointNEIn' we check if: a >= e, b >= f to say that thisPointWE is in the param 'r' rectangle
         * and there is no need to check if: c >= a && d >= b because it always true.
         */

        // if this._pointSW and thisPointNE is in 'r' rectangle so 'this' rectangle is sub of 'r' rectange
        return isPointSWIn && isPointNEIn; 
    }   
    
    /**
     * Returns true if the current rectangle overlaps with the parameter rectangle.
     * 
     * @param r another Rectangle to check with.
     * @return true - if the current Rectangle's overlaps with the other Rectangle which recieved as parameter even by a single point, false - otherwise.
     */
    public boolean overlap(RectangleA r) {
        Point rPointNE = r.getPointNE();
        Point thisPointNE = this.getPointNE();

        if ( r._pointSW.isRight(thisPointNE) || r._pointSW.isAbove(thisPointNE) ||
             rPointNE.isLeft(_pointSW) || rPointNE.isUnder(_pointSW) )
            return false;
        
        return true;
    }    
} // end of class RectangleA