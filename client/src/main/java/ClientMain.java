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
            if(scanner.hasNextLine()){
                System.out.println(scanner.nextLine());
            }
            //保持连接，测试多个客户端连接服务端
            Thread.sleep(100000);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
