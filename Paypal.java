import javax.swing.*;
import java.awt.*;  
import java.awt.event.*; 
public class Paypal implements MouseListener {
	JFrame PayPal= new JFrame();
		JLabel PayPLabel;
		JButton back,PayNow;
	
	Paypal(){
	       //jlabel
	      PayPLabel = new JLabel();
          PayPLabel.setIcon(new ImageIcon("img/paypalNBG.png"));
         PayPLabel.setBounds(50,10,200,60);

	    
	    //Jbuttons
back = new JButton("BACK");
        back.setBounds(0,0,50,30);  
        back.addMouseListener(this);
        back.setBorder(new buttonrounder(25)); 
        back.setUI(new RoundedCornerButton());
        back.setFont(new Font("Verdana", Font.BOLD, 11));
        back.setBackground(new Color(0,112,186));
        back.setForeground(Color.white);
    
    PayNow = new JButton("PayNow");
    PayNow.setBounds(100,350,350,50); 
    PayNow.setForeground(Color.white);
    PayNow.addMouseListener(this);
    PayNow.setBorder(new buttonrounder(25)); 
    PayNow.setUI(new RoundedCornerButton());
    PayNow.setFont(new Font("Verdana", Font.BOLD, 11));
    PayNow.setBackground(new Color(0,112,186));

   JLabel billpay = new JLabel(calculationcalss.df.format(calculationcalss.ALLTOTAL)+" PHP");
        billpay.setBounds(350,25,350,50);
        billpay.setForeground(Color.black);
        billpay.setFont(new Font("Verdana", Font.BOLD, 15));

        JLabel LINE = new JLabel("_________________________________________________");
        LINE .setBounds(50,45,430,50);
        LINE .setForeground(Color.black);
        LINE .setFont(new Font("Verdana", Font.BOLD, 15));
    
	    //Jframe
PayPal = new JFrame("PayPal");
PayPal.setSize(500,450);
PayPal.setLayout(null);
PayPal.getContentPane().setBackground(Color.white);
PayPal.setLocationRelativeTo(null);
PayPal.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
PayPal.setResizable(false);

PayPal.add(back);   PayPal.add(PayNow);    PayPal.add(PayPLabel);
PayPal.add(billpay);    PayPal.add(LINE);
PayPal.setVisible(true);
	    
	}
	public void mouseClicked(MouseEvent  arg0) {  
		if(arg0.getSource() == back){
      
        PayPal.dispose();
    }
    if(arg0.getSource() == PayNow){
    DBCON.Paynow(Paying.Mybillnum);
    Paying.paying.dispose();
        new paidpage();
        PayPal.dispose();
    }
	}
	public void mouseEntered(MouseEvent  arg0) {  

        if(arg0.getSource() == back){
            back.setBackground(new Color(0,70,208));
        }
        if(arg0.getSource() == PayNow){
            PayNow.setBackground(new Color(0,70,208));
        }
} 
//exit hover
public void mouseExited(MouseEvent  arg0) {  

        if(arg0.getSource() == back){
            back.setBackground(new Color(0,112,186));
        }
        if(arg0.getSource() == PayNow){
            PayNow.setBackground(new Color(0,87,228));
        }
}  


public void mousePressed(MouseEvent  arg0) {  
  
}  
public void mouseReleased(MouseEvent  arg0) {  
   
}
}