package leetcode.lcof;

import org.junit.Test;

public class Demo51 {

    @Test
    public void test() {
        System.out.println(reversePairs(new int[]{7, 5, 6, 4}));
        System.out.println(reversePairs(new int[]{1, 3, 2, 3, 1}));
    }

    private int ans;

    private int reversePairs(int[] nums) {
        ans = 0;
        int[] result = new int[nums.length];
        mergeSort(nums, result, 0, nums.length - 1);
        return ans;
    }

    private void mergeSort(int[] arr, int[] result, int start, int end) {
        if (start >= end) return;
        int mid = start + (end - start) / 2;
        int start1 = start, start2 = mid + 1;
        mergeSort(arr, result, start1, mid);
        mergeSort(arr, result, start2, end);
        int k = start;
        while (start1 <= mid && start2 <= end) {
            if (arr[start1] <= arr[start2]) result[k++] = arr[start1++];
            else {
                ans += mid - start1 + 1;
                result[k++] = arr[start2++];
            }
        }
        while (start1 <= mid) result[k++] = arr[start1++];
        while (start2 <= end) result[k++] = arr[start2++];
        System.arraycopy(result, start, arr, start, end + 1 - start);
    }
}
