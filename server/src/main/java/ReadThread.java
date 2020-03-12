import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * @description: 接收客户端消息线程
 * @author: hejiale
 * @create: 2020/03/09 21:50
 */
public class ReadThread implements Runnable {

    private Socket serverSocket;
    private String clientMsg;

    public ReadThread(Socket socket){
        this.serverSocket = socket;
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
            Scanner reader = new Scanner(this.serverSocket.getInputStream());
            while (true)
            {
                // 接收客户端消息
                if (reader.hasNextLine())
                {
                    clientMsg = reader.nextLine();
                    System.out.println(serverSay(clientMsg));
                }

                if ("end".equals(clientMsg))
                {
                    break;
                }
            }
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static String serverSay(String msg) {
        return "客户端：" + msg;
    }
}
