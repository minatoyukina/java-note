package leetcode._601__650._636;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(Arrays.toString(exclusiveTime(2, Arrays.asList("0:start:0,0:start:2,0:end:5,1:start:6,1:end:6,0:end:7".split(",")))));
        System.out.println(Arrays.toString(exclusiveTime(1, Arrays.asList("0:start:0,0:end:0".split(",")))));
    }

    private int[] exclusiveTime(int n, List<String> logs) {
        int[] ans = new int[n];
        Stack<int[]> stack = new Stack<>();
        Stack<int[]> list = new Stack<>();
        for (String log : logs) {
            String[] ss = log.split(":");
            int idx = Integer.parseInt(ss[0]), sec = Integer.parseInt(ss[2]);
            if (ss[1].equals("start")) {
                if (!stack.isEmpty()) ans[stack.peek()[0]] += sec - list.peek()[1] + (list.peek()[0] == 1 ? 0 : -1);
                stack.push(new int[]{idx, sec});
            } else {
                stack.pop();
                ans[idx] += sec - list.peek()[1] + (list.peek()[0] == 1 ? 1 : 0);
            }
            list.add(new int[]{ss[1].equals("start") ? 1 : 0, sec});
        }
        return ans;

    }

}