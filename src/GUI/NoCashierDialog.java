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
import javax.swing.JTextField;
import java.lang.Integer;

public class NoCashierDialog extends JDialog implements ActionListener, ItemListener{
    JButton buttonOK;
    JButton buttonCancel;
    
    JPanel textFieldPanel;
    
    

    JLabel InfoLabel;
    
    public NoCashierDialog() {
        Dimension size;
        size=new Dimension(400,300);
        
        this.setTitle("No Cashier");
        
        
        buttonOK=new JButton("OK");
        buttonOK.addActionListener(this);

        
        BorderLayout bl=new BorderLayout();//LayoutManager
        
        this.setLayout(bl);
        
        JPanel buttonPanel=new JPanel();
        GridLayout gl=new GridLayout(1,1);
        buttonPanel.setLayout(gl);
        
        buttonPanel.add(buttonOK);
        this.add(buttonPanel,bl.SOUTH);
        
        
        this.setSize(size);
        
        JPanel InfoPanel = new JPanel();
        GridLayout gl2 = new GridLayout(1,0);
        InfoPanel.setLayout(gl2);
        
        
        
        
        
        //artificial centering workaround
        InfoLabel=new JLabel("                      "
                + "                         No Active Cashier!");
        InfoPanel.add(InfoLabel);
        
        this.add(InfoPanel,bl.CENTER);
  
        
        
        
//        JPanel CustNoPanel = new JPanel();
//        GridLayout g14 = new GridLayout(3,3);
//        CustNoPanel.setLayout(g14);
//        
//        CustNoPanel.add(textCustNo);
//        this.add(CustNoPanel, b1.);
        
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        
        if (e.getActionCommand()=="OK"){
            
            
            
            
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