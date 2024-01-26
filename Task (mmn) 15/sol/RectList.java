/**
 * This class represents a list of rectangles.
 *
 * @author Yuval Pinhas - ID: 213598535
 * @version 12.01.2022
 */

public class RectList {
    private RectNode _head;
    
    
    /**
     * Empty Constructor. Creates empty list.
     * time complexity: O(1) - there are constant amount of commands.
     * space complexity: O(1) - there are constant amount of vars, and they are not dependant.                      
     */
    public RectList() {
        _head = null;
    }
    
    
    /**
     * add a rectangle to the end of the list. if it exist before, its not added.
     * time complexity: O(n) - this method go all over the list.
     * space complexity: O(1) - there are constant amount of vars, and they are not dependant.
     * 
     * @param other the rectangle that added to the end of the list, 
     *              if it exist before, its not added.
     */
    public void addRect(RectangleA other) {
        if (_head != null) {
            RectNode node = _head;
            
            //go all over the list while: you didnt reach the end and the node is not 'other'
            while (node.getNext() != null && !(node.getRect().equals(other))) {
                node = node.getNext(); //go to the next node
            }
            
            //when you exit the while, if you reach the end, add 'other, if not - do nothing
            if (!(node.getRect().equals(other)))
                node.setNext(new RectNode(other));
        } else {
            //if the _head is null - so head will point 'other'
            _head = new RectNode(other);
        }
    }
    
    /**
     * Returns how many rectangles have equal SW point to given point.
     * time complexity: O(n) - this method go all over the list.
     * space complexity: O(1) - there are constant amount of vars, and they are not dependant.
     *                          
     * @param p the given point.
     * @return how many rectangles have equal SW point to given point.
     */
    public int howManyWithPoint(Point p) {
        RectNode node = _head;
        int c = 0; //represents how many rectangles have equal SW point to given point ('p').
        
        //while the list didnt end
        while (node != null) {
            //if rectangle - in node - have equal SW point to given point ('p') - increase c by 1
            if (node.getRect().getPointSW().equals(p))
                c++;
            node = node.getNext(); //go to the next node
        }
        
        return c;
    }
    
    /**
     * Returns the longest diagonal from all the rectangles from the list.
     * time complexity: O(n) - this method go all over the list.
     * space complexity: O(1) - there are constant amount of vars, and they are not dependant.
     * 
     * @return the longest diagonal from all the rectangles from the list.
     */
    public double longestDiagonal() {
        RectNode node = _head;
        double maxDiagonal = 0; // represents the max diagonal
        
        while (node != null) {
            //if you found a node with bigger diagonal - change maxDiagonal to it
            if (node.getRect().getDiagonalLength() > maxDiagonal)
                maxDiagonal = node.getRect().getDiagonalLength();
            node = node.getNext();
        }
        
        return maxDiagonal;
    }
    
    /**
     * Returns the most left rectangle from all the list.
     * time complexity: O(n) - this method go all over the list.
     * space complexity: O(1) - there are constant amount of vars, and they are not dependant.
     * 
     * @return the most left rectangle from all the list.
     */
    public Point mostLeftRect() {
        if (_head == null)
            return null;
        
        RectNode node = _head;
        int minXLocation = node.getRect().getPointSW().getX(); //represents the min rectangle x value from all the list
        
        while (node != null) {
            //if you found smaller rectangle x value - change minXLocation to it.
            if (minXLocation > node.getRect().getPointSW().getX())
               minXLocation = node.getRect().getPointSW().getX();
            node = node.getNext();
        }
        
        node = _head; //return to the start of the list
        //found again the node that had the min x value (the first)
        while (minXLocation != node.getRect().getPointSW().getX()) {
            node = node.getNext();
        }
        
        //return the SW point of the node you found in the last while
        return new Point(node.getRect().getPointSW());
    }
    
