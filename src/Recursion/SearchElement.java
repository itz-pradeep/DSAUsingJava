package Recursion;

import java.util.Scanner;

public class SearchElement {
    public static boolean searchElementUsingRecursion(int[] arr, int size,int ele){
       if(arr.length == 0) return false;
       if(size < 0) return false;
       boolean isPresent = arr[size] == ele;
       return isPresent || searchElementUsingRecursion(arr,size-1,ele);
    }

    public static boolean searchElementUsingRecursionApproach2(int[] arr, int size,int ele,int index){
        if(size == 0) return false;
        if(arr[index] == ele) {
            return true;
        }
        else {
            return searchElementUsingRecursionApproach2(arr,size-1,ele,index+1);
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            int num = sc.nextInt();
            arr[i] = num;
        }
        int ele = sc.nextInt();
        boolean result1 = searchElementUsingRecursion(arr,arr.length-1,ele);
        System.out.println(result1);
        boolean result2 = searchElementUsingRecursionApproach2(arr,arr.length,ele,0);
        System.out.println(result2);
    }
}
