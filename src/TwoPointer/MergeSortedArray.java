package TwoPointer;

public class MergeSortedArray {
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

        while(left<m){
            result[index++] = nums1[left++];
        }

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
        int[] nums2 = {4,5,6};
        mergeSortedArrayWithExtraSpace(nums1,nums1.length,nums2,nums2.length);

    }
}
