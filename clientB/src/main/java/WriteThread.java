import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @description: 客户端发送数据线程
 * @author: hejiale
 * @create: 2020/03/09 22:04
 */
public class WriteThread implements Runnable {

    private Socket clientSocket;
    private Scanner keyboardScanner;
    private PrintStream writer;
    private String msg;

    public WriteThread(Socket socket) {
        this.clientSocket = socket;
        this.keyboardScanner = new Scanner(System.in);
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
    public void run() {
        try {
            this.writer = new PrintStream(this.clientSocket.getOutputStream());
            while (keyboardScanner.hasNextLine()) {
                this.msg = keyboardScanner.nextLine();
                this.writer.println(clientSay(this.msg));
                //退出循环
                if ("end".equals(this.msg)){
                    break;
                }
            }
            //断开连接
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("客户端B，已经离线");
    }

    private static String clientSay(String msg) {
        return "我：" + msg;
    }

}
