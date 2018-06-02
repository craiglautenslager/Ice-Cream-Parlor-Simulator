package hbparlor;

/*Stocker class which extends the regular worker
 */
public class Stocker extends Worker {
    public int Stamina;
    public boolean onBreak;
    
    public Stocker(String name) {
        super(name);
        this.Stamina = 18;
        this.onBreak = true;
    }
    
    public void setOnbreak(){
        this.onBreak = true;
    }
    
    public void setOffbreak(){
        this.onBreak = false;
    }
    
    public void decStan(){
        if((Stamina > 0) && (Stamina <= 20)){
            this.Stamina--;
        }
    }
    
    public void incStan(){
        if((Stamina >= 0) && (Stamina < 20)){
            this.Stamina++;
        }
    }
}
