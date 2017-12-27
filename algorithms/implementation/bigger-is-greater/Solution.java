//https://www.hackerrank.com/challenges/bigger-is-greater/problem

import java.io.*;
import java.util.*;

public class Solution {
    //java doesn't have permutation methods so we need to manually implement an algorithm to find the next lexicographical permutation 
    //from wikipedia:
    //1. Find the largest index k such that a[k] < a[k + 1]. If no such index exists, the permutation is the last permutation.
    //2. Find the largest index l greater than k such that a[k] < a[l].
    //3. Swap the value of a[k] with that of a[l].
    //4. Reverse the sequence from a[k + 1] up to and including the final element a[n].

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int no_of_cases = in.nextInt();
        for(int test_case = 0; test_case < no_of_cases; test_case++){
            String input = in.next();
            char[] word = input.toCharArray();
            //step 1
            int pivot;
            for(pivot = word.length - 2; pivot >= 0; pivot--){
		        if(word[pivot] < word[pivot+1])
                    break;
            }
            if(pivot < 0){
                System.out.println("no answer");
                continue;
            }
            //step 2
            int swap;
            for(swap = word.length - 1; swap > pivot; swap--){
		        if (word[swap] > word[pivot])
                    break;
            }
            //step 3
            char temp = word[swap];
            word[swap] = word[pivot];
            word[pivot] = temp;
            //step 4
            int reverse = word.length-1;
            while(pivot+1 < reverse){
                temp = word[reverse];
                word[reverse] = word[pivot+1];
                word[pivot+1] = temp;
                pivot++;
                reverse--;
            }
            System.out.println(word);
        }
        in.close();
        
    }
}
