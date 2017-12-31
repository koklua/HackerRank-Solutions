//https://www.hackerrank.com/challenges/fair-rations/problem

import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {
    //for the first N-1 peasants
    //if bread is odd, give bread to i and i+1
    //this propagates the odd to the end of the line
    //for the Nth peasant
    //if bread is odd, print NO
    //else print bread count
    //No need to hold an array, O(n) time complexity and constant space complexity

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int bread_carry = 0;
        int bread_count = 0;
        for(int i=0; i < N-1; i++){
            int peasant = in.nextInt() + bread_carry;
            if(peasant % 2 == 1){
                bread_count += 2;
                bread_carry = 1;
            }else{
                bread_carry = 0;
            }
        }
        int last_peasant = in.nextInt() + bread_carry;
        if(last_peasant % 2 == 1){
            System.out.println("NO");
        }else{
            System.out.println(bread_count);
        }
        in.close();
    }
}
