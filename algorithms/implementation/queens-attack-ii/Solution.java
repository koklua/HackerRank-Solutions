//https://www.hackerrank.com/challenges/queens-attack-2/problem

import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {
    
    //keep track of minimum distances for all 8 directions
    //compare the position of each obstacle with the queen during input
    //all the -1's to remove the queen's position from the difference
    //to check diagonals, abs(x1-x2) == abs(y1-y2)
    //O(k) complexity?

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int rowQueen = in.nextInt();
        int colQueen = in.nextInt();
        int[] direction = new int[8];
	//initialize distances to the ends of the board one by one (seems sloppy)
        direction[0] = rowQueen-1;
        direction[1] = Math.min(rowQueen-1,colQueen-1);
        direction[2] = colQueen-1;
        direction[3] = Math.min(n - rowQueen,colQueen-1);
        direction[4] = n - rowQueen;
        direction[5] = Math.min(n - rowQueen,n - colQueen);
        direction[6] = n - colQueen;
        direction[7] = Math.min(rowQueen-1,n - colQueen);
        int row_compare, col_compare;
        for(int i = 0; i < k; i++){
            int rowObstacle = in.nextInt();
            int colObstacle = in.nextInt();
            row_compare = rowQueen - rowObstacle;
            col_compare = colQueen - colObstacle;
            if(colObstacle == colQueen){ //obstacle is on the same column as the queen, check distance up/down
                if(row_compare > 0){
                    if(direction[0] > row_compare-1)
                        direction[0] = row_compare-1; //down
                }else{
                    if(direction[4] > Math.abs(row_compare)-1)
                        direction[4] = Math.abs(row_compare)-1; //up
                }
            }else if(rowObstacle == rowQueen){ //obstacle is on the same row as the queen, check distance left/right
                if(col_compare > 0){
                    if(direction[2] > col_compare-1)
                        direction[2] = col_compare-1; //left
                }else{
                    if(direction[6] > Math.abs(col_compare)-1)
                        direction[6] = Math.abs(col_compare)-1; //right
                }
            }else{ //obstacle is somewhere else, check if it is on the diagonals
                if(Math.abs(row_compare) == Math.abs(col_compare)){
                    if(row_compare > 0){
                        if(col_compare > 0){ //bottom left
                            if(direction[1] > col_compare-1)
                                direction[1] = col_compare-1;
                        }else{ // bottom right
                            if(direction[7] > row_compare-1)
                                direction[7] = row_compare-1;
                        }
                    }else{
                        if(col_compare > 0){ // upper left
                            if(direction[3] > col_compare-1)
                                direction[3] = col_compare-1;
                        }else{ // upper right
                            if(direction[5] > Math.abs(col_compare)-1)
                                direction[5] = Math.abs(col_compare)-1;
                        }
                    }
                }
            }
        }
        int total = 0;
        for(int element : direction){
            //System.out.println("Distance in this direction: " + element);
            total += element;
        }
        System.out.println(total);
        in.close();
    }
}
