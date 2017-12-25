//https://www.hackerrank.com/challenges/organizing-containers-of-balls/problem

import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {
    //since we can only swap balls (and not remove), the total number of balls in each container will never change
    //this means that for the conditions to be met, each ball type will need a matching container that started with exactly the same number as the total balls of that type
    //therefore we keep tally of type and container totals during input using arrays, then sort them. if arrays are a perfect match, then the result is "possible"

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int query = in.nextInt();
        for(int a0 = 0; a0 < query; a0++){
            int n = in.nextInt();
            long[] type_total = new long[n];
            long[] container_total = new long[n];
            Arrays.fill(container_total,0);
            Arrays.fill(type_total,0);
            int temp;
            for(int row=0; row < n; row++){
                for(int col=0; col < n; col++){
                    temp = in.nextInt();
                    container_total[row] += temp;
                    type_total[col] += temp;
                }
            }
            Arrays.sort(container_total);
            Arrays.sort(type_total);
            String result = "Possible";
            for(int check = 0; check < n; check++){
                if(container_total[check] != type_total[check]){
                    result = "Impossible";
                    break;
                }
            }
            System.out.println(result);
        }
        in.close();
    }
}
