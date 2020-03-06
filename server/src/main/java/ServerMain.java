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
            //建立连接数
            int count = 0;
            while (true) {
                System.out.println("当前建立连接数:" + count ++);
                //等待客户端建立连接
                Socket client = serverSocket.accept();
                //创建一个线程去跟客户端
                ServerProcesserThread serverProcesserThread = new ServerProcesserThread(client);
                new Thread(serverProcesserThread).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
