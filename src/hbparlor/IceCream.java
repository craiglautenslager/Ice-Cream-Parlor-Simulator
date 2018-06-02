/*Craig Lautenslager
*#100073407
*9/14/15 CSE 1325-003
*/
package hbparlor;

/*Ice Cream Flavor class
 */
public class IceCream {
    
    public String flavor;
    public Double price;
    public String name;
    public String descrip;
    public int idNum;
    public int scoops;
    
    public IceCream()
    {
        this.scoops = 80;
    }
    public void setFlavor(String flavor)
    {
        this.flavor = flavor;
    }
    
    public String getFlavor()
    {
        return flavor;
    }
    
    public void setPrice(Double price)
    {
        if(price > 0.0)
            this.price = price;
    }
    
    public Double getPrice()
    {
        return price;
    }
    
    public void setDescrip(String descrip)
    {
        this.descrip = descrip;
    }
    
    public String getDescrip()
    {
        return descrip;
    }
    
    public void setID(int IDnum)
    {
        this.idNum = IDnum;
    }
    
    public int getID()
    {
        return idNum;
    }
    
    public void setScoops(int scoopNum)
    {
        this.scoops = scoopNum;
    }
    
    public int getScoops()
    {
        return scoops;
    }
    
    public void decScoops()
    {
        if(this.scoops > 0){
        this.scoops = scoops - 1;
        }
    }
    
}
