package GUI;

import hbparlor.Cashier;
import hbparlor.Stocker;
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

public class WorkerDialog extends JDialog implements ActionListener, ItemListener{
    public Worker recordW = new Worker("First Last");
    public Stocker recordS = new Stocker("First Last");
    public Cashier recordC = new Cashier("First Last");
    
    public int workerID, type;
    JButton buttonOK;
    JButton buttonCancel;
    
    JPanel textFieldPanel;
    
    JTextField textName;
    JTextField textCustNo;
    JTextField textScoopNo;
    JTextField textMoney;
    
    JComboBox comboType;
    
    JLabel labelType;
    JLabel nameLabel;
    JLabel IdLabel;
    JLabel CustNoLabel;
    JLabel ScoopsNoLabel;
    JLabel MoneyLabel;
    
    public WorkerDialog(int ID) {
        Dimension size;
        size=new Dimension(400,300);
        workerID = ID;
        
        this.setTitle("Create Worker");
        
        //textFieldPanel=new JPanel();
        
        //GridLayout gltf=new GridLayout(10,2);
        
        //textFieldPanel.setLayout(gltf);
        
        buttonOK=new JButton("OK");
        buttonOK.addActionListener(this);
        buttonCancel=new JButton("Cancel");
        buttonCancel.addActionListener(this);
        
        //textName=new JTextField();
        
        textName = makeTextField("Enter Name", true);
        textCustNo = makeTextField("Enter Amount of Customers", true);
        textScoopNo = makeTextField("Enter Amount of Scoops", true);
        textMoney = makeTextField("Enter Money Earned", true);
        
        BorderLayout bl=new BorderLayout();//LayoutManager
        
        this.setLayout(bl);
        
        JPanel buttonPanel=new JPanel();
        GridLayout gl=new GridLayout(1,2);
        buttonPanel.setLayout(gl);
        
        buttonPanel.add(buttonOK);
        buttonPanel.add(buttonCancel);
        this.add(buttonPanel,bl.SOUTH);
        
        
        this.setSize(size);
        
        JPanel InfoPanel = new JPanel();
        GridLayout gl2 = new GridLayout(5,2);
        InfoPanel.setLayout(gl2);
        
        nameLabel=new JLabel("Name:");
        InfoPanel.add(nameLabel);
        InfoPanel.add(textName);
        
        
        CustNoLabel=new JLabel("Customers served:");
        InfoPanel.add(CustNoLabel);
        InfoPanel.add(textCustNo);
        
        ScoopsNoLabel=new JLabel("Scoops served:");
        InfoPanel.add(ScoopsNoLabel);
        InfoPanel.add(textScoopNo);
        
        MoneyLabel=new JLabel("Money Earned:");
        InfoPanel.add(MoneyLabel);
        InfoPanel.add(textMoney);
        
        labelType = new JLabel("Type of Worker");
        InfoPanel.add(labelType);
        comboType = new JComboBox();
        comboType.addItem("Regular Worker");
        comboType.addItem("Cashier");
        comboType.addItem("Stocker");
        comboType.addActionListener(this);
        
        InfoPanel.add(comboType);
        
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
            
            if (comboType.getSelectedIndex() == 0){
                type = 0;
                recordW.name = this.textName.getText();
                recordW.idNum = workerID;
                recordW.custNo = Integer.parseInt(this.textCustNo.getText());
                recordW.scoopsNo = Integer.parseInt(this.textScoopNo.getText());
                recordW.money = Double.parseDouble(this.textMoney.getText());
            }
            else if (comboType.getSelectedIndex() == 1){
                type = 1;
                recordC.name = this.textName.getText();
                recordC.idNum = workerID;
                recordC.custNo = Integer.parseInt(this.textCustNo.getText());
                recordC.scoopsNo = Integer.parseInt(this.textScoopNo.getText());
                recordC.money = Double.parseDouble(this.textMoney.getText());
                recordC.patience = 20;
            }
            else if (comboType.getSelectedIndex() == 2){
                type = 2;
                recordS.name = this.textName.getText();
                recordS.idNum = workerID;
                recordS.custNo = Integer.parseInt(this.textCustNo.getText());
                recordS.scoopsNo = Integer.parseInt(this.textScoopNo.getText());
                recordS.money = Double.parseDouble(this.textMoney.getText());
                recordS.Stamina = 20;
            }
            
            
            this.dispose();
        }
        
        if (e.getActionCommand()=="Cancel"){
            this.dispose();
        }
    }
    
    @Override
    public void itemStateChanged(ItemEvent e){   
    }
    
//    public void setRecord(Worker newWork){
//       this.record = newWork;
//    }
//    
//    public Worker getRecord(){
//        return this.record;
//    }
    
    
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