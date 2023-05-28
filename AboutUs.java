import javax.swing.*;
import java.awt.*;  
import java.awt.event.*; 
public class AboutUs extends Frame implements MouseListener{
    JFrame AUFrame = new JFrame("about Us");
    JButton back;


 AboutUs() {  
  String Par1 = "    Welcome to Kidlat_con, your trusted provider of reliable and sustainable energy\n    solutions. Since 2002, we have been committed to delivering high-quality"+
   "\n    service while minimizing our impact on the environment and supporting local\n    communities. Our team of experienced professionals is dedicated to providing\n    exceptional " +
   "service and support to our customers. At Kidlat_con, we invest in\n    the latest technology to stay at the forefront of the industry and provide the\n    best possible service."+
   " Thank you for choosing Kidlat_con for your energy needs.";

  String Par2 = "    At Kidlat_con, our mission is to provide reliable, safe, and affordable electricity\n    to our customers, while promoting sustainable energy solutions and\n   "+
 " contributing to the well-being of the communities we serve. We are committed\n    to powering the lives of our customers while minimizing our impact on the\n    environment and supporting local communities.";
 
 String Par3 ="    Our vision is to be a leader in the electric utility industry, recognized for our\n    commitment to innovation, excellence in customer "+
" service, and dedication to a\n    cleaner, more sustainable future. We strive to be a trusted partner for our customers,\n    employees, and stakeholders, "+
" and to play an active role in shaping a more\n    sustainable and resilient energy landscape.";





// buttons
        back = new JButton();
        back.setIcon(new ImageIcon("img/homelogo.png"));
        back.setSize(60, 60);
        back.addMouseListener(this);
        back.setBorder(null);
        back.setFont(new Font("Verdana", Font.BOLD, 11));
        back.setBackground(new Color(164,204,229));

//jlabel icons
JLabel logo1 = new JLabel();
logo1 .setIcon(new ImageIcon("img/logo2.png"));


JLabel blank = new JLabel();


logo1.setBounds(1030,-20,170,170);

 JLabel hi = new JLabel("About Us");
hi.setFont(new Font("Helvetica", Font.BOLD, 18)); 
hi.setHorizontalAlignment(SwingConstants.CENTER);



 JLabel lol = new JLabel("Mission");
 lol.setFont(new Font("Helvetica", Font.BOLD, 18));
 lol.setHorizontalAlignment(SwingConstants.CENTER);


 JLabel visionLable = new JLabel("Vision");
 visionLable.setFont(new Font("Helvetica", Font.BOLD, 18));
 visionLable.setHorizontalAlignment(SwingConstants.CENTER);

 JLabel ContactUs = new JLabel("Call  0909090909");
 ContactUs.setFont(new Font("Helvetica", Font.BOLD, 18));
ContactUs.setHorizontalAlignment(SwingConstants.CENTER);

JLabel Address = new JLabel("<html>Paganon Street, BRGY. Doon,<br> Lagpas Kana City</html>");
Address.setFont(new Font("", Font.BOLD, 15));  
Address.setBackground(new Color(164,204,229));



JTextArea aboutusTextArea = new JTextArea(""+ Par1);
 aboutusTextArea.setFont(new Font("", Font.ROMAN_BASELINE, 17));  
 aboutusTextArea.setEditable(false);
 aboutusTextArea.setBackground(new Color(164,204,229));


 JTextArea missionJTextArea = new JTextArea(""+ Par2);
 missionJTextArea.setFont(new Font("", Font.ROMAN_BASELINE, 17));  
 missionJTextArea.setEditable(false);
 missionJTextArea.setBackground(new Color(164,204,229));

 JTextArea visionTextArea= new JTextArea(""+ Par3);
 visionTextArea.setFont(new Font("", Font.ROMAN_BASELINE, 17));  
 visionTextArea.setEditable(false);
 visionTextArea.setBackground(new Color(164,204,229));



 //panels
JPanel FullframeP = new JPanel(new GridLayout(0, 1, 0, -30));
FullframeP.setBorder(BorderFactory.createEmptyBorder(0, 0, 0,10));
FullframeP.setBackground(new Color(164,204,229));

JPanel navbar = new JPanel(new GridLayout(0, 3));
navbar.setBackground(new Color(164,204,229));

JPanel butttomNav = new JPanel(new GridLayout(0, 2));
butttomNav.setBackground(new Color(135,206,235));

JPanel aboutPanel = new JPanel(new GridLayout(0,  1, 0, 0));
aboutPanel.setBorder(BorderFactory.createEmptyBorder(0, 30, 0,0));
aboutPanel.setBackground(new Color(164,204,229));

JPanel missionPanel = new JPanel(new GridLayout(0,  1, 0, 0));
missionPanel.setBorder(BorderFactory.createEmptyBorder(0, 30, 0,0));
missionPanel.setBackground(new Color(164,204,229));

JPanel visonPanel = new JPanel(new GridLayout(0,  1, 0, 0));
visonPanel.setBorder(BorderFactory.createEmptyBorder(0, 30, 0,0));
visonPanel.setBackground(new Color(164,204,229));

//navbar adds
navbar.add(back);   navbar.add(blank); navbar.add(logo1);

//bottomnav adss
butttomNav.add(ContactUs);      butttomNav.add(Address);

//aboutpanel ads
aboutPanel.add(aboutusTextArea);

missionPanel.add(missionJTextArea);

visonPanel.add(visionTextArea);
      

//adds in the scrollable panel
FullframeP.add(navbar);

FullframeP.add(hi);             FullframeP.add(aboutPanel);
FullframeP.add(lol);            FullframeP.add(missionPanel);
FullframeP.add(visionLable);    FullframeP.add(visonPanel);

FullframeP.add(butttomNav);

//make the fullpanel scrollable
JScrollPane FullJScrollPane = new JScrollPane(FullframeP);
FullJScrollPane.setBounds(0,0,750,800);




 AUFrame .setSize(750,800);
 AUFrame .setLayout(null);
 AUFrame .setLocationRelativeTo(null);
 AUFrame .setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
 AUFrame .setResizable(false);
 AUFrame. getContentPane().setBackground(new Color(164,204,229));

AUFrame.add(FullJScrollPane);
AUFrame.setVisible(true);

}  


    public void mouseClicked(MouseEvent arg0) {
      
        if(arg0.getSource() == back){
           AUFrame.dispose();
        }
    }


    public void mouseEntered(MouseEvent arg0) {
    }
     

    public void mouseExited(MouseEvent arg0) {
     
    }

    public void mousePressed(MouseEvent arg0) {
      
    }


    public void mouseReleased(MouseEvent arg0) {
    
    }
    
}
