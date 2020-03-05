import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @description:
 * @author: hejiale
 * @create: 2020/03/02 22:03
 */
public class ClientMain {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 8899);
            //输入流
            Scanner scanner = new Scanner(socket.getInputStream());
            //等待服务端建立连接的消息
            while(true) {
                if (scanner.hasNext()) {
                    System.out.println(scanner.next());
                    break;
                }
            }
            //回复消息
            System.out.println("客户端： 已经成功跟服务端建立连接，请回复：");
            //获取输出流，发送消息
            PrintStream printStream = new PrintStream(socket.getOutputStream());
            Scanner reply = new Scanner(System.in);
            printStream.println(reply.nextLine());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
