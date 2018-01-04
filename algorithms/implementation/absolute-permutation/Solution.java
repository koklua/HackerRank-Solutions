//https://www.hackerrank.com/challenges/absolute-permutation/problem

import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {
    //since we're working with a index that consists of ordered positive numbers:
    //pos[i] starts at 1, so until pos[i] > k, the only way to get abs(pos[i]-i) == k is with i = pos[i]+k
    //after that point i can be both pos[i]-k or pos[i]+k
    //to avoid repetition, we use a hashset to store previously used numbers
    
    //the -1 condition can occur in two ways:
    //1. if i is outside the boundary of n
    //we can pre-emptively check for the first section:
    //the i formula switch happens after pos[i] == k, meaning the max value of i = pos[i]+k is 2*k
    //at the start, check if 2*k > n
    //later, at the second section, check for pos[i]+k > n;
    
    //2. if the values pos[i]-k and pos[i]+k have both been used before
    //if the hashset already has both possible i values for pos[i], then no absolute permutation exists
    
    //O(n) space and time complexity
    
    public static void absolutePermutation(int n, int k){
        Set<Integer> valueSet = new HashSet<Integer>();
        int[] permutation = new int[n];
        int index = 1;
        if(2*k > n){
            System.out.println("-1");
            return;
        } 
        while(index <= k){
            permutation[index-1] = index + k;
            valueSet.add(index + k);
            index++;
        }
        while(index <= n){
            if(valueSet.contains(index - k) == false){
                permutation[index-1] = index - k;
                valueSet.add(index - k);
            }else if(valueSet.contains(index + k) == false && index + k <= n){
                permutation[index-1] = index + k;
                valueSet.add(index + k);
            }else{
                System.out.println("-1");
                return;
            }
            index++;
        }
        
        for(int number : permutation){
            System.out.print(number + " ");
        }
        System.out.println("");
        return;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int no_of_cases = in.nextInt();
        for(int test = 0; test < no_of_cases; test++){
            int n = in.nextInt();
            int k = in.nextInt();
            absolutePermutation(n,k);
        }
        in.close();
    }
}
