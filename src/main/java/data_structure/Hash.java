package data_structure;

public class Hash {
    private static int hash1(String key, int tableSize) {
        int hashVal = 0;
        for (int i = 0; i < key.length(); i++) {
            hashVal += key.charAt(i);
        }
        return hashVal % tableSize;
    }

    private static int hash2(String key, int tableSize) {
        return (key.charAt(0) + 27 * key.charAt(1) + 729 * key.charAt(2)) % tableSize;
    }

    private static int hash3(String key, int tableSIze) {
        int hashVal = 0;
        for (int i = 0; i < key.length(); i++) {
            hashVal = 37 * hashVal + key.charAt(i);
        }
        hashVal %= tableSIze;
        if (hashVal < 0)
            hashVal += tableSIze;
        return hashVal;
    }

    public static void main(String[] args) {
        System.out.println(hash1("hello", 10_007));
        System.out.println(hash2("hello", 10_007));
        System.out.println(hash3("hello", 10_007));
    }
}
