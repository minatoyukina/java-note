package leetcode._101__150._136;

import org.junit.Test;

import java.util.Arrays;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(singleNumber(new int[]{4, 4, 3, 4, 1, 2, 2}));
        System.out.println(singleNumber(new int[]{2, 2, 1}));
    }

    private int singleNumber(int[] nums) {
//        LinkedList<Integer> q = Arrays.stream(nums).boxed().sorted().collect(Collectors.toCollection(LinkedList::new));
//        Integer tmp = null;
//        while (q.size() >= 2) {
//            int b = q.peekFirst();
//            if (q.get(0).equals(q.get(1)))
//                tmp = b;
//            else if (!Objects.equals(tmp, b)) break;
//            q.pollFirst();
//        }
//
        if (nums.length < 2) return nums[0];
        Arrays.sort(nums);
        int tmp = nums[1];
        for (int i = 0; i < nums.length - 1; i++)
            if (nums[i] == nums[i + 1])
                tmp = nums[i];
            else if (tmp != nums[i]) return nums[i];
        return nums[nums.length - 1];
    }
}
