import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @description:
 * @author: hejiale
 * @create: 2020/03/02 22:03
 */
public class ClientAMain {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 8899);
            //输入流
            Scanner serverContent = new Scanner(socket.getInputStream());
            PrintStream printStream = new PrintStream(socket.getOutputStream());
            // 键盘输入
            Scanner keyboardScanner = new Scanner(System.in);

            String serverMsg = "";
            String clientMsg = "";

            while (true) {
                // 接收服务端消息
                if (serverContent.hasNextLine()) {
                    serverMsg = serverContent.nextLine();
                    System.out.println(serverSay(serverMsg));
                }
                if("end".equals(serverMsg)){
                    break;
                }
                //发送给服务端
                if(keyboardScanner.hasNextLine()){
                    clientMsg = keyboardScanner.nextLine();
                    printStream.println(clientMsg);
                    System.out.println(clientSay(clientMsg));
                }
                if("end".equals(clientMsg)){
                    break;
                }
            }
            System.out.println("与服务端断开连接");
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String serverSay(String msg) {
        return "服务端：" + msg;
    }

    private static String clientSay(String msg) {
        return "我：" + msg;
    }
}
