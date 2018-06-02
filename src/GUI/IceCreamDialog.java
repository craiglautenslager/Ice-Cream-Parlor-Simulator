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
import hbparlor.IceCream;
import javax.swing.JTextField;
import java.lang.Integer;

public class IceCreamDialog extends JDialog implements ActionListener, ItemListener{
    IceCream record = new IceCream();
    int id;
    JButton buttonOK;
    JButton buttonCancel;
    
    JPanel textFieldPanel;
    
    JTextField textDescription;
    JTextField textFlavor;
    JTextField textName;
    JTextField textScoops;
    JTextField textPrice;
    
    JLabel nameLabel;
    JLabel IdLabel;
    JLabel FlavorLabel;
    JLabel ScoopsNoLabel;
    JLabel PriceLabel;
    JLabel DescriptionLabel;
    
    public IceCreamDialog(int ID) {
        Dimension size;
        size=new Dimension(400,300);
        id = ID;
        
        this.setTitle("Create IceCream");
        
        //textFieldPanel=new JPanel();
        
        //GridLayout gltf=new GridLayout(10,2);
        
        //textFieldPanel.setLayout(gltf);
        
        buttonOK=new JButton("OK");
        buttonOK.addActionListener(this);
        buttonCancel=new JButton("Cancel");
        buttonCancel.addActionListener(this);
        
        //textName=new JTextField();
        
        textName = makeTextField("Enter name", true);
        textFlavor = makeTextField("Enter flavor", true);
        textScoops = makeTextField("Enter amount of scoops", true);
        textPrice = makeTextField("Enter price:", true);
        textDescription = makeTextField("Enter description:", true);
        
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
        GridLayout gl2 = new GridLayout(6,2);
        InfoPanel.setLayout(gl2);
        
        nameLabel=new JLabel("Name:");
        InfoPanel.add(nameLabel);
        InfoPanel.add(textName);
        
        DescriptionLabel=new JLabel("Description:");
        InfoPanel.add(DescriptionLabel);
        InfoPanel.add(textDescription);
        
        
        FlavorLabel=new JLabel("Flavor:");
        InfoPanel.add(FlavorLabel);
        InfoPanel.add(textFlavor);
        
        ScoopsNoLabel=new JLabel("Scoop ammount:");
        InfoPanel.add(ScoopsNoLabel);
        InfoPanel.add(textScoops);
        
        PriceLabel=new JLabel("Price:");
        InfoPanel.add(PriceLabel);
        InfoPanel.add(textPrice);
        
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
            
            record.name = this.textName.getText();
            record.idNum = id;
            record.descrip = this.textDescription.getText();
            record.flavor = this.textFlavor.getText();
            record.price = Double.parseDouble(this.textPrice.getText());
            record.scoops = Integer.parseInt(this.textScoops.getText());
            
            this.dispose();
        }
        
        if (e.getActionCommand()=="Cancel"){
            this.dispose();
        }
    }
    
    @Override
    public void itemStateChanged(ItemEvent e){   
    }
    
    public void setRecord(IceCream newIceCream){
       this.record = newIceCream;
    }
    
    public IceCream getRecord(){
        return this.record;
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