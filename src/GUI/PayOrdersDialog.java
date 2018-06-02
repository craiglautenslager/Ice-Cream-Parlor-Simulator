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

public class PayOrdersDialog extends JDialog implements ActionListener, ItemListener{
    public int record;
    JButton buttonCredit;
    JButton buttonCash;
    
    JPanel textFieldPanel;
    
    
    
    JLabel OrderLabel;
    
    
    public PayOrdersDialog(Order tempOrder) {
        
        double tempDouble;
        String tempString;
        String tempString2;
       
        
        Dimension size;
        size=new Dimension(400,300);
        
        this.setTitle("Pay Orders");
        
        //textFieldPanel=new JPanel();
        
        //GridLayout gltf=new GridLayout(10,2);
        
        //textFieldPanel.setLayout(gltf);
        
        buttonCredit=new JButton("Credit");
        buttonCredit.addActionListener(this);
        buttonCash=new JButton("Cash");
        buttonCash.addActionListener(this);
        
        //textName=new JTextField();
        
        
        
        BorderLayout bl=new BorderLayout();//LayoutManager
        
        this.setLayout(bl);
        
        JPanel buttonPanel=new JPanel();
        GridLayout gl=new GridLayout(1,2);
        buttonPanel.setLayout(gl);
        
        buttonPanel.add(buttonCredit);
        buttonPanel.add(buttonCash);
        this.add(buttonPanel,bl.SOUTH);
        
        
        this.setSize(size);
        
        JPanel InfoPanel = new JPanel();
        GridLayout gl2 = new GridLayout(1,1);
        InfoPanel.setLayout(gl2);
        
        
        
                tempDouble = tempOrder.gettotal();
                
             
                
                tempString=Integer.toString(tempOrder.getNum());
                tempString2=Double.toString(tempDouble);
        OrderLabel=new JLabel("                                             "
                + " Order # "+tempString+"."+"      $"+tempString2);
        InfoPanel.add(OrderLabel);
        
        
        
       
        
        this.add(InfoPanel,bl.CENTER);
  
        
        
        

        
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        
        if (e.getActionCommand()=="Credit"){
            
            
            record = 1;
            
            
            
            this.dispose();
        }
        
        if (e.getActionCommand()=="Cash"){
            record=2;
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