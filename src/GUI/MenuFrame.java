
package GUI;

import hbparlor.BananaSplit;
import hbparlor.CashRegister;
import hbparlor.Cashier;
import hbparlor.Customer;
import hbparlor.ICSoda;
import hbparlor.ICSundae;
import hbparlor.IceCream;
import hbparlor.IceCreamCone;
import hbparlor.RootBeerFloat;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextPane;
import hbparlor.Shop;
import hbparlor.Stocker;
import hbparlor.Worker;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;


public class MenuFrame extends JFrame implements ActionListener, WindowListener
{
    
    Shop objShop = new Shop();
    //Here are the constants that define the commands on the menus
    
    public static final String labelFile="File";
    public static final String labelCreate="Create";
    public static final String labelUpdate="Update";
    public static final String labelTasks="Tasks";
    public static final String labelCharts="Charts";
        
    public static final String cmdFileIceCream="Ice Cream";
    public static final String cmdFileWorkers="Workers";
    public static final String cmdFileCustomers="Customers";
    public static final String cmdFileExit="Exit Saving";
    public static final String cmdFileExitWOS="Exit Without Saving";
   
    public static final String cmdCreateIceCream="Create Ice Cream";
    public static final String cmdCreateWorker="Create Worker";
    public static final String cmdCreateCustomer="Create Customer";

    public static final String cmdUpdateIceCream="Update Ice Cream";
    public static final String cmdUpdateWorker="Update Worker";
    public static final String cmdUpdateCustomer="Update Customer";
    
    public static final String cmdTaskPlaceOrder="Place Order";
    public static final String cmdTaskPayOrder="Pay Order";
    public static final String cmdTaskActiveCashier="Acitve Cashier";
    public static final String cmdTaskActiveStocker="Active Stocker";
    public static final String cmdTaskOnBreakCashier="Cashier on Break";
    public static final String cmdTaskOnBreakStocker="Stocker on Break";
    public static final String cmdTaskRestockIceCream="Restock Ice Cream";

    public static final String cmdChartPieHappiness="Happiness Pie Chart";
    public static final String cmdChartPieMoney="Money Pie Chart";
    public static final String cmdChartBarHappiness="Happiness Bar Chart";
    public static final String cmdChartBarMoney="Money Bar Chart";
    public static final String cmdStatistics="Statistics";
    public static final String cmdFlavorList="Flavor List";
    public static final String cmdOccupants="Parlor Occupants";
    
    public static final String cmdAbout="About";
    
    //Here is the Menu Bar. It is very hard to have a Menu Frame without a Menu Bar
    JMenuBar menuBar;
    
    //Here are the Menus
    JMenu menuFile;//Load the three files, and exit
    JMenu menuCreate;//Create individuals
    JMenu menuUpdate;//Update individuals
    JMenu menuTasks;//Placing and paying for orders
    JMenu menuCharts;//Showing Charts
    
    
    //Here are all the clickble items on the menu bar.
    //Good gosh, there are a lot for such a small program!
    JMenuItem menuItemExit;
    JMenuItem menuItemExitWOS;
    JMenuItem menuItemFileIceCream;
    JMenuItem menuItemFileCustomers;
    JMenuItem menuItemFileWorkers;
    
    JMenuItem menuItemCreateIceCream;
    JMenuItem menuItemCreateCustomer;
    JMenuItem menuItemCreateWorker;
    
    JMenuItem menuItemUpdateIceCream;
    JMenuItem menuItemUpdateCustomer;
    JMenuItem menuItemUpdateWorker;
    
    JMenuItem menuItemTaskPayOrder;
    JMenuItem menuItemTaskPlaceOrder;
    JMenuItem menuItemTaskActiveCashier;
    JMenuItem menuItemTaskActiveStocker;
    JMenuItem menuItemTaskOnBreakCashier;
    JMenuItem menuItemTaskOnBreakStocker;
    JMenuItem menuItemTaskRestockIceCream;

    JMenuItem menuItemChartPieHappiness;
    JMenuItem menuItemChartPieMoney;
    JMenuItem menuItemChartBarHappiness;
    JMenuItem menuItemChartBarMoney;
    JMenuItem menuItemStatistics;
    JMenuItem menuItemFlavorList;
    JMenuItem menuItemOccupants;
    
    JMenuItem menuItemAbout;
    
    //Hang on a minute! Why does Dr. Becker have this item here?
    JMenuItem menuItemBonus;
    
    //This section is for creating a status document to show the activity
    //in the Ice Cream Parlor. 
    JTextPane document;
    
    DialogAbout dialogAbout;
    
    
    
