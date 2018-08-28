//class that create Chameleon with id and color after creation he has to meet his partnere to make a transfer 

public class Chameleon implements Runnable {
	
	public static int counter=1;
	private int id;
	public MyColors currentColor, anotherColor;
    public Walk walk;

    public Chameleon(MyColors couleur , Walk promenade) {
    	walk = promenade;
        id=counter++;
        currentColor = couleur;
    }
    
    //method can be check state of Chameleon
    public void check(String status) {
        System.out.println("id:" + this.id + " color:" + this.currentColor + "  state:" + status);
    }

   
    public void eating() {
        this.check("I am eating");
    }

    
    public void training() {
        this.check("I'm training");
    }

   
    public void goToWalk() {
        this.check("I want to go to the walk");
    }

    
    public void makeMutation() {
        this.check("make a transfer");
        this.anotherColor=walk.joining(currentColor);
        this.currentColor=this.currentColor.changerCouleur(anotherColor);
        this.check("mutation is finished");
    }

   
    public void run() {
        while (true) {
        	eating();
        	training();
        	goToWalk();
            makeMutation();
        }
    }
}
