package Recursion;

import java.util.Scanner;

public class FibonacciSeries {
    //https://leetcode.com/problems/fibonacci-number/
    public static int fibRecursiveApproach(int n) {
        //0 1 1 2 3 5 8 13...
        if(n==0) return 0;
        if(n==1) return 1;

        return fibRecursiveApproach(n-1) + fibRecursiveApproach(n-2);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result1 = FibonacciSeries.fibRecursiveApproach(n);
        System.out.println(result1);

    }
}
