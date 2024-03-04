package Recursion;

import java.util.Scanner;

public class PowerOfTwo {
    //https://leetcode.com/problems/power-of-two/
    public static boolean isPowerOfTwoLinearApproach(int n){
        if(n==0) return false; // 0 cannot be achieved by adding any number as power of 2.
        while(n%2==0){
            n=n/2;
        }
        return n==1; //2 ki power 0 is equal to 1.

        //Time complexity O(log n)
        //Space complexity 1
    }

    public static boolean isPowerOfTwoRecursiveApproach(int n){
        if(n==0) return false;
        return n==1 || (n%2==0 && isPowerOfTwoRecursiveApproach(n/2));

        //Time complexity O(log n)
        //Space complexity O(log n) Recursive stack is counted
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean result1 = PowerOfTwo.isPowerOfTwoLinearApproach(n);
        System.out.println(result1);

        boolean result2 = PowerOfTwo.isPowerOfTwoRecursiveApproach(n);
        System.out.println(result2);

    }
}
