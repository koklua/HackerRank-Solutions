//https://www.hackerrank.com/challenges/non-divisible-subset/problem

import java.io.*;
import java.util.*;

public class Solution {
    //modulo can be distributed such that (a+b)%k = (a%k+b%k)%k
    //find the modulo k equivalents of all elements during input and store them in an array
    //count the max number of elements such that for any element of index i, there won't be one of index k-i;
    //if k is 1, then the length is 1.

    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();
        int total;
        if(k == 1){
            total = 1;
        }else{
            int[] mod = new int[k];
            for(int i = 0; i < n; i++){
                mod[input.nextInt() % k]++;
            }
            total = 0;
            //for(int element:mod)
            //    System.out.printf("%d ",element);
            //System.out.println("Total is");
            for(int index = 1; index < k - index; index++ ){
                if(mod[index] > mod[k - index]){
                    total += mod[index];
                }else{
                    total += mod[k - index];
                }
            }
            //can only have 1 of an element where mod[i] % k = 0
            if(mod[0]>0)
                total++;
            //can only have 1 of an element where mod[i] % k = k/2
            if(k % 2 == 0 && mod[k/2] > 0)
                total++;
            
        }
        System.out.println(total);
        input.close();
    }
}
