package data_structure.adt;

import java.util.Iterator;
import java.util.Random;

public class QuadraticProbingHashTable<T> {
    private static final int DEFAULT_TABLE_SIZE = 11;
    private HashEntry<T>[] array;
    private int currentSize;

    private static class HashEntry<T> {
        public T element;
        public boolean isActive;

        public HashEntry(T e) {
            this(e, true);
        }

        public HashEntry(T e, boolean i) {
            element = e;
            isActive = i;
        }
    }

    public QuadraticProbingHashTable(int size) {
        array = new HashEntry[size];
        makeEmpty();
    }

    public QuadraticProbingHashTable() {
        this(DEFAULT_TABLE_SIZE);
    }

    public void makeEmpty() {
        for (int i = 0; i < array.length; i++) {
            array[i] = null;
        }
        currentSize = 0;
    }

    public boolean contains(T x) {
        int currentPos = findPos(x);
        return isActive(currentPos);
    }

    public void insert(T x) {
        int currentPos = findPos(x);
        System.out.println(x + " hash-> " + currentPos);
        if (isActive(currentPos))
            return;
        array[currentPos] = new HashEntry<>(x, true);
        if (++currentPos > array.length / 2)
            rehash();
    }

    public void remove(T x) {
        int currentPos = findPos(x);
        if (isActive(currentPos))
            array[currentPos].isActive = false;
    }

    private int findPos(T x) {
        int offset = 1;
        int currentPos = myhash(x);
        while (array[currentPos] != null && !array[currentPos].element.equals(x)) {
            currentPos += offset;
            offset += 2;
            if (currentPos >= array.length)
                currentPos -= array.length;
        }
        return currentPos;
    }

    private boolean isActive(int currentPos) {
        return array[currentPos] != null && array[currentPos].isActive;
    }

    private int myhash(T x) {
        int hashVal = x.hashCode();
        hashVal %= array.length;
        if (hashVal < 0)
            hashVal += array.length;
        return hashVal;
    }

    private void rehash() {
        HashEntry<T>[] oldArray = array;
        array = new HashEntry[nextPrime(2 * array.length)];
        currentSize = 0;
        for (int i = 0; i < oldArray.length; i++) {
            if (oldArray[i] != null && oldArray[i].isActive)
                insert(oldArray[i].element);
        }
        System.out.println("\nrehash by length of: " + array.length);
    }

    private static int nextPrime(int n) {
        if (n == 0 || n == 1 || n == 2)
            return 2;
        if (n % 2 == 0)
            n++;
        while (!isPrime(n))
            n += 2;
        return n;
    }

    private static boolean isPrime(int n) {
        if (n == 2 || n == 3)
            return true;
        if (n == 1 || n % 2 == 0)
            return false;
        for (int i = 3; i * i <= n; i += 2)
            if (n % i == 0)
                return false;
        return true;
    }

    public void printTable() {
        for (int i = 0; i < array.length; i++) {
            System.out.println("-----");
            if (array[i] != null)
                System.out.println(array[i].element + " ");
            else
                System.out.println();
        }
    }

    public static void main(String[] args) {
        QuadraticProbingHashTable<Integer> hashTable = new QuadraticProbingHashTable<>();
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            hashTable.insert(random.nextInt(60));
        }
        hashTable.printTable();
    }
}
