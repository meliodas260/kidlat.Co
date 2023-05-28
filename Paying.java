import javax.swing.*;
import java.awt.*;  
import java.awt.event.*; 

public class Paying  extends Frame implements MouseListener{

    //this will remove the bill in the data base
    JButton cancel;
    JButton Gcash,Paymaya,Paypal;
static JFrame paying;
static String Mybillnum  = payment.Billnum;;

Paying(){


    //Rbuttons
    Gcash = new JButton();
    Gcash.setBounds(100,100,180,50);
    Gcash.setIcon(new ImageIcon("img/gcashl.png"));
    Gcash.setBackground(new Color(31,202,222));
    Gcash.setBorder(new buttonrounder(25)); 
    Gcash.setUI(new RoundedCornerButton());
    Gcash.addMouseListener(this);

    Paymaya = new JButton();
    Paymaya.setBounds(100,160,180,50); 
    Paymaya.setIcon(new ImageIcon("img/paymayalogo.png"));
    Paymaya.setBackground(new Color(31,202,222));
    Paymaya.setBorder(new buttonrounder(25)); 
    Paymaya.setUI(new RoundedCornerButton());
    Paymaya.addMouseListener(this);

    Paypal= new JButton();
    Paypal.setBounds(290,100,180,50); 
    Paypal.setIcon(new ImageIcon("img/paypalNBG.png"));
    Paypal.setBackground(new Color(31,202,222));
    Paypal.setBorder(new buttonrounder(25)); 
    Paypal.setUI(new RoundedCornerButton());
    Paypal.addMouseListener(this);

cancel = new JButton("cancel");
cancel.setBounds(30,30,100,30);  
cancel.addMouseListener(this);
cancel.setBorder(new buttonrounder(25)); 
cancel.setUI(new RoundedCornerButton());
cancel.setFont(new Font("Verdana", Font.BOLD, 11));
cancel.setBackground(new Color(102,233,233));

//jlabel
JLabel chooseLabel = new JLabel("CHOOSE PAYMENT METHOD");
chooseLabel.setBounds(150,30,300,40);
chooseLabel.setFont(new Font("Verdana", Font.BOLD, 18));

paying = new JFrame("Choose payment");
        paying.setSize(500,300);
        paying.setLayout(null);
        paying.getContentPane().setBackground(new Color(164,204,229));
        paying.setLocationRelativeTo(null);
        paying.setResizable(false);
        paying.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 paying.add(cancel);        paying.add(chooseLabel);    paying.add(Gcash);  paying.add(Paypal);     paying.add(Paymaya);
        paying.setVisible(true);


}

public void mouseClicked(MouseEvent  arg0) {  
 
    if(arg0.getSource() == cancel){
new payment();
paying.dispose();
    }    
    if(arg0.getSource() == Paypal){
            
        new Paypal();
    }
        if(arg0.getSource() == Paymaya){
            new Paymaya();
    }
        if(arg0.getSource() == Gcash){
            new GCash();
    }
    

   }
   
   //on hover
   public void mouseEntered(MouseEvent  arg0) {  
    if(arg0.getSource() == cancel){
        cancel.setBackground(new Color(52,190,190));
    }
    if(arg0.getSource() == Gcash){ 
        Gcash.setBackground(new Color(52,140,190));
    }
    if(arg0.getSource() == Paypal){ 
        Paypal.setBackground(new Color(52,140,190));
    }
    if(arg0.getSource() == Paymaya){ 
        Paymaya.setBackground(new Color(52,140,190));
    }
   } 
   //exit hover
   public void mouseExited(MouseEvent  arg0) {  
    
    if(arg0.getSource() == cancel){
        cancel.setBackground(new Color(31,202,222));
    }
    if(arg0.getSource() == Gcash){ 
        Gcash.setBackground(new Color(31,202,222));
    }
    if(arg0.getSource() == Paypal){ 
        Paypal.setBackground(new Color(31,202,222));
    }
    if(arg0.getSource() == Paymaya){ 
        Paymaya.setBackground(new Color(31,202,222));
    }
   }  
   
   
   
   public void mousePressed(MouseEvent  arg0) {  
     
   }  
   public void mouseReleased(MouseEvent  arg0) {  
      
   }

}