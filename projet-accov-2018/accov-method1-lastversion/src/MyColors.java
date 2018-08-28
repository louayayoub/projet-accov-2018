public class MyColors {

    private int id;

    public MyColors(int code) {
        id = code % 3;
    }

     // this method can be change color of chameleon
    
    public MyColors changerCouleur(MyColors chameleonColor) {
        if (id == chameleonColor.getId()) {
            return new MyColors(id);
        }
        return new MyColors(3 - id - chameleonColor.getId());
    }
    
    public int getId() {
    	return id;
    }
    public String toString() {
    	switch(id) {
    	case 0:return Palette.BLUE.getName();
    	case 1:return Palette.RED.getName();
    	case 2:return Palette.YELLOW.getName();
    	default:return null;
    	}
    }

}
