/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbparlor;


/*Ice Cream Cone Class that extends the serving class
 */
public class IceCreamCone extends Serving {
    public IceCream[] scoops = new IceCream[3];
    public int coneType;
    
    public void IceCreamCone(){
        this.scoops[0] = null;
        this.scoops[1] = null;
        this.scoops[2] = null;
        this.servePrice = 0.00; 
} 
    public void addIC(IceCream type, int j){   
        this.scoops[j-1] = type;
        this.servePrice += type.price;   
        
    }
    
    public void setCone(int num){
        this.coneType = num;
    }
}
