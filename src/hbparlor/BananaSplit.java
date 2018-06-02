package hbparlor;

/*Banana Split class which extends the serving class*/

public class BananaSplit extends Serving {
    public IceCream[] scoops = new IceCream[3];
    public int[] sauces = new int[3];
    public boolean dezNuts;
    
    //Constructor to set default settings
    public void BananaSplit(){
        this.scoops[0] = null;
        this.scoops[1] = null;
        this.scoops[2] = null;
        this.dezNuts = false;
    } 
        
    public void addIC(IceCream type, int j){   
        this.scoops[j-1] = type;
        this.servePrice = type.getPrice() + this.servePrice;   
        
    }
    
    
    
    public void setNut(){
        this.dezNuts = true;
        this.servePrice += 2.00;
    }
    
    public void setSauce(int num, int place){
        this.sauces[place] = num;
        
    }
    
}
