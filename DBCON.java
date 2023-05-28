import java.sql.*;

import javax.swing.JOptionPane;
public class DBCON {
    static String name,dates,toTArea,recieptNUM,pastbill,paidpastbill, JustpaidReciept;
    static int acc,meternum;
    static double KW,ArrearsNow;


    public static String CheckIfpaid(String accc){//check if the billnum iinput is paid by checking the database reciept number from the billnumber input
        try{  //connect database
            Connection con=DriverManager.getConnection(  
            "jdbc:mysql://localhost:3306/consumer","mine","pass");  //adddress username password of admin 
            Statement stmt=con.createStatement();  
            ResultSet rs=stmt.executeQuery("SELECT `reciept_num` FROM `receipt` WHERE `bill_num` = "+ accc);  
    
    
    
            
            while(rs.next()) {
             recieptNUM = rs.getString("reciept_num");
         
        }       
            con.close();  
            }catch(Exception e){ System.out.println(e);
               return "";}  
    
     if(recieptNUM==null || recieptNUM==""  ){
      
    return checkbill(accc); //called to check if the input billnum is existing and amke a bill
        
    }
    else{  recieptNUM = "";
   return "1";
    }
}

// method that make the reciept and check if there is that input billbnumber
    public static String checkbill(String accc){
        try{  //connect database
            Connection con=DriverManager.getConnection(  
            "jdbc:mysql://localhost:3306/consumer","mine","pass");  //adddress username password of admin 
            Statement stmt=con.createStatement();  
            ResultSet rs=stmt.executeQuery("Select bill.Bill_date , users.name, users.address, users.accnum, users.meter_num,"+
            "bill.Arrears, bill.Current_Total, bill.ALL_TOTAL ,bill.KW_used ,bill.due_date bill from bill  "+
            "INNER JOIN users on users.accnum = bill.acc_num  "+
           " where bill_num = "+accc);  
    

            while(rs.next()) {
             name = rs.getString("name"); //column name
            acc = rs.getInt("accnum");
            meternum = rs.getInt("meter_num");
            dates =  rs.getString("Bill_date");
            KW = rs.getDouble("KW_used");
         
        }       
            con.close();  
            }catch(Exception e){ System.out.println(e);
               return "";}  
            
    
     if(dates!=null){
     String Calculations =  calculationcalss.reciept(KW);

    toTArea ="Account Number\t"+acc+"\nName\t\t"+name+"\nMeter Number\t"+meternum+"\nDate give\t\t"+dates+"\n"+"Kilo Watt Used : \t"+KW+"\n"+Calculations;
    dates = null;
return toTArea;

    }
    else{
   return "";
    }}

    // this method will connect to database and make a reciept if you pay
    public static void Paynow(String B){

        try {
            Connection con=DriverManager.getConnection(  
            "jdbc:mysql://localhost:3306/consumer","mine","pass");  //adddress username password of admin 
            Statement stmt=con.createStatement();  
   
            // Update a row in the table
            String sql = "INSERT INTO `receipt` (`reciept_num`, `bill_num`, `date_paid`) VALUES (NULL, '"+B+"', CURRENT_TIMESTAMP)";
            int rowsAffected = stmt.executeUpdate(sql);
            System.out.println(rowsAffected + " row(s) updated");
            stmt.close();
            
         } catch(SQLException e) {
            System.out.println(e.getMessage());
         }  

    }




        //this method will check if the input is lower than 0 or number
    public boolean inputcheck(String A){
        try {
            int B = Integer.parseInt(A);
            if(B<0){          
                JOptionPane.showMessageDialog(null, "NUMBERS MUST NOT LOWER THAN 0");  return false;}
           return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "NUMBERS ONLY!!"); 
           return false;
        }

    }


    public static boolean ArrearsCheck(String A){

        try {
            Connection con=DriverManager.getConnection(  
            "jdbc:mysql://localhost:3306/consumer","mine","pass");  //adddress username password of admin 
            Statement stmt=con.createStatement();  
            ResultSet rs=stmt.executeQuery("SELECT `pastBill_num` FROM `bill` WHERE `bill_num` = "+ A);  

            while(rs.next()) {
             pastbill = rs.getString("pastBill_num");
         
        }      

         } catch(SQLException e) {
            System.out.println(e.getMessage());
         }

         if(CheckArrearsPaid(pastbill)){
            ForArears(pastbill);
            return false;
         }
         else{
            return true;
         }

    }

    public static boolean CheckArrearsPaid(String A){

        try {
            Connection con=DriverManager.getConnection(  
            "jdbc:mysql://localhost:3306/consumer","mine","pass");  //adddress username password of admin 
            Statement stmt=con.createStatement();  
            ResultSet rs=stmt.executeQuery("SELECT `reciept_num` FROM `receipt` WHERE `bill_num` = "+ A);  

            while(rs.next()) {
                paidpastbill = rs.getString("reciept_num");
         
        }      

         } catch(SQLException e) {
            System.out.println(e.getMessage());
         }
if(paidpastbill == null){

   
    paidpastbill = null;
 return true;
}
else{
  return false;
    }}

    public static void ForArears(String A){

        try {
            Connection con=DriverManager.getConnection(  
            "jdbc:mysql://localhost:3306/consumer","mine","pass");  //adddress username password of admin 
            Statement stmt=con.createStatement();  
            ResultSet rs=stmt.executeQuery("SELECT `ALL_TOTAL` FROM bill WHERE `bill_num` = "+ A);  

            while(rs.next()) {
                
                ArrearsNow= rs.getDouble("ALL_TOTAL");
         System.out.print(ArrearsNow);
        }      

         } catch(SQLException e) {
            System.out.println(e.getMessage());
         }
        }

        public static String myReiept(String A){

            try {
                Connection con=DriverManager.getConnection(  
                "jdbc:mysql://localhost:3306/consumer","mine","pass");  //adddress username password of admin 
                Statement stmt=con.createStatement();  
                ResultSet rs=stmt.executeQuery("SELECT `reciept_num` FROM `receipt` WHERE `bill_num` = "+ A);  
    
                while(rs.next()) {
                    
                    JustpaidReciept = rs.getString("reciept_num");
             System.out.print(JustpaidReciept);
            }      
    return JustpaidReciept;
             } catch(SQLException e) {
                System.out.println(e);
                return "failed";
             }
            }

        public static String Message(String email, String mess){

            try {
                Connection con=DriverManager.getConnection(  
                "jdbc:mysql://localhost:3306/consumer","mine","pass");  //adddress username password of admin 
                Statement stmt=con.createStatement();  
       
                // Update a row in the table
                String sql = "INSERT INTO `reports` (`report_number`, `Email`, `compaint`, `time`) VALUES (NULL, '"+email+"', '"+mess+"', CURRENT_TIMESTAMP)";
                int rowsAffected = stmt.executeUpdate(sql);
                System.out.println(rowsAffected + " row(s) updated");
                stmt.close();
                return "Message uploaded";
             } catch(SQLException e) {
                System.out.println(e);
                return "message failed";
             } 

        }

        

    //update the totals




}
