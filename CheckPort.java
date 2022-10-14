
import java.io.IOException;
import java.net.Socket;
public class CheckPort {

    public static boolean available(int port) {
        System.out.println("--------------Testing port " + port);
        Socket s = null;
        try {
            s = new Socket("localhost", port);
            System.out.println("--------------Port " + port + " is not available");
            return false;
        } catch (IOException e) {
            System.out.println("--------------Port " + port + " is available");
            return true;
        }
    }

    public static void main(String[] args) {

            available(1234);
            available(1234);


    }

}
