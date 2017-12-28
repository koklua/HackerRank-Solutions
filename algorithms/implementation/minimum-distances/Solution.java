//https://www.hackerrank.com/challenges/minimum-distances/problem

import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {
    //hold a 2d frequency array[100001][2] with the second row storing the last index of the corresponding value
    //during input, check if the number already exists and if it does, compare for minimum distance and update the last index

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] bucket = new int[100001][2];
        int min_dist = 100001;
        for(int i = 0; i < n; i++){
            int number = in.nextInt();
            if(bucket[number][0] == 0){
                bucket[number][0]++;
            }else{
                int temp_dist = i - bucket[number][1];
                if(temp_dist < min_dist)
                    min_dist = temp_dist;
            }
            bucket[number][1] = i;
        }
        if(min_dist == 100001){
            min_dist = -1;
        }
        System.out.println(min_dist);
        in.close();
    }
}
