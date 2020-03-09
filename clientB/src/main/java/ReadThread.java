import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * @description: 接收服务端消息线程
 * @author: hejiale
 * @create: 2020/03/09 21:50
 */
public class ReadThread implements Runnable {

    private Socket clientSocket;
    private String serverMsg;

    public ReadThread(Socket socket){
        this.clientSocket = socket;
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
            Scanner reader = new Scanner(this.clientSocket.getInputStream());
            while (true)
            {
                // 接收服务端消息
                if (reader.hasNextLine())
                {
                    serverMsg = reader.nextLine();
                    System.out.println(serverSay(serverMsg));
                }

                if ("end".equals(serverMsg))
                {
                    break;
                }
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static String serverSay(String msg) {
        return "服务端：" + msg;
    }
}
