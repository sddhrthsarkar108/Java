package inheritance;

import java.io.IOException;

class AB {
    public static void get() throws IOException {
        System.out.println("parent version");
    }

    public  void put() {

    }
}

public class MethodHiding extends AB {

    //static void get() throws Exception { // CE
    public static void get() throws IOException {
        System.out.println("child version");
    }

    public static void main(String[] args) throws IOException {
        AB ab = new MethodHiding();
        ab.get();
    }

//    static void put() { // CE
//
//    }
}
