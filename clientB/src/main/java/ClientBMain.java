import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description:
 * @author: hejiale
 * @create: 2020/03/02 22:03
 */
public class ClientBMain {

    public static void main(String[] args) {
        //线程池
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        try {
            Socket socket = new Socket("127.0.0.1", 8899);

            executorService.execute(new ReadThread(socket));
            executorService.execute(new WriteThread(socket));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
