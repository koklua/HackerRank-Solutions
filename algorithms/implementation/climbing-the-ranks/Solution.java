//https://www.hackerrank.com/challenges/climbing-the-leaderboard/problem

import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {
    
    //insert the scores into a list of ranks
    //iterate backwards through the list for alice's scores
    //O(n) complexity? only iterates through the ranks once

    public static void main(String[] args) {
        //rank class to hold rank information
        class Rank{
            int score;
            int rank;
            Rank prev;
        
            public Rank(int new_score, int new_rank, Rank previous){
                rank = new_rank;
                score = new_score;
                prev = previous;
            }
        
            public Rank(int new_score, int new_rank){
                rank = new_rank;
                score = new_score;
                prev = null;
            }
        }
        
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int temp_score;
        int rank_counter = 1;
        Rank rank_list = new Rank(in.nextInt(), rank_counter);
        for(int i = 1; i < n; i++){
            temp_score = in.nextInt();
            if(rank_list.score > temp_score){
                rank_counter++;
                rank_list = new Rank(temp_score, rank_counter, rank_list);
            }
            
        }
        int m = in.nextInt();
        for(int j = 0; j < m; j++){
            int alice_score = in.nextInt();
            int alice_rank;
            if(alice_score < rank_list.score){
                alice_rank = rank_list.rank + 1;
            }else{
                while(alice_score > rank_list.score && rank_list.prev != null){
                    rank_list = rank_list.prev;
                }
                if(alice_score < rank_list.score){
                    alice_rank = rank_list.rank +1;
                }else{
                    alice_rank = rank_list.rank;
                }
            }
            System.out.println(alice_rank);
        }
        
        in.close();
    }
}