    public MenuFrame()
    {
        this.setTitle("Honey Badger Ice Cream Parlor");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        makeMenuBar();
        addWindowListener(this);
        
        makeDocument();
        
        dialogAbout=new DialogAbout(this,true);
        
        this.setSize(new Dimension(800,600));
        this.setVisible(true);
    }

    private void makeMenuItem(JMenu menuContainer, JMenuItem menuItemObject, String label)
    {
        menuItemObject=new JMenuItem(label);
        menuContainer.add(menuItemObject);
        menuItemObject.addActionListener(this);
    }
    
    private void makeMenuBar() {
        menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);

        menuFile = new JMenu(labelFile);
        makeMenuItem(menuFile,menuItemFileIceCream,cmdFileIceCream);
        makeMenuItem(menuFile,menuItemFileIceCream,cmdFileWorkers);
        makeMenuItem(menuFile,menuItemFileIceCream,cmdFileCustomers);
        makeMenuItem(menuFile,menuItemFileIceCream,cmdFileExit);
        makeMenuItem(menuFile,menuItemFileIceCream,cmdFileExitWOS);
        menuBar.add(menuFile);

        menuCreate = new JMenu(labelCreate);
        makeMenuItem(menuCreate,menuItemCreateIceCream,cmdCreateIceCream);
        makeMenuItem(menuCreate,menuItemCreateWorker,cmdCreateWorker);
        makeMenuItem(menuCreate,menuItemCreateCustomer,cmdCreateCustomer);
        menuBar.add(menuCreate);
        
        menuUpdate = new JMenu(labelUpdate);
        makeMenuItem(menuUpdate,menuItemUpdateIceCream,cmdUpdateIceCream);
        makeMenuItem(menuUpdate,menuItemUpdateWorker,cmdUpdateWorker);
        makeMenuItem(menuUpdate,menuItemUpdateCustomer,cmdUpdateCustomer);
        menuBar.add(menuUpdate);
        
        menuTasks = new JMenu(labelTasks);
        makeMenuItem(menuTasks, menuItemTaskPayOrder,cmdTaskPayOrder);
        makeMenuItem(menuTasks,menuItemTaskPlaceOrder,cmdTaskPlaceOrder);
        makeMenuItem(menuTasks,menuItemTaskActiveCashier,cmdTaskActiveCashier);
        makeMenuItem(menuTasks,menuItemTaskActiveStocker,cmdTaskActiveStocker);
        makeMenuItem(menuTasks,menuItemTaskOnBreakCashier,cmdTaskOnBreakCashier);
        makeMenuItem(menuTasks,menuItemTaskOnBreakStocker,cmdTaskOnBreakStocker);
        makeMenuItem(menuTasks,menuItemTaskRestockIceCream,cmdTaskRestockIceCream);
        menuBar.add(menuTasks);
        
        menuCharts = new JMenu(labelCharts);
        makeMenuItem(menuCharts, menuItemChartPieHappiness, cmdChartPieHappiness);
        makeMenuItem(menuCharts, menuItemChartPieMoney,cmdChartPieMoney);
        makeMenuItem(menuCharts, menuItemChartBarHappiness,cmdChartBarHappiness);
        makeMenuItem(menuCharts, menuItemChartBarMoney,cmdChartBarMoney); 
        makeMenuItem(menuCharts, menuItemStatistics,cmdStatistics);
        makeMenuItem(menuCharts, menuItemFlavorList, cmdFlavorList);
        makeMenuItem(menuCharts, menuItemOccupants, cmdOccupants);
        menuBar.add(menuCharts);
        
        menuItemAbout = new JMenuItem(cmdAbout);
        menuItemAbout.addActionListener(this);
        menuBar.add(menuItemAbout);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
       String command;
       command=e.getActionCommand();
      
