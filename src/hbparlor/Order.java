/*Craig Lautenslager
*#100073407
*9/14/15 CSE 1325-003
*/

package hbparlor;
import java.util.ArrayList;

/*Order class*/

public class Order {
    
    public int orderNum;
    public Customer customer;
    public Worker worker;
    public int workerNo;
    public int custNo;
    public int serveNum = 0;
    public ArrayList<Serving> serveArray = new ArrayList<>();
    public boolean paid;
    
    
    public Order(int num)
    {
        this.orderNum = num;
        this.paid = false;
        
    }
    
    public void setNum(int orderNum)
    {
        this.orderNum = orderNum;
    }
    
    public int getNum()
    {
        return orderNum;
    }
    
    public void setCust(Customer name)
    {
        this.customer = name;
    }
    
    public Customer getCust()
    {
        return customer;
    }
    
    public void setWorker(Worker name)
    {
        this.worker = name;
    }
    
    public Worker getWorker()
    {
        return worker;
    }
    
    public void addServe(Serving addServe)
    {
        serveArray.add(addServe);
        serveNum += 1;
        
    }
    
    public ArrayList<Serving> getServe()
    {
        return serveArray;
    }
    
    public double gettotal()
    {
        int i;
        double total = 0.00;
        for(i = 0; i < serveArray.size(); i++)
        {
            Serving loopServe = serveArray.get(i);
            total = total + loopServe.getPrice();
        }
        return total;
    }
    
}
