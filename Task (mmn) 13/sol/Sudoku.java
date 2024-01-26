/**
 * This class represents a board of sudoku. 
 *
 * @author Yuval Pinhas ID: 213598535
 * @version 08.12.2021
 */

public class Sudoku {
    private Square3x3[][] _boardSudoku = new Square3x3[3][3];
    
    /**
     * Constructor for objects of class Sudoku. Constructs and initializes a 2-dimensional
     * array of the size 3X3, with Square3x3 objects with the values of –1 in each cell.
     */
    public Sudoku() {
        for (int i=0; i<_boardSudoku.length; i++)
            for(int j=0; j<_boardSudoku[0].length; j++)
                _boardSudoku[i][j] = new Square3x3();
    }
    
    /**
     * Copy constructor. Constructs a 2-dimensional array of the size 3X3, whose values are
     * taken from the array of the given Sudoku object. 
     * 
     * @param square3x3Array The object that the values are taken from it.
     */
    public Sudoku(Square3x3[][] square3x3Array) {
        for (int i=0; i<_boardSudoku.length; i++)
            for(int j=0; j<_boardSudoku[0].length; j++)
                _boardSudoku[i][j] = new Square3x3(square3x3Array[i][j]);
    }
    
    
    /**
     * This method checks if a board of sudoku is valid. Board is valid iff the rows, cols, squares of 3x3, have all the
     * numbers between 1-9 once.
     * 
     * @return true if the board is valid, false - otherwise.
     */
    public boolean isValid() {
        //check if all the numbers 1-9 are in the board's squares
        for (int i=0; i<_boardSudoku.length; i++)
            for(int j=0; j<_boardSudoku[0].length; j++)
                if (!_boardSudoku[i][j].allThere())
                    return false;
        
        //check if all the numbers 1-9 are in the board's rows
        boolean[] valuesRow;
        for (int wholeRow=0; wholeRow<3; wholeRow++) {
            for (int j=0; j<_boardSudoku.length; j++) {
                valuesRow = new boolean[10];
                for (int k=0; k<_boardSudoku[0].length; k++) {  
                    _boardSudoku[j][k].whosThereRow(wholeRow, valuesRow); 
                }
                if (!allTrue(valuesRow))
                    return false;
            }
        }
        
        //check if all the numbers 1-9 are in the board's cols
        boolean[] valuesCol;
        for (int wholeCol=0; wholeCol<3; wholeCol++) {
            for (int j=0; j<_boardSudoku.length; j++) {
                valuesCol = new boolean[10];
                for (int k=0; k<_boardSudoku[0].length; k++) {  
                    _boardSudoku[k][j].whosThereCol(wholeCol, valuesCol); 
                }
                if (!allTrue(valuesCol))
                    return false;
            }
        }
        
        return true;
    }
    
    /**
     * Auxiliary method, that checks if array of boolean values has in all of his cells true value.
     * 
     * @param arr The arr that checked if he has in all of his cells true value.
     * @return true - if the array has the value true in all of his cells, false - otherwise.
     */
    private boolean allTrue(boolean[] arr) {
        for (int i=1; i<arr.length; i++) 
            if (!arr[i])
                return false;
        return true;
    }
}