package hbparlor;
import java.util.Scanner;
import java.lang.Double;
import GUI.MoneyDialog;

/*Transaction Class that deals with credit and cash transactions, calculating 
the correct change for the former 
 */
public class transaction {
    
    public CashRegister till = new CashRegister();
    public double change, totalChange;
    
    //A method to determine if a double is zero
    public boolean isZero(double value, double threshold)
    {
    return value >= -threshold && value <= threshold;
    }
    
    //method to return the cash reg object stored on this class
    public CashRegister getCashRegister()
    {
        return till;
    }
    
    /*cash transaction method, throws an exception if there isn't enough money 
    in the customer's wallet*/
    public Customer cashTrans(Customer custCur, double money)
            throws NotEnoughMoneyException
    {
        int num;
        double cashUsed = 0.00, zero = 0.00;
        this.change = 0.00;
        boolean paid = false, changeGiven = false;
        if(custCur.moneyBal < money){
            throw new NotEnoughMoneyException();
        }
        Scanner input = new Scanner(System.in);        
        //System.out.printf("Customer %s owes $%.2f\n", custCur.name, money);
        
        //Prompts user for cash until it covers the cost of the order
        while(cashUsed < money)
        {   
            String tempstring2;
            tempstring2="twenty";
            MoneyDialog twentiesDialog = new MoneyDialog(tempstring2);
            twentiesDialog.setModal(true);
            twentiesDialog.setVisible(true);
            num = twentiesDialog.record;
            //System.out.print("How manny twenties to give?\n");
            //num = input.nextInt();
            custCur.twenties -= num;
            cashUsed += num*20;
            
            if(cashUsed < money)
            {
                tempstring2="ten";
                MoneyDialog tensDialog = new MoneyDialog(tempstring2);
                tensDialog.setModal(true);
                tensDialog.setVisible(true);
                num = tensDialog.record;
                
                //System.out.print("How manny tens to give?\n");
                //num = input.nextInt();
                custCur.tens -= num;
                cashUsed += num*10;
            }
            if(cashUsed < money)
            {
                tempstring2="five";
                MoneyDialog fivesDialog = new MoneyDialog(tempstring2);
                fivesDialog.setModal(true);
                fivesDialog.setVisible(true);
                num = fivesDialog.record;
                
                //System.out.print("How manny fives to give?\n");
                //num = input.nextInt();
                custCur.fives -= num;
                cashUsed += num*5;
            }
            if(cashUsed < money)
            {
                tempstring2="one";
                MoneyDialog onesDialog = new MoneyDialog(tempstring2);
                onesDialog.setModal(true);
                onesDialog.setVisible(true);
                num = onesDialog.record;
                
                //System.out.print("How manny ones to give?\n");
                //num = input.nextInt();
                custCur.ones -= num;
                cashUsed += num*1;
            }
            if(cashUsed < money)
            {
                tempstring2="quarter";
                MoneyDialog quartersDialog = new MoneyDialog(tempstring2);
                quartersDialog.setModal(true);
                quartersDialog.setVisible(true);
                num = quartersDialog.record;
                
                //System.out.print("How manny quaters to give?\n");
                //num = input.nextInt();
                custCur.quarters -= num;
                cashUsed += num*.25;
            }
            if(cashUsed < money)
            {
                tempstring2="dime";
                MoneyDialog dimesDialog = new MoneyDialog(tempstring2);
                dimesDialog.setModal(true);
                dimesDialog.setVisible(true);
                num = dimesDialog.record;
                
                //System.out.print("How manny dimes to give?\n");
                //num = input.nextInt();
                custCur.dimes -= num;
                cashUsed += num*.1;
            }
            if(cashUsed < money)
            {
                tempstring2="nickel";
                MoneyDialog nickelsDialog = new MoneyDialog(tempstring2);
                nickelsDialog.setModal(true);
                nickelsDialog.setVisible(true);
                num = nickelsDialog.record;
                
                //System.out.print("How manny nickels to give?\n");
                //num = input.nextInt();
                custCur.nickels -= num;
                cashUsed += num*.05;
            }
            if(cashUsed < money)
            {
                tempstring2="penny";
                MoneyDialog penniesDialog = new MoneyDialog(tempstring2);
                penniesDialog.setModal(true);
                penniesDialog.setVisible(true);
                num = penniesDialog.record;
                
                //System.out.print("How manny pennies to give?\n");
                //num = input.nextInt();
                custCur.pennies -= num;
                cashUsed += num*.01;
            }
        }
        
        
        this.change = cashUsed - money;
        this.totalChange = this.change;
        
        till.balance -= change;
        //System.out.printf("Your change is $%.2f\n", change);
        /*loops through until cutomer has been given correct change*/
        while(changeGiven == false)
        {
            if(change > 19.99)
            {
                change -= 20;
                custCur.twenties += 1;
                till.twenties -= 1;
                
            }
            if((change > 9.9999) && (change < 20.00))
            {
                change -= 10;
                custCur.tens += 1;
                till.tens -= 1;
                
            }
            if((change > 4.9999) && (change < 10.00))
            {
                change -= 5;
                custCur.fives += 1;
                till.fives -= 1;
                
            }
            if((change > .9999) && (change < 5.00))
            {
                change -= 1;
                custCur.ones += 1;
                till.ones -= 1;
                
            }
            if((change > 0.24444) && (change < 1.00))
            {
                change -= .25;
                custCur.quarters += 1;
                till.quarters -= 1;
                
            }
            if((change > 0.0999) && (change < 0.25))
            {
                change -= .1;
                custCur.dimes += 1;
                till.dimes -= 1;
                
            }
            if((change > .04999) && (change < 0.10))
            {
                change -= .05;
                custCur.nickels += 1;
                till.nickels -= 1;
                
            }
            if((change >= 0.00001) && (change < 0.05))
            {
                change -= .01;
                custCur.nickels += 1;
                till.nickels -= 1;
                
            }
            
            if(isZero(change, 0.0001))
            {
                changeGiven = true;
            }
            
        }
        custCur.moneyBal -= money;
        till.balance += money;
        return custCur;
    }
    
    //Credit transaction
    public void creditTrans(double money)
    {
        till.setBalance(money);
    }
}
