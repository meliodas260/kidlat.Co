import javax.swing.*;
import java.awt.*;  
import java.awt.event.*; 
public class contactus  extends Frame implements MouseListener {
JFrame ConFrame = new JFrame("CONTACTUS");
static JTextArea textArea , email;
JButton Send,back;
JLabel Message, emailLabel,logo2;
Timer timerMes, timerEmail;
int x =130, y = 410,Xmail = 130, Ymail = 300;
double Emailf = 15, Messagef = 15;;
int EmailR=0, EmailB=0, MessageR = 0, MessageB = 0;
int EmailnewF,MessagenewF;
contactus(){

//LAbels
Message = new JLabel("Message");
Message.setBounds(x,y,200,30);
Message.setFont(new Font("", Font.BOLD, 15));
Message.setForeground(new Color(0,0,0));

emailLabel= new JLabel("E-Mail");
emailLabel.setBounds(Xmail,Ymail,200,30);
emailLabel.setFont(new Font("", Font.BOLD, 15));
emailLabel.setForeground(new Color(0,0,0));

logo2 = new JLabel();
logo2 .setIcon(new ImageIcon("img/logo1.png"));
logo2.setBounds(300,-20,500,170);


//buttons
Send = new JButton("Send");
Send.setBounds(175,600,100,30);
Send.addMouseListener(this);
Send.setBorder(new buttonrounder(25)); 
Send.setUI(new RoundedCornerButton());
Send.setFont(new Font("Verdana", Font.BOLD, 11));
Send.setBackground(new Color(102,233,233));

back = new JButton("BACK");
        back.setBounds(50,50,90,30);  
        back.addMouseListener(this);
        back.setBorder(new buttonrounder(25)); 
        back.setUI(new RoundedCornerButton());
        back.setFont(new Font("Verdana", Font.BOLD, 11));
        back.setBackground(new Color(102,233,233));
//jtextareas
    textArea= new JTextArea();
    textArea.setLineWrap(true);
    textArea.setWrapStyleWord(true);
    textArea.setBounds(100,400,250,200);
    textArea.addMouseListener(this);
    textArea.setFont(new Font("", Font.ROMAN_BASELINE, 15));
    textArea.setBorder(new buttonrounder(3));  

    email= new JTextArea();
    email.setBounds(100,300,250,30);
    email.addMouseListener(this);
    email.setFont(new Font("", Font.ROMAN_BASELINE, 15));
    email.setBorder(new buttonrounder(3));  
    

    //frame
    ConFrame.setSize(600,800);
    ConFrame.setLayout(null);
    ConFrame.setLocationRelativeTo(null);
    ConFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    ConFrame.setResizable(false);
    ConFrame.getContentPane().setBackground(new Color(164,204,229));

    //timers for animation

    timerMes = new Timer(30, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            if(y != 370){
            x--;
            y-=2;
            Messagef -= .15;
            MessageR += 6;
            MessageB +=6;
            MessagenewF = (int)Math.round(Messagef);
            Message.setFont(new Font("", Font.BOLD, MessagenewF));
            Message.setForeground(new Color(MessageR,0,MessageB));
            Message.setLocation(x, y);
            repaint();
        }
        else if(y == 370){timerMes.stop();}
        }
    });


    //email label animation
    timerEmail = new Timer(30, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            if(Ymail != 270){
            Xmail--;
            Ymail-=2;
            Emailf -= .2;
            EmailR += 6;
            EmailB +=6;
            EmailnewF = (int)Math.round(Emailf);
            emailLabel.setLocation(Xmail, Ymail);
            emailLabel.setFont(new Font("", Font.BOLD, EmailnewF));
            emailLabel.setForeground(new Color(EmailR,0,EmailB));
            repaint();
        }
        else if(Ymail == 370){timerEmail.stop();}
        }
    });
    
//scrollmaker
    JScrollPane compaints = new JScrollPane(textArea);
    compaints.setBounds(100,400,250,200);

    ConFrame.add(back); ConFrame.add(logo2);
    ConFrame.add(emailLabel);    ConFrame.add(email);
    ConFrame.add(Message);      ConFrame.add(compaints);    ConFrame.add(Send);
    ConFrame.setVisible(true);
}

    


    public void mouseClicked(MouseEvent arg0) {
        if(arg0.getSource() == back){
            new kidlat_co();
            ConFrame.dispose();
        }
        if(arg0.getSource() == Send){
            if((email.getText().equals(""))){
                email.setForeground(Color.red);
                JOptionPane.showMessageDialog(null, "ENTER EMAIL");
            }
            else if (!(email.getText().matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}"))){
               email .setForeground(Color.red);
                JOptionPane.showMessageDialog(null, "ENTER A VALID EMAIL!!");
            }
            else if((textArea.getText().equals(""))){
                email.setForeground(Color.green);
                textArea.setForeground(Color.red);
                JOptionPane.showMessageDialog(null, "ENTER MESSAGE !!");
            }
            else{//this will send the message to the database
                email.setForeground(Color.black);
                textArea.setForeground(Color.black);
                
                JOptionPane.showMessageDialog(null, DBCON.Message(email.getText(), textArea.getText()));
                email.setText("");
                textArea.setText("");
            }
        }
     
    }

    public void mouseEntered(MouseEvent arg0) {
        if(arg0.getSource() == back){
            back.setBackground(new Color(52,190,190));
        }
        if(arg0.getSource() == Send){
            Send.setBackground(new Color(52,190,190));
        }
        if(arg0.getSource() == textArea){

                timerMes.start();

        }
        if(arg0.getSource() == email){
            timerEmail.start();
        }
    }

    public void mouseExited(MouseEvent arg0) {
        if(arg0.getSource() == back){
            back.setBackground(new Color(102,233,233));
        }
        if(arg0.getSource() == Send){
            Send.setBackground(new Color(102,233,233));
        }
        if(arg0.getSource() == textArea){
         timerMes.stop();
         if(!(textArea.getText().equals(""))){
            x = 110;
            y=370;
    Message.setLocation(x,y);
        }
            else{
         x = 130;
         y=410;
         Xmail = 125;
            Ymail=300;
            MessageR = 0;
           MessageB = 0;
           Messagef = 15;
           MessagenewF = 15;
            Message.setForeground(new Color(MessageR,0,MessageB));
    Message.setFont(new Font("", Font.BOLD, MessagenewF));
 Message.setLocation(x,y); }
        }
        if(arg0.getSource() == email){
            timerEmail.stop();
            if(!(email.getText().equals(""))){
               Xmail = 110;
               Ymail=270;
       emailLabel.setLocation(Xmail,Ymail);
       
           }
               else{
            Xmail = 125;
            Ymail=300;
           EmailR = 0;
           EmailB = 0;
           Emailf = 15;
            EmailnewF = 15;
    emailLabel.setLocation(Xmail,Ymail); 
    emailLabel.setForeground(new Color(EmailR,0,EmailB));
    emailLabel.setFont(new Font("", Font.BOLD, EmailnewF));
   }
           }
    }

    public void mousePressed(MouseEvent arg0) {
        
    }


    public void mouseReleased(MouseEvent arg0) {
       
    }

    public static void main(String[] args) {
        new contactus();
    }
}
