import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ChameleonList {
	
	private int clientCounter;
    private List<Chameleon> chameleons;

    public ChameleonList() {
    	chameleons = new ArrayList<>();
        clientCounter = 0;
    }
    
    public int getCounter() {
    	return clientCounter;
    }
    
    public void setCounter(int i) {
    	clientCounter = i;
    }

    public void add(Chameleon client) {
    	chameleons.add(client);
    }

    public void delete(Chameleon c) throws IOException {
        c.getreader().close();
        c.getwriter().close();
        c.getSocket().close();
        chameleons.remove(c);
    }
    
    public void manageMutation(Chameleon c1, Chameleon c2, String color) {
        c1.getwriter().println(color);
        c2.getwriter().println(color);
        System.out.println("la mutation est fini et Mon couleur est:" +color);
        c1.setColor(null);
        clientCounter--;
    }

  
    public synchronized void makeMutation(Chameleon c, String color) {
    	chameleons.stream().filter((cameneon) -> (cameneon.getColor() != null)).forEach((cameneon) -> {
            if (cameneon.getColor().equals(color)) {
                manageMutation(cameneon, c, color);
            } else if ((color.equals("Rouge") && cameneon.getColor().equals("Bleu")) || (color.equals("Bleu") && cameneon.getColor().equals("Rouge"))) {
                manageMutation(cameneon, c, "Jaune");
            } else if ((color.equals("Jaune") && cameneon.getColor().equals("Bleu")) || (color.equals("Bleu") && cameneon.getColor().equals("Jaune"))) {
                manageMutation(cameneon, c, "Rouge");
            } else if ((color.equals("Jaune") && cameneon.getColor().equals("Rouge")) || (color.equals("Rouge") && cameneon.getColor().equals("Jaune"))) {
                manageMutation(cameneon, c, "Bleu");
            }
        });
    }
    
}
