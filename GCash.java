import javax.swing.*;
import java.awt.*;  
import java.awt.event.*; public class GCash implements MouseListener {
	static JFrame Gcash = new JFrame();
	
		JLabel GcashLabel,GGif, COMname, billpay;
		JButton back,PayNow;
       static Timer timerG;
       JPanel GcashWhite;
	
	GCash(){
//panels
GcashWhite = new JPanel();
GcashWhite.setBounds(10,10,748,372);
GcashWhite.setLayout(null);
GcashWhite.setBackground(new Color(255,255,255));

// the gif
        GGif = new JLabel();
        GGif.setIcon(new ImageIcon("img/24-f.gif"));
        GGif.setBounds(0,0,768,432);

	       //jlabel
	      GcashLabel = new JLabel();
          GcashLabel.setIcon(new ImageIcon("img/gcashl.png"));
         GcashLabel.setBounds(90,30,150,20);
  
         COMname = new JLabel("KEC");
         COMname.setBounds(500,50,150,20);
         COMname.setForeground(Color.black);
         COMname.setFont(new Font("Verdana", Font.BOLD, 19));

        billpay = new JLabel("<html>"+calculationcalss.df.format(calculationcalss.ALLTOTAL) +"<br> _________________________________________________________________________________________________</html>");
        billpay.setBounds(350,110,350,50);
        billpay.setForeground(Color.black);
        billpay.setFont(new Font("Verdana", Font.ROMAN_BASELINE, 15));
	    
	    //Jbuttons
        back = new JButton("BACK");
        back.setBounds(20,20,30,30);  
        back.addMouseListener(this);
        back.setBorder(new buttonrounder(25)); 
        back.setUI(new RoundedCornerButton());
        back.setFont(new Font("Verdana", Font.BOLD, 6));
        back.setBackground(new Color(0,87,228));
        back.setForeground(Color.white);
    
    PayNow = new JButton("Pay Now");
    PayNow.setBounds(350,330,350,50);  
    PayNow.addMouseListener(this);
    PayNow.setBorder(new buttonrounder(25)); 
    PayNow.setUI(new RoundedCornerButton());
    PayNow.setFont(new Font("Verdana", Font.BOLD, 11));
    PayNow.setBackground(new Color(0,87,228));
    PayNow.setForeground(Color.white);

    

	    //Jframe
	    Gcash = new JFrame("GCASH");
Gcash.setSize(768,432);
Gcash.setLayout(null);
Gcash.getContentPane().setBackground(new Color(0, 87, 228, 255));//rgbo
Gcash.setLocationRelativeTo(null);
Gcash.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
Gcash.setResizable(false);
ForIntro();
	}

    public void ForIntro(){
        Gcash.add(GGif);

timerG = new Timer(5430, new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        Gcash.getContentPane().removeAll(); 
        Gcash.repaint(); 
      Gcashhome();
    }
 });
 timerG.start();Gcash.setVisible(true);
    }

public void Gcashhome(){
timerG.stop();

Gcash.add(back);    Gcash.add(billpay);    Gcash.add(PayNow);    Gcash.add(COMname);    Gcash.add(GcashLabel);Gcash.add(GcashWhite);


}





	public void mouseClicked(MouseEvent  arg0) {  
		if(arg0.getSource() == back){
         
        Gcash.dispose();
    }
    if(arg0.getSource() == PayNow){
        DBCON.Paynow(Paying.Mybillnum);
        Paying.paying.dispose();
        new paidpage();
        Gcash.dispose();
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
            back.setBackground(new Color(0,87,228));
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