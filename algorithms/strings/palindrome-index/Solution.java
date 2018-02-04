//https://www.hackerrank.com/challenges/palindrome-index/problem

import java.io.*;
import java.util.*;


public class Solution {
    
    //start comparing characters from the left and right ends
    //if characters don't match, check if the next ones in line would match after a removal
    //if there would be a match, tag the character on the other side for removal
    //if more than one character would need to be removed, return -1

    static int palindromeIndex(String s){
        int right = s.length() - 1;
        int left = 0;
        int remove = -1;
        while (left < right){
            if(s.charAt(left)!=s.charAt(right)){
                //System.out.println("mismatch at indexes: " + left + " and " + right);
                if(remove != -1){
                    //System.out.println("another index previously tagged for removal at index: " + remove);
                    return -1;
                }
                if(s.charAt(left) == s.charAt(right-1) && s.charAt(left+1) == s.charAt(right-2)){
                    remove = right;
                    //System.out.println("tagging right side for removal at index: " + remove);
                    right--;
                }else if(s.charAt(left+1) == s.charAt(right) && s.charAt(left+2) == s.charAt(right-1)){
                    remove = left;
                    //System.out.println("tagging left side for removal at index: " + remove);
                    left++;
                }else{
                    //System.out.println("removing either one won't turn the string into a palindrome");
                    return -1;
                }
            }else{
                left++;
                right--;
            }
        }
        return remove;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            int result = palindromeIndex(s);
            System.out.println(result);
        }
    }
}
