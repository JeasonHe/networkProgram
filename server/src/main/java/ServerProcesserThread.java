import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

/**
 * @description: 服务端socket连接器
 * @author: hejiale
 * @create: 2020/03/06 10:55
 */
public class ServerProcesserThread implements Runnable{
    /**
     * 与客户端建立连接的socket
     */
    private Socket socket;
    /**
     * 给客户端发送消息
     */
    private PrintStream printStream;

    public ServerProcesserThread(Socket socket) throws IOException {
        this.socket = socket;
        this.printStream = new PrintStream(socket.getOutputStream());
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
            //回复客户端
            printStream.println("成功建立连接");
            //关闭连接
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
