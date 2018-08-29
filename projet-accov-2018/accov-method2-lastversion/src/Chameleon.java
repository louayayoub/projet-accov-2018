
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Chameleon {

	private final BufferedReader read;
    private final PrintWriter write;
    private Socket socket;
    private String color;

 
    public Chameleon(Socket socket) throws IOException {
        this.socket = socket;
        read = getData(socket);
        write = getPen(socket);
        color = null;
    }
    
    public BufferedReader getreader() {
        return this.read;
    }

    public PrintWriter getwriter() {
        return this.write;

    }
   
    public Socket getSocket() {
        return this.socket;
    }

    
    public String getColor() {
        return color;
    }
    
    public void setSocket(Socket socket) {
        this.socket = socket;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
 
    final BufferedReader getData(Socket socket) throws IOException {
        return new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    final PrintWriter getPen(Socket socket) throws IOException {
        return new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
    }
}
