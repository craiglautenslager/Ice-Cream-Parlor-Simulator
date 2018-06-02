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
import hbparlor.ICSoda;
import hbparlor.IceCream;
import java.util.ArrayList;
import javax.swing.JTextField;
import java.lang.Integer;

public class ICSodaDialog extends JDialog implements ActionListener, ItemListener{
    public ICSoda record;
    public int serveNo;
    public ArrayList<IceCream> ICArray1;
    JButton buttonOK;
    JButton buttonCancel;
    
    JLabel labelFlavor1 = new JLabel("Select Flavor");
    
    JComboBox comboFlavor1;
    
    public ICSodaDialog(ArrayList<IceCream> ICArray, int serveNo) {
        this.serveNo = serveNo;
        record = new ICSoda();
        ICArray1 = ICArray;
        Dimension size;
        String orderTitle = String.format("Add Ice Cream Soda: Serving #%d", serveNo);
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
        
        comboFlavor1 = new JComboBox();
        int i;
        for(i =0; i < ICArray.size(); i++){
            comboFlavor1.addItem(ICArray.get(i).getFlavor());
        }
        comboFlavor1.addActionListener(this);
        comboPanel.add(labelFlavor1);
        comboPanel.add(comboFlavor1);
        
        this.add(comboPanel,bl.CENTER);
}

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand()=="OK"){
            int pos, nextScoop = 1;
            pos = comboFlavor1.getSelectedIndex();
            record.setFlavor(ICArray1.get(pos));
            ICArray1.get(pos).scoops--;
            ICArray1.get(pos).scoops--;
            record.servePrice = record.icServing.price + record.icServing.price;
            this.serveNo++;
            this.dispose();
        }
        else if (e.getActionCommand()=="Cancel"){
            this.dispose();
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        
    }
}