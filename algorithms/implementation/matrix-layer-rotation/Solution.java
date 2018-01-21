//https://www.hackerrank.com/challenges/matrix-rotation-algo/problem

import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {
    //if we process each ring individually, we can find a modulo equivalent for the effective number of rotations required by eliminating the full rotations: rotations % 2*(ring_rows + ring_columns)-4
    //for each ring, we create a temporary array of length 2*(ring_rows + ring_columns)-4 and we place the numbers in this temporary array in the shifted order, then we place them back to the main matrix
    //O(N*M) time complexity, O(N+M) space complexity
    

    static void matrixRotation(int[][] matrix, int row, int col, int rotations) {
        int start = 0;
        int loops = Math.min(row,col)/2;//number of rings will be equal to the smallest dimension halved
        while(loops-- > 0){
            int ring_size = 2*(row+col-2*start)-4;
            int[] temp_array = new int[ring_size];
            int eff_rotations = rotations % ring_size;
            int temp_i = ring_size - eff_rotations; //start the temporary array index at the shifted position
            for(int j = start; j < col-1; j++){//move the top row to the temp array
                temp_array[temp_i % ring_size] = matrix[start][j];
                temp_i++;
            }
            for(int i = start; i < row-1; i++){//move the right column to the temp array
                temp_array[temp_i % ring_size] = matrix[i][col-1];
                temp_i++;
            }
            for(int j = col-1; j > start; j--){//move the bottom row to the temp array
                temp_array[temp_i % ring_size] = matrix[row-1][j];
                temp_i++;
            }
            for(int i = row-1; i > start; i--){//move the left column to the temp array
                temp_array[temp_i % ring_size] = matrix[i][start];
                temp_i++;
            }
            //at this point we have a full and shifted temporary array that needs to be moved back to the matrix
            temp_i = 0;
            for(int j = start; j < col-1; j++){//top row
                matrix[start][j] = temp_array[temp_i];
                temp_i++;
            }
            for(int i = start; i < row-1; i++){//right column
                matrix[i][col-1] = temp_array[temp_i];
                temp_i++;
            }
            for(int j = col-1; j > start; j--){//bottom row
                matrix[row-1][j] = temp_array[temp_i];
                temp_i++;
            }
            for(int i = row-1; i > start; i--){//left column
                matrix[i][start] = temp_array[temp_i];
                temp_i++;
            }
            //adjust the limits for the next ring
            row--;
            col--;
            start++;
        }
        //after the whole matrix is shifted, print it
        for(int matrix_i = 0; matrix_i < row+start; matrix_i++){
            for(int matrix_j = 0; matrix_j < col+start; matrix_j++){
                System.out.printf("%d ", matrix[matrix_i][matrix_j]);
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int r = in.nextInt();
        int[][] matrix = new int[m][n];
        
        for(int matrix_i = 0; matrix_i < m; matrix_i++){
            for(int matrix_j = 0; matrix_j < n; matrix_j++){
                matrix[matrix_i][matrix_j] = in.nextInt();
            }
        }
        matrixRotation(matrix, m, n, r);
        in.close();
    }
}
