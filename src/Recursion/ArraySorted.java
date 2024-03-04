package Recursion;

import java.util.Scanner;

public class ArraySorted {
    public static boolean checkArraySortedLinearApproach(int[] arr, int size){
        for(int i=0;i<size-1;i++){
            if(arr[i] > arr[i+1]){
                return false;
            }
        }

        return true;
    }

    public static boolean checkArraySortedRecursionApproach(int[] arr,int start, int size){
        //Array has only 0 or 1 element return true
        if(size==0 || size==1) return true;
        return (arr[start] <= arr[start+1]) && checkArraySortedRecursionApproach(arr,start+1,size-1);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            int num = sc.nextInt();
            arr[i] = num;
        }
        boolean result1 = ArraySorted.checkArraySortedLinearApproach(arr,arr.length);
        System.out.println(result1);

        boolean result2 = ArraySorted.checkArraySortedRecursionApproach(arr,0,arr.length);
        System.out.println(result2);
    }
}

