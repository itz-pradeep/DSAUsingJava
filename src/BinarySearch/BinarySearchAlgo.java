package BinarySearch;

import java.util.Scanner;

public class BinarySearchAlgo {
    public static int applyBinarySearch(int[] arr, int k) {
        int s = 0;
        int e = arr.length - 1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (arr[mid] == k) {
                return mid;
            }

            if (arr[mid] < k) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            arr[i] = num;
        }
        int k = sc.nextInt();
        int result1 = applyBinarySearch(arr, k);
        System.out.println(result1);

    }
}
