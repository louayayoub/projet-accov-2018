import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ConnectMyClient {

    public static void main(String[] args) throws IOException, InterruptedException {
    	Scanner sc = new Scanner(System.in);
        Socket socket = null;
        String color = "";
        
        try {
            socket = new Socket("localhost", Server.PORT);
            BufferedReader read = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter send = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
            System.out.println(socket.getLocalSocketAddress());
            do {
                System.out.println("Choose a color for the chameleon that wants to connect:");
                System.out.println("Choose one of the colors: Yellow, Red, Blue");
                color = sc.nextLine();
            } while (!colorExiste(capitalizerPremierLetter(color)));

            Thread thread = new Thread(new OncomingChameleon(read, send,color));
            thread.start();
            thread.join();
        } finally {
            if (socket != null) {
                socket.close();
               sc.close();
            }
            
        }
    }
    
    
    public static boolean colorExiste(String color) {
    	switch(color) {
        case "Red":return true;
        case "Yellow":return true;
        case "Blue" :return true;
        default :return false;
        }
    }

  
    public static String capitalizerPremierLetter(String color) {
        return (color == null || color.length() == 0)?color:color.substring(0, 1).toUpperCase() + color.substring(1);
    }
}
