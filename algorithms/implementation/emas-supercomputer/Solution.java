//https://www.hackerrank.com/challenges/two-pluses/problem

import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {
    //scan the entire grid for all plusses
    //check for the non-overlapping pair with the biggest product of areas
    
    static class Plus{
        //plus data structure to hold coordinates and length for overlap checks
        int row;
        int col;
        int len;
        int area;
        
        Plus(int r, int c, int length) {
            this.row = r;
            this.col = c;
            this.len = length;
            this.area = 1 + length*4 ;
        }
    }
    
    static boolean checkOverlap(Plus plus1, Plus plus2) {
        //based on the row and column values, two plusses can be in 8 different positional states
        //we use the lengths to check for overlaps based on these positions
        //constant time regardless of plus lengths but very bloated code; any way to check "cleaner"?
        boolean overlap = false;
        if(plus1.row == plus2.row && plus1.col == plus2.col){//same coordinates
            overlap = true;
        }else if(plus1.row == plus2.row){//they are on the same row
            if(plus1.col > plus2.col){//second plus on the left
                if(plus1.col - plus1.len <= plus2.col + plus2.len)
                    overlap = true;
            }else{//second plus on the right
                if(plus1.col + plus1.len >= plus2.col - plus2.len)
                    overlap = true;
            } 
        }else if(plus1.col == plus2.col){//they are on the same column
            if(plus1.row > plus2.row){//second plus above
                if(plus1.row - plus1.len <= plus2.row + plus2.len)
                    overlap = true;
            }else{//second plus below
                if(plus1.row + plus1.len >= plus2.row - plus2.len)
                    overlap = true;
            } 
        }else if(plus1.row > plus2.row){//the second plus is on one of the top quadrants
            if(plus1.col > plus2.col){//top left quadrant
                if((plus1.row - plus1.len <= plus2.row && plus2.col + plus2.len >= plus1.col) ||
                   (plus1.col - plus1.len <= plus2.col && plus2.row + plus2.len >= plus1.row))
                    overlap = true;
            }else{//top right quadrant
                if((plus1.row - plus1.len <= plus2.row && plus2.col - plus2.len <= plus1.col) ||
                   (plus1.col + plus1.len >= plus2.col && plus2.row + plus2.len >= plus1.row))
                    overlap = true;
            }
        }else{//the second plus is on one of the bottom quadrants
            if(plus1.col > plus2.col){//bottom left quadrant
                if((plus1.row + plus1.len >= plus2.row && plus2.col + plus2.len >= plus1.col) ||
                   (plus1.col - plus1.len <= plus2.col && plus2.row - plus2.len <= plus1.row))
                    overlap = true;
            }else{//bottom right quadrant
                if((plus1.row + plus1.len >= plus2.row && plus2.col - plus2.len <= plus1.col) ||
                   (plus1.col + plus1.len >= plus2.col && plus2.row - plus2.len <= plus1.row))
                    overlap = true;
            }
        }
        return overlap;
    }

    static int twoPluses(String[] grid, int n, int m) {
        ArrayList<Plus> plusses = new ArrayList<Plus>();
        //iterate over the grid and find all plusses
        for(int r = 0; r < n; r++) {
            for(int c = 0; c < m; c++) {
            	if(grid[r].charAt(c) == 'G'){
                    int len = 0;
                    plusses.add(new Plus(r, c, len));
                    len++;
                    while(r - len >= 0 && r + len < n && c - len >= 0 && c + len < m && 
                          grid[r - len].charAt(c) == 'G' && grid[r + len].charAt(c) == 'G' && 
                          grid[r].charAt(c - len) == 'G' && grid[r].charAt(c + len) == 'G'){
                        plusses.add(new Plus(r, c, len));
                        //System.out.println("Adding new plus with length " + len + " at coordinates: " + r + "," + c);
                        len++;
                    }
                }
            }
        }  
        
        //find the non-overlapping pair with the largest product, brute force check all combinations
        int max = 0;
        for(int first = 0; first < plusses.size()-1; first++) {
            Plus plus1 = plusses.get(first);
            for(int second = first+1; second < plusses.size(); second++) {
                Plus plus2 = plusses.get(second);
                if(checkOverlap(plus1,plus2) == false) {
                    int product = plus1.area * plus2.area;
                    if(max < product)
                        max = product;
                }  
            }
        }
        //possible to improve this section by sorting the plusses by length and starting the check in descending order:
        //for a > b > c > d it's always a*b > a*c > b*c, however it's possible for b*c > a*d
        //for such cases due to overlaps, we can check the middle section if it contains 2 or more elements
        //might implement this method later
        return max;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        String[] grid = new String[n];
        for(int grid_i = 0; grid_i < n; grid_i++){
            grid[grid_i] = in.next();
        }
        int result = twoPluses(grid,n,m);
        System.out.println(result);
        in.close();
    }
}
