public class Walk {

    public MyColors c1Color, c2Color;
    public Boolean thefirstCall = true, youHaveAnother = false;


    public synchronized MyColors joining(MyColors color) {
    	MyColors changedColor;
       
        while (youHaveAnother) {
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }
        if (thefirstCall) {
            c1Color = color;
            thefirstCall = false;
            while (!thefirstCall) {
                try {
                    wait();
                } catch (InterruptedException e) {

                }
            }
            youHaveAnother=false;
            changedColor=c2Color;
            notifyAll();
        }
        else{
            c2Color=color;
            changedColor=c1Color;
            thefirstCall=true;
            youHaveAnother=true;
            notifyAll();
        }
        return changedColor;
    }
}
