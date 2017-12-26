//https://www.hackerrank.com/challenges/encryption/problem

import java.io.*;
import java.util.*;

public class Solution {
    //use pointer arithmetic logic to move the character index as if the string was a grid
    //Roughly O(n) complexity since columns*rows is roughly n

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String sentence = input.next();
        int length = sentence.length();
        int columns = (int)Math.ceil(Math.sqrt(length)); 
        int rows = (int)Math.ceil((float)length/columns); 
        for(int i = 0; i < columns*rows; i++){
            int index = i / rows + (i % rows)*columns; //transform the loop counter into an index from the imagined grid
            if(index < length){//could be an out of bounds character (final row)
                System.out.print(sentence.charAt(index));
            }
            if(i%rows == rows-1)//if we're at the end of a column, print a space
                System.out.print(' ');
        }
        input.close();
    }
}
