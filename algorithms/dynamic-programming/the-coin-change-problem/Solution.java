//https://www.hackerrank.com/challenges/coin-change/problem

import java.io.*;
import java.util.*;

public class Solution {

    static long getWays(int sum, int types, int[] coin){
	//outer loop iterates through each coin type
        //inner loops iterate over the occurrences of the corresponding coin type
        //the totals are stored in a one dimensional array to connect separate inner loops through storage
        //inner loop starts from the case where the sub-total = value of current coin, propagates possible combinations bottom up
		
        long[] storage = new long[sum+1];
        Arrays.fill(storage, 0);
        storage[0] = 1; //initialize 0 remaining as 1
        
        for(int i = 0; i < types; i++){
            for(int j = coin[i]; j <= sum; j++){
                storage[j] += storage[j-coin[i]];
            }
        }
        
        return storage[sum];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] c = new int[m];
        for(int i=0; i < m; i++){
            c[i] = in.nextInt();
        }
        // Print the number of ways of making change for 'n' units using coins having the values given by 'c'
        System.out.println(getWays(n, m, c));
    }
}
