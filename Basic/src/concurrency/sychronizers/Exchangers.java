package concurrency.sychronizers;

import java.util.concurrent.Exchanger;

public class Exchangers {
    public static void main(String[] args) {
//        Exchanger<String> ex = new Exchanger<>();
//        String str = "";
//
//        new Thread(() -> {
//            char c = 'A';
//
//            for(int i=0; i<3; i++) {
//                for (int j=0; j<5; j++) {
//                    str.concat("" + c++);
//                }
//
//                try {
//                    str = new String(ex.exchange(str));
//                } catch (InterruptedException e) {
//
//                }
//            }
//        }).start();
//
//        new Thread(() -> {
//            for(int i=0; i<3; i++) {
//                str = ex.exchange(str);
//            }
//        }).start();
    }
}
