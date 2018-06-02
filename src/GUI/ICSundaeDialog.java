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
import hbparlor.ICSundae;
import hbparlor.IceCream;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.lang.Integer;

public class ICSundaeDialog extends JDialog implements ActionListener, ItemListener{
    public ICSundae record;
    public int serveNo;
    public ArrayList<IceCream> ICArray1;
    public String[] condimentList = {"Strawberry", "Chocolate", "Marshmellow Cream", "Pineapple", "Ketchup", "Mustard", "Pickle Relish"};
    JButton buttonOK;
    JButton buttonCancel;
    
    JLabel labelFlavor1 = new JLabel("Flavor 1st Scoop");
    JLabel labelFlavor2 = new JLabel("Flavor 2nd Scoop");
    JLabel labelSauce = new JLabel("Condiments");
    JLabel labelNuts = new JLabel("Do you want Nuts?");
    
    ButtonGroup NutGroup;
    JRadioButton radioNuts;
    JRadioButton radioNoNuts;
    
    JComboBox comboFlavor1;
    JComboBox comboFlavor2;
    JComboBox comboSauce;
    
    public ICSundaeDialog(ArrayList<IceCream> ICArray, int serveNo) {
        this.serveNo = serveNo;
        record = new ICSundae();
        ICArray1 = ICArray;
        Dimension size;
        String orderTitle = String.format("Add Ice Cream Sundae: Serving #%d", serveNo);
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
        
        comboSauce = new JComboBox();
        
        for(i = 0; i < condimentList.length; i++){
            comboSauce.addItem(condimentList[i]);
        }
        comboPanel.add(labelSauce);
        comboPanel.add(comboSauce);
        this.add(comboPanel,bl.CENTER);
        
        NutGroup = new ButtonGroup();
        JPanel radioPanel = new JPanel();
        GridLayout gl3 = new GridLayout(1,3);
        radioNuts = new JRadioButton("Yes");
        radioNoNuts = new JRadioButton("No");
        
        radioPanel.add(labelNuts);
        radioPanel.add(radioNuts);
        radioPanel.add(radioNoNuts);
        NutGroup.add(radioNuts);
        NutGroup.add(radioNoNuts);
        radioNuts.setSelected(true);
        
        this.add(radioPanel, bl.NORTH);
}

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand()=="OK"){
            int pos;
            pos = comboFlavor1.getSelectedIndex();
            record.addIC(ICArray1.get(pos), 1);
            ICArray1.get(pos).scoops--;
            pos = comboFlavor2.getSelectedIndex();
            if(pos != 0){
                record.addIC(ICArray1.get(pos-1), 2);
                ICArray1.get(pos-1).scoops--;
            }
            pos = comboSauce.getSelectedIndex();
            record.setSauce(pos);
            if(NutGroup.getSelection() == radioNuts){
                record.dezNuts = true;
            }
            else{
                record.dezNuts = false;
            }
            record.servePrice += 1.00;
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