//https://www.hackerrank.com/challenges/lisa-workbook/problem

import java.io.*;
import java.util.*;

public class Solution {
    //go over each chapter while keeping track of the number of pages so far
    //for each chapter, check problems one by one
    //complexity O(sum of t's)

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();
        int pages = 0;
        int count = 0;
        for(int chapter = 1; chapter <= n; chapter++){
            int t = input.nextInt();
            for(int problem = 1; problem <= t; problem++){
                //current page is equal to total pages of previous chapters + the pages in this chapter up to the problem
                int current_page = pages + (int) Math.ceil((float)problem/k);
                if(current_page == problem)
                    count++;
            }
            //add the number of pages in this chapter to total page count
            pages += (int) Math.ceil((float)t/k);
        }
        System.out.println(count);
        input.close();
    }
}
