//https://www.hackerrank.com/challenges/beautiful-triplets/problem

import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {
    //we're looking for triplets where elements will be equal to a[i], a[i]+d and a[i]+2*d
    //while taking input, we can count the frequency for each integer three times: as they are, after adding d and after adding 2*d
    //then for any frequency with 3 elements, there's a triplet 
    //O(n) complexity with input included

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int d = in.nextInt();
        int[] bucket = new int[20001+2*d];
        Arrays.fill(bucket,0);
        for(int i = 0; i < n; i++){
            int value = in.nextInt();
            bucket[value]++;
            bucket[value+d]++;
            bucket[value+2*d]++;
        }
        int total = 0;
        for(int check : bucket){
            total += check/3;
        }
        System.out.println(total);
        in.close();
    }
}
