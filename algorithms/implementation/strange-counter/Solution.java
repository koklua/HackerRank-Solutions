//https://www.hackerrank.com/challenges/strange-code/problem

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;

public class Solution {
    //the size of the scale at cycle i is 3 * 2^i (assuming the first cycle is 0)
    //the pattern for max time value for any cycle is max[i] = 3 * 2^i + max[i-1]
    //after finding the current max, simply subtract t from max

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long t = in.nextLong();
        long max = 3; //max[0];
        int i = 0; //cycle 0
        while(t > max){
            i++;
            max += 3 * (long) Math.pow(2,i);
        }
        long value = max - t + 1;
        System.out.println(value);
    }
}
