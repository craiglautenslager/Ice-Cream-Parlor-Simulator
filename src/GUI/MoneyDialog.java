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
import hbparlor.Worker;
import hbparlor.Customer;
import hbparlor.Order;

import javax.swing.JTextField;
import java.lang.Integer;
import java.text.DecimalFormat;

public class MoneyDialog extends JDialog implements ActionListener, ItemListener{
    public int record;
    JButton buttonOk;
    JButton buttonCash;
    
    JPanel textFieldPanel;
    
    JTextField textAmmount;
    
    JLabel Label;
    
    
    public MoneyDialog(String input) {
        
        
        Dimension size;
        size=new Dimension(400,300);
        
        if(input=="twenty"){
        this.setTitle("Twenties?");
        }
        
        if(input=="ten"){
        this.setTitle("Tens?");
        }
        
        if(input=="five"){
        this.setTitle("Fives?");
        }
        
        if(input=="one"){
        this.setTitle("Ones?");
        }
        
        if(input=="quarter"){
        this.setTitle("Quarters?");
        }
        
        if(input=="dime"){
        this.setTitle("Dimes?");
        }
        
        if(input=="nickel"){
        this.setTitle("Nickels?");
        }
        
        if(input=="penny"){
        this.setTitle("Pennies?");
        }
        
        
        //textFieldPanel=new JPanel();
        
        //GridLayout gltf=new GridLayout(10,2);
        
        //textFieldPanel.setLayout(gltf);
        
        buttonOk=new JButton("OK");
        buttonOk.addActionListener(this);
        
        
        textAmmount = makeTextField("Enter ammount:", true);
        
        BorderLayout bl=new BorderLayout();//LayoutManager
        
        this.setLayout(bl);
        
        JPanel buttonPanel=new JPanel();
        GridLayout gl=new GridLayout(1,1);
        buttonPanel.setLayout(gl);
        
        buttonPanel.add(buttonOk);
        this.add(buttonPanel,bl.SOUTH);
        
        
        this.setSize(size);
        
        
        
        JPanel InfoPanel = new JPanel();
        GridLayout gl2 = new GridLayout(1,2);
        InfoPanel.setLayout(gl2);
        
        
        
               
             
                
        if(input=="twenty"){
        Label=new JLabel("How many twenties?");;
        }
        
        if(input=="ten"){
        Label=new JLabel("How many tens?");;
        }
        
        if(input=="five"){
        Label=new JLabel("How many fives?");;
        }
        
        if(input=="one"){
        Label=new JLabel("How many ones?");;
        }
        
        if(input=="quarter"){
        Label=new JLabel("How many quarters?");;
        }
        
        if(input=="dime"){
        Label=new JLabel("How many dimes?");;
        }
        
        if(input=="nickel"){
        Label=new JLabel("How many nickels?");;
        }
        
        if(input=="penny"){
        Label=new JLabel("How many pennies?");;
        }        
        
        
        
        InfoPanel.add(Label);
        InfoPanel.add(textAmmount);
        
        
        
       
        
        this.add(InfoPanel,bl.CENTER);
  
        
        
        

        
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        
        if (e.getActionCommand()=="OK"){
            
            
            record = Integer.parseInt(this.textAmmount.getText());
            
            
            
            this.dispose();
        }
        
        
    }
    
    @Override
    public void itemStateChanged(ItemEvent e){   
    }
    
   
    
    
    private JTextField makeTextField(String string,boolean enable) {
		JTextField tf=new JTextField();
		JLabel l=new JLabel(string);
	
		/*.textFieldPanel.add(l);
		this.textFieldPanel.add(tf);*/
		l.setEnabled(enable);
		tf.setEnabled(enable);
		return tf;
    }
}