//https://www.hackerrank.com/challenges/kaprekar-numbers/problem

import java.io.*;
import java.util.*;

public class Solution {
    //using string manipulation to split the squares into two pieces
    //needs an exception for single digit squares (range 1 to 3) because parseInt parses nothing from empty string
    //may or may not perform better than the standard modulo/division method, needs to be compared

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int lower_bound = input.nextInt();
        int upper_bound = input.nextInt();
        int count = 0;
        if(lower_bound < 4){//exception for single digit squares
            if(lower_bound == 1){
                System.out.printf("1 ");
                count++;
            }
            lower_bound = 8;
        }
        for(long i = lower_bound; i <= upper_bound; i++){
            String square = Long.toString(i*i);
            int separator = square.length() - Long.toString(i).length();
            int left_piece = Integer.parseInt(square.substring(0,separator));
            int right_piece = Integer.parseInt(square.substring(separator));
            if(i == right_piece + left_piece){
                System.out.printf("%d ",i);
                count++;
            }
        }
        if(count == 0)
            System.out.println("INVALID RANGE");
        input.close();
    }
}
