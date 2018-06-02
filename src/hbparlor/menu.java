package hbparlor;

import GUI.MenuFrame;
import java.util.Scanner;
/**
 *
 * @author Craig
 */
public class menu {
    public int orderNo = 1;
    
    /*Menu run method*/
    public void menuRun()
    {
        Scanner input = new Scanner(System.in);
        Shop shopObj = new Shop();// Creates a Shop object which controls the system
        
        boolean run;
        run = true;//Sets the while loop to run
        
        MenuFrame menuFrame = new MenuFrame(); 
        
        /*The menu input code, runs methods of the shop controller. Will become 
        irrelevant when we write the GUI
        while(run == true)
        {
            System.out.print("Ice Cream Main Menu\n\n \t1. Create Menu\n\t2. Actions Menu\n\t3. Display\n\t4. Exception Tests\n\t5. Quit\n");
            switch(input.nextInt())
            {
            case 1:
                System.out.print("Create Menu\n\n\t1. Create Ice Cream\n\t2. Create Customer\n\t3. Create Worker\n\t4. Create Order\n\t5. Return to Previous Menu\n");
                switch(input.nextInt())
                {
                    case 1:
                        shopObj.newIcecream();
                        break;
                    
                    case 2:
                        shopObj.newCustomer();
                        break;
                    case 3:
                        System.out.print("Create Worker Menu\n\n\t1. Create Regular Worker\n\t2. Create Stocker\n\t3. Create Cashier\n\t4. Return to Previous Menu\n");
                        switch(input.nextInt())
                        {
                            case 1:
                                shopObj.newWorker();
                                break;
                            case 2:
                                shopObj.newStocker();
                                break;
                            case 3:
                                shopObj.newCashier();
                                break;
                            case 4:
                                break;
                            default:
                            System.out.print("Create Worker\n\n\t1. Create Regular Worker\n\t2.Create Stocker\n\t3. Create Cashier\n\t4. Return to Previous Menu\n");    
                        }
                        break;
                    case 4:
                        shopObj.newOrder();
                        break;
                        
                    default:
                        System.out.print("Create Menu\n\n\t1. Create Ice Cream\n\t2. Create Serving\n\t3. Create Customer\n\t4. Create Worker\n\t5. Create Order\n\t6. Return to Previous Menu\n");
                }
                break;
            
            case 2:
                System.out.print("Actions Menu\n\n\t1. Pay Orders\n\t2. Set Active Cashier\n\t3. Put Cashier on Break\n\t4. Set Active Stocker\n\t5. Put Stocker on  Break\n\t6. Restock Ice Cream\n\t7. Return to Previous Menu\n");
                switch(input.nextInt()){
                    case 1:
                        shopObj.payOrders();
                        break;
                    case 2:
                        shopObj.setCasiher();
                        break;
                    case 3:
                        shopObj.cashierBreak();
                        break;
                    case 4:
                        shopObj.setStocker();
                        break;
                    case 5:
                        shopObj.stockerBreak();
                        break;
                    case 6:
                        shopObj.icRestock();
                        break;
                    
                }
                
                break;
                
            case 3:
                System.out.print("Display menu\n\n1. Waiting Orders\n2. Parlor Occupants\n3. Parlor Statistics\n4. Ice Cream Inventory\n5. Return To Previous Menu\n");
                switch(input.nextInt())
                {
                    case 1:
                        shopObj.orderWait();
                        break;
                    case 2:
                        shopObj.occupants();
                        break;
                    case 3:
                        shopObj.regBalance();
                        break;
                    case 4:
                        shopObj.icList();
                    default:
                }
                break;
            case 4:
                shopObj.moneyExcep();
                break;
            case 5:
                shopObj.saveArrays();
                System.exit(0);
                
            default:
                System.out.print("Ice Cream Main Menu\n\n \t1. Create Menu\n\t2. Update Menu\n\t3. Display\n\t4. Quit\n");
            }
        }*/
        
    }
}
