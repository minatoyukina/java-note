package leetcode.lcci;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ccq
 * @since 2021/4/14 10:39
 */
public class Demo_0306 {

    @Test
    public void test() {
        AnimalShelf q = new AnimalShelf();
        q.enqueue(new int[]{0, 0});
        q.enqueue(new int[]{1, 0});
        q.enqueue(new int[]{2, 1});
        q.dequeueDog();
        q.dequeueCat();
        q.dequeueAny();
    }

    @SuppressWarnings("all")
    class AnimalShelf {

        Queue<Integer> dog = new LinkedList<>();
        Queue<Integer> cat = new LinkedList<>();

        public AnimalShelf() {

        }

        public void enqueue(int[] animal) {
            if (animal[1] == 0) {
                cat.offer(animal[0]);
            } else {
                dog.offer(animal[0]);
            }
        }

        public int[] dequeueAny() {
            if (!dog.isEmpty() && !cat.isEmpty()) {
                if (dog.peek() > cat.peek()) return new int[]{dog.poll(), 1};
                else return new int[]{cat.poll(), 0};
            }
            if (!dog.isEmpty()) return new int[]{dog.poll(), 1};
            if (!cat.isEmpty()) return new int[]{cat.poll(), 0};
            return new int[]{-1, -1};
        }

        public int[] dequeueDog() {
            if (dog.isEmpty()) {
                return new int[]{-1, -1};
            }
            return new int[]{dog.poll(), 1};
        }

        public int[] dequeueCat() {
            if (cat.isEmpty()) {
                return new int[]{-1, -1};
            }
            return new int[]{cat.poll(), 0};
        }
    }


}
