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
import hbparlor.Stocker;
import hbparlor.IceCream;
import java.util.ArrayList;
import javax.swing.JTextField;
import java.lang.Integer;

public class restockDialog extends JDialog implements ActionListener, ItemListener{
    public int serveNo;
    public ArrayList<IceCream> record;
    public Stocker activeStock;
    JButton buttonOK;
    JButton buttonCancel;
    JButton buttonRestock;
    
    JLabel labelFlavor = new JLabel("Select Flavor To Restock");
    
    JComboBox comboFlavor;
    
    public restockDialog(ArrayList<IceCream> ICArray, Stocker activeStocker) {
        record = ICArray;
        activeStock = activeStocker;
        Dimension size;
        String orderTitle = String.format("Restock IceCream", serveNo);
        size=new Dimension(400,300);
        this.setTitle(orderTitle);
        this.setSize(size);
        
        buttonOK=new JButton("OK");
        buttonOK.addActionListener(this);
        buttonCancel=new JButton("Cancel");
        buttonCancel.addActionListener(this);
        buttonRestock=new JButton("Restock");
        buttonRestock.addActionListener(this);
        
        BorderLayout bl = new BorderLayout();
        this.setLayout(bl);
        
        JPanel buttonPanel = new JPanel();
        GridLayout gl=new GridLayout(1,3);
        buttonPanel.setLayout(gl);
        
        buttonPanel.add(buttonOK);
        buttonPanel.add(buttonRestock);
        buttonPanel.add(buttonCancel);
        this.add(buttonPanel,bl.SOUTH);
        
        JPanel comboPanel = new JPanel();
        GridLayout gl2 = new GridLayout(1,2);
        comboPanel.setLayout(gl2);
        
        comboFlavor = new JComboBox();
        int i;
        for(i =0; i < ICArray.size(); i++){
            comboFlavor.addItem(ICArray.get(i).getFlavor());
        }
        comboFlavor.addActionListener(this);
        comboPanel.add(labelFlavor);
        comboPanel.add(comboFlavor);
        
        this.add(comboPanel,bl.CENTER);
}

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand()=="OK"){
            this.dispose();
        }
        else if (e.getActionCommand()=="Cancel"){
            this.dispose();
        }
        else if (e.getActionCommand()=="Restock"){
            int pos;
            pos = comboFlavor.getSelectedIndex();
            record.get(pos).scoops = 80;
            activeStock.decStan();
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        
    }
}