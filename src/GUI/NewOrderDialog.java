package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import hbparlor.Order;
import hbparlor.Customer;
import hbparlor.Worker;
import hbparlor.IceCream;
import hbparlor.RootBeerFloat;
import java.util.ArrayList;
import java.awt.event.WindowListener;
import javax.swing.JTextField;
import java.lang.Integer;

public class NewOrderDialog extends JDialog implements ActionListener, ItemListener{
    public Order record;
    public ArrayList<Customer> custArray1;
    public ArrayList<Worker> workerArray1;
    public ArrayList<IceCream> ICArray1;
    public int serveNo = 1;
    JButton buttonOK;
    JButton buttonCancel;
    JPanel peoplePanel;
    
    JComboBox comboCust;
    JComboBox comboWorker;
    
    JLabel labelCust = new JLabel("Customer");
    JLabel labelWorker = new JLabel("Worker");
    
    JButton buttonICCone;
    JButton buttonICSundae;
    JButton buttonBSplit;
    JButton buttonICSoda;
    JButton buttonRBFloat;
    
    public NewOrderDialog(int orderNo, ArrayList<Customer> custArray, ArrayList<Worker> workerArray, ArrayList<IceCream> ICArray) {
        record = new Order(orderNo);
        custArray1 = custArray;
        workerArray1 = workerArray;
        ICArray1 = ICArray;
        Dimension size;
        String orderTitle = String.format("Place Order #%d", orderNo);
        size=new Dimension(400,300);
        this.setTitle(orderTitle);
        this.setSize(size);
        
        buttonOK=new JButton("OK");
        buttonOK.addActionListener(this);
        buttonCancel=new JButton("Cancel");
        buttonCancel.addActionListener(this);
        
        buttonICCone = new JButton("Ice Cream Cone");
        buttonICCone.addActionListener(this);
        buttonICSundae = new JButton("Ice Cream Sundae");
        buttonICSundae.addActionListener(this);
        buttonBSplit = new JButton("Banana Split");
        buttonBSplit.addActionListener(this);
        buttonICSoda = new JButton("Ice Cream Soda");
        buttonICSoda.addActionListener(this);
        buttonRBFloat = new  JButton("Root Beer Float");
        buttonRBFloat.addActionListener(this);
        
        BorderLayout bl=new BorderLayout();//LayoutManager
        
        this.setLayout(bl);
        
        JPanel buttonPanel = new JPanel();
        GridLayout gl=new GridLayout(1,2);
        buttonPanel.setLayout(gl);
        
        buttonPanel.add(buttonOK);
        buttonPanel.add(buttonCancel);
        this.add(buttonPanel,bl.SOUTH);
        
        JPanel selectPanel = new JPanel();
        GridLayout gl2 = new GridLayout(2,3);
        selectPanel.setLayout(gl2);
        
        selectPanel.add(buttonICCone);
        selectPanel.add(buttonICSundae);
        selectPanel.add(buttonBSplit);
        selectPanel.add(buttonICSoda);
        selectPanel.add(buttonRBFloat);
        this.add(selectPanel,bl.CENTER);
        
        peoplePanel = new JPanel();
        GridLayout gl3 = new GridLayout(2,2);
        peoplePanel.setLayout(gl3);
        
        comboCust = new JComboBox();
        int i;
        for(i = 0;i < custArray.size(); i++){
            comboCust.addItem(custArray.get(i).getName());
            
        }
        comboCust.addActionListener(this);
        peoplePanel.add(labelCust);
        peoplePanel.add(comboCust);
        
        comboWorker = new JComboBox();
        for(i = 0;i < workerArray.size(); i++){
            comboWorker.addItem(workerArray.get(i).getName());
        }
        comboWorker.addActionListener(this);
        peoplePanel.add(labelWorker);
        peoplePanel.add(comboWorker);
        this.add(peoplePanel, bl.NORTH);
    }
    
    

    
        
    
    
    @Override
    public void actionPerformed(ActionEvent e){
        
        if (e.getActionCommand()=="OK"){
            int pos;
            pos = comboCust.getSelectedIndex();
            record.setCust(custArray1.get(pos));
            record.custNo = pos + 1;
            pos = comboWorker.getSelectedIndex();
            record.setWorker(workerArray1.get(pos));
            
            this.dispose();
        }
        else if (e.getActionCommand()=="Cancel"){
            this.dispose();
        }
        else if (e.getActionCommand()=="Ice Cream Cone"){
            ICConeDialog ICCDialog = new ICConeDialog(ICArray1, serveNo);
            ICCDialog.setModal(true);
            ICCDialog.setVisible(true);
            record.addServe(ICCDialog.record);
            this.ICArray1 = ICCDialog.ICArray1;
            this.serveNo = ICCDialog.serveNo;
            
        }
        else if (e.getActionCommand()=="Ice Cream Sundae"){
            ICSundaeDialog ICSDialog = new ICSundaeDialog(ICArray1,serveNo);
            ICSDialog.setModal(true);
            ICSDialog.setVisible(true);
            record.addServe(ICSDialog.record);
            this.ICArray1 = ICSDialog.ICArray1;
            this.serveNo = ICSDialog.serveNo;
            
        }
        else if (e.getActionCommand()=="Banana Split"){
            BSplitDialog BSDialog = new BSplitDialog(ICArray1, serveNo);
            BSDialog.setModal(true);
            BSDialog.setVisible(true);
            record.addServe(BSDialog.record);
            this.ICArray1 = BSDialog.ICArray1;
            this.serveNo = BSDialog.serveNo;
        }
        else if (e.getActionCommand()=="Ice Cream Soda"){
            ICSodaDialog SodaDialog = new ICSodaDialog(ICArray1, serveNo);
            SodaDialog.setModal(true);
            SodaDialog.setVisible(true);
            record.addServe(SodaDialog.record);
            this.ICArray1 = SodaDialog.ICArray1;
            this.serveNo = SodaDialog.serveNo;
        }
        else if (e.getActionCommand()=="Root Beer Float"){
            JOptionPane.showMessageDialog(this, "Root Beer Float Added");
            RootBeerFloat loopFloat = new RootBeerFloat();
            loopFloat.setFlavor(ICArray1.get(0));
            ICArray1.get(0).scoops--;
            loopFloat.servePrice = 1.25;
            record.addServe(loopFloat);
        }
    }
    
    @Override
    public void itemStateChanged(ItemEvent e){ 
        
    }
    
    public void setRecord(Customer newCust){
       
    }
    
    /*private JRadioButton makeRadioButton(String label)
	{
		JRadioButton rb=new JRadioButton(label);
		rb.addActionListener(this);
		radioCust.add(rb);
		return rb;
	}*/
}