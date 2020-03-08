import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @description: 服务端socket连接器
 * @author: hejiale
 * @create: 2020/03/06 10:55
 */
public class ServerProcesserThread implements Runnable {
    /**
     * 与客户端建立连接的socket
     */
    private Socket socket;
    /**
     * 给客户端发送消息
     */
    private PrintStream printStream;
    /**
     * 从客户端接收消息
     */
    private Scanner receive;

    ServerProcesserThread(Socket socket) throws IOException {
        this.socket = socket;
        this.printStream = new PrintStream(socket.getOutputStream());
        this.receive = new Scanner(socket.getInputStream());
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        try {
            String clientMsg = "";
            String serverMsg = "";

            //键盘输入
            Scanner scanner = new Scanner(System.in);
            while (true) {
                //发送给客户端
                if (scanner.hasNextLine()) {
                    serverMsg = scanner.nextLine();
                    printStream.println(serverMsg);
                    System.out.println(serverSay(serverMsg));
                }
                if ("end".equals(serverMsg)) {
                    break;
                }

                if (receive.hasNext()) {
                    clientMsg = receive.nextLine();
                    System.out.println(clientSay(clientMsg));
                }
                // end 结束通信
                if ("end".equals(clientMsg)) {
                    break;
                }
            }
            System.out.println("与客户端断开连接");
            //关闭连接
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String serverSay(String msg) {
        return "我：" + msg;
    }

    private String clientSay(String msg) {
        return "客户端：" + msg;
    }
}
