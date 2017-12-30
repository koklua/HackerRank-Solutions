//https://www.hackerrank.com/challenges/flatland-space-stations/problem

import java.io.*;
import java.util.*;

public class Solution {
    //sort the space stations, then check the distances between each space station to find the maximum

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        int max;
        if(n == m){ //if each city has its own station
            max = 0;
        }else{
            int[] station = new int[m];
            for(int i = 0; i < m; i++)
                station[i] = input.nextInt();
            Arrays.sort(station);
            max = station[0]; //distance for city 0
            int temp_max;
            for(int j = 0; j < m-1; j++){
                temp_max = (station[j+1]-station[j])/2;
                if(temp_max > max)
                    max = temp_max;
            }
            temp_max = n - 1 - station[m-1]; //distance for city n-1
            if(temp_max > max)
                max = temp_max;
        }
        System.out.println(max);
        input.close();
    }
}
