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
import hbparlor.Customer;
import java.awt.event.WindowListener;
import javax.swing.JTextField;
import java.lang.Integer;

public class CustomerDialog extends JDialog implements ActionListener, ItemListener{
    public Customer record = new Customer("First last");
    JButton buttonOK;
    JButton buttonCancel;
    JPanel cashPanel;
    
    JLabel Name;
    
    
    JTextField textName;
    JTextField pennies;
    JTextField nickels;
    JTextField dimes;
    JTextField quarters;
    JTextField ones;
    JTextField fives;
    JTextField tens;
    JTextField twenties;
    
    public CustomerDialog() {
        Dimension size;
        size=new Dimension(400,300);
        this.setTitle("Create Customer");
        
        buttonOK=new JButton("OK");
        buttonOK.addActionListener(this);
        buttonCancel=new JButton("Cancel");
        buttonCancel.addActionListener(this);
        cashPanel = new JPanel();
        
        textName = new JTextField();
        Name = new JLabel("Name");
        
        pennies = makeCashField("Pennies", true);
        nickels = makeCashField("Nickels", true);
        dimes = makeCashField("Dimes", true);
        quarters = makeCashField("Quarters", true);
        ones = makeCashField("1 Dollar Bills", true);
        fives = makeCashField("5 Dollar Bills", true);
        tens = makeCashField("10 Dollar Bills", true);
        twenties = makeCashField("20 Dollar Bills", true);
        
        BorderLayout bl=new BorderLayout();//LayoutManager
        
        this.setLayout(bl);
        
        JPanel buttonPanel=new JPanel();
        GridLayout gl=new GridLayout(1,2);
        buttonPanel.setLayout(gl);
        
        buttonPanel.add(buttonOK);
        buttonPanel.add(buttonCancel);
        this.add(buttonPanel,bl.SOUTH);
        
        
        this.setSize(size);
        
        JPanel namePanel = new JPanel();
        GridLayout gl2 = new GridLayout(1,1);
        namePanel.setLayout(gl2);
        
        namePanel.add(Name);
        namePanel.add(textName);
        this.add(namePanel,bl.NORTH);
        
        
        GridLayout gl3 = new GridLayout(4,2);
        cashPanel.setLayout(gl3);
        
        /*cashPanel.add(pennies);
        cashPanel.add(nickels);
        cashPanel.add(dimes);
        cashPanel.add(quarters);
        cashPanel.add(ones);
        cashPanel.add(fives);
        cashPanel.add(tens);
        cashPanel.add(twenties);*/
        this.add(cashPanel, bl.CENTER);
        
        
    }
    
    

    
        
    
    
    @Override
    public void actionPerformed(ActionEvent e){
        
        if (e.getActionCommand()=="OK"){
            
            record.name = this.textName.getText();
            record.pennies = Integer.parseInt(this.pennies.getText());
            record.nickels = Integer.parseInt(this.nickels.getText());
            record.dimes = Integer.parseInt(this.dimes.getText());
            record.quarters = Integer.parseInt(this.quarters.getText());
            record.ones = Integer.parseInt(this.ones.getText());
            record.fives = Integer.parseInt(this.fives.getText());
            record.tens = Integer.parseInt(this.tens.getText());
            record.twenties = Integer.parseInt(this.twenties.getText());
            
            this.dispose();
        }
        else if (e.getActionCommand()=="Cancel"){
            this.dispose();
        }
    }
    
    @Override
    public void itemStateChanged(ItemEvent e){   
    }
    
    public void setRecord(Customer newCust){
       this.record = newCust;
    }
    
    private JTextField makeCashField(String string,boolean enable) {
		JTextField tf=new JTextField();
		JLabel l=new JLabel(string);
	
		this.cashPanel.add(l);
		this.cashPanel.add(tf);
		l.setEnabled(enable);
		tf.setEnabled(enable);
		return tf;
    }
}