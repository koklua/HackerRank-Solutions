//https://www.hackerrank.com/challenges/the-grid-search/problem

import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {
    
    //for current row in the first R-r rows:
    //for the current row's first C-c characters, compare character with the small grid's first character
    //if the characters match, do a regionMatch check on r rows
    //if all r rows match, return YES
    //brute force solution. better solution possible through string concatenation and regex (concatenate r rows and do a regex match)
    
    public static String gridSearch(String[] big, String[] small){
        int R = big.length;
        int C = big[0].length();
        int r = small.length;
        int c = small[0].length();
        boolean check = false;
        for(int current_row=0; current_row <= R-r; current_row++){
            for(int current_col = 0; current_col <= C-c; current_col++){
                if(big[current_row].charAt(current_col) == small[0].charAt(0)){
                    check = true;
                    for(int test_row = current_row; test_row < current_row + r; test_row++){
                        if(big[test_row].regionMatches(current_col, small[test_row - current_row], 0, c) == false){
                            check = false;
                            break;
                        }
                    }
                    if(check == true)
                        return "YES";
                }
            }
        }
        return "NO";
    }
    

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int test_case = 0; test_case < t; test_case++){
            int R = in.nextInt();
            int C = in.nextInt();
            String[] big_grid = new String[R];
            for(int b_row =0; b_row < R; b_row++){
                big_grid[b_row] = in.next();
            }
            int r = in.nextInt();
            int c = in.nextInt();
            String[] small_grid = new String[r];
            for(int s_row=0; s_row < r; s_row++){
                small_grid[s_row] = in.next();
            }
            System.out.println(gridSearch(big_grid, small_grid));
        }
    }
}
