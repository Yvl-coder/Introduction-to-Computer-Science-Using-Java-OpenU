/**
 * This class represents a sqaure of 3x3.
 *
 * @author Yuval Pinhas ID: 213598535
 * @version 26.11.2021
 */

public class Square3x3 {
    private int[][] _arr3x3 = new int[3][3];
    
    
    /**
     * Constructor for objects of class Square3X3. Constructs and initializes a 2-dimensional
     * array of the size 3X3, with the values of –1 in each cell.
     */
    public Square3x3() {
        for (int i=0; i<_arr3x3.length; i++)
            for (int j=0; j<_arr3x3[0].length; j++) 
                _arr3x3[i][j] = -1;
    }
    
    /**
     * Constructs a 2-dimensional array of the size 3X3, whose values are taken from the given
     * array. If the given array’s size is bigger than 3X3, only the first 3X3 cells are taken. If the
     * given array is smaller, the rest of the cells are initialized to –1. 
     * 
     * @param array The array that the values from it are taken to this.
     */
    public Square3x3(int[][] array) {
        for (int i=0; i<_arr3x3.length; i++) {
            if (i < array.length) {        
                if (array[i].length > 3) {
                    for (int j=0; j<_arr3x3[0].length; j++) {
                        _arr3x3[i][j] = array[i][j];
                    }
                } else {
                    for (int j=0; j<array[i].length; j++) {
                        _arr3x3[i][j] = array[i][j];
                    }
                    for (int k=_arr3x3[0].length-1; k>=array[i].length; k--) {
                        _arr3x3[i][k] = -1;
                    }
                }
            } else {
                for (int l=0; l<_arr3x3[0].length; l++) {
                    _arr3x3[i][l] = -1;
                }
            }
        }
    }
    
    /**
     * Copy constructor. Constructs a 2-dimensional array of the size 3X3, whose values are
     * taken from the array of the given Square3x3 object. 
     * 
     * @param other The object that the values are taken from it.
     */
    public Square3x3(Square3x3 other) {
        this(other._arr3x3);
    }
    
    
    /**
     * Auxiliary method, that checks if the row and col value are valid. Legal values for row/col are 0,1,2.
     * 
     * @param row The row value
     * @param col The column value
     * @return if the col and the row are valid - true, false - otherwise.
     */
    private boolean isValid(int row, int col) {
        return  (0 <= row && row <= 2) && (0 <= col && col <= 2);
    }
    
    /**
     * Returns the value in the (row, col) cell. If the row and/or col are out of the
     * array bounds, returns –1. 
     * 
     * @param row The row value
     * @param col The column value
     * @return The value in the (row, col) cell, if the row/col are illegal - returns -1.
     */
    public int getCell(int row, int col) {
        if (isValid(row, col))
            return _arr3x3[row][col];
        return -1;
    }
    
    /**
     * Sets the cell (row, col) in the array to the given value. If the row and/or col
     * are out of the array bounds – does nothing. Legal values for row/col are 0,1,2.
     * 
     * @param row The row value
     * @param col The column value
     * @param value The value that the cell (row, col) will get iff row and col are valid. 
     */
    public void setXY(int row, int col, int value) {
       if (isValid(row, col))
           _arr3x3[row][col] = value;
    }
    
    /**
     * Returns a String representation of the array.
     * 
     * @return a String representation of the array.
     */
    public String toString() {
       String result = "";
       
       for (int i=0; i<_arr3x3.length; i++) {
           for (int j=0; j<_arr3x3[0].length-1; j++) {
               result += _arr3x3[i][j]+"\t"; 
           }
           result += _arr3x3[i][_arr3x3[0].length-1]+"\n";
       }
       
       return result;
    }
    
    /**
     * This method checks if all the numbers between 1-9 are in _arr3x3.
     * 
     * @return if all the numbers between 1-9 are in _arr3x3 - true, false - otherwise.
     */
    public boolean allThere() {        
        boolean[] allThere = new boolean[10];
        
        for (int i=0; i<_arr3x3.length; i++) {
            for (int j=0; j<_arr3x3[0].length; j++) {
                if (1 > _arr3x3[i][j] || 9 < _arr3x3[i][j])
                    return false;
                allThere[_arr3x3[i][j]] = true;
            }
        }
        
        for (int k=1; k<allThere.length; k++) {
            if (!allThere[k])
                return false;
        }
        
        return true;        
    }
    
    /**
     * This method updates 'values' parameter by the cells value in the 'row' parameter.
     * for example: if the value in cell in 'row' parameter is 4, so 'values' in index 4 will get true.
     * 
     * @param row The row that the values of the cells are taken.
     * @param values An array with length of 10.
     */
    public void whosThereRow(int row, boolean[] values) {
        if (0 <= row && row <= 2) { 
            for (int i=0; i<_arr3x3[0].length; i++) {
                if (_arr3x3[row][i] >= 1 && _arr3x3[row][i] <= 9) {
                    values[_arr3x3[row][i]] = true;                    
                }
            }
        }
    }
    
    /**
     * This method updates 'values' parameter by the cells value in the 'col' parameter.
     * for example: if the value in cell in 'col' parameter is 4, so 'values' in index 4 will get true.
     * 
     * @param col The col that the values of the cells are taken.
     * @param values An array with length of 10.
     */
    public void whosThereCol(int col, boolean[] values) {
        if (0 <= col && col <=2) {
            for (int i=0; i<_arr3x3.length; i++) {
                if (_arr3x3[i][col] >= 1 && _arr3x3[i][col] <= 9) {
                    values[_arr3x3[i][col]] = true;
                }
            }
        }
    }    
}