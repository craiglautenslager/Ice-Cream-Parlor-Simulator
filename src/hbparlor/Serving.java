/*Craig Lautenslager
*#100073407
*9/14/15 CSE 1325-003
*/
package hbparlor;

/*serving class which is abstract because we now have specific types of servings
 */
public abstract class Serving {
    
    public double servePrice;
    public IceCream icServing;
    
    public void setPrice(double servePrice)
    {
        
        this.servePrice = servePrice;
    }
    
    public double getPrice()
    {
        return servePrice;
    }
    
    public void setFlavor(IceCream type)
    {
        this.icServing = type;
    }
    
    public IceCream getFlavor()
    {
        return icServing;
    }
}
