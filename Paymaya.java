import javax.swing.*;
import java.awt.*;  
import java.awt.event.*; public class Paymaya implements MouseListener {
	JFrame PayMaya = new JFrame();
	
		JLabel PayMLabel;
		JButton back,PayNow;
	
	Paymaya(){
        //panels
JPanel PAYmaya = new JPanel();
PAYmaya.setBounds(0,50,380,550);
PAYmaya.setLayout(null);
PAYmaya.setBackground(new Color(255,255,255));
	       //jlabel
	    PayMLabel = new JLabel("CONFIRMATION");
        PayMLabel.setBounds(150,17,150,20);
        PayMLabel.setFont(new Font("Verdana", Font.ITALIC, 15));

        JLabel billpay = new JLabel(calculationcalss.df.format(calculationcalss.ALLTOTAL));
        billpay.setBounds(150,150,350,50);
        billpay.setForeground(Color.black);
        billpay.setFont(new Font("Verdana", Font.ITALIC, 34));

        JLabel php = new JLabel("PHP");
        php .setBounds(120,145,60,50);
        php .setForeground(Color.black);
        php .setFont(new Font("Verdana", Font.ITALIC, 15));
	    
	    //Jbuttons
        back = new JButton();
        back.setBounds(0,0,50,50);  
        back.addMouseListener(this);
        back.setBorder(null); 
        back.setBackground(new Color(149, 190, 86));
        back.setIcon(new ImageIcon("img/arrow.png"));
    
    PayNow = new JButton("PayNow");
    PayNow.setBounds(0,450,380,50);  
    PayNow.addMouseListener(this);
    PayNow.setBorder(new buttonrounder(5));  
    PayNow.setFont(new Font("Verdana", Font.BOLD, 11));
    PayNow.setBackground(new Color(102,233,233));

    
    
	    //Jframe
	    PayMaya = new JFrame("Paymaya");
PayMaya.setSize(380,600);
PayMaya.setLayout(null);
PayMaya.getContentPane().setBackground(new Color(149, 190, 86));
PayMaya.setLocationRelativeTo(null);
PayMaya.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
PayMaya.setResizable(false);

PayMaya.add(back);      PayMaya.add(PayNow);        PayMaya.add(PayMLabel);
PayMaya.add(billpay);   PayMaya.add(php);
PayMaya.add(PAYmaya);
PayMaya.setVisible(true);
	    
	}
	public void mouseClicked(MouseEvent  arg0) {  
		if(arg0.getSource() == back){
    
        PayMaya.dispose();
    }
    if(arg0.getSource() == PayNow){
        DBCON.Paynow(Paying.Mybillnum);
        Paying.paying.dispose();
        new paidpage();
        PayMaya.dispose();
        }
	}
	public void mouseEntered(MouseEvent  arg0) {  

        if(arg0.getSource() == back){
            back.setBackground(new Color(110, 150, 50));
        }
} 
//exit hover
public void mouseExited(MouseEvent  arg0) {  

        if(arg0.getSource() == back){
            back.setBackground(new Color(149, 190, 86));
        }
}  


public void mousePressed(MouseEvent  arg0) {  
  
}  
public void mouseReleased(MouseEvent  arg0) {  
   
}
}