package exceptions;

class OpenException extends Exception {}
class CloseException extends Exception {}

public class PreciseRethrow {

    public static void main(String [] args) throws OpenException, CloseException {
        boolean flag = true;

        try {
            if (flag){
                throw new OpenException();
            }
            else {
                throw new CloseException();
            }
        }
        // in Java 6, the following code snippet will generate the following compiler error:
        // Unhandled exception type Exception
        catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }
}
