package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class notwRotateMatrix {

    public static void printMatrix(int matrix[][], int r, int c) {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException{
        
/*
        InputStreamReader inp = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(inp);
        
        System.out.println("Enter text : ");
        
        String str = br.readLine();
        
        System.out.println("You entered String : ");
        
        System.out.println(str);

*/
        int row, col;
        int topR, botR, botL, topL, i, j;
        System.out.println("enter matrix : ");
        Scanner scrnr = new Scanner(System.in);
        row = scrnr.nextInt();
        col = scrnr.nextInt();
        int[][] m = new int[row][col];
        for(i=0; i<row; i++) {
            for(j=0; j<col; j++) {
                m[i][j] = i*row + j;
                System.out.print(m[i][j]+" ");
            }
            System.out.println("");
        }
        System.out.println("\n\n");

        topR = m[0][col-1];
        for(i=col-1; i >=1; i--) {
            m[0][i] = m[0][i-1];
        }

        botR = m[row-1][col-1];
        for(i=row-1; i >= 1; i--) {
            m[i][col-1] = m[i-1][col-1];
        }
        m[1][col-1] = topR;

        botL = m[row-1][0];
        for(i=0; i<col-1; i++) {
            m[row-1][i] = m[row-1][i+1];
        }
        m[row-1][col-2] = botR;

        // Shift element from bottom to top and move bottom left element to row above
        topL = m[0][0];
        for(i=0; i < row-1; i++) {
            m[i][0] = m[i+1][0];
        }
        m[1][0] = botL;
        printMatrix(m, row, col);
    }
}
