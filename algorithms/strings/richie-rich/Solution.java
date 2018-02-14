//https://www.hackerrank.com/challenges/richie-rich/problem

import java.io.*;
import java.util.*;

public class Solution {
    
    static String richieRich(String s, int n, int k){
        char[] array = s.toCharArray();

        //count the digits that would need to be changed to turn this number into a palindrome
        int count = 0;
        for(int i = 0; i < n/2; i++){
            if(array[i] != array[n-1-i])
                count++;
        }
        //if the count is higher than k, then it's not possible
        if(count > k)
            return "-1";
        
        //estimate an initial budget for maximizing the number by subtracting the necessary changes from k
        int budget = k - count;
        
        
        //try to maximize the number as much as the budget allows by changing digits to 9 on both ends of the number
        int i = 0;
        while(budget > 0 && i < n/2){
            if(array[i] != array[n-1-i])//if it's a digit that's already in the count, refund the budget
                budget++;
            if(budget >= 2 && i < n-1-i){//if the budget allows it, change digits to 9
                if(array[i] != '9'){
                    array[i] = '9';
                    budget--;
                }
                if(array[n-1-i] != '9'){
                    array[n-1-i] = '9';
                    budget--;
                }
            }
            if(i == n-1-i){//if we're at the middle of the string, change it to 9 and end the loop
                array[i] = '9';
                break;
            }
            i++;
        }
        
        //when we're out of budget for further increases, change the remaining digits
        while(i < n-1-i){
            if(array[i] != array[n-1-i]){
                if(s.codePointAt(i)>s.codePointAt(n-1-i)){
                    array[n-1-i] = array[i];
                }else{
                    array[i] = array[n-1-i];
                }
            }
            i++;
        }
        return new String(array);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        String s = in.next();
        System.out.println(richieRich(s, n, k));
    }
}
