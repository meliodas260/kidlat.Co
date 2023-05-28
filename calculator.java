import javax.swing.*;
import java.awt.*;  
import java.awt.event.*;


 class calculator extends Frame implements MouseListener{

    JTextField prev, cur,justKW;
    int KwUsed;
    JTextArea Calcuinfo;
    JLabel prevJL,curJL,energyCOn,calculation,kWUsedLabel;
JFrame calcu;
JPanel sidebar,calculatioPanel,VLine;
JButton CALCULATE, back,KWcalcu , clearAll;
    calculator(){

     //panles
     sidebar = new JPanel();
    sidebar.setBounds(0,0,320,800);
    sidebar.setLayout(null);
    sidebar.setBackground(new Color(6,23,79));
    sidebar.setBorder(new buttonrounder(0));   

    calculatioPanel = new JPanel();
    calculatioPanel.setBounds(450,20,650,330);
    calculatioPanel.setLayout(null);
    calculatioPanel.setBackground(new Color(6,23,79));
    calculatioPanel.setBorder(new buttonrounder(5));

    VLine = new JPanel();
    VLine.setBounds(875,400,1,350);
    VLine.setBackground(Color.black);
    VLine.setLayout(null);

//labels
prevJL = new JLabel("Previous Reading :");
prevJL.setBounds(500,390,300,30);

curJL = new JLabel("Current Reading :");
curJL.setBounds(700,390,300,30);

kWUsedLabel = new JLabel("ENTER KW USED :");
kWUsedLabel.setBounds(900,390,300,30);

energyCOn= new JLabel("<html>ENERGY CONSUMPTION <br>CALCULATOR</html>");
energyCOn.setBounds(20,60,280,70);
energyCOn.setFont(new Font("Verdana", Font.BOLD, 18)); 
energyCOn.setForeground(Color.lightGray);
 //textfields
        cur = new JTextField();
        cur.setBounds(500,420,150,30);
  

        prev = new JTextField();
        prev.setBounds(700,420,150,30); 
        
        justKW = new JTextField();
        justKW.setBounds(900,420,150,30);

//textarea
Calcuinfo = new JTextArea("KEC's energy consumption calculator\n estimates how much energy and\n money are being used based on\n factors such"+
" as appliance type,\nfrequency of use, and energy cost.\n It helps with budgeting, reducing\n usage, and identifying efficiency\n improvements.");
Calcuinfo.setBounds(20,150,290,250);
Calcuinfo.setFont(new Font("Verdana", Font.ROMAN_BASELINE, 16)); 
Calcuinfo.setBackground(new Color(6,23,79));
Calcuinfo.setEditable(false);
Calcuinfo.setForeground(Color.lightGray);


//buttons
CALCULATE = new JButton("CALCULATE");
CALCULATE.setBounds(520,500,150,50);  
CALCULATE.addMouseListener(this);
CALCULATE.setBorder(new buttonrounder(25)); 
CALCULATE.setUI(new RoundedCornerButton());
CALCULATE.setFont(new Font("Verdana", Font.BOLD, 11));
CALCULATE.setBackground(new Color(31,202,222));


clearAll = new JButton("CLEAR");
clearAll.setBounds(500,280,150,30);  
clearAll.addMouseListener(this);
clearAll.setBorder(new buttonrounder(25)); 
clearAll.setUI(new RoundedCornerButton());
clearAll.setFont(new Font("Verdana", Font.BOLD, 11));
clearAll.setBackground(new Color(31,202,222));

KWcalcu = new JButton("CALCULATE");
KWcalcu.setBounds(920,500,150,50);  
KWcalcu.addMouseListener(this);
KWcalcu.setBorder(new buttonrounder(25)); 
KWcalcu.setUI(new RoundedCornerButton());
KWcalcu.setFont(new Font("Verdana", Font.BOLD, 11));
KWcalcu.setBackground(new Color(31,202,222));

back = new JButton("BACK");
back.setBounds(20,20,100,40);  
back.addMouseListener(this);
back.setBorder(new buttonrounder(25)); 
back.setUI(new RoundedCornerButton());
back.setFont(new Font("Verdana", Font.BOLD, 11));
back.setBackground(new Color(102,233,233));

//adds in sidebar
sidebar.add(energyCOn);       sidebar.add(Calcuinfo);      sidebar.add(back); 
        //frame
        calcu = new JFrame("calculator");
        calcu.setSize(1200,800);
        calcu.setLayout(null);
        calcu.setLocationRelativeTo(null);
        calcu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        calcu.setResizable(false);
        calcu.getContentPane().setBackground(new Color(164,204,229));

        Calcupage();
    }

    public void Calcupage(){

        calcu.add(KWcalcu);                calcu.add(CALCULATE);
        calcu.add(prev);            calcu.add(prevJL);          calcu.add(justKW);      calcu.add(VLine);       calcu.add(kWUsedLabel);
        calcu.add(cur);             calcu.add(curJL);
        calcu.add(sidebar);         calcu.add(calculatioPanel);
        calcu.setVisible(true);
    }
    

//clicked
public void mouseClicked(MouseEvent  arg0) {  DBCON check = new DBCON();

    if(arg0.getSource() == KWcalcu){
if(check.inputcheck(justKW.getText())){
        KwUsed =  Integer.parseInt(justKW.getText());
         Calcualtion_R(KwUsed);
         prev.setText(""); cur.setText("");
}else{
    justKW.setText("");
}
      
    }

    if(arg0.getSource() == CALCULATE){ if(check.inputcheck(prev.getText()) && check.inputcheck(cur.getText())){
         int INprev = Integer.parseInt(prev.getText());
        int INcur = Integer.parseInt(cur.getText());
        if(INprev>INcur){
       
   
    KwUsed = INprev-INcur;
    justKW.setText(""+KwUsed);
    Calcualtion_R(KwUsed);
   
    }else{
        JOptionPane.showMessageDialog(null,"Prev must not begreather than Cur");
    }}else{
        prev.setText("");       cur.setText("");
    }
    
    }

    if(arg0.getSource() == back){
        new kidlat_co();
        calcu.dispose();
    }

    if(arg0.getSource() == clearAll){
        calcu.getContentPane().removeAll();
        calculatioPanel.removeAll();
        calcu.repaint();
        Calcupage();
        prev.setText("");    cur.setText("");   justKW.setText("");
       
      
    }

   }
   
   
   public void mouseEntered(MouseEvent  arg0) {  
    if(arg0.getSource() == back){
        back.setBackground(new Color(52,140,190));
    }
    if(arg0.getSource() == KWcalcu){
        KWcalcu.setBackground(new Color(52,140,190));
    }
    if(arg0.getSource() == CALCULATE){
        CALCULATE.setBackground(new Color(52,140,190));
    }
    if(arg0.getSource() == clearAll){
        clearAll.setBackground(new Color(52,140,190));
    }

   } 
   public void mouseExited(MouseEvent  arg0) {  
    if(arg0.getSource() == back){
        back.setBackground(new Color(102,233,233));
    }
    if(arg0.getSource() == KWcalcu){
        KWcalcu.setBackground(new Color(31,202,222));
    }
    if(arg0.getSource() == CALCULATE){
        CALCULATE.setBackground(new Color(31,202,222));
    }
    if(arg0.getSource() == clearAll){
        clearAll.setBackground(new Color(31,202,222));
    }
   }  
   
   public void mousePressed(MouseEvent  arg0) {  
     
   }  
   public void mouseReleased(MouseEvent  arg0) {  
      
   }

    public void Calcualtion_R(double X){


   //GRn&Trans calculations
   calculationcalss  Total = new calculationcalss();
   String values = Total.total(X);

   calculation = new JLabel(""+values);
   calculation.setBounds(10,10,630,310);
   calculation.setFont(new Font("Verdana", Font.BOLD, 18));
    calculation.setForeground(Color.lightGray);

   calcu.getContentPane().removeAll();
   calculatioPanel.removeAll();
   calculatioPanel.add(calculation);
   calculatioPanel.add(clearAll); 
   calcu.repaint();
   Calcupage();

    }


}
