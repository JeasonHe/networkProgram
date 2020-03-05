import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

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
            Socket client = serverSocket.accept();
            //输出流
            PrintStream printStream = new PrintStream(client.getOutputStream());
            //回复建立连接
            printStream.println("你好，我是服务端，已成功建立连接。");
            //获取输入流
            Scanner scanner = new Scanner(client.getInputStream());
            try {
                while (true) {
                    if (scanner.hasNext()) {
                        System.out.println(scanner.next());
                        //断开
                        client.close();
                        break;
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            } finally {
                client.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
