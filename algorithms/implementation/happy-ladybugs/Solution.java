//https://www.hackerrank.com/challenges/happy-ladybugs/forum

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    //a single empty cell is enough to rearrange the whole board
    //if there is an empty cell: check if there are any single ladybugs
    //if there are no empty cells: check if all ladybugs are already happy
    
    //O(n) time complexity
    
    public static String happyCheck(String board, int n){
        //first check for an empty cell
        String regex = "_";
        Pattern pattern = Pattern.compile("_");
        Matcher matcher = pattern.matcher(board);
        boolean has_empty_cells = matcher.find(); 
        if(has_empty_cells){//we can rearrange, do a frequency count for singles
            int singles = 0;
            int[] freq = new int[26]; //frequency array for A-Z
            for(int i = 0; i < n; i++){
                int temp = board.codePointAt(i)-65;
                if(temp != 30){
                    freq[temp]++;
                    if(freq[temp] == 1){
                        singles++;
                    }else if(freq[temp] == 2){
                        singles--;
                    }
                }
            }
            if(singles > 0)
                return "NO";
        }else{//no empty cells, we check each ladybird for happiness
            if(n == 1)
                return "NO";
            if(board.charAt(0) != board.charAt(1))
                return "NO";
            for(int i = 1; i < n-1; i++){
                if(board.charAt(i) != board.charAt(i-1) && board.charAt(i) != board.charAt(i+1))
                    return "NO";
            }
            if(board.charAt(n-1) != board.charAt(n-2))
                return "NO";
        }
        //if the constraints are met, return YES
        return "YES";
    }
        

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int no_of_games = in.nextInt();
        for(int game = 0; game < no_of_games; game++){
            int length = in.nextInt();
            String board = in.next();
            System.out.println(happyCheck(board,length));
        }
        in.close();
    }
}
