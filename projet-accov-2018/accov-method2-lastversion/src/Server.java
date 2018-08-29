import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    final static int PORT = 1231;
	private static ServerSocket serverSocket;

    public static void main(String[] args) throws IOException {

    	ChameleonList list = new ChameleonList();
    	service(list);
    }

    public static void service(ChameleonList l) throws IOException {
        serverSocket = new ServerSocket(PORT);
        System.out.println(serverSocket.getLocalSocketAddress());
        while (true) {
            Socket serviceSocket = serverSocket.accept();
            Thread nc = new Thread(new ManageChameleons(serviceSocket, l));
            nc.setDaemon(true);
            nc.start();
        }
        
    }
}
