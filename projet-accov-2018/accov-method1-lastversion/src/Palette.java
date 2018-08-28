
public enum Palette{
	
	BLUE(0,"blue"),RED(1,"red"),YELLOW(2,"yellow");
	
	private int code;
	private String name;
	
    private Palette(int code,String name){
    	this.code = code;
    	this.name=name;
    }
    public int getCode(){
    	return code;
    }
    public String getName() {
    	return name;
    }
}
