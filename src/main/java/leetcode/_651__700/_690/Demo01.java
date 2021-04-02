package leetcode._651__700._690;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Demo01 {

    @SuppressWarnings("all")
    private class Employee {
        private int id;
        private int importance;
        private List<Integer> subordinates;
    }


    @Test
    public void test() {
        System.out.println(getImportance(new ArrayList<>(), 1));
    }

    private int getImportance(List<Employee> employees, int id) {
        int sum = 0;
        for (Employee employee : employees) {
            if (employee.id == id) {
                sum += employee.importance;
                for (Integer subordinate : employee.subordinates) {
                    sum += getImportance(employees, subordinate);
                }
                break;
            }
        }
        return sum;
    }

}