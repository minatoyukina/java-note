package data_structure.adt;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class SeparatedChainingHashTable<T> {
    public static final int DEFAULT_TABLE_SIZE = 101;
    private int currentSize;
    private List<T>[] theLists;

    public SeparatedChainingHashTable() {
        this(DEFAULT_TABLE_SIZE);
    }

    public SeparatedChainingHashTable(int size) {
        theLists = new LinkedList[nextPrime(size)];
        for (int i = 0; i < theLists.length; i++) {
            theLists[i] = new LinkedList<>();
        }
    }

    public void insert(T x) {
        List<T> whichList = theLists[myhash(x)];
        if (!whichList.contains(x)) {
            whichList.add(x);
            if (++currentSize > theLists.length)
                rehash();
        }
    }

    public void remove(T x) {
        List<T> whichList = theLists[myhash(x)];
        if (whichList.contains(x)) {
            whichList.remove(x);
            currentSize--;
        }
    }

    public boolean contains(T x) {
        List<T> whichList = theLists[myhash(x)];
        return whichList.contains(x);
    }

    public void makeEmpty() {
        for (List<T> theList : theLists) {
            theList.clear();
        }
        currentSize = 0;
    }

    private void rehash() {
        List<T>[] oldLists = theLists;
        theLists = new List[nextPrime(2 * theLists.length)];
        for (int j = 0; j < theLists.length; j++) {
            theLists[j] = new LinkedList<>();
        }
        currentSize = 0;
        for (int i = 0; i < oldLists.length; i++) {
            for (T item : oldLists[i]) {
                insert(item);
            }
        }
    }

    private int myhash(T x) {
        int hashVal = x.hashCode();
        hashVal %= theLists.length;
        if (hashVal < 0)
            hashVal += theLists.length;
        return hashVal;
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
        for (int i = 0; i < theLists.length; i++) {
            Iterator<T> iterator = theLists[i].iterator();
            while (iterator.hasNext())
                System.out.print(iterator.next() + " ");
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        SeparatedChainingHashTable<Integer> hashTable = new SeparatedChainingHashTable<>();
        for (int i = 0; i < 30; i++) {
            hashTable.insert(random.nextInt(30));
        }
        System.out.println(hashTable.currentSize);
        System.out.println(hashTable.theLists.length);
        hashTable.printTable();
    }
}