       switch(command)
       {
            case cmdFileIceCream:
                putLine("action:"+cmdFileIceCream+"\n");
                this.objShop.loadIceCream();
                break;
            case cmdFileWorkers:
                 putLine("action:"+cmdFileWorkers+"\n");
                 this.objShop.loadWorkers();
                break;
            case cmdFileCustomers:
                putLine("action:"+cmdFileCustomers+"\n");
                this.objShop.loadCustomer();
                break;
            case cmdFileExit:
                putLine("action:"+cmdFileExit+"\n");
                objShop.saveArrays();
                System.exit(0);
                break;
            case cmdFileExitWOS:
                putLine("action:"+cmdFileExitWOS+"\n");
                System.exit(0);
                break;
            case cmdCreateIceCream:
                putLine("action:"+cmdCreateIceCream+"\n");
                this.objShop.newIcecream();
                break;
            case cmdCreateWorker:
                putLine("action:"+cmdCreateWorker+"\n");
                this.objShop.newWorker();
                break;
            case cmdCreateCustomer:
                putLine("action:"+cmdCreateCustomer+"\n");
                this.objShop.newCustomer();
                break;
            case cmdUpdateIceCream:
                putLine("action:"+cmdUpdateIceCream+"\n");
                break;
            case cmdUpdateWorker:
                putLine("action:"+cmdUpdateWorker+"\n");
                break;
            case cmdUpdateCustomer:
                putLine("action:"+cmdUpdateCustomer+"\n");
                break;
            case cmdTaskPlaceOrder:
                document.setText("");
                putLine("action:"+cmdTaskPlaceOrder+"\n");
                this.objShop.newOrder();
                printNewOrder();
                break;
            case cmdTaskPayOrder:
                document.setText("");
                putLine("action:"+cmdTaskPayOrder+"\n");
                this.objShop.payOrders();
                printTransaction();
                break;
            case cmdTaskActiveCashier:
                putLine("action:"+cmdTaskActiveCashier+"\n");
                objShop.setCasiher();
                break;
            case cmdTaskActiveStocker:
                putLine("action:"+cmdTaskActiveStocker+"\n");
                objShop.setStocker();
                break;
            case cmdTaskOnBreakCashier:
                putLine("action:"+cmdTaskOnBreakCashier+"\n");
                objShop.cashierBreak();
                break;
            case cmdTaskOnBreakStocker:
                putLine("action:"+cmdTaskOnBreakStocker+"\n");
                objShop.stockerBreak();
                break;
            case cmdTaskRestockIceCream:
                putLine("action:"+cmdTaskRestockIceCream+"\n");
                objShop.icRestock();
                break;
            case cmdChartPieHappiness:
                putLine("action:"+cmdChartPieHappiness+"\n");
                this.objShop.HappinessPieCharts();
                break;
            case cmdChartPieMoney:
                putLine("action:"+cmdChartPieMoney+"\n");
                this.objShop.MoneyPieCharts();
                break;
            case cmdChartBarHappiness:
                putLine("action:"+cmdChartBarHappiness+"\n");
                this.objShop.HappinessBarCharts();
                break;
            case cmdChartBarMoney:
                putLine("action:"+cmdChartBarMoney+"\n");
                this.objShop.MoneyBarCharts();
                break;
            case cmdStatistics:
                document.setText("");
                putLine("action:"+cmdStatistics+"\n");
                regBalance();
                break;
            case cmdFlavorList:
                document.setText("");
                putLine("action:"+cmdFlavorList+"\n");
                icList();
                break;
            case cmdOccupants:
                document.setText("");
                putLine("action:"+cmdOccupants+"\n");
                occupants();
                break;
            case cmdAbout:
                putLine("action:"+cmdAbout+"\n");
                dialogAbout.setVisible(true);
                break;

                

        }
    }
    
    
    @Override
    public void windowClosing(WindowEvent e){
        //objShop.saveArrays();
    }
    
    @Override
    public void windowActivated(WindowEvent e){
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }    

    @Override
    public void windowDeactivated(WindowEvent e) {

    }

    public void windowGainedFocus(WindowEvent e) {

    }

    public void windowLostFocus(WindowEvent e) {

    }

    public void windowStateChanged(WindowEvent e) {

    }
    
    @Override
    public void windowDeiconified(WindowEvent e){
        
    }
    private void makeDocument() {
        document=new JTextPane();
        document.setEditable(false);
        this.add(document);
        
    }

    private void putLine(String line) {
        document.setText(document.getText()+line);
    }

    public void printNewOrder() {
        int i;
        IceCreamCone tempCone = new IceCreamCone();
        ICSundae tempSundae = new ICSundae();
        BananaSplit tempSplit = new BananaSplit();
        ICSoda tempSoda = new ICSoda();
        RootBeerFloat tempFloat = new RootBeerFloat();
        putLine("Order Number :"+objShop.lastOrder.orderNum+"\n");
        putLine("Customer Ordering :"+objShop.lastOrder.customer.name+"\n");
        putLine("Worker taking Order :"+objShop.lastOrder.worker.name+"\n");
        
        for(i = 0; i < objShop.lastOrder.serveArray.size(); i++)
            {
                /*Tests to see what class the serving is and for every serving 
                the price is added to the order total
                */
                String serveNo = Integer.toString(i+1);
                if(tempCone.getClass() == objShop.lastOrder.serveArray.get(i).getClass()){
                    IceCreamCone loopCone = (IceCreamCone) objShop.lastOrder.serveArray.get(i);
                    putLine("   Serving "+serveNo+": IceCream Cone\n");
                    for(int j = 0; j < 3; j++){
                        int scoopNo = j+1;
                        if(loopCone.scoops[j] != null){
                            putLine("   Flavor #"+scoopNo+" "+loopCone.scoops[j].flavor+"\n");
                        }
                    }
                    //total += loopCone.servePrice;
                }
                else if(tempSundae.getClass() == objShop.lastOrder.serveArray.get(i).getClass()){
                    ICSundae loopSundae = (ICSundae) objShop.lastOrder.serveArray.get(i);
                    System.out.printf("   Serving "+serveNo+": Ice Cream Sundae\n");
                    for(int j = 0; j < 2; j++){
                        int scoopNo = j+1;
                        if(loopSundae.scoops[j] != null){
                            putLine("   Flavor #"+scoopNo+" "+loopSundae.scoops[j].flavor+"\n");
                        }
                    }
                    
                    //total += loopSundae.servePrice;
                }
                else if(tempSplit.getClass() == objShop.lastOrder.serveArray.get(i).getClass()){
                    BananaSplit loopSplit = (BananaSplit) objShop.lastOrder.serveArray.get(i);
                    putLine("Serving "+serveNo+": Banana Split\n");
                    for(int j = 0; j < 3; j++){
                        int scoopNo = j+1;
                        if(loopSplit.scoops[j] != null){
                            putLine("   Flavor #"+scoopNo+" "+loopSplit.scoops[j].flavor+"\n");
                        }
                    }
                    //total += loopSplit.servePrice;
                }
                else if(tempSoda.getClass() == objShop.lastOrder.serveArray.get(i).getClass()){
                    ICSoda loopSoda = (ICSoda) objShop.lastOrder.serveArray.get(i);
                    putLine("Serving "+serveNo+": Ice Cream Soda\n");
                    System.out.printf("   Flavor "+loopSoda.icServing.flavor+"\n");
                    //total += loopSoda.servePrice;
                }
                else if(tempFloat.getClass() == objShop.lastOrder.serveArray.get(i).getClass()){
                    putLine("Serving "+serveNo+": Root Beer Float\n");
                    //total += loopOrder.serveArray.get(s).servePrice;
                }
                String servePrice = Double.toString(objShop.lastOrder.serveArray.get(i).servePrice);
                putLine("   Price: $"+servePrice+"\n");
            }
            String totalPrice = Double.toString(objShop.lastOrder.gettotal());
            putLine("--------------------\nOrder Total: "+totalPrice+"\n");
            }
    
    
    public void regBalance()
    {
        int i, totalHappy =0;
        double totalMoney = 0.00;
        CashRegister till;
        
        //adds the customers money together
        for(i = 0; i < objShop.custArray.size(); i++){
            Customer loopCust = objShop.custArray.get(i);
            totalMoney += loopCust.moneyBal;
        }
        
        String custMoney = Double.toString(totalMoney);
        putLine("######Parlour Statistics######\n\n");
        putLine("Total Money of Customers in Parlor: "+custMoney+"\n");
        //transfers transactions register object to one in shop
        till = objShop.transactions.getCashRegister();
        
        //Prints money in cash register
        String balance = Double.toString(till.balance);
        String twenties = Double.toString(till.twenties);
        String tens = Double.toString(till.tens);
        String fives = Double.toString(till.fives);
        String ones = Double.toString(till.ones);
        String quarters = Double.toString(till.quarters);
        String dimes = Double.toString(till.dimes);
        String nickels = Double.toString(till.nickels);
        String pennies = Double.toString(till.pennies);
        putLine("Cash Register Balance: "+balance+"\n");
        putLine("--Currency in Register--\n");
        putLine("$20 Bills : "+twenties+"\n");
        putLine("$10 Bills : "+tens+"\n");
        putLine("$5 Bills  : "+fives+"\n");
        putLine("$1 Bills  : "+ones+"\n");
        putLine("Quarters  : "+quarters+"\n");
        putLine("Dimes     : "+dimes+"\n");
        putLine("Nickels   : "+nickels+"\n");
        putLine("Pennies   : "+pennies+"\n");
        
        //adds happiness together
        for(i = 0; i < objShop.custArray.size(); i++){
            Customer loopCust = objShop.custArray.get(i);
            totalHappy += loopCust.happy;
        }
        String happy = Integer.toString(totalHappy);
        putLine("\nTotal Happiness in Parlor: "+totalHappy+"\n");
    }
    
    public void icList()
    {
        int i;
        putLine("List of Flavors:\n\n");
        
        for(i = 0; i < objShop.icArray.size(); i++)
        {
            IceCream loopIC = objShop.icArray.get(i);
            String no = Integer.toString(i+1);
            String idnum = Integer.toString(loopIC.idNum);
            String price = Double.toString(loopIC.price);
            String scoops = Integer.toString(loopIC.scoops);
            putLine(""+idnum+". "+loopIC.flavor+" "+price+" "+scoops+"\n");
        }
    }
    
    public void printTransaction(){
        String cost = Double.toString(objShop.earned);
        
        if (objShop.lastTrans == 1){
            putLine("======Credit Transaction=====\n");
            putLine("[VISA]===Transaction Accepted\n");
            putLine("Total   : "+cost+"\n");
        }
        else if (objShop.lastTrans == 2){
            String change = Double.toString(objShop.lastChange);
            putLine("=======Cash Transaction======\n");
            putLine("Total   : "+cost+"\n");
            putLine("Customer's Change : "+change+"\n");
        }
    }
    
    public void occupants()
    {
        int i, s = 0;
        putLine("###Parlor Occupants###\n\nWorkers:\n");
        Stocker cmpStock = new Stocker("First Last");
        Worker cmpWork = new Worker("First Last");
        Cashier cmpCash = new Cashier("First Last");
        putLine("    ID  |Name       |Money Earned\n");
        
        //Prints regular workers
        for(i = 0; i < objShop.workerArray.size(); i++)
        {
            Worker loopWork = objShop.workerArray.get(i);
            
            if(loopWork.getClass() == cmpWork.getClass()){
                s += 1;
                String no = Integer.toString(s);
                String id = Integer.toString(loopWork.idNum);
                String money = Double.toString(loopWork.getMoney());
                putLine(""+no+". #"+id+" "+loopWork.name+"   "+money+"\n");
            }
        }
        putLine("Stockers:\n");
        putLine("    ID  |Name       |Money Earned|Stamina\n");
        s=0;
        //Prints stockers
        for(i = 0; i < objShop.workerArray.size(); i++)
        {
            Worker loopWork = objShop.workerArray.get(i);
            
            if(loopWork.getClass() == cmpStock.getClass()){
                s += 1;
                Stocker loopStock = (Stocker) loopWork;
                String no = Integer.toString(s);
                String id = Integer.toString(loopStock.idNum);
                String money = Double.toString(loopStock.getMoney());
                String stamina = Integer.toString(loopStock.Stamina);
                putLine(""+no+". #"+id+" "+loopStock.name+"    "+money+"    "+stamina+"\n");
            }
        }
        putLine("Cashiers:\n");
        putLine("    ID  |Name       |Money Earned|Patiance\n");
        s += 1;
        //Prints the cashiers
        for(i = 0; i < objShop.workerArray.size(); i++)
        {
            Worker loopWork = objShop.workerArray.get(i);
            
            if(loopWork.getClass() == cmpCash.getClass()){
                s += 1;
                Cashier loopCash = (Cashier) loopWork;
                String no = Integer.toString(s);
                String id = Integer.toString(loopCash.idNum);
                String money = Double.toString(loopCash.getMoney());
                String patience = Integer.toString(loopCash.patience);
                putLine(""+no+". #"+id+" "+loopCash.name+"    "+money+"    "+patience+"\n");
            }
        }
        putLine("\nCustomers:\n\n");
        putLine("    ID  |Name|Happines|Money in Wallet|\n");
        
        //Prints the customers in the store
        for(i = 0; i < objShop.custArray.size(); i++)
        {
            Customer loopCust = objShop.custArray.get(i);
            String no = Integer.toString(i+1);
            String id = Integer.toString(loopCust.idNum);
            String happy = Integer.toString(loopCust.happy);
            String moneyBal = Double.toString(loopCust.moneyBal);
            String twenties = Integer.toString(loopCust.twenties);
            String tens = Integer.toString(loopCust.tens);
            String fives = Integer.toString(loopCust.fives);
            String ones = Integer.toString(loopCust.ones);
            String quarters = Integer.toString(loopCust.quarters);
            String dimes = Integer.toString(loopCust.dimes);
            String nickels = Integer.toString(loopCust.nickels);
            String pennies = Integer.toString(loopCust.pennies);
            putLine(""+no+". #"+id+" "+loopCust.name+" "+happy+" "+moneyBal+" "+twenties+"|"+tens+"|"+fives+"|"+ones+"|"+quarters+"|"+dimes+"|"+nickels+"|"+pennies+"\n");
        }
     
    }
}