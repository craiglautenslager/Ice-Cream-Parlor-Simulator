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
import java.util.ArrayList;
import javax.swing.JTextField;
import java.lang.Integer;
/**
 *
 * @author Craig
 */
public class setStockerDialog extends JDialog implements ActionListener, ItemListener{
    public Stocker record = new Stocker("First Last");
    public ArrayList<Stocker> StockerArray;
    JButton buttonOK;
    JButton buttonCancel;
    
    JLabel labelStocker = new JLabel("Select Stocker");
    
    JComboBox comboStocker;
    
    public setStockerDialog(ArrayList<Stocker> Stockers){
        StockerArray = Stockers;
        Dimension size;
        String orderTitle = String.format("Set Active Stocker");
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
        
        comboStocker = new JComboBox();
        int i;
        for (i = 0; i < Stockers.size(); i++){
            comboStocker.addItem(Stockers.get(i).name);
        }
        comboStocker.addActionListener(this);
        comboPanel.add(labelStocker);
        comboPanel.add(comboStocker);
        
        this.add(comboPanel, bl.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand()=="OK"){
            int pos;
            pos = comboStocker.getSelectedIndex();
            record = StockerArray.get(pos);
            
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