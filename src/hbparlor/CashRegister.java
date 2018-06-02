package hbparlor;

/*Cash register class

holds individual amounts of cash types in the cash register as well as the total
balance of the register
*/
public class CashRegister {
    
    public Double balance;
    public int pennies;
    public int nickels;
    public int dimes;
    public int quarters;
    public int ones;
    public int fives;
    public int tens;
    public int twenties;
    
    //Constructor sets the default balance of the register
    public CashRegister()
    {
        pennies = 150;
        nickels = 100;
        dimes = 100;
        quarters = 80;
        ones = 30;
        fives = 25;
        tens = 20;
        twenties = 10;
        balance = 636.5;
    }
    
    public void setBalance(Double balance)
    {
        if(balance > 0.0)
            this.balance = this.balance + balance;
    }
    
    public Double getBalance()
    {
        return balance;
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
