/**
 * This class represents a node in rectangles list.
 *
 * @author Yuval Pinhas - ID: 213598535
 * @version 11.01.2022
 */

public class RectNode {
    private RectangleA _rect;
    private RectNode _next;
    
    
    /**
     * Constructor that get rectangle to _rect, and point to null in _next.
     * time complexity: O(1) - there are constant amount of commands.
     * space complexity: O(1) - there are constant amount of vars, and they are not dependant.
     * 
     * @param r the rectangle that copied to _rect.
     */
    public RectNode(RectangleA r) {
        _rect = new RectangleA(r);
        _next = null;
    }
    
    /**
     * Constructor that get rectangle to _rect and RectNode to point to (_next).
     * time complexity: O(1) - there are constant amount of commands.
     * space complexity: O(1) - there are constant amount of vars, and they are not dependant.
     * 
     * @param r the rectangle that copied to _rect.
     * @param n the RectNode that this is point.
     */
    public RectNode(RectangleA r, RectNode n) {
        _rect = new RectangleA(r);
        _next = n;
    }
    
    /**
     * Copy constructor, copy onther RectNode object to this.
     * time complexity: O(1) - there are constant amount of commands.
     * space complexity: O(1) - there are constant amount of vars, and they are not dependant.
     * 
     * @param r the object that is copied.
     */
    public RectNode(RectNode r) {
        this(r._rect, r._next);
    }
    
    
    /**
     * Returns the rectangle (_rect) attribute.
     * time complexity: O(1) - there are constant amount of commands.
     * space complexity: O(1) - there are constant amount of vars, and they are not dependant.
     *                       
     * @return the rectangle (_rect) attribute.
     */
    public RectangleA getRect() {
        return new RectangleA(_rect);
    }
    
    /**
     * Returns the object that this is point (_next) attribute.
     * time complexity: O(1) - there are constant amount of commands.
     * space complexity: O(1) - there are constant amount of vars, and they are not dependant.
     * 
     * @return the object that this is point (_next) attribute.
     */
    public RectNode getNext() {
        return _next;
    }
    
    /**
     * Changes the rectangle (_rect) attribute.
     * time complexity: O(1) - there are constant amount of commands.
     * space complexity: O(1) - there are constant amount of vars, and they are not dependant. 
     *
     * @param r the rectangle that copied to _rect.
     */
    public void setRect(RectangleA r) {
        _rect = new RectangleA(r);
    }
    
    /**
     * Changes the _next attribute.
     * time complexity: O(1) - there are constant amount of commands.
     * space complexity: O(1) - there are constant amount of vars, and they are not dependant.
     *                         
     * @param next the RectNode object that copied to _next.
     */
    public void setNext(RectNode next) {
        _next = next;
    }
}