package leetcode.summary;

import org.junit.Test;

import java.util.*;

/**
 * @author ccq
 * @since 2021/5/25 15:23
 */
public class Sort {

    @Test
    public void test() {
        System.out.println(Arrays.toString(bubbleSort(new int[]{4, 1, 3, 5, 2, 7, 6})));
        System.out.println(Arrays.toString(selectSort(new int[]{4, 1, 3, 5, 2, 7, 6})));
        System.out.println(Arrays.toString(insertSort(new int[]{4, 1, 3, 5, 2, 7, 6})));
        System.out.println(Arrays.toString(shellSort(new int[]{4, 1, 3, 5, 2, 7, 6})));
        System.out.println(Arrays.toString(quickSort(new int[]{4, 1, 3, 5, 2, 7, 6})));
        System.out.println(Arrays.toString(mergeSort(new int[]{4, 1, 3, 5, 2, 7, 6})));
        System.out.println(Arrays.toString(heapSort(new int[]{4, 1, 3, 5, 2, 7, 6})));
        System.out.println(Arrays.toString(countingSort(new int[]{4, 1, 3, 5, 2, 7, 6})));
        System.out.println(Arrays.toString(bucketSort(new int[]{4, 1, 3, 5, 2, 7, 6})));
        System.out.println(Arrays.toString(radixSort(new int[]{4, 1, 3, 5, 2, 7, 6})));
    }

    private int[] bubbleSort(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
        return arr;
    }

    private int[] selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[index]) index = j;
            }
            if (i != index) {
                int tmp = arr[i];
                arr[i] = arr[index];
                arr[index] = tmp;
            }
        }
        return arr;
    }

    private int[] insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int tmp = arr[i];
            int j = i;
            while (j > 0 && tmp < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = tmp;
        }
        return arr;
    }

    private int[] shellSort(int[] arr) {
        int len = arr.length;
        for (int step = len / 2; step > 0; step /= 2) {
            for (int i = step; i < len; i++) {
                int tmp = arr[i];
                int j = i - step;
                while (j >= 0 && arr[j] > tmp) {
                    arr[j + step] = arr[j];
                    j -= step;
                }
                arr[j + step] = tmp;
            }
        }
        return arr;
    }

    private int[] quickSort(int[] arr) {
        qSort(arr, 0, arr.length - 1);
        return arr;
    }

    private void qSort(int[] arr, int start, int end) {
        if (start >= end) return;
        int pivot = arr[start];
        int i = start, j = end;
        while (i < j) {
            while (i < j && arr[i] < pivot) i++;
            while (i < j && arr[j] > pivot) j--;
            if (i < j && arr[i] == arr[j]) i++;
            else {
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }
        qSort(arr, start, i - 1);
        qSort(arr, j + 1, end);
    }

    private int[] mergeSort(int[] arr) {
        mSort(arr, new int[arr.length], 0, arr.length - 1);
        return arr;
    }

    @SuppressWarnings("all")
    private void mSort(int[] arr, int[] res, int start, int end) {
        if (start >= end) return;
        int mid = start + (end - start) / 2;
        int start1 = start, start2 = mid + 1;
        mSort(arr, res, start1, mid);
        mSort(arr, res, start2, end);
        int k = start;
        while (start1 <= mid && start2 <= end) {
            if (arr[start1] < arr[start2]) res[k++] = arr[start1++];
            else res[k++] = arr[start2++];
        }
        while (start1 <= mid) res[k++] = arr[start1++];
        while (start2 <= end) res[k++] = arr[start2++];
        for (int i = start; i <= end; i++) arr[i] = res[i];
    }

    private int[] heapSort(int[] arr) {
        int len = arr.length;
        buildMaxHeap(arr, len);
        for (int i = len - 1; i >= 0; i--) {
            int tmp = arr[0];
            arr[0] = arr[i];
            arr[i] = tmp;
            heapify(arr, 0, --len);
        }
        return arr;
    }

    private void buildMaxHeap(int[] arr, int len) {
        for (int i = (int) Math.floor(len / 2); i >= 0; i--) {
            heapify(arr, i, len);
        }
    }

    private void heapify(int[] arr, int i, int len) {
        int left = 2 * i + 1;
        int right = left + 1;
        int max = i;
        if (left < len && arr[left] > arr[max]) max = left;
        if (right < len && arr[right] > arr[max]) max = right;
        if (max != i) {
            int tmp = arr[i];
            arr[i] = arr[max];
            arr[max] = tmp;
            heapify(arr, max, len);
        }
    }

    private int[] countingSort(int[] arr) {
        int max = arr[0];
        for (int i : arr) max = Math.max(max, i);
        int[] bucket = new int[max + 1];
        for (int i : arr) bucket[i]++;
        int index = 0;
        for (int i = 0; i <= max; i++) {
            while (bucket[i] > 0) {
                arr[index++] = i;
                bucket[i]--;
            }
        }
        return arr;
    }

    @SuppressWarnings("unchecked")
    private int[] bucketSort(int[] arr) {
        int max = arr[0], min = arr[0];
        for (int i : arr) {
            max = Math.max(max, i);
            min = Math.min(min, i);
        }
        int d = max - min;
        int bucketNum = 3;
        List<Integer>[] bucketList = new List[bucketNum];
        for (int i = 0; i < bucketNum; i++) bucketList[i] = new ArrayList<>();
        for (int i : arr) {
            int num = (i - min) * ((bucketNum - 1) / d);
            bucketList[num].add(i);
        }
        int index = 0;
        for (int i = 0; i < bucketNum; i++) {
            Collections.sort(bucketList[i]);
            for (int j : bucketList[i]) {
                arr[index++] = j;
            }
        }
        return arr;
    }

    @SuppressWarnings("all")
    private int[] radixSort(int[] arr) {
        int max = arr[0];
        for (int i : arr) max = Math.max(max, i);
        int maxDigit = 0;
        for (int i = max; i != 0; i /= 10) maxDigit++;
        if (maxDigit == 0) maxDigit = 1;
        int mod = 10, dev = 1;
        for (int i = 0; i < maxDigit; i++, dev *= 10, mod *= 10) {
            Queue<Integer>[] counter = new Queue[mod * 2];
            for (int num : arr) {
                int bucket = ((num % mod) / dev) + mod;
                if (counter[bucket] == null) counter[bucket] = new LinkedList<>();
                counter[bucket].add(num);
            }
            int index = 0;
            for (Queue<Integer> aCounter : counter) {
                if (aCounter != null) {
                    while (!aCounter.isEmpty()) arr[index++] = aCounter.poll();
                }
            }
        }
        return arr;
    }
}
