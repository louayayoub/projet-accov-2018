public class Game {
	
   
    public static MyColors[] colors={new MyColors(Palette.BLUE.getCode()),new MyColors(Palette.YELLOW.getCode()),new MyColors(Palette.BLUE.getCode()),new MyColors(Palette.RED.getCode()),new MyColors(Palette.BLUE.getCode())};
    
    public static Chameleon[] chameleons=new Chameleon[colors.length];
    
    public static void main(String args[]){
    	
    	
    	Walk currentPromenade=new Walk();
        
        for(int i =0;i<colors.length;i++){
        	chameleons[i]=new Chameleon(colors[i],currentPromenade);
            new Thread(chameleons[i]).start();            
            
        }
    }
    
}
