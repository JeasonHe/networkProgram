import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @description:
 * @author: hejiale
 * @create: 2020/03/02 22:04
 */
public class ServerMain {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8899);
            //等待客户端建立连接
            Socket accept = serverSocket.accept();
            System.out.println("与客户端成功建立连接");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
