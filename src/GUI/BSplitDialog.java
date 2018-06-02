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
import hbparlor.BananaSplit;
import hbparlor.IceCream;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.lang.Integer;

public class BSplitDialog extends JDialog implements ActionListener, ItemListener{
    public BananaSplit record;
    public int serveNo;
    public ArrayList<IceCream> ICArray1;
    public String[] condimentList = {"Strawberry", "Chocolate", "Marshmellow Cream", "Pineapple", "Ketchup", "Mustard", "Pickle Relish"};
    JButton buttonOK;
    JButton buttonCancel;
    
    JLabel labelFlavor1 = new JLabel("Flavor 1st Scoop");
    JLabel labelFlavor2 = new JLabel("Flavor 2nd Scoop");
    JLabel labelFlavor3 = new JLabel("Flavor 3rd Scoop");
    JLabel labelSauce1 = new JLabel("1st Condiment");
    JLabel labelSauce2 = new JLabel("2nd Condiment");
    JLabel labelSauce3 = new JLabel("3rd Condiment");
    JLabel labelNuts = new JLabel("Do you want Nuts?");
    
    ButtonGroup NutGroup;
    JRadioButton radioNuts;
    JRadioButton radioNoNuts;
    
    JComboBox comboFlavor1;
    JComboBox comboFlavor2;
    JComboBox comboFlavor3;
    JComboBox comboSauce1;
    JComboBox comboSauce2;
    JComboBox comboSauce3;
    
    public BSplitDialog(ArrayList<IceCream> ICArray, int serveNo) {
        this.serveNo = serveNo;
        record = new BananaSplit();
        ICArray1 = ICArray;
        Dimension size;
        String orderTitle = String.format("Add Banana Split: Serving #%d", serveNo);
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
        GridLayout gl2 = new GridLayout(6,2);
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
        
        for(i = 0; i < ICArray.size(); i++){
            comboFlavor2.addItem(ICArray.get(i).getFlavor());
        }
        comboFlavor2.addActionListener(this);
        comboPanel.add(labelFlavor2);
        comboPanel.add(comboFlavor2);
        
        comboFlavor3 = new JComboBox();
        
        for(i = 0; i < ICArray.size(); i++){
            comboFlavor3.addItem(ICArray.get(i).getFlavor());
        }
        comboFlavor3.addActionListener(this);
        comboPanel.add(labelFlavor3);
        comboPanel.add(comboFlavor3);
        
        comboSauce1 = new JComboBox();
        
        for(i = 0; i < condimentList.length; i++){
            comboSauce1.addItem(condimentList[i]);
        }
        comboPanel.add(labelSauce1);
        comboPanel.add(comboSauce1);
        
        comboSauce2 = new JComboBox();
        
        for(i = 0; i < condimentList.length; i++){
            comboSauce2.addItem(condimentList[i]);
        }
        comboPanel.add(labelSauce2);
        comboPanel.add(comboSauce2);
        
        comboSauce3 = new JComboBox();
        
        for(i = 0; i < condimentList.length; i++){
            comboSauce3.addItem(condimentList[i]);
        }
        comboPanel.add(labelSauce3);
        comboPanel.add(comboSauce3);
        
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
            record.addIC(ICArray1.get(pos),1);
            ICArray1.get(pos).scoops--;
            pos = comboFlavor2.getSelectedIndex();
            record.addIC(ICArray1.get(pos), 2);
            ICArray1.get(pos).scoops--;
            pos = comboFlavor3.getSelectedIndex();
            record.addIC(ICArray1.get(pos), 3);
            ICArray1.get(pos).scoops--;
            
            pos = comboSauce1.getSelectedIndex();
            record.setSauce(pos, 0);
            pos = comboSauce2.getSelectedIndex();
            record.setSauce(pos, 1);
            pos = comboSauce3.getSelectedIndex();
            record.setSauce(pos, 2);
            
            if(NutGroup.getSelection() == radioNuts){
                record.dezNuts = true;
            }
            else{
                record.dezNuts = false;
            }
            record.servePrice += 2.00;
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