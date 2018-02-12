//https://www.hackerrank.com/challenges/sherlock-and-valid-string/problem

import java.io.*;
import java.util.*;

public class Solution {
    
    //first use a frequency array to count frequencies of characters
    //then go over the frequency array to map the frequencies of frequencies
    //if the size of the map is 1, then all characters have the same frequency and the string meets the first condition
    //if the size of the map is 2, there are two possibilities to meet the second condition:
    //a. if the lower frequency only occurs once and its value is 1
    //OR
    //b. if the higher frequency only occurs once and its value is 1 greater than the lower frequency
    

    static String isValid(String s){
        int len = s.length();
        int[] freq = new int[26];
        for(int i = 0; i < len; i++)
            freq[s.codePointAt(i)-97]++;
        HashMap<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();
        int max = 0; //track the highest frequency
        for(int i = 0; i < 26; i++){
            if(freq[i] > 0){
                if(!frequencyMap.containsKey(freq[i])){
                    //System.out.println("new frequency: " + freq[i]);
                    frequencyMap.put(freq[i],1);
                }else{
                    //System.out.println("incrementing frequency: " + freq[i]);
                    frequencyMap.replace(freq[i],frequencyMap.get(freq[i]) + 1);
                }
                if(freq[i] > max)
                    max = freq[i];
            }
        }
        //System.out.println("number of different frequencies: " + frequencyMap.size());
        if(frequencyMap.size() == 1)
            return "YES"; //satisfies first condition
        if(frequencyMap.size() == 2 && frequencyMap.containsValue(1)){ //could satisfy second condition
            if(frequencyMap.containsKey(1) && frequencyMap.get(1) == 1 ||  //possibility a
               frequencyMap.get(max) == 1 && frequencyMap.containsKey(max-1)) //possibility b
                return "YES"; 
        }
        return "NO";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = isValid(s);
        System.out.println(result);
    }
}
