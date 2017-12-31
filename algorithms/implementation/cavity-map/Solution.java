//https://www.hackerrank.com/challenges/cavity-map/problem

import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {
    //simply iterate through each square that's not on the border and check individually
    //O(n^2) time complexity, constant space as we only hold 3 rows at any time
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if(n > 1){
            String top_row = in.next();
            String middle_row = in.next();
            System.out.println(top_row);
            for(int i=0; i < n-2; i++){
                String bottom_row = in.next();
                for(int j = 1; j < n-1; j++){
                    if(middle_row.codePointAt(j) > middle_row.codePointAt(j-1) &&
                       middle_row.codePointAt(j) > middle_row.codePointAt(j+1) &&
                       middle_row.codePointAt(j) > top_row.codePointAt(j) &&
                       middle_row.codePointAt(j) > bottom_row.codePointAt(j)){
                        middle_row = middle_row.substring(0,j) + "X" + middle_row.substring(j+1);
                        j++; //skip the next square because two cavities can't be adjacent
                    }
                }
                System.out.println(middle_row);
                top_row = middle_row;
                middle_row = bottom_row;
            }
            System.out.println(middle_row);
        }else{
            int single = in.nextInt();
            System.out.println(single);
        }
        in.close();
    }
}
