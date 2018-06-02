/*
All of the packages needed for the controller
 */
package hbparlor;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.lang.Integer;
import java.lang.Double;
import java.util.Formatter;
import GUI.CustomerDialog;
import GUI.NewOrderDialog;
import GUI.setCashierDialog;
import GUI.setStockerDialog;
import GUI.restockDialog;
import GUI.WorkerDialog;
import GUI.IceCreamDialog;
import GUI.PayOrdersDialog;
import GUI.NoCashierDialog;
import GUI.NoPatienceDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Shop {
    /*Initialisation of Arraylists, Objects and lists needed by the controller*/
    public ArrayList<Customer> custArray = new ArrayList<>();
    public ArrayList<Worker> workerArray = new ArrayList<>();
    public ArrayList<IceCream> icArray = new ArrayList<>();
    public ArrayList<Order> orderArray = new ArrayList<>();
    
    MoneyPieChart moneyPieChart = new MoneyPieChart();
    MoneyBarChart moneyBarChart = new MoneyBarChart();
    HappinessPieChart happinessPieChart = new HappinessPieChart();
    HappinessBarChart happinessBarChart = new HappinessBarChart();
    
    public CashRegister till = new CashRegister();
    public Order lastOrder;
    public double lastChange;
    public int lastTrans;
    public double earned;
    public static Stocker stockerObj = null;
    public static Cashier cashierObj = null;
    public transaction transactions = new transaction();
    //Keeps track of the number of orders placed
    public int orderNo = 1;
    public String[] condimentList = {"Strawberry", "Chocolate", "Marshmellow Cream", "Pineapple", "Ketchup", "Mustard", "Pickle Relish"};
    
    File icflavors;
    File customers;
    File workers;
    
    public Shop()
    {
        /* Constructor for Shop controller opens customer, worker and flavors
        file. It then populates the respective array list with that information
        */
        
        /* Exception Handing Block for reading the flavors file*/
//        try 
//        {
//            File icflavors = new File("flavorslist.txt");
//            Scanner reader = new Scanner(icflavors);
//            String line;
//            IceCream tempIce = new IceCream();
//            int count = 0;
//            
//            /* While loop to read each line place the information into the 
//            respective fields of a temporary IceCream object then appends it to 
//            the Ice Cream array 
//            */
//            while (reader.hasNextLine())
//            {
//                line = reader.nextLine();
//                String[] tokens;
//                tokens = line.split(",");
//                tempIce.setID(Integer.parseInt(tokens[0]));
//                tempIce.setPrice(Double.parseDouble(tokens[1]));
//                tempIce.setFlavor(tokens[2]);
//                tempIce.setDescrip(tokens[3]);
//                tempIce.setScoops(Integer.parseInt(tokens[4]));
//                icArray.add(tempIce);
//                tempIce = new IceCream();
//                /*reader.close();*/
//            }
//            reader.close();
//            
//        }catch (FileNotFoundException ex){
//            Logger.getLogger(Shop.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        /*Exception handling for reading the customer file*/
//        try
//        {
//            File customers = new File("customerlist.txt");
//            Scanner reader = new Scanner(customers);
//            String line = "set up";
//            Customer tempCust = new Customer("First Last");
//            int count = 0;
//            
//            /* While loop to read each line place the information into the 
//            respective fields of a temporary customer object then appends it to 
//            the Customer array 
//            */
//            while (reader.hasNextLine())
//            {
//                line = reader.nextLine();
//                String[] tokens;
//                tokens = line.split(","); //splits file by commas to a string array
//                //using a parse functions to convert strings to numbers
//                tempCust.setID(Integer.parseInt(tokens[0]));
//                tempCust.setName(tokens[1]);
//                tempCust.setHappy(Integer.parseInt(tokens[2]));
//                tempCust.setBalance(Double.parseDouble(tokens[3]));
//                tempCust.setPennies(Integer.parseInt(tokens[4]));
//                tempCust.setNickels(Integer.parseInt(tokens[5]));
//                tempCust.setDimes(Integer.parseInt(tokens[6]));
//                tempCust.setQuarters(Integer.parseInt(tokens[7]));
//                tempCust.setOnes(Integer.parseInt(tokens[8]));
//                tempCust.setFives(Integer.parseInt(tokens[9]));
//                tempCust.setTens(Integer.parseInt(tokens[10]));
//                tempCust.setTwenties(Integer.parseInt(tokens[11]));
//                custArray.add(tempCust);
//                tempCust = new Customer("First Last");
//                /*count += 1;*/
//                Customer loopCust = custArray.get(0);
//                
//                /*reader.close();*/
//            }
//            reader.close();
//            
//        }catch (FileNotFoundException ex){
//            Logger.getLogger(Shop.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        /*Exception handling for reading the worker file*/
//        try
//        {
//            File workers = new File("workerlist.txt");
//            Scanner reader = new Scanner(workers);
//            String line;
//            
//            int count = 0;
//            
//            /* While loop to read each line place the information into the 
//            respective fields of a temporary customer object then appends it to 
//            the Customer array 
//            */
//            while (reader.hasNextLine())
//            {
//                line = reader.nextLine();
//                String[] tokens;
//                tokens = line.split(",");
//                Worker tempWork = new Worker("First Last");
//                Stocker tempStock = new Stocker("First Last");
//                Cashier tempCash = new Cashier("First Last");
//                
//                /*Determining by the first token what type of worker they are.*/
//                
//                //If the token is 'w' create regular worker
//                if(tokens[0].equals("w")){
//                    tempWork.setID(Integer.parseInt(tokens[1]));
//                    tempWork.setName(tokens[2]);
//                    tempWork.scoopsNo = Integer.parseInt(tokens[3]);
//                    tempWork.custNo = Integer.parseInt(tokens[4]);
//                    tempWork.money = Double.parseDouble(tokens[5]);
//                    workerArray.add(tempWork);
//                    tempWork = new Worker("First Last");
//                }
//                //If token is 's' create stocker
//                else if(tokens[0].equals("s")){
//                    tempStock.setID(Integer.parseInt(tokens[1]));
//                    tempStock.setName(tokens[2]);
//                    tempStock.scoopsNo = Integer.parseInt(tokens[3]);
//                    tempStock.custNo = Integer.parseInt(tokens[4]);
//                    tempStock.money = Double.parseDouble(tokens[5]);
//                    workerArray.add(tempStock);
//                    tempStock = new Stocker("First Last");
//                }
//                //If token is 'c' create cashier
//                else if(tokens[0].equals("c")){
//                    tempCash.setID(Integer.parseInt(tokens[1]));
//                    tempCash.setName(tokens[2]);
//                    tempCash.scoopsNo = Integer.parseInt(tokens[3]);
//                    tempCash.custNo = Integer.parseInt(tokens[4]);
//                    tempCash.money = Double.parseDouble(tokens[5]);
//                    workerArray.add(tempCash);
//                    tempCash = new Cashier("First Last");
//                }
//                
//                
//            }
//            reader.close();
//            
//        }catch (FileNotFoundException ex){
//            Logger.getLogger(Shop.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
        
    }    
        public void loadIceCream()
        {
        try 
        {
        
            JFileChooser filechooser = new JFileChooser();
            filechooser.showOpenDialog(null);
            
            icflavors = filechooser.getSelectedFile();
            Scanner reader = new Scanner(icflavors);
            String line;
            IceCream tempIce = new IceCream();
            int count = 0;
            
            /* While loop to read each line place the information into the 
            respective fields of a temporary IceCream object then appends it to 
            the Ice Cream array 
            */
            while (reader.hasNextLine())
            {
                line = reader.nextLine();
                String[] tokens;
                tokens = line.split(", |[,]+");
                tempIce.setID(Integer.parseInt(tokens[0]));
                tempIce.setPrice(Double.parseDouble(tokens[1]));
                tempIce.setFlavor(tokens[2]);
                tempIce.setDescrip(tokens[4]);
                tempIce.setScoops(Integer.parseInt(tokens[5]));
                icArray.add(tempIce);
                tempIce = new IceCream();
                /*reader.close();*/
            }
            reader.close();
            
        }catch (FileNotFoundException ex){
            Logger.getLogger(Shop.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        }
       
        /*Exception handling for reading the customer file*/
        
        
        
        
        
        public void loadCustomer(){
        try
        {
            
            
            JFileChooser filechooser = new JFileChooser();
            filechooser.showOpenDialog(null);
            
            this.customers = filechooser.getSelectedFile();
           
            Scanner reader = new Scanner(this.customers);
            String line = "set up";
            Customer tempCust = new Customer("First Last");
            int count = 0;
            
            /* While loop to read each line place the information into the 
            respective fields of a temporary customer object then appends it to 
            the Customer array 
            */
            while (reader.hasNextLine())
            {
                line = reader.nextLine();
                String[] tokens;
                tokens = line.split(", |[,]+"); //splits file by commas to a string array
                //using a parse functions to convert strings to numbers
                tempCust.setID(Integer.parseInt(tokens[0]));
                tempCust.setName(tokens[1]);
                tempCust.setHappy(Integer.parseInt(tokens[3]));
                tempCust.setBalance(Double.parseDouble(tokens[2]));
                tempCust.setPennies(Integer.parseInt(tokens[4]));
                tempCust.setNickels(Integer.parseInt(tokens[5]));
                tempCust.setDimes(Integer.parseInt(tokens[6]));
                tempCust.setQuarters(Integer.parseInt(tokens[7]));
                tempCust.setOnes(Integer.parseInt(tokens[8]));
                tempCust.setFives(Integer.parseInt(tokens[9]));
                tempCust.setTens(Integer.parseInt(tokens[10]));
                tempCust.setTwenties(Integer.parseInt(tokens[11]));
                custArray.add(tempCust);
                tempCust = new Customer("First Last");
                /*count += 1;*/
                Customer loopCust = custArray.get(0);
                
                /*reader.close();*/
            }
            reader.close();
            
        }catch (FileNotFoundException ex){
            Logger.getLogger(Shop.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        /*Exception handling for reading the worker file*/
        
        
        
        
        
        public void loadWorkers(){
        try
        {
            
            
            JFileChooser filechooser = new JFileChooser();
            filechooser.showOpenDialog(null);
            
            this.workers = filechooser.getSelectedFile();
            
            Scanner reader = new Scanner(this.workers);
            String line;
            
            int count = 0;
            
            /* While loop to read each line place the information into the 
            respective fields of a temporary customer object then appends it to 
            the Customer array 
            */
            while (reader.hasNextLine())
            {
                line = reader.nextLine();
                String[] tokens;
                tokens = line.split(", |[,]+");
                Worker tempWork = new Worker("First Last");
                Stocker tempStock = new Stocker("First Last");
                Cashier tempCash = new Cashier("First Last");
                
                /*Determining by the first token what type of worker they are.*/
                
                //If the token is 'w' create regular worker
                if(tokens[1].equals("Worker")){
                    tempWork.setID(Integer.parseInt(tokens[0]));
                    tempWork.setName(tokens[2]);
                    tempWork.scoopsNo = Integer.parseInt(tokens[4]);
                    tempWork.custNo = Integer.parseInt(tokens[3]);
                    tempWork.money = Double.parseDouble(tokens[5]);
                    workerArray.add(tempWork);
                    tempWork = new Worker("First Last");
                }
                //If token is 's' create stocker
                else if(tokens[1].equals("Stocker")){
                    tempStock.setID(Integer.parseInt(tokens[0]));
                    tempStock.setName(tokens[2]);
                    tempStock.scoopsNo = Integer.parseInt(tokens[4]);
                    tempStock.custNo = Integer.parseInt(tokens[3]);
                    tempStock.money = Double.parseDouble(tokens[5]);
                    workerArray.add(tempStock);
                    tempStock = new Stocker("First Last");
                }
                //If token is 'c' create cashier
                else if(tokens[1].equals("Cashier")){
                    tempCash.setID(Integer.parseInt(tokens[0]));
                    tempCash.setName(tokens[2]);
                    tempCash.scoopsNo = Integer.parseInt(tokens[4]);
                    tempCash.custNo = Integer.parseInt(tokens[3]);
                    tempCash.money = Double.parseDouble(tokens[5]);
                    workerArray.add(tempCash);
                    tempCash = new Cashier("First Last");
                }
                
                
            }
            reader.close();
            
        }catch (FileNotFoundException ex){
            Logger.getLogger(Shop.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    /*create new customer method*/
    public void newCustomer()
    {
        //Prompts for Customer Name
        Customer cstmrObj = new Customer("First last");
        
        CustomerDialog custDialog = new CustomerDialog();
        custDialog.setModal(true);
        custDialog.setVisible(true);
        if(!"First Last".equals(custDialog.record.name)){
            
            cstmrObj = custDialog.record;
            
            cstmrObj.setID(custArray.size() + 1001);
            cstmrObj.setHappy(5);
            double totalMoney = (cstmrObj.pennies * 0.01)+(cstmrObj.nickels * 0.05)+
            (cstmrObj.dimes * 0.1)+(cstmrObj.quarters * 0.25)+(cstmrObj.ones * 1)
            +(cstmrObj.fives * 5)+(cstmrObj.tens * 10)+(cstmrObj.twenties * 20);
            cstmrObj.setBalance(totalMoney);
            custArray.add(cstmrObj);
            System.out.print("Customer Created");
        }
        //Sets ID, happiness then prompts for the change in the wallet
        
        /*
        System.out.print("\nPennies in Wallet: ");
        cstmrObj.setPennies(input.nextInt());
        System.out.print("\nNickels in Wallet: ");
        cstmrObj.setNickels(input.nextInt());
        System.out.print("\nDimes in Wallet: ");
        cstmrObj.setDimes(input.nextInt());
        System.out.print("\nQuarters in Wallet: ");
        cstmrObj.setQuarters(input.nextInt());
        System.out.print("\nOnes in Wallet: ");
        cstmrObj.setOnes(input.nextInt());
        System.out.print("\nFives in Wallet: ");
        cstmrObj.setFives(input.nextInt());
        System.out.print("\nTens in Wallet: ");
        cstmrObj.setTens(input.nextInt());
        System.out.print("\nTwenties in Wallet: ");
        cstmrObj.setTwenties(input.nextInt());*/
        
        //Adds money together for total
        
        
    }
    
    // Create new ice cream flavor
    public void newIcecream()
    {
        int icID = icArray.size() + 1;
        IceCreamDialog IceDialog = new IceCreamDialog(icID);
        IceDialog.setModal(true);
        IceDialog.setVisible(true);
        icArray.add(IceDialog.getRecord());
    }
    
    public void newWorker()
    {
        int workerId = workerArray.size() + 2001;
        
        WorkerDialog workDialog = new WorkerDialog(workerId);
        workDialog.setModal(true);
        workDialog.setVisible(true);
        
        if(workDialog.type == 0){
            workerArray.add(workDialog.recordW);
        }
        if(workDialog.type == 1){
            workerArray.add(workDialog.recordC);
        }
        if(workDialog.type == 2){
            workerArray.add(workDialog.recordS);
        }
        
    }
    //Redundant new serving method
    /*public void newServing()
    {
        System.out.print("Serving Created\n");
        System.out.print("Enter Number of Servings: ");
        Scanner input = new Scanner(System.in);
        Serving serveObj = new Serving();
        System.out.print("Enter Price per Serving: ");
        serveObj.setPrice(input.nextDouble());
    }*/
    
    //create new regular worker method
    
    
    //create new stocker method 
    public void newStocker(){
        //prompt for stocker name
        System.out.print("Stocker Created\n");
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Worker Name: \n");
        Stocker stockerTemp = new Stocker(input.nextLine());
        stockerTemp.setID(workerArray.size() + 2000);
        stockerTemp.custNo = 0;
        stockerTemp.scoopsNo = 0;
        
        //Add to array of workers
        workerArray.add(stockerTemp);
    }
    
    /*Create new Cashier method*/
    public void newCashier(){
        System.out.print("Cashier Created\n");
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Worker Name: \n");
        Cashier cashTemp = new Cashier(input.nextLine());
        cashTemp.setID(workerArray.size() + 2000);
        cashTemp.custNo = 0;
        cashTemp.scoopsNo = 0;
        
        //Add to array of workers
        workerArray.add(cashTemp);
    }
    
    /*Create new order method*/
    public void newOrder()
    {
        
        //increment the order number variable
        
        Order tempOrder = new Order(orderNo);
        boolean nextServe = true, first = true;
        NewOrderDialog OrderDialog = new NewOrderDialog(orderNo, custArray, workerArray, icArray);
        OrderDialog.setModal(true);
        OrderDialog.setVisible(true);
        
        tempOrder = OrderDialog.record;
        lastOrder = OrderDialog.record;
        tempOrder.setNum(orderNo);
        
        if (tempOrder.serveArray.isEmpty()){
            
        }
        else{
                this.orderNo += 1;
        }
        orderArray.add(tempOrder);
    }
    
    /*Method for paying orders*/
    public void payOrders()
    {
        
        int i, s, paySel = 0, workerNo, custNo;
        
        boolean continueloop = true;
        Customer tempCust = new Customer("First last");
        Scanner input = new Scanner(System.in);
        
        /*Print the orders, if there are orders in the order array and there is 
        a cashier active and the cashier's patience is not zero
        */
        if((orderArray.size() > 0) && (cashierObj != null) && (cashierObj.patience != 0))
        {
            for(i = 0; i < orderArray.size(); i++)
            {
                Order loopOrder = orderArray.get(i);
                //if the order has not been payed, print it
                if(loopOrder.paid == false)
                {
//                System.out.printf("Order #%d\n", loopOrder.getNum());
                earned = loopOrder.gettotal();
                System.out.printf("$%.2f\n", earned);
                workerNo = loopOrder.workerNo;
                custNo = loopOrder.custNo;
                do{
                    PayOrdersDialog payordersDialog = new PayOrdersDialog(loopOrder);
                    payordersDialog.setModal(true);
                    payordersDialog.setVisible(true);
                    
                    paySel = payordersDialog.record;
                    /*Exception handling block for not enough money exception
                    */
                    try{
//                        paySel = 0;
//                        //Runs until credit or cash is selected
//                        while((paySel < 1) || (paySel > 2))
//                        {
//                            
//                            //System.out.print("Pay by:\n1. Credit\n2.Cash\n");
//                            paySel = input.nextInt();
//                        }
                        if(paySel == 1)
                        {
                            //For credit call the transaction's credit method
                            loopOrder.worker.money += earned;
                            loopOrder.worker.custNo += 1;
                            cashierObj.decPat();
                            cashierObj.scoopsNo++;
                            loopOrder.worker.scoopsNo += loopOrder.serveNum;
                            transactions.creditTrans(earned);
                            lastTrans = 1;
                            loopOrder.paid = true;
                            continueloop = false;
                        }
                        else if(paySel == 2)
                        {
                            /*For cash call the transaction object's cash method
                            pass in the customer object from the order as well as
                            the total cost of the order passes back a customer object
                            with correct change and money
                            */
                            tempCust = transactions.cashTrans(loopOrder.customer, earned);
                            loopOrder.setCust(tempCust);
                            loopOrder.worker.money += earned;
                            loopOrder.worker.custNo += 1;
                            loopOrder.worker.scoopsNo += loopOrder.serveNum;
                            lastChange = transactions.totalChange;
                            lastTrans = 2;
                            cashierObj.decPat();
                            cashierObj.scoopsNo++;
                            continueloop = false;
                        }
                    }
                    catch (NotEnoughMoneyException moneyexception){
                        System.err.printf("%nException: %s%n", moneyexception);
                        System.out.print("Not enough money in customer's wallet, please pay by credit.\n");
                    }
                }
                while(continueloop);
                
                loopOrder.customer.happy += 1;
                /*Update the worker and customer arrays with updated entries 
                after the completed order
                */ 
                workerArray.set((loopOrder.worker.idNum -2001), loopOrder.worker);
                custArray.set((custNo - 1), loopOrder.customer);
                loopOrder.paid = true;
                orderArray.set(i, loopOrder);
                
                /*Run through the worker array and increase the patience of the 
                cashiers and stockers on break
                */
                for(int k = 0; k > workerArray.size(); k++){
                    Cashier loopCash = new Cashier("First Last");
                    Stocker loopStock = new Stocker("First Last");
                    if(loopCash.getClass() == workerArray.get(k).getClass()){
                        loopCash = (Cashier) workerArray.get(k);
                        if(loopCash.idNum != cashierObj.idNum){
                            
                            loopCash.incPat();
                            workerArray.set(k, loopCash);
                        }
                    }
                    else if(loopStock.getClass() == workerArray.get(k).getClass()){
                        loopStock = (Stocker) workerArray.get(k);
                        if(loopStock.idNum != cashierObj.idNum){
                            
                            loopStock.incStan();
                            workerArray.set(k, loopStock);
                        }
                    }
                }
                }
            }
        }
        else if(cashierObj == null){
            /*If no cashier is on duty refuse to process orders, customers 
            happiness decereases*/
            //System.out.print("No Cashier on Duty: No orders can be\n processed at this time.\n");
            
            NoCashierDialog nocashierDialog = new NoCashierDialog();
            nocashierDialog.setModal(continueloop);
            nocashierDialog.setVisible(true);
            
            for(s = 0; s < custArray.size(); s++){
                custArray.get(s).happy -= 1;
            }
        }
        else if(cashierObj.patience == 0){
            /*If cashier has lost patience, refuse to process orders and decrease
            customers happiness
            */
            //System.out.print("Cashier has lost their patiance!\nNew Cashier Required\n");
            
            NoPatienceDialog nopatienceDialog = new NoPatienceDialog();
            nopatienceDialog.setModal(continueloop);
            nopatienceDialog.setVisible(true);
            
            for(s = 0; s < custArray.size(); s++){
                custArray.get(s).happy -= 1;
            }
        }
    }
    
    /*method for printing the parlors occupants*/
    public void occupants()
    {
        int i;
        System.out.print("###Parlor Occupants###\n\nWorkers:\n");
        Stocker cmpStock = new Stocker("First Last");
        Worker cmpWork = new Worker("First Last");
        Cashier cmpCash = new Cashier("First Last");
        System.out.print("    ID  |Name       |Money Earned\n");
        
        //Prints regular workers
        for(i = 0; i < workerArray.size(); i++)
        {
            Worker loopWork = workerArray.get(i);
            
            if(loopWork.getClass() == cmpWork.getClass()){
                System.out.printf("%d. #%d %s    %.2f\n", i+1, loopWork.idNum, loopWork.name, loopWork.getMoney());
            }
        }
        System.out.print("Stockers:\n");
        System.out.print("    ID  |Name       |Money Earned|Stamina\n");
        
        //Prints stockers
        for(i = 0; i < workerArray.size(); i++)
        {
            Worker loopWork = workerArray.get(i);
            
            if(loopWork.getClass() == cmpStock.getClass()){
                Stocker loopStock = (Stocker) loopWork;
                System.out.printf("%d. #%d %s    %.2f %d\n", i+1, loopStock.idNum, loopStock.name, loopStock.getMoney(), loopStock.Stamina);
            }
        }
        System.out.print("Cashiers:\n");
        System.out.print("    ID  |Name       |Money Earned|Patiance\n");
        
        //Prints the cashiers
        for(i = 0; i < workerArray.size(); i++)
        {
            Worker loopWork = workerArray.get(i);
            
            if(loopWork.getClass() == cmpCash.getClass()){
                Cashier loopCash = (Cashier) loopWork;
                System.out.printf("%d. #%d %s    %.2f %d\n", i+1, loopCash.idNum, loopCash.name, loopCash.getMoney(), loopCash.patience);
            }
        }
        System.out.print("\nCustomers:\n\n");
        System.out.print("    ID  |Name|Happines|Money in Wallet|\n");
        
        //Prints the customers in the store
        for(i = 0; i < custArray.size(); i++)
        {
            Customer loopCust = custArray.get(i);
            System.out.printf("%d. %d %s %d %.2f %d|%d|%d|%d|%d|%d|%d|%d|\n", i+1, loopCust.idNum, loopCust.name, loopCust.happy, loopCust.moneyBal, loopCust.twenties, loopCust.tens, loopCust.fives, loopCust.ones, loopCust.quarters, loopCust.dimes, loopCust.nickels, loopCust.pennies);
        }
     
    }
    
    //method to list the Ice Cream flavors and the scoops left
    public void icList()
    {
        int i;
        
        for(i = 0; i < icArray.size(); i++)
        {
            IceCream loopIC = icArray.get(i);
            System.out.printf("%d. %d , %s , %f, %d\n", i+1, loopIC.idNum, loopIC.flavor, loopIC.price, loopIC.scoops);
        }
    }
    
    /*method to print the balance of the register as well as the total money and
    happiness of the customers*/
    public void regBalance()
    {
        int i, totalHappy =0;
        double totalMoney = 0.00;
        
        //adds the customers money together
        for(i = 0; i < custArray.size(); i++){
            Customer loopCust = custArray.get(i);
            totalMoney += loopCust.moneyBal;
        }
        System.out.print("######Parlour Statistics######\n\n");
        System.out.printf("Total Money of Customers in Parlor: %.2f\n\n", totalMoney);
        //transfers transactions register object to one in shop
        till = transactions.getCashRegister();
        
        //Prints money in cash register
        System.out.printf("Cash Register Balance: %.2f\n", till.balance);
        System.out.print("--Currency in Register--\n");
        System.out.printf("$20 Bills : %d\n", till.twenties);
        System.out.printf("$10 Bills : %d\n", till.tens);
        System.out.printf("$5 Bills  : %d\n", till.fives);
        System.out.printf("$1 Bills  : %d\n", till.ones);
        System.out.printf("Quarters  : %d\n", till.quarters);
        System.out.printf("Dimes     : %d\n", till.dimes);
        System.out.printf("Nickels   : %d\n", till.nickels);
        System.out.printf("Pennies   : %d\n", till.pennies);
        
        //adds happiness together
        for(i = 0; i < custArray.size(); i++){
            Customer loopCust = custArray.get(i);
            totalHappy += loopCust.happy;
        }
        System.out.printf("\nTotal Happiness in Parlor: %d\n", totalHappy);
    }
    
    /*Orders to be filled method
    Prints unfilled orders
    */
    public void orderWait()
    {
        int i, s;
        double total = 0.00;
        System.out.print("####Orders to Be Filled####\n");
        
        //Series of temporary objects
        IceCreamCone tempCone = new IceCreamCone();
        ICSundae tempSundae = new ICSundae();
        BananaSplit tempSplit = new BananaSplit();
        ICSoda tempSoda = new ICSoda();
        RootBeerFloat tempFloat = new RootBeerFloat();
        
        /*loops through the order array and displays the unpaid orders*/
        for(i = 0; i < orderArray.size();i ++)
        {
            
            Order loopOrder = orderArray.get(i);
            if(loopOrder.paid == true)
            {
                
            }
            else
            {
            System.out.printf("%d. Customer: %s\n   Worker: %s\n", loopOrder.orderNum, loopOrder.customer.name, loopOrder.worker.name);
            
            //loops through each serving of the order and prints it
            for(s = 0; s < loopOrder.serveArray.size(); s++)
            {
                /*Tests to see what class the serving is and for every serving 
                the price is added to the order total
                */
                if(tempCone.getClass() == loopOrder.serveArray.get(s).getClass()){
                    IceCreamCone loopCone = (IceCreamCone) loopOrder.serveArray.get(s);
                    System.out.printf("   Serving %d: %s ", s+1, "IceCream Cone\n");
                    for(int j = 0; j < 3; j++){
                        if(loopCone.scoops[j] != null){
                            System.out.printf("   Flavor %d.%s\n", j+1, loopCone.scoops[j].flavor);
                        }
                    }
                    total += loopCone.servePrice;
                }
                else if(tempSundae.getClass() == loopOrder.serveArray.get(s).getClass()){
                    ICSundae loopSundae = (ICSundae) loopOrder.serveArray.get(s);
                    System.out.printf("   Serving %d: %s ", s+1, "Ice Cream Sundae\n");
                    for(int j = 0; j < 2; j++){
                        if(loopSundae.scoops[j] != null){
                            System.out.printf("   Flavor %d.%s\n", j+1, loopSundae.scoops[j].flavor);
                        }
                    }
                    
                    total += loopSundae.servePrice;
                }
                else if(tempSplit.getClass() == loopOrder.serveArray.get(s).getClass()){
                    BananaSplit loopSplit = (BananaSplit) loopOrder.serveArray.get(s);
                    System.out.printf("Serving %d: %s ", s+1, "Banana Split\n");
                    for(int j = 0; j < 3; j++){
                        if(loopSplit.scoops[j] != null){
                            System.out.printf("   Flavor %d.%s\n", j+1, loopSplit.scoops[j].flavor);
                        }
                    }
                    total += loopSplit.servePrice;
                }
                else if(tempSoda.getClass() == loopOrder.serveArray.get(s).getClass()){
                    ICSoda loopSoda = (ICSoda) loopOrder.serveArray.get(s);
                    System.out.printf("Serving %d: %s ", s+1, "Ice Cream Soda\n");
                    System.out.printf("   Flavor %s\n", loopSoda.icServing.flavor);
                    total += loopSoda.servePrice;
                }
                else if(tempFloat.getClass() == loopOrder.serveArray.get(s).getClass()){
                    System.out.printf("Serving %d: Root Beer Float\n", s+1);
                    total += loopOrder.serveArray.get(s).servePrice;
                }
                System.out.printf("   Price: $%.2f\n", loopOrder.serveArray.get(s).servePrice);
            }
            System.out.printf("--------------------\nOrder Total: %.2f\n", loopOrder.gettotal());
            }
        }
    }
    
    /*Method that saves the customers, workers and flavors to file*/
    public void saveArrays()
    {
        int i;
        Worker tempWork = new Worker("First Last");
        Stocker tempStock = new Stocker("First Last");
        Cashier tempCash = new Cashier("First Last");
        
        try{
        
        Formatter writer = new Formatter(this.customers);
        
        for(i = 0; i < custArray.size(); i++)
        {
            Customer loopCust = custArray.get(i);
            writer.format("%d,%s,%.2f,%d,%d,%d,%d,%d,%d,%d,%d,%d%n",
                    loopCust.idNum, loopCust.name, loopCust.moneyBal, loopCust.happy, loopCust.pennies, loopCust.nickels, loopCust.dimes, loopCust.quarters, loopCust.ones, loopCust.fives, loopCust.tens, loopCust.twenties);
            writer.flush();
        }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Shop.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try{
        Formatter writer = new Formatter(this.workers);
        
        for(i = 0; i < workerArray.size(); i++)
        {
            if(workerArray.get(i).getClass() == tempWork.getClass()){
                Worker loopWork = workerArray.get(i);
                writer.format("%d,Worker,%s,%d,%d,%.2f%n", loopWork.idNum, loopWork.name, loopWork.custNo, loopWork.scoopsNo, loopWork.getMoney());
                writer.flush();
            }
            else if(workerArray.get(i).getClass() == tempStock.getClass()){
                Stocker loopStock = (Stocker) workerArray.get(i);
                writer.format("%d,Stocker,%s,%d,%d,%.2f,%d%n", loopStock.idNum, loopStock.name, loopStock.custNo, loopStock.scoopsNo, loopStock.getMoney(), loopStock.Stamina);
                writer.flush();
            }
            else if(workerArray.get(i).getClass() == tempCash.getClass()){
                Cashier loopCash = (Cashier) workerArray.get(i);
                writer.format("%d,Cashier,%s,%d,%d,%.2f%d%n", loopCash.idNum, loopCash.name, loopCash.custNo, loopCash.scoopsNo, loopCash.getMoney(), loopCash.patience);
                writer.flush();
            }
        }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Shop.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try{
        Formatter writer = new Formatter(this.icflavors);
        
        for(i = 0; i < icArray.size(); i++)
        {
            IceCream loopIC = icArray.get(i);
            writer.format("%d,%.2f,%s,%s,%s,%d%n", loopIC.idNum, loopIC.price, loopIC.flavor, loopIC.flavor, loopIC.descrip, loopIC.scoops); 
            
        }
        writer.flush();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Shop.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /*Method to put a cashier on duty*/
    public void setCasiher(){
        int i;
        ArrayList<Cashier> cashierArray = new ArrayList<>();
        Cashier tempCash = new Cashier("First Last");
        
        //Arranges cashiers into an array
        for(i = 0; i < workerArray.size(); i++){
            
            if(tempCash.getClass() == workerArray.get(i).getClass()){
                Cashier loopCash = (Cashier) workerArray.get(i);
                cashierArray.add(loopCash);
                
            }
        }
        setCashierDialog cashierDialog = new setCashierDialog(cashierArray);
        cashierDialog.setModal(true);
        cashierDialog.setVisible(true);
        
        if (cashierDialog.record != null){
            cashierObj = cashierDialog.record;
            cashierObj.onBreak = false;
        }
    }
    
    /*method to put a stocker on duty*/
    public void setStocker(){
        int i;
        Stocker tempStock = new Stocker("First Last");
        ArrayList<Stocker> stockerArray = new ArrayList<>();
        for(i = 0; i < workerArray.size(); i++){
            
            if(tempStock.getClass() == workerArray.get(i).getClass()){
                Stocker loopStock = (Stocker) workerArray.get(i);
                stockerArray.add(loopStock);
            }
        }
        setStockerDialog stockDialog = new setStockerDialog(stockerArray);
        stockDialog.setModal(true);
        stockDialog.setVisible(true);
        
        if(stockDialog.record != null){
            stockerObj = stockDialog.record;
            stockerObj.onBreak = false;
        }
    }
    
    /*Method to put the active cashier on break*/
    public void cashierBreak(){
        if(cashierObj != null){
            JOptionPane.showMessageDialog(null, "The Active Cashier Has been put on break");
            Cashier tempCash = cashierObj;
            cashierObj = null;
            int i;
            
            /*loops through worker array and ovewrites the worker with the same 
            id as the active cashier*/
            for(i = 0; i < workerArray.size(); i++){
                if(tempCash.getClass() == workerArray.get(i).getClass()){
                    if(tempCash.idNum == workerArray.get(i).idNum){
                        workerArray.set(i, tempCash);
                        break;
                    }
                
                }
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "No Cashier Active");
        }
    }
    /*method to put the active stocker on break*/
    public void stockerBreak(){
       if(stockerObj != null){
            JOptionPane.showMessageDialog(null, "The Active Stocker has been put on break");
            Stocker tempStock = stockerObj;
            stockerObj = null;
            int i;
            /*loops through the worker array and overwrites the worker with the 
            same id as the active stocker
            */
            for(i = 0; i < workerArray.size(); i++){
                if(tempStock.getClass() == workerArray.get(i).getClass()){
                    if(tempStock.idNum == workerArray.get(i).idNum){
                        workerArray.set(i, tempStock);
                        break;
                    }
                
                }
            }
        }
       else{
           JOptionPane.showMessageDialog(null, "No Active Stocker");
       }
    }
    
    /*Method to restock ice Cream*/
    public void icRestock(){
        //Checks if stocker is active(not null)
        if(stockerObj != null){
            
            restockDialog restockD = new restockDialog(icArray, stockerObj);
            restockD.setModal(true);
            restockD.setVisible(true);
            
            icArray = restockD.record;
            stockerObj = restockD.activeStock;
        }
        else{
            JOptionPane.showMessageDialog(null, "No Active Stocker");
        }
    }
    
    /*Method to test Not enough money exception*/
    public void moneyExcep(){
        Customer excepCust = new Customer("Exception Customer");
        excepCust.moneyBal = 0.00;
        double testMoney = 2.00;
        try{
            excepCust = transactions.cashTrans(excepCust, testMoney);
        }
        catch(NotEnoughMoneyException moneyExcep){
            System.err.printf("%nException: %s%n", moneyExcep);
            System.out.print("Not enough money in customer's wallet, please pay by credit.\n");
        }
    }
    public void MoneyPieCharts(){
        moneyPieChart.WorkerPieChart(workerArray);
    }
    public void MoneyBarCharts(){
        moneyBarChart.WorkerBarChart(workerArray);
    }
    public void HappinessPieCharts(){
        happinessPieChart.happinessPieChart(custArray);
    }
    public void HappinessBarCharts(){
        happinessBarChart.happinessBarChart(custArray);
    }
}

