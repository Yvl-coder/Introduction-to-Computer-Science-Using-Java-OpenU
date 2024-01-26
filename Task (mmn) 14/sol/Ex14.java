/**
 * This class contains exercises from Maman 14.
 *
 * @author Yuval Pinhas - ID: 213598535
 * @version 11.01.2022
 */

public class Ex14 {
    /**
     * This method returns the minimum index distance between x and y cells in the array. 
     * time complexity: O(n) - the method runs all over the array.
     * space complexity: O(1) - the amount of the vars is constant, and there is no arrays that not constant.
     * 
     * @param a the array that the distance is sought
     * @param x number that checked to the min diff
     * @param y number that checked to the min diff
     * @return the min distance. if x or y not in a so return Integer.MAX_VALUE
     */
    public static int findMinDiff(int[] a, int x, int y) {
        int xIndex = -1; // represents the index of x in the a array
        int yIndex = -1; // represents the index of y in the a array
        int minDistance = Integer.MAX_VALUE; // represents the min distance between x index and y index

        for (int i=0; i<a.length; i++) {
            if (a[i] == x) 
                xIndex = i;
            if (a[i] == y)
                yIndex = i;
            if (xIndex != -1 && yIndex != -1 && Math.abs(xIndex-yIndex) < minDistance) { //if there is smaller distance
                minDistance = Math.abs(xIndex-yIndex);
            }
        }
            
        return minDistance; // return the min distance
    }
    
    
    /**
     * This method search number in circular sorted mat.
     * time complexity: O(log n) - the method runs in each time 2 times smaller the mat length.
     * space complexity: O(1) - the amount of the vars is constant, and there is no arrays that not constant.
     * 
     * @param mat the circular sorted mat
     * @param num the number that checked if it in the mat
     * @return if the num is in the mat - true, false - otherwise
     */
    public static boolean search(int[][] mat, int num) {
        // very hard question! how can i do it in the exam? 
        // its hard without computer to check my solution.
        
        int len = mat.length;
        int lowRow = 0;
        int lowCol = 0;
        int highRow = mat.length - 1;
        int highCol = 0;
        
        //if the number is not in the mat
        if (!(mat[lowRow][lowCol] <= num && num <= mat[highRow][highCol])) {
            return false;
        }
        
        //in each if, in the while, the range of "looking" the array is changed according to which 
        //quadrant the number can be. 
        while (len > 1) {
            //if the number is can be in the top left quadrant
            if (mat[lowRow][lowCol] <= num && num <= mat[lowRow+(len/2-1)][lowCol]) {
                highRow = lowRow+(len/2-1);
                highCol = lowCol;
            }
            //if the number is can be in the top right quadrant
            else if (mat[lowRow][lowCol+(len/2)] <= num && num <= mat[lowRow+(len/2-1)][lowCol+(len/2)]) {
                lowCol = lowCol+(len/2);
                highRow = lowRow+(len/2-1);
                highCol = lowCol+(len/2);
            }
            //if the number is can be in the bottom right quadrant
            else if (mat[lowRow+(len/2)][lowCol+(len/2)] <= num && num <= mat[highRow][lowCol+(len/2)]) {
                lowRow = lowRow+(len/2);
                lowCol = lowCol+(len/2);                
                highCol = lowCol+(len/2);
            }
            //if the number is can be in the bottom left quadrant
            else {
                lowRow = lowRow+(len/2);
            }
            
            //if we know in each quadrant the number can be, we can divide the len by 2 
            len /= 2;
        }
        
        //in the last iteration, the lowRow and lowCol are point the location of the number
        //if the number is there - true, if not - false
        return mat[lowRow][lowCol] == num;
    }
    
    
    /**
     * This method checks if its possible to split given array to two different groups that the sum of them is equal, and the
     * size of each of them is half from the given array.
     * 
     * @param arr the array that checked if it can be splitted.
     * @return if its possible to split given array to two different groups that the sum of them is equal, and the
     * size of each of them is half from the given array.
     */
    public static boolean equalSplit(int[] arr) {
        if (arr.length % 2 == 0)
            return equalSplit(arr, 0, 0, 0, 0, 0);
        return false; //if the array length even, so it cant be spllited
    }
    
    private static boolean equalSplit(int[] arr, int i, int c1, int c2, int sum1, int sum2) {
        //if the program found 2 sums, in the same length of half of the arr.
        if (i != 0 && sum1 == sum2 && c1 == c2 && c1 == arr.length/2)
            return true;
        //if the i is too much big or c1 is too much big or c2 is too much big
        if (i > arr.length-1 || c1 > arr.length/2 || c2 > arr.length/2)
            return false;
        
        /* c1 - how many times sum1 added arr[i] 
         * c2 - how many times sum2 added arr[i]
         * change the sum1 or sum2 and c1 or c2 respectively */
        return equalSplit(arr, i+1, c1+1, c2, sum1+arr[i], sum2) || equalSplit(arr, i+1, c1, c2+1, sum1, sum2+arr[i]);
        
        /*
          if I wrote this solution in the exam, how much points I could get? (thats took time to me to found whats the problem, 
          in the exam I pretty sure I couldnt catch the problem...) 
          ------------------------------------------------------------------
            if (i > arr.length-1 || c1 > arr.length/2 || c2 > arr.length/2)
                return false;
            if (i != 0 && sum1 == sum2 && c1 == c2 && c1 == arr.length/2)
                return true;
            
            return equalSplit(arr, i+1, c1+1, c2, sum1+arr[i], sum2) || equalSplit(arr, i+1, c1, c2+1, sum1, sum2+arr[i]);
          ------------------------------------------------------------------
          in the start, I didnt thought to change the if's, the problem here is the check of the 'i' in the first if.
        */
    }
    
    
    /**
     * this method checks if number is special.
     * 
     * @param n the number that checked if it special
     * @return if number is special
     */
    public static boolean isSpecial(int n) {
        if (n > 0) 
            return isSpecial(n, 2);
        return false; //if the number is negetive, it is not special.
    }

    private static boolean isSpecial(int n, int del) {
        //if the number is divide with no remainder with the del loc - so its gonna to delete
        if (n % del == 0)
            return false;
        //if the number is smaller then the div, so its "safe" from deletion
        if (n < del)
            return true;
        
        //the next location of the number
        return isSpecial(n-(n/del), del+1);
    }
}