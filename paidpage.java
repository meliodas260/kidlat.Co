import javax.swing.*;
import java.awt.*;  
import java.awt.event.*; 
public class paidpage extends Frame implements MouseListener{
    JFrame PAIDF= new JFrame();
    JLabel PAIDLabel,recieptBG;
    JButton confirm;


paidpage(){
       //jlabel
    PAIDLabel = new JLabel("SUCCESSFULLY PAID");
    PAIDLabel.setBounds(200,30,250,20);
    PAIDLabel .setForeground(Color.white);
    PAIDLabel.setFont(new Font("Verdana", Font.BOLD, 20));

    JLabel PAYinfo = new JLabel("<html>Account No. &emsp; : "+DBCON.name+"<br>Paid Bill No.&emsp; : "+Paying.Mybillnum+"<br>Receipt No. &emsp; : "+DBCON.myReiept(Paying.Mybillnum)+"</html>");
    PAYinfo.setBounds(130,230,300,90);
    PAYinfo.setFont(new Font("Verdana", Font.BOLD, 20));

    JLabel payamount = new JLabel("Ammount paid : "+calculationcalss.df.format(calculationcalss.ALLTOTAL));
    payamount.setBounds(130,400,300,20);
    payamount.setFont(new Font("Verdana", Font.BOLD, 20));

     //pics
    recieptBG = new JLabel();
    recieptBG.setBounds(24,150,550,400);
    recieptBG.setIcon(new ImageIcon("img/recieptlogo.png"));
    
    //Jbuttons


confirm = new JButton("BACK HOME");
confirm.setBounds(225,550,150,50);  
confirm.addMouseListener(this);
confirm.setBorder(new buttonrounder(25)); 
confirm.setUI(new RoundedCornerButton());
confirm.setFont(new Font("Verdana", Font.BOLD, 11));
confirm.setBackground(new Color(102,233,233));



    //Jframe
    PAIDF = new JFrame("PAID SUCCESS");
PAIDF.setSize(600,700);
PAIDF.setLayout(null);
PAIDF.getContentPane().setBackground(new Color(6,23,79));
PAIDF.setLocationRelativeTo(null);
PAIDF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
PAIDF.setResizable(false);

   PAIDF.add(confirm);    PAIDF.add(PAIDLabel); PAIDF.add(payamount);   PAIDF.add(PAYinfo);   PAIDF.add(recieptBG);
PAIDF.setVisible(true);
    
}
public void mouseClicked(MouseEvent  arg0) {  

if(arg0.getSource() == confirm){
 new kidlat_co();
    PAIDF.dispose();
}
}
public void mouseEntered(MouseEvent  arg0) {  


} 
//exit hover
public void mouseExited(MouseEvent  arg0) {  


}  


public void mousePressed(MouseEvent  arg0) {  

}  
public void mouseReleased(MouseEvent  arg0) {  

}
}
