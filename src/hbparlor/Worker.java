/*Craig Lautenslager
*#100073407
*9/14/15 CSE 1325-003
*/
package hbparlor;

/*Regular worker class
 */
public class Worker {
    
    public String name;
    public int idNum;
    public int custNo;
    public int scoopsNo;
    public double money = 0.00;
    
    public Worker(String name)
    {
        this.name = name;
        
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setID(int IDnum)
    {
        this.idNum = IDnum;
    }
    
    public int getID()
    {
        return idNum;
    }

    /**
     * @return the money
     */
    public double getMoney() {
        return money;
    }
    
    
}
