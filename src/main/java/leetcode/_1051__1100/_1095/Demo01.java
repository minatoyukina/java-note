package leetcode._1051__1100._1095;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(findInMountainArray(1, new MountainArray() {

            List<Integer> list = Arrays.asList(1, 5, 2);

            @Override
            public int get(int index) {
                return list.get(index);
            }

            @Override
            public int length() {
                return list.size();
            }
        }));
        System.out.println(findInMountainArray(2, new MountainArray() {

            List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 3, 1);

            @Override
            public int get(int index) {
                return list.get(index);
            }

            @Override
            public int length() {
                return list.size();
            }
        }));
    }

    private int findInMountainArray(int target, MountainArray mountainArr) {
        if (mountainArr == null) return -1;
        return dfs(target, mountainArr, 0, mountainArr.length() - 1);

    }

    private int dfs(int target, MountainArray arr, int left, int right) {
        int mid = (left + right) / 2;
        if (left == mid) {
            if (arr.get(left) == target) return left;
            else if (arr.get(right) == target) return right;
            return -1;
        }
        int pivot = arr.get(mid);
        if ((mid >= 1 && pivot > arr.get(mid - 1)) || (mid < arr.length() - 1 && pivot < arr.get(mid + 1))) {
            if (pivot > target) {
                int min = dfs(target, arr, left, mid);
                if (min != -1) return min;
                return dfs(target, arr, mid, right);
            } else if (pivot < target) return dfs(target, arr, mid, right);
            else return mid;
        } else {
            if (pivot > target) {
                int min = dfs(target, arr, left, mid);
                if (min != -1) return min;
                return dfs(target, arr, mid, right);
            } else if (pivot < target) return dfs(target, arr, left, mid);
            else {
                int l = dfs(target, arr, left, mid);
                if (l != -1) return l;
                return mid;
            }
        }
    }
}