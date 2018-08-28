import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ManageChameleons implements Runnable{

    private final Chameleon chameleon;
    private final ChameleonList chameleonsList;

   
    public ManageChameleons(Socket socket, ChameleonList listechameleon) throws IOException {
        this.chameleon = new Chameleon(socket);
        this.chameleonsList = listechameleon;
        this.chameleonsList.add(chameleon);
    }

   
    @Override
    public void run() {

        try {
            System.out.println(chameleon.getSocket().getRemoteSocketAddress());
            String line;
            while (!(line = chameleon.getreader().readLine()).equals(".")) {
                System.out.println("Server trace the color is "+line);
                if (chameleonsList.getCounter() == 0) {
                    chameleon.setColor(line);
                    chameleonsList.setCounter(chameleonsList.getCounter());;
                } else {
                	chameleonsList.makeMutation(this.chameleon, line);
                }

            }
            chameleon.getwriter().println(".");;
        } catch (IOException ex) {
            Logger.getLogger(this.getClass().getSimpleName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
            	chameleonsList.delete(chameleon);
            } catch (IOException ex) {
                Logger.getLogger(this.getClass().getSimpleName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
