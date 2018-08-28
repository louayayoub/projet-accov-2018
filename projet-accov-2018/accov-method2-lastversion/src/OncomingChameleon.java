import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OncomingChameleon implements Runnable {

    private final PrintWriter writer;
    private final BufferedReader reader;
    private String color;

    public OncomingChameleon(BufferedReader reader, PrintWriter writer, String color) {
        this.reader = reader;
        this.writer = writer;
        this.color = color;
    }

   
    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("I am eating");
                System.out.println("I'm training");
                try {
                    Thread.sleep(2500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(this.getClass().getSimpleName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("I want to go to the walk");
                try {
                    Thread.sleep(2500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(this.getClass().getSimpleName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("I want to make a change My color : " + color);
                try {
                    Thread.sleep(2500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(this.getClass().getSimpleName()).log(Level.SEVERE, null, ex);
                }
                String line;
                writer.print(color);
                writer.flush();
                if ((line = reader.readLine()) != null) {
                    color = line;
                    System.out.println("Mutation is finished and My color is: " + color);

                }
            } catch (IOException ex) {
                Logger.getLogger(this.getClass().getSimpleName()).log(Level.SEVERE, null, ex);
            }

        }
    }
}
