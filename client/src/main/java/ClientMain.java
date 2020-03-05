import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @description:
 * @author: hejiale
 * @create: 2020/03/02 22:03
 */
public class ClientMain {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 8899);
        } catch (IOException e) {


        }

    }
}
