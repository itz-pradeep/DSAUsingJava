package Sorting;

import Recursion.ArraySorted;

import java.util.Scanner;

public class SelectionSort {
    static void sort1(int[] arr, int n){
        //Last element will be sorted already
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if(arr[i]>arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    static void print(int[] arr,int n){
        for(int i=0;i<n;i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args){
        int[] arr = {20,3,5,4,41};
        sort1(arr,arr.length);
        print(arr,arr.length);
    }
}
