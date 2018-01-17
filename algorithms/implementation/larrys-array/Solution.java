//https://www.hackerrank.com/challenges/larrys-array/problem

import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {
    //for n elements, the first or last n-2 can always be sorted due to the rotation method
    //once n-2 elements are sorted, the remaining 2 elements can't be swapped anymore without breaking the preceeding or succeeding order
    //brute force implementation with two arrays: second array holds indexes for quicker iterations. for values 1 through n-2, immediately go to the index on the array and apply rotations to propagate the number to its sorted index
    //at the end, if the final element is the largest element, then it is sorted

    static String larrysArray(int[] array, int[] index_of) {
        for(int i = 1; i < array.length-1; i++){
            int index = index_of[i];
            while(array[i-1] != i){//keep rotating until the element is at its sorted spot
                //System.out.printf("number is %d and the current index is %d\n", i, index);
                int temp = array[index];
                if(index == i){
                    //System.out.println("single rotation with element starting from the center");
                    index_of[array[index+1]] = index;
                    index_of[array[index-1]] = index+1;
                    index_of[array[index]] = index-1;
                    array[index] = array[index+1];
                    array[index+1] = array[index-1];
                    array[index-1] = temp;
                }else{
                    //System.out.println("double rotation with element starting from far right");
                    index_of[array[index-2]] = index;
                    index_of[array[index-1]] = index-2;
                    index_of[array[index]] = index-1;
                    array[index] = array[index-2];
                    array[index-2] = array[index-1];
                    array[index-1] = temp;
                }
                index--;
            }
        } 
        if(array[array.length-1] == array.length){//is the last element the largest element?
            return "YES";
        }else{
            return "NO";
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int[] values = new int[n];
            int[] indexes = new int[n+1];
            for(int i = 0; i < n; i++){
                values[i] = in.nextInt();
                indexes[values[i]] = i;
            }
            String result = larrysArray(values, indexes);
            System.out.println(result);
        }
        in.close();
    }
}
