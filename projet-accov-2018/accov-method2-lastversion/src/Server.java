import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    final static int PORT = 1323;
	private static ServerSocket serverSocket;

    public static void main(String[] args) throws IOException {

    	ChameleonList listeCameneon = new ChameleonList();
        gererServeur(listeCameneon);
    }

    public static void gererServeur(ChameleonList listeCameneon) throws IOException {
        serverSocket = new ServerSocket(PORT);
        System.out.println(serverSocket.getLocalSocketAddress());
        while (true) {
            Socket serviceSocket = serverSocket.accept();
            Thread nc = new Thread(new ManageChameleons(serviceSocket, listeCameneon));
            nc.setDaemon(true);
            nc.start();
        }
        
    }
}
