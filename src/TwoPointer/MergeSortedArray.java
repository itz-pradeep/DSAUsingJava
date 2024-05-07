package TwoPointer;

import java.util.Arrays;

public class MergeSortedArray {
    /**
     * O(m+n) for copying elements from both arrays to result array.
     * O(m+n) for copying elements from result to given arrays.
     * O(m+n)+O(m+n)
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    static void mergeSortedArrayWithExtraSpace(int[] nums1,int m,int[] nums2,int n){
        int left=0, right=0, index=0;
        int[] result = new int[m+n];
        while(left < m && right < n){
            if(nums1[left] > nums2[right]){
                result[index] = nums2[right];
                right++;
            }
            else{
                result[index] = nums1[left];
                left++;
            }
            index++;
        }
        //element left in nums1 copy all to result array
        while(left<m){
            result[index++] = nums1[left++];
        }
        //element left in nums2 copy all to result array
        while(right<n){
            result[index++] = nums2[right++];
        }
        System.out.println("Printing result array");
        printArray(result);

        //put back the elements in nums1 and nums2
        for(int i=0;i<result.length;i++){
            if(i<m){ // 0 1 2
                nums1[i] = result[i];
            }
            else{
                nums2[i-m] = result[i];
            }
        }
        System.out.println("\nPrinting result 1");
        printArray(nums1);
        System.out.println("\nPrinting result 2");
        printArray(nums2);
    }

    /**
     * Two pointer approach
     * @param nums1
     * @param m
     * @param nums2
     * O(min(l,r)) moving smaller elements to left array and large elements to right array.
     * O(n*log n) and O(m*log m) is for sorting arrays.
     * Time complexity O(min(l,r))+O(m(log m))+o(n(log n))
     */
    static void mergeSortedArrayWithoutExtraSpace(int[] nums1,int m,int[] nums2,int n){
        int l=m-1;
        int r=0;
        while(l>=0 && r<n){
            if(nums1[l] > nums2[r]){
                swap(nums1,nums2,l,r);
                r++;
                l--;
            }
            else{
                break;
            }
        }

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        System.out.println("\nPrinting result 1");
        printArray(nums1);
        System.out.println("\nPrinting result 2");
        printArray(nums2);
    }


    /**
     *O((n+m)*log(n+m)), where n and m are the sizes of the given arrays.
     * The gap is ranging from n+m to 1 and every time the gap gets divided by 2.
     * So, the time complexity of the outer loop will be O(log(n+m)).
     * Now, for each value of the gap, the inner loop can at most run for (n+m) times.
     * So, the time complexity of the inner loop will be O(n+m).
     * So, the overall time complexity will be O((n+m)*log(n+m)).
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    static void mergeSortedArrayWithoutExtraSpaceGapMethod(int[] nums1,int m,int[] nums2,int n){
        int len=m+n;
        int gap = len/2 + len%2;
        while(gap > 0){
            int left = 0;
            int right = left + gap;
            while(right < len){
                //pointer 1 is on nums1 and pointer 2 is on nums2
                if(left < m && right >= m){
                    swapIfGreater(nums1,nums2,left, right-m);
                }
                //both pointers are on nums2
                else if (left >= m){
                    swapIfGreater(nums2,nums2,left-m, right-m);
                }
                else{
                    swapIfGreater(nums1,nums1,left, right);
                }
                left++;right++;
            }
            if(gap == 1) break;
            gap = gap/2 + gap%2;
        }

        System.out.println("\nPrinting result 1");
        printArray(nums1);
        System.out.println("\nPrinting result 2");
        printArray(nums2);
    }

    static void swapIfGreater(int[] nums1,int[] nums2,int ind1,int ind2){
       if(nums1[ind1] > nums2[ind2]){
           swap(nums1,nums2,ind1,ind2);
       }
    }
    static void swap(int[] nums1,int[] nums2,int ind1,int ind2){
        int temp = nums1[ind1];
        nums1[ind1] = nums2[ind2];
        nums2[ind2] = temp;
    }
    static void printArray(int[] arr){
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }
    public static void main(String[] args){
        int[] nums1 = {1,2,3};
        int[] nums2 = {1,2,3};
        //mergeSortedArrayWithExtraSpace(nums1,nums1.length,nums2,nums2.length);
        //mergeSortedArrayWithoutExtraSpace(nums1,nums1.length,nums2,nums2.length);
        mergeSortedArrayWithoutExtraSpaceGapMethod(nums1,nums1.length,nums2,nums2.length);

    }
}
