import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Game {

    public static void main(String[] args) throws IOException, InterruptedException {
    	Scanner sc = new Scanner(System.in);
        Socket socket = null;
        String couleurCameneonCourant = "";
        
        try {
            socket = new Socket("localhost", Server.PORT);
            System.out.println(socket.getLocalSocketAddress());
            
            BufferedReader read = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter send = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
            do {
            	
            	
                System.out.println("Choose a color for the cameneon who wants to connect:");
                System.out.println("Choose one of the colors: Yellow, Red, Blue");
                
                
                couleurCameneonCourant = sc.nextLine();
            } while (!couleurExiste(capitalizerPremierLetter(couleurCameneonCourant)));
            
            
            Thread thread = new Thread(new OncomingChameleon(read, send,"."));
            thread.start();
            thread.join();
        } finally {
            if (socket != null) {
                socket.close();
               sc.close();
            }
            
        }
    }
    
    
    public static boolean couleurExiste(String couleur) {
        return (couleur.equals("Red") || couleur.equals("Yellow") || couleur.equals("Blue"));
    }

  
    public static String capitalizerPremierLetter(String couleur) {
        if (couleur == null || couleur.length() == 0) {
            return couleur;
        }
        return couleur.substring(0, 1).toUpperCase() + couleur.substring(1);
    }
}
