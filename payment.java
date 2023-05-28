
import javax.swing.*;
import java.awt.*;  
import java.awt.event.*; 


class payment extends Frame implements MouseListener{

    String recieptS;
    static String Billnum;
    JTextField InAccNum;
    JLabel nobill, InBill_Num,alreadyPaid,MaiinLAbel;
    JFrame payment;
    JButton enter,back,ChoosePayment;
   JTextArea Receipt;
   JScrollPane RecieptScroll;
   Timer Billnummover;
   JPanel sidebar;
   int x = 830,y = 420;
    payment(){

//panles
sidebar = new JPanel();
sidebar.setBounds(0,0,320,800);
sidebar.setLayout(null);
sidebar.setBackground(new Color(6,23,79));
sidebar.setBorder(new buttonrounder(0));

        //jlabel
        InBill_Num = new JLabel("Bill Number");
        InBill_Num.setBounds(x,y,140,30); 

        MaiinLAbel = new JLabel("Bill Search");
        MaiinLAbel.setBounds(480,30,200,30);
        MaiinLAbel.setFont(new Font("Verdana", Font.BOLD, 30));

JLabel  energyCOn= new JLabel("<html>ENERGY CONSUMPTION <br>CALCULATOR</html>");
energyCOn.setBounds(20,60,280,70);
energyCOn.setFont(new Font("Verdana", Font.BOLD, 18)); 
energyCOn.setForeground(Color.lightGray);

//textarea
JTextArea  Calcuinfo = new JTextArea("KEC's energy consumption calculator\n estimates how much energy and\n money are being used based on\n factors such"+
" as appliance type,\nfrequency of use, and energy cost.\n It helps with budgeting, reducing\n usage, and identifying efficiency\n improvements.");
Calcuinfo.setBounds(20,150,290,250);
Calcuinfo.setFont(new Font("Verdana", Font.ROMAN_BASELINE, 16)); 
Calcuinfo.setBackground(new Color(6,23,79));
Calcuinfo.setEditable(false);
Calcuinfo.setForeground(Color.lightGray);

        //buttons
     enter=new JButton("receipt");
     enter.setBounds(800,480,160,30);  
     enter.addMouseListener(this);
     enter.setBorder(new buttonrounder(25)); 
     enter.setUI(new RoundedCornerButton());
     enter.setFont(new Font("Verdana", Font.BOLD, 11));
     enter.setBackground(new Color(31,202,222));

        back = new JButton("BACK");
        back.setBounds(50,30,90,30);  
        back.addMouseListener(this);
        back.setBorder(new buttonrounder(25)); 
        back.setUI(new RoundedCornerButton());
        back.setFont(new Font("Verdana", Font.BOLD, 11));
        back.setBackground(new Color(102,233,233));

        ChoosePayment = new JButton("Payment Method");
        ChoosePayment.setBounds(800,520,160,30);  
        ChoosePayment.addMouseListener(this);
        ChoosePayment.setBorder(new buttonrounder(25)); 
        ChoosePayment.setUI(new RoundedCornerButton());
        ChoosePayment.setFont(new Font("Verdana", Font.BOLD, 11));
        ChoosePayment.setBackground(new Color(31,202,222));

          //fields
        InAccNum = new JTextField();
        InAccNum.setBounds(800,420,160,30);   
        InAccNum.addMouseListener(this);

        Billnummover = new Timer(30, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               
                if(y != 390){
                    x--;
                    y-=2;
                    InBill_Num.setLocation(x, y);
                    repaint();
                }
                else if(y == 370){Billnummover.stop();}
                
            }
        });


        //frame
        payment = new JFrame("PAYMENT");
        payment.setSize(1000,800);
        payment.setLayout(null);
        payment.setLocationRelativeTo(null);
        payment.setResizable(false);
        payment.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        payment.getContentPane().setBackground(new Color(164,204,229));

sidebar.add(energyCOn); sidebar.add(Calcuinfo);
        paymentpage();
    }

    public void paymentpage(){

       payment.add(back); payment.add(sidebar); payment.add(MaiinLAbel);
                payment.add(enter);       payment.add(InBill_Num);
        payment.add(InAccNum);
        payment.setVisible(true);
        

    }


     public void mouseClicked(MouseEvent  arg0) {  

        if(arg0.getSource() == enter){//payment

         payment.getContentPane().removeAll();
         recieptS= "";
         payment.repaint();
        Billnum =InAccNum.getText();
        recieptS = DBCON.CheckIfpaid(Billnum);
  
        if(recieptS==""){
  

            nobill = new JLabel("no current bill");
            nobill.setBounds(400,330,300,300);
            nobill.setFont(new Font("Verdana", Font.BOLD, 20));
            payment.add(nobill);   

           
         }
         else if(recieptS=="1"){

    alreadyPaid = new JLabel("Already Paid");
    alreadyPaid.setBounds(400,330,300,300);
    alreadyPaid.setFont(new Font("Verdana", Font.BOLD, 20));
    payment.add(alreadyPaid);    

         }
        else{
            Receipt = new JTextArea(""+recieptS);
            Receipt.setBounds(0,0,300,0);
            Receipt.setFont(new Font("Helvetica", Font.ITALIC, 12));
            Receipt.setEditable(false);

            RecieptScroll = new JScrollPane(Receipt);
            RecieptScroll.setBounds(350,110,425,600);

            payment.add(ChoosePayment);
            payment.add(RecieptScroll);  
 
  
    }       InAccNum.setText("");
    payment.repaint();  
       paymentpage();
     
        
       
    }

    if(arg0.getSource() == back){
        new kidlat_co();
        payment.dispose();
    }
    if(arg0.getSource() == ChoosePayment){
        new Paying();
        payment.dispose();

    }

       }
       
       

       public void mouseEntered(MouseEvent  arg0) { 
        if(arg0.getSource() == InAccNum){
            Billnummover.start();
        }
        if(arg0.getSource() == back){
            back.setBackground(new Color(52,190,190));
        }
        if(arg0.getSource() == ChoosePayment){
            ChoosePayment.setBackground(new Color(52,140,190));
        }
        if(arg0.getSource() == enter){
            enter.setBackground(new Color(52,140,190));
        }
    
       } 



       public void mouseExited(MouseEvent  arg0) {  
        if(arg0.getSource() == back){
            back.setBackground(new Color(102,233,233));
        }
        if(arg0.getSource() == ChoosePayment){
            ChoosePayment.setBackground(new Color(31,202,222));
        }
        if(arg0.getSource() == enter){
            enter.setBackground(new Color(31,202,222));
        }
        if(arg0.getSource() == InAccNum){
            Billnummover.stop();
            if(!(InAccNum.getText().equals(""))){
               x = 815;
               y=390;
       InBill_Num.setLocation(x,y);
           }
               else{
                x = 830;
            y=420;
   InBill_Num.setLocation(x,y); }
           }
       }  
       

       public void mousePressed(MouseEvent  arg0) {  
         
       }  


       public void mouseReleased(MouseEvent  arg0) {  
          
       }

}
