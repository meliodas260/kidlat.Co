import javax.swing.*;
import java.awt.*;  
import java.awt.event.*;
import java.text.DecimalFormat; 

class kidlat_co extends Frame implements MouseListener{


JFrame home;
JTextArea tips;
JButton tocalcu,topayment, aboutus, feedback;
JPanel sidebar;
JLabel logo1,logo2,midtext,tipidTLabel,Eyes,Eye2, mascot;
String  theme;
Timer timers;
int currentImageIndex = 0;
static PointerInfo pointer = MouseInfo.getPointerInfo();
static double xroot = Math.sqrt(pointer.getLocation().x);
static double yroot = Math.sqrt(pointer.getLocation().y);
static int RXeye = (int) xroot, RYeye = (int) yroot,LXeye = (int) xroot, LYeye = (int) yroot;
static int Rx = 350, Ry = 300;
static DecimalFormat INs = new DecimalFormat("0");

kidlat_co(){

    // panelss
    
    sidebar = new JPanel();
    sidebar.setBounds(890,0,310,800);
    sidebar.setLayout(null);
    sidebar.setBackground(new Color(6,23,79));
    sidebar.setBorder(new buttonrounder(0));  

      


//jlabel icons
logo2 = new JLabel();
logo2 .setIcon(new ImageIcon("img/logo2.png"));
logo2.setBounds(1030,-20,170,170);

logo1 = new JLabel();
logo1 .setIcon(new ImageIcon("img/logo1.png"));
logo1.setBounds(0,-20,500,170);

mascot = new JLabel();
mascot .setIcon(new ImageIcon("img/IMG_20230504_132605-removebg-preview.png"));
mascot .setBounds(300,0,500,500);

    Eyes = new JLabel();
    Eyes.setIcon(new ImageIcon("img/IMG_20230504_132528-removebg-preview (1).png"));
    Eyes.setBounds(Rx,Ry,70,70);

    Eye2 = new JLabel();
    Eye2.setIcon(new ImageIcon("img/IMG_20230504_132528-removebg-preview (1).png"));
    Eye2.setBounds(Rx,Ry,70,70);

//buttons

    tocalcu = new JButton("Bill Calculator");
    tocalcu.setBounds(200,600,150,50);
    tocalcu.addMouseListener(this);
    tocalcu.setBorder(new buttonrounder(25)); 
    tocalcu.setUI(new RoundedCornerButton());
    tocalcu.setFont(new Font("Verdana", Font.BOLD, 11));
    tocalcu.setBackground(new Color(31,202,222));

    topayment = new JButton("View/Pay Bills");
    topayment.setBounds(380,600,150,50);  
    topayment.addMouseListener(this);
    topayment.setFont(new Font("Verdana", Font.BOLD, 11));
    topayment.setBackground(new Color(31,202,222));
    topayment.setBorder(new buttonrounder(25)); 
    topayment.setUI(new RoundedCornerButton()); 

     aboutus = new JButton("About Us");
     aboutus.setBounds(560,600,150,50);  
     aboutus.addMouseListener(this);
     aboutus.setFont(new Font("Verdana", Font.BOLD, 11));
     aboutus.setBackground(new Color(31,202,222));
     aboutus.setBorder(new buttonrounder(25)); 
     aboutus.setUI(new RoundedCornerButton());

     feedback= new JButton("Contact Us");
     feedback.setBounds(730,600,150,50);  
     feedback.addMouseListener(this);
     feedback.setFont(new Font("Verdana", Font.BOLD, 11));
     feedback.setBackground(new Color(31,202,222));
     feedback.setBorder(new buttonrounder(25)); 
     feedback.setUI(new RoundedCornerButton());

    //label text

    midtext = new JLabel("<html>Have the power to access your KEC Bill with KEC Online!</html>");
    midtext.setBounds(300,456,500,40);
    midtext.setFont(new Font("", Font.BOLD, 21));
    midtext.setForeground(new Color(91,76,255));


    tipidTLabel = new JLabel("Energy Tipid Tips :");
    tipidTLabel.setBounds(900,110,250,50);
    tipidTLabel.setFont(new Font("Verdana", Font.BOLD, 19));
    tipidTLabel.setForeground(Color.lightGray);
  

    //textarea

    tips = new JTextArea("1. Turn off electronics and appliances \n   when not in use. \n\n"+
    "2. Use energy-efficient light bulbs like \n    LED bulbs.\n\n"+
    "3. Adjust the thermostat to use less\n   energy.\n\n"+
    "4. Seal air leaks to keep your home \n   comfortable and reduce energy\n   waste.\n\n"+
    "5. Use ENERGY STAR-rated appliances,\n   which are designed to use less \n  energy and can save money over time.");
    tips.setBounds(900,160,300,300);
    tips.setFont(new Font("", Font.ROMAN_BASELINE, 15));  
    tips.setBackground(new Color(6,23,79));
    tips.setEditable(false);
    tips.setForeground(Color.lightGray);

home = new JFrame("home");
home.setSize(1200,800);
home.setLayout(null);
home.setLocationRelativeTo(null);
home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
home.setResizable(false);
home.getContentPane().setBackground(new Color(164,204,229));


timers = new Timer(30, new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        pointer = MouseInfo.getPointerInfo();
        xroot = Math.sqrt(pointer.getLocation().x);
        yroot = Math.sqrt(pointer.getLocation().y);
        RXeye = 437+(int) xroot;
        RYeye = 200 + (int) yroot;
        LXeye = 557+(int) xroot;
        LYeye = 200 +(int) yroot;
Eyes.setLocation(RXeye, RYeye);
Eye2.setLocation(LXeye, LYeye);
repaint();
    }
});
timers.start();
home();
}


