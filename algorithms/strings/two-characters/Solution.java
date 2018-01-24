//https://www.hackerrank.com/challenges/two-characters/problem

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    //use a set to hold all unique characters, test all distinct pairs with regex

    static int twoCharaters(String s) {
        int max = 0;
        Set<Character> charSet = new HashSet<Character>();
        for(int i = 0; i < s.length(); i++){
            if(!charSet.contains(s.charAt(i)))
                charSet.add(s.charAt(i));
        }
        Iterator<Character> i = charSet.iterator();
        while(i.hasNext()) {
            Character first = i.next();
            i.remove();
            Iterator<Character> j = charSet.iterator();
            //System.out.println("Checking pairs for character: " + first);
            while(j.hasNext()){
                String variant = s;
                Character second = j.next();
                //System.out.println("Pairing with: " + second);
                Pattern pattern = Pattern.compile("[^"+ first + second +"]");
                Matcher matcher = pattern.matcher(variant);
                variant = matcher.replaceAll("");
                //System.out.println("Removed all other characters: " + variant);
                pattern = Pattern.compile("^([a-z])(?!\\1)([a-z])(\\1\\2)*\\1?$");
                matcher = pattern.matcher(variant);
                if(matcher.matches() && max < variant.length())
                    max = variant.length();
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int l = in.nextInt();
        String s = in.next();
        System.out.println(twoCharaters(s));
        in.close();
    }
}
