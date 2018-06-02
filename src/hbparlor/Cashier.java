package hbparlor;

/*Cashier class that extends the regular worker*/
public class Cashier extends Worker {
    public int patience;
    public boolean onBreak;
    public boolean overLoad = false;
    
    //Constructor sets super as well as patiance
    public Cashier(String name) {
        super(name);
        this.patience = 18;
        this.onBreak = true;
    }
    
    public void setOnbreak(){
        this.onBreak = true;
    }
    
    public void setOffbreak(){
        this.onBreak = false;
    }
    
    public void decPat(){
        if(patience == 0){
            this.overLoad = true;
            
        }
        else{
            this.patience--;
            
        }
    }
    
    public void incPat(){
        if(patience == 0){
            this.overLoad = false;
            this.patience++;
        }
        else if(patience < 20){
            this.patience++;
        }
        
    }
}