public void home(){

home.add(Eyes);  home.add(Eye2);   home.add( mascot);
        home.add(topayment);
home.add(midtext);      home.add(tipidTLabel);      home.add(tips);
home.add(tocalcu);
home.add(logo2);        home.add(logo1);
home.add( aboutus); home.add(feedback);

home.add(sidebar);   

home.setVisible(true);
}

//clicked
public void mouseClicked(MouseEvent  arg0) {
 

 if(arg0.getSource() == tocalcu){

new calculator();
home.dispose();
 }

 if(arg0.getSource() == topayment){
new payment();

    home.dispose();
 }
 if(arg0.getSource() ==  aboutus){
    new AboutUs();
 }
 if(arg0.getSource() ==  feedback){
new contactus();
home.dispose();
 }
}

//on hover
public void mouseEntered(MouseEvent  arg0) {  
    if(arg0.getSource() == tocalcu){ 
        tocalcu.setBackground(new Color(52,140,190));
    }
    if(arg0.getSource() == topayment){
        topayment.setBackground(new Color(52,140,190));
    }
    if(arg0.getSource() ==  aboutus){
         aboutus.setBackground(new Color(52,140,190));
    }
    if(arg0.getSource() ==  feedback){
        feedback.setBackground(new Color(52,140,190));
    }
} 
//exit hover
public void mouseExited(MouseEvent  arg0) {  
    if(arg0.getSource() == tocalcu){
        tocalcu.setBackground(new Color(31,202,222));
    }
    if(arg0.getSource() == topayment){
        topayment.setBackground(new Color(31,202,222));
    }
    if(arg0.getSource() ==  aboutus){
         aboutus.setBackground(new Color(31,202,222));
    }
    if(arg0.getSource() ==  feedback){
        feedback.setBackground(new Color(31,202,222));
    }
}

public void mousePressed(MouseEvent  arg0) {  
  
}  
public void mouseReleased(MouseEvent  arg0) {  
   
}



public static void main(String [] args){


  //  System.out.println("Mouse location: x = " + INs.format(xroot) + ", y = " + INs.format(yroot));
    new kidlat_co();
}


}