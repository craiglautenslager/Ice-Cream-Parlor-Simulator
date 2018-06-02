/*Craig Lautenslager
*#100073407
*9/14/15 CSE 1325-003
*/
package hbparlor;

/*Customer Class
 */
public class Customer {
    
    public String name;
    public int happy;
    public Double moneyBal;
    public int idNum;
    public int pennies;
    public int nickels;
    public int dimes;
    public int quarters;
    public int ones;
    public int fives;
    public int tens;
    public int twenties;
    
    //Constuctor simply sets the name and base happiness
    public Customer(String name)
    {
        this.name = name;
        this.happy = 5;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setHappy(int happy)
    {
        this.happy = happy;
    }
    
    public int gethappy()
    {
        return happy;
    }
    
    public void setBalance(Double moneyBal)
    {
        if(moneyBal > 0.0)
            this.moneyBal = moneyBal;
    }
    
    public Double getBalance()
    {
        return moneyBal;
    }
    
    public void setID(int idNum)
    {
        this.idNum = idNum;
    }
    
    public int getID()
    {
        return idNum;
    }
    
    public void setPennies(int amount)
    {
        this.pennies = amount;
    }
    
    public int getPennies()
    {
        return pennies;
    }
    
    public void setNickels(int amount)
    {
        this.nickels = amount;
    }
    
    public int getNickels()
    {
        return nickels;
    }
    
    public void setDimes(int amount)
    {
        this.dimes = amount;
    }
    
    public int getDimes()
    {
        return dimes;
    }
    
    public void setQuarters(int amount)
    {
        this.quarters = amount;
    }
    
    public int getQuarters()
    {
        return quarters;
    }
    
    public void setOnes(int amount)
    {
        this.ones = amount;
    }
    
    public int getOnes(int amount)
    {
        return ones;
    }
    
    public void setFives(int amount)
    {
        this.fives = amount;
    }
    
    public int getFives(int amount)
    {
        return fives;
    }
    
    public void setTens(int amount)
    {
        this.tens = amount;
    }
    
    public int getTens()
    {
        return tens;
    }
    
    public void setTwenties(int amount)
    {
        this.twenties = amount;
    }
    
    public int getTwenties()
    {
        return twenties;
    }
}
