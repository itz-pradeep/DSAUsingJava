package Recursion;

import java.util.Scanner;

public class SumOfArrayElements {
    public static int getSumOfArrayLinearApproach(int[] arr, int size) {
        int i=0;
        int sum=0;
        if (size == 0) return 0;
        if (size == 1) return arr[0];

        while (i<size){
            sum += arr[i];
            i++;
        }

        return sum;
    }
    public static int getSumOfArrayRecursiveApproach(int[] arr, int size) {
        //0 1 2 3 4
        if(size == 0) return arr[0];

        return arr[size] + getSumOfArrayRecursiveApproach(arr,size-1);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            int num = sc.nextInt();
            arr[i] = num;
        }
        int result1 = SumOfArrayElements.getSumOfArrayLinearApproach(arr,arr.length);
        System.out.println(result1);
        int result2 = SumOfArrayElements.getSumOfArrayRecursiveApproach(arr,arr.length-1);
        System.out.println(result2);
    }
}
