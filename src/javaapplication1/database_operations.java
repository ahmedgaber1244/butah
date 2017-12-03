package javaapplication1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class database_operations {

    database_operations() {
    }

    public Connection connect() {
        Connection conn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\gaber\\mamav.db");
            JOptionPane.showMessageDialog(null, "database is connected", "sdad", 3);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 3);
        }
        return conn;
    }

    public void InsertDate(String Name, int Age, String Address, String Job, String MobilePhone, String Soker, String virous, String syolt_dam, String ghodah, String awram,
            String dateldam, String amradel2alb, String smoker, String hsaysya, String Romatezm, String Surgery, String kmayah, String Eshay, String Kortezon, String hsasya_mn_eladwayh, String hamel, String redaah, String notes) {
        Connection conn = connect();
        try {
            String sql = "INSERT INTO PatientAppliction (Name, Age, Address , Job, MobilePhone , Soker,virous , syolt dam , 8odah ,awram , d8teldam , amradel2alb , smoker , 7saysya , Romatezm , Surgery  , kmayah , Esh3a3y , Kortezon , 7sasya mn el adwayh , 7amel , reda3ah , notes ) VALUES"
                    + " (?, ?, ? ,?, ? , ? , ? , ? ,? , ? ,? , ? , ? ,? , ? , ? , ? , ? , ? , ? , ? , ? , ?)";
            PreparedStatement prs = conn.prepareStatement(sql);
            prs.setString(1, Name);
            prs.setInt(2, Age);
            prs.setString(3, Address);
            prs.setString(4, Job);
            prs.setString(5, MobilePhone);
            prs.setString(6, Soker);
            prs.setString(7, virous);
            prs.setString(8, syolt_dam);
            prs.setString(9, ghodah);
            prs.setString(10, awram);
            prs.setString(11, dateldam);
            prs.setString(12, amradel2alb);
            prs.setString(13, smoker);
            prs.setString(14, hsaysya);
            prs.setString(15, Romatezm);
            prs.setString(16, Surgery);
            prs.setString(17, kmayah);
            prs.setString(18, Eshay);
            prs.setString(19, Kortezon);
            prs.setString(20, hsasya_mn_eladwayh);
            prs.setString(21, hamel);
            prs.setString(22, redaah);
            prs.setString(23, notes);
            prs.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 3);

        }
    }

    public void InsertFee(String T_plan,int payment , int total , String name , String date) {
        Connection conn = connect();
        try {
            String fee = "INSERT INTO fee (T_plan, payment , total , name ,date ) values (?,?,?,?,?)";
            PreparedStatement prs = conn.prepareStatement(fee);
            prs.setString(1, T_plan);
            prs.setInt(2, payment);
            prs.setInt(3, total);
            prs.setString(4, name);
            prs.setString(5, date);
            prs.executeUpdate();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 3);

        }
    }

     public void UpdateFee(String T_plan,int payment , int total , String name , String date,int feeid) {
        Connection conn = connect();
        try {
            String fee = "UPDATE fees set T_plan=?, payment=? , total=? , name=? , date=? where feeid=?";
            PreparedStatement prs = conn.prepareStatement(fee);
            prs.setString(1, T_plan);
            prs.setInt(2, payment);
            prs.setInt(3, total);
            prs.setString(4, name);
            prs.setString(5, date);
            prs.executeUpdate();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 3);

        }
    }
    public void UpdateDate(int id, String nameN, String teleN, int ageN, String addressN) {
        Connection conn = connect();
        try {
            String sql = "UPDATE patients set name=?, tele=? , age=? , adress=? where id=? ";
            PreparedStatement prs = conn.prepareStatement(sql);
            prs.setString(1, nameN);
            prs.setString(2, teleN);
            prs.setInt(3, ageN);
            prs.setString(4, addressN);
            prs.setInt(5, id);
            prs.executeUpdate();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 3);
        }
    }

    public void DeleteDate(int id, String name, String tele, int age, String address) {
        Connection conn = connect();
        try {
            String sql = "DELETE FROM patients set name=?, tele=? , age=? , adress=? where id=? ";
            PreparedStatement prs = conn.prepareStatement(sql);
            prs.setString(1, name);
            prs.setString(2, tele);
            prs.setInt(3, age);
            prs.setString(4, address);
            prs.setInt(5, id);
            prs.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 3);

        }
    }

    public DefaultTableModel select_appointments() {
        Connection conn = connect();
        DefaultTableModel mod = new DefaultTableModel();
        Object rowdata[] = new Object[23];

        try {
            String sql = "select * from appointments";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String Name = rs.getString(1);
                String Address = rs.getString(2);
                int Age = rs.getInt(3);
                String Job = rs.getString(4);
                String MobilePhone = rs.getString(5);
                String Soker = rs.getString(6);
                String virous = rs.getString(7);
                String syolt_dam = rs.getString(8);
                String odah = rs.getString(9);
                String awram = rs.getString(10);
                String d8teldam = rs.getString(11);
                String amradel2alb = rs.getString(12);
                String smoker = rs.getString(13);
                String hsaysya = rs.getString(14);
                String Romatezm = rs.getString(15);
                String Surgery = rs.getString(16);
                String kmayah = rs.getString(17);
                String Esh3a3y = rs.getString(18);
                String Kortezon = rs.getString(19);
                String hsasya_mn_el_adwayh = rs.getString(20);
                String hamel = rs.getString(21);
                String reda3ah = rs.getString(22);
                String notes = rs.getString(23);

                rowdata[0] = Name;
                rowdata[1] = Age;
                rowdata[2] = Address;
                rowdata[3] = Job;
                rowdata[4] = MobilePhone;
                rowdata[5] = Soker;
                rowdata[6] = virous;
                rowdata[7] = syolt_dam;
                rowdata[8] = odah;
                rowdata[9] = awram;
                rowdata[10] = d8teldam;
                rowdata[11] = amradel2alb;
                rowdata[12] = smoker;
                rowdata[13] = hsaysya;
                rowdata[14] = Romatezm;
                rowdata[15] = Surgery;
                rowdata[16] = kmayah;
                rowdata[17] = Esh3a3y;
                rowdata[18] = Kortezon;
                rowdata[19] = hsasya_mn_el_adwayh;
                rowdata[20] = hamel;
                rowdata[21] = reda3ah;
                rowdata[22] = notes;
                mod.addRow(rowdata);

            }
            return mod;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 3);

        }
        return mod;
    }
     public DefaultTableModel select_appointments_with_filter(String query) {
        Connection conn = connect();
        DefaultTableModel mod = new DefaultTableModel();
        Object rowdata[] = new Object[23];

        try {
            String sql = "select * from appointments"+query;
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String Name = rs.getString(1);
                String Address = rs.getString(2);
                int Age = rs.getInt(3);
                String Job = rs.getString(4);
                String MobilePhone = rs.getString(5);
                String Soker = rs.getString(6);
                String virous = rs.getString(7);
                String syolt_dam = rs.getString(8);
                String odah = rs.getString(9);
                String awram = rs.getString(10);
                String d8teldam = rs.getString(11);
                String amradel2alb = rs.getString(12);
                String smoker = rs.getString(13);
                String hsaysya = rs.getString(14);
                String Romatezm = rs.getString(15);
                String Surgery = rs.getString(16);
                String kmayah = rs.getString(17);
                String Esh3a3y = rs.getString(18);
                String Kortezon = rs.getString(19);
                String hsasya_mn_el_adwayh = rs.getString(20);
                String hamel = rs.getString(21);
                String reda3ah = rs.getString(22);
                String notes = rs.getString(23);

                rowdata[0] = Name;
                rowdata[1] = Age;
                rowdata[2] = Address;
                rowdata[3] = Job;
                rowdata[4] = MobilePhone;
                rowdata[5] = Soker;
                rowdata[6] = virous;
                rowdata[7] = syolt_dam;
                rowdata[8] = odah;
                rowdata[9] = awram;
                rowdata[10] = d8teldam;
                rowdata[11] = amradel2alb;
                rowdata[12] = smoker;
                rowdata[13] = hsaysya;
                rowdata[14] = Romatezm;
                rowdata[15] = Surgery;
                rowdata[16] = kmayah;
                rowdata[17] = Esh3a3y;
                rowdata[18] = Kortezon;
                rowdata[19] = hsasya_mn_el_adwayh;
                rowdata[20] = hamel;
                rowdata[21] = reda3ah;
                rowdata[22] = notes;
                mod.addRow(rowdata);

            }
            return mod;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 3);

        }
        return mod;
    }

    public DefaultTableModel select() {
        Connection conn = connect();
        DefaultTableModel mod = new DefaultTableModel();
        Object rowdata[] = new Object[5];

        try {
            String sql = "select * from patients";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString(2);
                String tele = rs.getString(3);
                int age = rs.getInt(4);
                String address = rs.getString(5);
                int id = rs.getInt(1);
                rowdata[1] = id;
                rowdata[2] = name;
                rowdata[3] = tele;
                rowdata[4] = age;
                rowdata[5] = address;
                mod.addRow(rowdata);

            }
            return mod;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 3);

        }
        return mod;
    }
     public void DeleteFee(String T_plan,int payment , int total , String name , String date,int feeid) {
        Connection conn = connect();
        try {
            String fee = "DELETE FROM fees where feeid=? ";
            PreparedStatement prs = conn.prepareStatement(fee);
            prs.executeUpdate();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 3);

        }
}
}
