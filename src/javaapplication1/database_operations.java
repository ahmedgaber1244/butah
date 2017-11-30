package javaapplication1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class database_operations {
    database_operations(){
    }
    public Connection connect(){
        Connection conn = null;
        try{
            Class.forName("org.sqlite.JDBC");  
            conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\gaber\\mamav.db");  
           JOptionPane.showMessageDialog(null, "database is connected", "sdad", 3);
 
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 3);
        }
        return conn;
    }
    public void InsertDate(String Name,int Age,String Address ,String Job
            ,String MobilePhone ,String Soker,String virous ,String syolt_dam ,String ghodah ,String awram ,
            String dateldam ,String amradel2alb ,String smoker ,String hsaysya ,String Romatezm ,String Surgery  ,String kmayah 
            ,String Eshay ,String Kortezon ,String hsasya_mn_eladwayh 
            ,String hamel ,String redaah ,String  notes) {
            Connection conn = connect();
        try{
                  String sql = "INSERT INTO PatientAppliction (Name, Age, Address , Job, MobilePhone , Soker,virous , syolt dam , 8odah ,awram , d8teldam , amradel2alb , smoker , 7saysya , Romatezm , Surgery  , kmayah , Esh3a3y , Kortezon , 7sasya mn el adwayh , 7amel , reda3ah , notes ) VALUES"
                          + " (?, ?, ? ,?, ? , ? , ? , ? ,? , ? ,? , ? , ? ,? , ? , ? , ? , ? , ? , ? , ? , ? , ?)";
                  PreparedStatement prs = conn.prepareStatement(sql);
                    prs.setString(1,Name);
                    prs.setInt(2,Age);
                    prs.setString(3, Address);
                    prs.setString(4, Job);
                    prs.setString(5,MobilePhone);
                    prs.setString(6,Soker);
                    prs.setString(7, virous);
                    prs.setString(8, syolt_dam);
                    prs.setString(9,ghodah);
                    prs.setString(10,awram);
                    prs.setString(11, dateldam);
                    prs.setString(12, amradel2alb);
                    prs.setString(13,smoker);
                    prs.setString(14,hsaysya);
                    prs.setString(15, Romatezm);
                    prs.setString(16, Surgery);
                    prs.setString(17,kmayah);
                    prs.setString(18,Eshay);
                    prs.setString(19, Kortezon);
                    prs.setString(20, hsasya_mn_eladwayh);
                    prs.setString(21,hamel);
                    prs.setString(22,redaah);
                    prs.setString(23,notes);
                    prs.executeUpdate(); 
        }catch(Exception e){
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 3);

           } 
    }
    public void InsertFee ()
    {
        Connection conn = connect();
        try {
           String fee = "INSERT INTO fee ()";
            
      }catch(Exception e){
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 3);

           } 
    }
    public void UpdateDate (int id ,String nameN, String teleN,int ageN,String addressN)
           
    {
        Connection conn = connect();
        try {
            String sql = "UPDATE patients set name=?, tele=? , age=? , adress=? where id=? ";
                  PreparedStatement prs = conn.prepareStatement(sql);
                    prs.setString(1, nameN);
                    prs.setString(2, teleN);
                    prs.setInt(3,ageN);
                    prs.setString(4,addressN);
                    prs.setInt(5, id);
                    prs.executeUpdate(); 
            
        }
        catch(Exception e ){
             JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 3);
        }
    }
    public void DeleteDate (int id ,String name, String tele,int age,String address) {
        Connection conn = connect();
        try{
                  String sql = "DELETE FROM patients set name=?, tele=? , age=? , adress=? where id=? ";
                  PreparedStatement prs = conn.prepareStatement(sql);
                    prs.setString(1, name);
                    prs.setString(2, tele);
                    prs.setInt(3,age);
                    prs.setString(4,address);
                    prs.setInt(5, id);
                    prs.executeUpdate(); 
        }catch(Exception e){
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 3);

           } 
    }
      public  DefaultTableModel  select() {
        Connection conn = connect();
        DefaultTableModel mod=new DefaultTableModel();
         Object rowdata[]=new Object[5]; 
        
        try{
                  String sql = "select * from patients";
                  PreparedStatement preparedStatement = conn.prepareStatement(sql);
                  ResultSet rs= preparedStatement.executeQuery();
                  while(rs.next()){
                  String name=rs.getString(2);
                  String tele=rs.getString(3);
                  int age=rs.getInt(4);
                  String address=rs.getString(5);
                  int id=rs.getInt(1);
                  rowdata[1]= id;
                  rowdata[2]= name;
                  rowdata[3]= tele;
                  rowdata[4]= age;
                  rowdata[5]= address;
                   mod.addRow(rowdata);
              
                  }
                    return mod ;
                 
        }catch(Exception e){
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 3);

                       
    
        }
        return mod;
      }
} 

    
      


