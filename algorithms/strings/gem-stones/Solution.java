//https://www.hackerrank.com/challenges/gem-stones/problem

import java.io.*;
import java.util.*;

public class Solution {
    
    //use a frequency array to count the number of rocks that contain each element
    //using a set to avoid multiples
    //after checking all rocks, any element that's in n rocks is a gem-element
  

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] freq = new int[26];
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < n; i++){
            String rock = in.next();
            int len = rock.length();
            for (int j = 0; j < len; j++){
                int element = rock.codePointAt(j)-97;
                if(!set.contains(element)){
                    freq[element]++;
                    set.add(element);
                }
            }
            set.clear();
        }
        int count = 0;
        for(int element:freq){
            if(element == n)
                count++;
        }
        System.out.println(count);
    }
}
