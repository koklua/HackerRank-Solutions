//https://www.hackerrank.com/challenges/acm-icpc-team/problem

import java.io.*;
import java.util.*;

public class Solution {
    //iterate over every duo while keeping track of maximum proficiency count
    //brute force solution of at least O(m*n^2) complexity, is there a better way?

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        String[] nerd = new String[n];
        for(int index = 0; index < n; index++)
            nerd[index] = input.next();
        int max = 0;
        int teams = 0;
        for(int i = 0; i < n-1; i++){
            for(int j = i+1; j < n; j++){
                int count = 0;
                for(int k = 0; k < m; k++){
                    if( nerd[i].charAt(k) == '1' || nerd[j].charAt(k) == '1')
                        count++;   
                }
                if(count > max){
                    max = count;
                    teams = 1;
                }else if(count == max){
                    teams++;
                }  
            }
        }
        System.out.println(max);
        System.out.println(teams);
    }
}
