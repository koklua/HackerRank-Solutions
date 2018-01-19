//https://www.hackerrank.com/challenges/almost-sorted/problem

import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {
    //graceless O(n) solution with a lot of disjointed iterations:
    //1. iterate until either the array ends or an element breaks ascending order
    //2. iterate through the elements in the descending subsection
    //3. iterate until either the array ends or an element breaks ascending order
    //4. do a boundary check for the descending subsection reversal
    //5. if we're at the end of the array and a reversal is possible, print reversal (or swap if subsequence length is 2)
    //6. if we're not at the end of the array, it means the second element is found.
    //7. iterate until either the array ends or an element breaks ascending order
    //8. if we're at the end of the array, it means a swap is possible, print swap
    //9. if we're not at the end of the array, it means sorting isn't possible at all, print no

    static void almostSorted(int[] array) {
        int i = 0;
        int len = array.length;
        boolean reversal = true;
        while(i < len - 1 && array[i] < array [i+1]){
            i++;
        }
        int start = i;
        int count = 0;
        //System.out.println("start of reversal on index: " + start);
        while(i < len - 1 && array[i] > array [i+1]){
            i++;
            count++;
        }
        int end = i;
        //System.out.println("end of reversal at index: " + end);
        while(i < len - 1 && array[i] < array [i+1]){
            i++;
        }
        if((start > 0 && array[end] < array[start-1])||(end < len - 1 && array[start] > array[end+1])){
            //we know the subsegment is in descending order, but we have to check if its start and end are in bounds 
            reversal = false;
        }
        if(i == len - 1 && reversal){//if reversal is possible
            System.out.println("yes");
            if(count > 1){
                System.out.printf("reverse %d %d\n", start+1, end+1);
            }else if(count == 1){
                System.out.printf("swap %d %d\n", start+1, end+1);
            }
            return;
        }else if(i < len - 1 && count == 1){//if reversal isn't possible, keep checking for swap
            i++;
            end = i;
            while(i < len - 1 && array[i] < array [i+1]){
                i++;
            }
            if(i == len - 1){
                System.out.println("yes");
                System.out.printf("swap %d %d\n", start+1, end+1);
                return;
            }
        }
        //at this point, nothing can be done to sort the array
        System.out.println("no");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        almostSorted(arr);
        in.close();
    }
}
