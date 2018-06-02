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
import hbparlor.IceCreamCone;
import hbparlor.IceCream;
import java.util.ArrayList;
import javax.swing.JTextField;
import java.lang.Integer;

public class ICConeDialog extends JDialog implements ActionListener, ItemListener{
    public IceCreamCone record;
    public int serveNo;
    public ArrayList<IceCream> ICArray1;
    JButton buttonOK;
    JButton buttonCancel;
    
    JLabel labelFlavor1 = new JLabel("Flavor 1st Scoop");
    JLabel labelFlavor2 = new JLabel("Flavor 2nd Scoop");
    JLabel labelFlavor3 = new JLabel("Flavor 3rd Scoop");
    
    JComboBox comboFlavor1;
    JComboBox comboFlavor2;
    JComboBox comboFlavor3;
    
    public ICConeDialog(ArrayList<IceCream> ICArray, int serveNo) {
        this.serveNo = serveNo;
        record = new IceCreamCone();
        ICArray1 = ICArray;
        Dimension size;
        String orderTitle = String.format("Add Ice Cream Cone: Serving #%d", serveNo);
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
        GridLayout gl2 = new GridLayout(3,2);
        comboPanel.setLayout(gl2);
        
        comboFlavor1 = new JComboBox();
        int i;
        for(i =0; i < ICArray.size(); i++){
            comboFlavor1.addItem(ICArray.get(i).getFlavor());
        }
        comboFlavor1.addActionListener(this);
        comboPanel.add(labelFlavor1);
        comboPanel.add(comboFlavor1);
        
        comboFlavor2 = new JComboBox();
        comboFlavor2.addItem("No 2nd Scoop");
        
        for(i = 0; i < ICArray.size(); i++){
            comboFlavor2.addItem(ICArray.get(i).getFlavor());
        }
        comboFlavor2.addActionListener(this);
        comboPanel.add(labelFlavor2);
        comboPanel.add(comboFlavor2);
        
        comboFlavor3 = new JComboBox();
        comboFlavor3.addItem("No 3rd Scoop");
        
        for(i = 0; i < ICArray.size(); i++){
            comboFlavor3.addItem(ICArray.get(i).getFlavor());
        }
        comboFlavor3.addActionListener(this);
        comboPanel.add(labelFlavor3);
        comboPanel.add(comboFlavor3);
        this.add(comboPanel,bl.CENTER);
}

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand()=="OK"){
            int pos, nextScoop = 2;
            pos = comboFlavor1.getSelectedIndex();
            record.addIC(ICArray1.get(pos), 1);
            ICArray1.get(pos).scoops--;
            pos = comboFlavor2.getSelectedIndex();
            if(pos != 0){
                record.addIC(ICArray1.get(pos-1), nextScoop);
                ICArray1.get(pos-1).scoops--;
                nextScoop++;
            }
            pos = comboFlavor3.getSelectedIndex();
            if(pos != 0){
                record.addIC(ICArray1.get(pos-1), nextScoop);
                ICArray1.get(pos-1).scoops--;
            }
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
