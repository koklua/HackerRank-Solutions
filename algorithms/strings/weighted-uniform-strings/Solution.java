//https://www.hackerrank.com/challenges/weighted-uniform-string/problem

import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Set<Integer> set = new HashSet<Integer>();
        String s = in.next();
        int len = s.length();
        int count = 0;
        int prev = s.codePointAt(0);
        //find all uniform substrings and hold their weights in a set
        for (int i = 0; i < len; i++){
            int temp = s.codePointAt(i);
            if(temp == prev){
                count++;
            }else{
                prev = temp;
                count = 1;
            }
            int weight = (prev-96)*count;
            if(!set.contains(weight))
                set.add(weight);
        }
        int n = in.nextInt();
        //iterate over all x values and check if they exist in the set
        for(int i = 0; i < n; i++){
            int x = in.nextInt();
            if(set.contains(x)){
                System.out.println("Yes");
            }else{
                System.out.println("No");
            }
        }
    }
}
