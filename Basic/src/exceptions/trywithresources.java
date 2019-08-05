package exceptions;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class trywithresources {
    void m1() throws Exception {
        InputStream is = new FileInputStream(new File(""));

        try(is) {
            // this would cause compilation error since reference used in
            // try must be effectively final.
            // is = new FileInputStream(new File(""));
        }
    }
}
