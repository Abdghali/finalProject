package finalproject;

import finalproject.employee;
import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DBconnection {

    static Statement st;
    static Connection con;
    ResultSet rs;
    PreparedStatement pst;

    public DBconnection() {
           try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/mytest", "root", "");
            st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
        
    }

    public static Connection getCon() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/mytest", "root", "");
            st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
        return con;
    }

    
    public void getData(DefaultTableModel MODEL ) throws SQLException {
        String query = "SELECT * FROM employees";
        rs = st.executeQuery(query);
        Object[] OP = new Object[rs.getMetaData().getColumnCount()];
        while (rs.next()) {
        OP[0] = rs.getInt(1);
        OP[1] = rs.getString(2);
        OP[2] = rs.getString(3);
        OP[3] = rs.getFloat(4);
        OP[4] = rs.getInt(5);
        OP[5] = rs.getString(6);
        MODEL.addRow(OP);

         }
    }
    
    ////؟؟؟
     public ArrayList<employee> getDataAsArrayList(  ) throws SQLException {
         ArrayList<employee> emp = new ArrayList<>();
        String query = "SELECT * FROM employees";
        rs = st.executeQuery(query);
//        if(rs.next.equals(null)){
//            
//            
//        }
        while (rs.next()) {
        int id= rs.getInt(1);
       String Fname = rs.getString(2);
       String lname = rs.getString(3);
        float salary = rs.getFloat(4);
        int nomberOfChiled = rs.getInt(5);
        String date = rs.getString(6);
       employee employee = new employee(id, salary,Fname , nomberOfChiled, lname, date);
        emp.add(employee);
         }
            // System.out.println(emp.get(0).getId());
            
            
         return emp;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    public boolean serchByID(int idd, DefaultTableModel MODEL) throws SQLException {
        boolean isexist;
        String query = "SELECT * FROM employees where id="+idd;
        rs = st.executeQuery(query);
        Object[] OP = new Object[rs.getMetaData().getColumnCount()];
        while (rs.next()) {
        OP[0] = rs.getInt(1);
        OP[1] = rs.getString(2);
        OP[2] = rs.getString(3);
        OP[3] = rs.getFloat(4);
        OP[4] = rs.getInt(5);
        OP[5] = rs.getString(6);
        MODEL.addRow(OP);

         }
        
        if(rs.last()){
            isexist= true;
        }else{
            
        isexist = false;
        }
       return isexist;
    }
   
    
    
    
    
    
    
    
    
      public boolean serchByLastName(String LastNmae, DefaultTableModel MODEL) throws SQLException {
        boolean isexist;
        String query = "SELECT * FROM employees where LastName = '"+LastNmae+"'";
        rs = st.executeQuery(query);
        Object[] OP = new Object[rs.getMetaData().getColumnCount()];
        while (rs.next()) {
        OP[0] = rs.getInt(1);
        OP[1] = rs.getString(2);
        OP[2] = rs.getString(3);
        OP[3] = rs.getFloat(4);
        OP[4] = rs.getInt(5);
        OP[5] = rs.getString(6);
        MODEL.setRowCount(0);
        MODEL.addRow(OP);

         }
        
        if(rs.last()){
            isexist= true;
        }else{
        isexist = false;
        }
       return isexist;
    }
    
    
    public void  insertEmoplyee(employee emp) throws SQLException {
        String query = "INSERT INTO employees "+" VALUES ("+emp.getId()+",\""+emp.getFirstName()+"\",\""+emp.getLastName()+"\","+emp.getSalary()+","+emp.getNumberOfChildren()+",\""+emp.getDateOfBirth()+"\")";
         st.executeUpdate(query);
    }

    public void updateEmoplyee(employee emp) throws SQLException {
       String query = "UPDATE `employees` SET `ID`="+emp.getId()+",`FirstName`='"+emp.getFirstName()+"',`LastName`='"+emp.getLastName()+"',`Salary`='"+emp.getSalary()+"',`#OfChildren`="+emp.getNumberOfChildren()+",`DOB`='"+emp.getDateOfBirth()+"' WHERE `ID`="+emp.getId();  
        st.executeUpdate(query);
      
    }

    public void  DeleteEmoploee(employee emp) throws SQLException {

        int id = emp.getId();
        String query = "delete FROM employees where ID ="+id;
         st.executeUpdate(query);

      

    
    }

}