    /**
     * Returns the highest rectangle from all the list.
     * time complexity: O(n) - this method go all over the list.
     * space complexity: O(1) - there are constant amount of vars, and they are not dependant.
     * 
     * @return the highest rectangle from all the list.
     */
    public Point highestRect() {
        if (_head == null)
            return null;
        
        RectNode node = _head;
        int maxYLocation = node.getRect().getPointNE().getY(); //represents the max rectangle y value from all the list
        
        while (node != null) {
            //if you found bigger rectangle y value - change maxYLocation to it.
            if (maxYLocation < node.getRect().getPointNE().getY())
                maxYLocation = node.getRect().getPointNE().getY();
            node = node.getNext();
        }
        
        node = _head;//return to the start of the list
        //found again the node that had the max y value (the first)
        while (maxYLocation != node.getRect().getPointNE().getY()) {
            node = node.getNext();
        }
        
        //return the NE point of the node you found in the last while
        return new Point(node.getRect().getPointNE());
    }
    
    /**
     * Returns the most right rectangle from all the list.
     * time complexity: O(n) - this method go all over the list.
     * space complexity: O(1) - there are constant amount of vars, and they are not dependant.
     * 
     * @return the most right rectangle from all the list.
     */
    private Point mostRightRect() {
        if (_head == null)
            return null;
        
        RectNode node = _head;
        int maxXLocation = node.getRect().getPointNE().getX(); //represents the max rectangle x value from all the list
        
        while (node != null) {
            //if you found bigger rectangle x value - change maxXLocation to it.
            if (maxXLocation < node.getRect().getPointNE().getX())
                maxXLocation = node.getRect().getPointNE().getX();
            node = node.getNext();
        }
        
        node = _head; //return to the start of the list
        //found again the node that had the max x value (the first)
        while (maxXLocation != node.getRect().getPointNE().getX()) {
            node = node.getNext();
        }
        
        //return the NE point of the node you found in the last while
        return new Point(node.getRect().getPointNE());
    }
    
    /**
     * Returns the lowest rectangle from all the list.
     * time complexity: O(n) - this method go all over the list.
     * space complexity: O(1) - there are constant amount of vars, and they are not dependant.
     * 
     * @return the lowest rectangle from all the list.
     */
    private Point lowestRect() {
        if (_head == null)
            return null;
        
        RectNode node = _head;
        int minYLocation = node.getRect().getPointSW().getY(); //represents the min rectangle y value from all the list
        
        while (node != null) {
            //if you found smaller rectangle y value - change minYLocation to it.
            if (minYLocation > node.getRect().getPointSW().getY())
                minYLocation = node.getRect().getPointSW().getY();
            node = node.getNext();
        }
        
        node = _head; //return to the start of the list
        //found again the node that had the min y value (the first)
        while (minYLocation != node.getRect().getPointSW().getY()) {
            node = node.getNext();
        }
        
        //return the SW point of the node you found in the last while
        return new Point(node.getRect().getPointSW());
    }
    
    /**
     * Returns the minimal container that all the rectangles from the list include on it.
     * time complexity: O(n) - this method go all over the list (4 times).
     * space complexity: O(1) - there are constant amount of vars, and they are not dependant.
     * 
     * @return the lowest rectangle from all the list.
     */
    public RectangleA minimalContainer() {
        if (_head == null) 
            return null;
        
        //create the SW point of the minimalContainer by the min x value and min y value of all the rectangles from the list
        Point pointSW = new Point(this.mostLeftRect().getX(), this.lowestRect().getY());
        
        //create the NE point of the minimalContainer by the max x value and max y value of all the rectangles from the list
        Point pointNE = new Point(this.mostRightRect().getX(), this.highestRect().getY());
        
        //return the minimalContainer
        return new RectangleA(pointSW, pointNE);
    }
    
    /**
     * Returns a string representation of object from this class.
     * time complexity: O(n) - this method go all over the list.
     * space complexity: O(1) - there are constant amount of vars, and they are not dependant.
     *                                                 
     * @return a string representation of object from this class.
     */
    public String toString() {
        if (_head == null) 
            return "The list has 0 rectangles.\n";
        String result = "";
        RectNode node = _head;
        int len = 0;
        
        while (node != null) {
            len++;
            node = node.getNext();
        }
        
        result += "The list has " + len + " rectangles.\n";
        node = _head;
        for (int i = 1; i <= len; i++) {
            result += i + ". " + node.getRect() + "\n";
            node = node.getNext();
        }
        
        return result;
    }
}