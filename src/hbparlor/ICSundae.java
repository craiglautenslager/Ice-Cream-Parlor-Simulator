package hbparlor;

/*Ice Cream Sundae Class that extends the serving class
 */
public class ICSundae extends Serving {
    public IceCream[] scoops = new IceCream[2];
    public int sauce;
    public boolean dezNuts;
    
    public void ICSundae(){
        this.scoops[0] = null;
        this.scoops[1] = null;
        this.servePrice = 1.00;
        this.sauce = 0;
        this.dezNuts = false;
    }
    
    public void addIC(IceCream type, int j){   
        this.scoops[j-1] = type;
        this.servePrice = servePrice + type.getPrice();   
        
    }
    
    public void setSauce(int num){
        this.sauce = num;

    }
    
    public void setNut(){
        this.dezNuts = true;

    }
}
