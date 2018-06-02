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
import javax.swing.JPanel;
import hbparlor.Cashier;
import java.util.ArrayList;
import javax.swing.JTextField;
import java.lang.Integer;
/**
 *
 * @author Craig
 */
public class setCashierDialog extends JDialog implements ActionListener, ItemListener{
    public Cashier record = new Cashier("First Last");
    public ArrayList<Cashier> cashierArray;
    JButton buttonOK;
    JButton buttonCancel;
    
    JLabel labelCashier = new JLabel("Select Cashier");
    
    JComboBox comboCashier;
    
    public setCashierDialog(ArrayList<Cashier> cashiers){
        cashierArray = cashiers;
        Dimension size;
        String orderTitle = String.format("Set Active Cashier");
        size=new Dimension(400,300);
        this.setTitle(orderTitle);
        this.setSize(size);
        
        buttonOK=new JButton("OK");
        buttonOK.addActionListener(this);
        buttonCancel=new JButton("Cancel");
        buttonCancel.addActionListener(this);
        
        BorderLayout bl = new BorderLayout();
        this.setLayout(bl);
        
        JPanel buttonPanel = new JPanel();
        GridLayout gl=new GridLayout(1,2);
        buttonPanel.setLayout(gl);
        
        buttonPanel.add(buttonOK);
        buttonPanel.add(buttonCancel);
        this.add(buttonPanel,bl.SOUTH);
        
        JPanel comboPanel = new JPanel();
        GridLayout gl2 = new GridLayout(1,2);
        comboPanel.setLayout(gl2);
        
        comboCashier = new JComboBox();
        int i;
        for (i = 0; i < cashiers.size(); i++){
            comboCashier.addItem(cashiers.get(i).name);
        }
        comboCashier.addActionListener(this);
        comboPanel.add(labelCashier);
        comboPanel.add(comboCashier);
        
        this.add(comboPanel, bl.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand()=="OK"){
            int pos;
            pos = comboCashier.getSelectedIndex();
            record = cashierArray.get(pos);
            
            this.dispose();
        }
        else if (e.getActionCommand()=="Cancel"){
            record = null;
            this.dispose();
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        
    }
    
}
