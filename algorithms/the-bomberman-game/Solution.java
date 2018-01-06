//https://www.hackerrank.com/challenges/bomber-man/problem

import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {
    //the grid goes throught the following states
    //t=0 the initial state
    //t=1 still initial state
    //t=2 full bombs
    //t=3 the initial explosion from the t=0 bombs
    //after that point, the grid will loop through full (0 % 4), explode (1 % 4), full (2 % 4), explode (3 % 4) in this order every 4 seconds
    //t=3 (3 % 4) depends on the t=0 layout, and t=5 (1 % 4) depends on t=3. it alternates between these two states after that.
    //we find the modulo 4 equivalent of n and print the corresponding grid state
    
    //O(r*c) time complexity
    
    static String[] gridTransform(int r, int c, String[] grid){
        String[] answer = new String[r];
        char[] post_explosion = new char[r*c];
        Arrays.fill(post_explosion, 'O');
        for(int row = 0; row < r; row++){
            for(int col = 0; col < c; col++){
                if(grid[row].charAt(col) == 'O'){
                    post_explosion[row *c + col] = '.';
                    if(row > 0)
                        post_explosion[(row -1)*c + col] = '.';
                    if(row < r-1)
                        post_explosion[(row +1)*c + col] = '.';
                    if(col > 0)
                        post_explosion[row*c + col -1] = '.';
                    if(col < c-1)
                        post_explosion[row*c + col +1] = '.';
                }
            }
        }
        for(int i = 0; i < r; i++){
            String new_row = new String(post_explosion,i*c,c);
            answer[i] = new_row;
        }
        return answer;
    }

    static String[] bomberMan(int n, int r, int c, String[] grid) {
        if(n == 1)//if nothing has happened yet, return the initial grid
            return grid;
        int state = n % 4;
        String[] answer = new String[r];
        if(state == 0 || state == 2){//grid is full of bombs
            char[] bombs = new char[c];
            Arrays.fill(bombs, 'O');
            String row = new String(bombs);
            for(int i = 0; i < r; i++)
                answer[i] = row;
        }else if (state == 1 || state == 3){//construct t=3 (3 modulo 4) grid from the initial grid
            answer = gridTransform(r, c, grid);
            if(state == 1)//construct t=5 (1 modulo 4) grid from the t=3 grid
                answer = gridTransform(r, c, answer); 
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int r = in.nextInt();
        int c = in.nextInt();
        int n = in.nextInt();
        String[] grid = new String[r];
        for(int grid_i = 0; grid_i < r; grid_i++){
            grid[grid_i] = in.next();
        }
        String[] result = bomberMan(n, r, c, grid);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
        }
        System.out.println("");


        in.close();
    }
}
