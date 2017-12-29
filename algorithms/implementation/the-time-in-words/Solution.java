//https://www.hackerrank.com/challenges/the-time-in-words/problem

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Map<Integer, String> words = new HashMap<>();
        words.put(1, "one");
        words.put(2, "two");
        words.put(3, "three");
        words.put(4, "four");
        words.put(5, "five");
        words.put(6, "six");
        words.put(7, "seven");
        words.put(8, "eight");
        words.put(9, "nine");
        words.put(10, "ten");
        words.put(11, "eleven");
        words.put(12, "twelve");
        words.put(13, "thirteen");
        words.put(14, "fourteen");
        words.put(16, "sixteen");
        words.put(17, "seventeen");
        words.put(18, "eighteen");
        words.put(19, "nineteen");
        words.put(20, "twenty");
        words.put(21, "twenty one");
        words.put(22, "twenty two");
        words.put(23, "twenty three");
        words.put(24, "twenty four");
        words.put(25, "twenty five");
        words.put(26, "twenty six");
        words.put(27, "twenty seven");
        words.put(28, "twenty eight");
        words.put(29, "twenty nine");
        Scanner input = new Scanner(System.in);
        int hour = input.nextInt();
        int minute = input.nextInt();
        String output;
        String minutes = " minutes ";
        if(minute == 0){
            output = words.get(hour) + " o' clock";
        }else if(minute == 30){
            output = "half past " + words.get(hour);
        }else if(minute == 15){
            output = "quarter past " + words.get(hour);
        }else if(minute == 45){
            output = "quarter to " + words.get(hour+1);
        }else{
            if(minute == 1 && minute == 59)
                minutes = "minute";
            if(minute < 30){
                output = words.get(minute) + minutes + "past " + words.get(hour);
            }else{
                output = words.get(60-minute) + minutes + "to " + words.get(hour+1);
            }
        }
        System.out.println(output);
        input.close();
    }
}
