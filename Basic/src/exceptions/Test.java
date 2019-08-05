package exceptions;

import java.io.IOException;

public class Test {
    int m1() {
        try {
            return 0;
        }
        catch (Exception e) {
            return 1;
        }
        finally {
            // 2 would be returned
            return 2;
        }
    }

    void m2() {
        throw new ArithmeticException();
    }

    void m3() throws IOException {
        throw new IOException();
    }

    public static void main(String[] args) {
        Test t = new Test();
        System.out.println(t.m1());
    }
}
