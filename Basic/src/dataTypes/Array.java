package dataTypes;

public class Array {
    public static void main(String[] args) {
        Object x[] = new String[3];
        // Exception in thread "main" java.lang.ArrayStoreException: java.lang.Integer
        x[0] = Integer.valueOf(0);
    }
}
