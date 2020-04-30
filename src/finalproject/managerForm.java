/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author ABDGHALI
 */
public class managerForm extends JFrame {
// DBconnection dbC = new DBconnection();
 
    String select = "";
  boolean visebleBoton= false;
  
  
    public managerForm() {
         
File f = new File(getClass().getResource("abd12.text").getPath());
        method m = new method();
        this.setResizable(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);

        JPanel MainPanel = new JPanel();
        MainPanel.setLayout(new GridLayout(4, 1));

        ///
        FlowLayout fww = new FlowLayout(FlowLayout.CENTER, 20, 20);
        JPanel PanelFlow = new JPanel();
        PanelFlow.setLayout(fww);

        GridLayout grid = new GridLayout(3, 4, 5, 5);
        JPanel input = new JPanel();
        input.setAlignmentY(100);
        input.setLayout(grid);
        JLabel LID = new JLabel("ID:   ");
        JTextField jtfID = new JTextField(10);
        JLabel LSalary = new JLabel("Salary:  ");
        JTextField jtfSalary = new JTextField(10);
        
        
        input.add(LID);
        input.add(jtfID);
        input.add(LSalary);
        input.add(jtfSalary);
        ////  

        JLabel LFname = new JLabel("First Name:");
        JTextField jtfFname = new JTextField(10);
        JLabel LNchildren = new JLabel("# of children:");
        JTextField jtfNchildren = new JTextField(10);
        
        
        input.add(LFname);
        input.add(jtfFname);
        input.add(LNchildren);
        input.add(jtfNchildren);
        ///// 

        JLabel LLname = new JLabel("lastNmae:");
        JTextField jtfLname = new JTextField(10);
        JLabel LDOB = new JLabel("DCB");
        JTextField jtfDOB = new JTextField(10);
        input.add(LLname);
        input.add(jtfLname);
        input.add(LDOB);
        input.add(jtfDOB);

        ///////////////////////////////////////////////////////////////////////
        JPanel PSerch = new JPanel();
        PSerch.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        JLabel LSerch = new JLabel("Serch By:");
        JRadioButton ID = new JRadioButton("ID");
        JRadioButton LastName = new JRadioButton("Last Name");
        JTextField jtfSerch = new JTextField(10);
        ButtonGroup bg = new ButtonGroup();
        bg.add(ID);
        bg.add(LastName);
        JButton BSerch = new JButton("Serch");
        PSerch.add(LSerch);
        PSerch.add(ID);
        PSerch.add(LastName);
        PSerch.add(jtfSerch);
        PSerch.add(BSerch);

        //////
        JPanel operation = new JPanel();
        operation.setLayout(new FlowLayout());
        JButton create = new JButton("Create ");
        JButton update = new JButton("Update");
        update.setEnabled(false);
        JButton Delete = new JButton("Delete");
         Delete.setEnabled(false);
        JButton Export = new JButton("Export");
        JButton Refrech = new JButton("Refrech");
        ButtonGroup Bgroup = new ButtonGroup();
        Bgroup.add(create);
        Bgroup.add(update);
        Bgroup.add(Delete);
        Bgroup.add(Export);
        Bgroup.add(Refrech);
        operation.add(create);
        operation.add(update);
        operation.add(Delete);
        operation.add(Export);
        operation.add(Refrech);

/////////
        JPanel Ptable = new JPanel();
        Ptable.setLayout(new FlowLayout());
        String[] coll = {"ID  ", "First Name  ", "Last Name  ", "Salary", "# of chidrin", "DOB"};
        DefaultTableModel DTM = new DefaultTableModel(coll, 0);
        JTable table = new JTable(DTM);

        table.setPreferredScrollableViewportSize(new Dimension(450, 80));
        table.setFillsViewportHeight(true);
        table.setAutoCreateRowSorter(true);
        JScrollPane tableScrollPane = new JScrollPane(table);
        tableScrollPane.setAutoscrolls(true);
        Ptable.add(tableScrollPane);
/////////////////////////////////////////////////////////////////////////defined new employee
       DBconnection db = new DBconnection();
        DTM.setRowCount(0);
        try {
            db.getData(DTM);
        } catch (SQLException ex) {
            Logger.getLogger(managerForm.class.getName()).log(Level.SEVERE, null, ex);
        }
////-----table action
table.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
            
            }

            @Override
            public void mousePressed(MouseEvent me) {
                 update.setEnabled(true);
                Delete.setEnabled(true);
               DefaultTableModel model =(DefaultTableModel) table.getModel();
               int selectRowIndex = table.getSelectedRow();
			   
               jtfID.setText(model.getValueAt(selectRowIndex, 0).toString());
			   
			   
			   
                jtfFname.setText(model.getValueAt(selectRowIndex, 1).toString());
                   jtfLname.setText(model.getValueAt(selectRowIndex, 2).toString());
                jtfSalary.setText(model.getValueAt(selectRowIndex, 3).toString());
                jtfNchildren.setText(model.getValueAt(selectRowIndex, 4).toString());
                jtfDOB.setText(model.getValueAt(selectRowIndex, 5).toString());
              
            }

            @Override
            public void mouseReleased(MouseEvent me) {
              //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseEntered(MouseEvent me) {
                
              
            }

            @Override
            public void mouseExited(MouseEvent me) {
              //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });



        ///Start action lesener
        BSerch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                boolean validcerch = true;
                DBconnection db = new DBconnection();
                if(jtfSerch.getText().equals("")){
                    validcerch=false;
                     JOptionPane.showMessageDialog(managerForm.this, "please enter your id or lastname in the text", "error", 0);
                }
              if(validcerch==true){
                if(ID.isSelected() && validcerch==true){
                int id = Integer.parseInt(jtfSerch.getText());
                try {
                    DTM.setRowCount(0);
                    boolean s = db.serchByID(id, DTM);
                    if (s == false) {
                        JOptionPane.showMessageDialog(managerForm.this, "the id not found !!!!", "error", 0);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(managerForm.class.getName()).log(Level.SEVERE, null, ex);
                }
                }
                 else if(LastName.isSelected() && validcerch==true){
                     String lasrname = jtfSerch.getText();
                      JOptionPane.showMessageDialog(managerForm.this, lasrname,"error" , 0);
                     try {
                         
                         boolean li = db.serchByLastName(lasrname ,DTM);
                         
                         if(li ==false){
                             JOptionPane.showMessageDialog(managerForm.this, "the id not found !!!!","error" , 0);
                         }
                     }catch (SQLException ex) {
                         Logger.getLogger(managerForm.class.getName()).log(Level.SEVERE, null, ex);
                     }
                 } else {
                       JOptionPane.showMessageDialog(managerForm.this, "please celect your serch by","error" , 0);
                      validcerch=false;
                 }}
            }
        });
        
        
        
        

        create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                boolean s = m.ValidateTextField(jtfID.getText(), jtfSalary.getText(), jtfFname.getText(), jtfNchildren.getText(), jtfLname.getText(), jtfDOB.getText());
                if (s == false) {
                    JOptionPane.showMessageDialog(managerForm.this, "please enter all fields", "error", 0);
                } else {
                        employee emp = new employee(Integer.parseInt(jtfID.getText()), Float.parseFloat(jtfSalary.getText()), jtfFname.getText(), Integer.parseInt(jtfNchildren.getText()), jtfLname.getText(), jtfDOB.getText());
                        DBconnection db = new DBconnection();
                        int id = Integer.parseInt(jtfID.getText());
                        try {
                            DTM.setRowCount(0);//for clare the table
                            boolean ss = db.serchByID(id, DTM);
                            if (ss == false) {
                                db.insertEmoplyee(emp);
                                
                                 DTM.setRowCount(0);
                                  db.getData(DTM);
                            }else {
                                 JOptionPane.showMessageDialog(managerForm.this, "the employee id is exist", "error", 0);
                            }
                        } catch (SQLException ex) {
                            Logger.getLogger(managerForm.class.getName()).log(Level.SEVERE, null, ex);
                        }

                }

            }
        });

        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                boolean s = m.ValidateTextField(jtfID.getText(), jtfSalary.getText(), jtfFname.getText(), jtfNchildren.getText(), jtfLname.getText(), jtfDOB.getText());
                if (s == false) {
                      JOptionPane.showMessageDialog(managerForm.this, "please enter all fields", "error", 0);   
                }else{
                        DBconnection db = new DBconnection();
                       float f =(float)Float.parseFloat(jtfSalary.getText());
                   employee emp = new employee(Integer.parseInt(jtfID.getText()), f, jtfFname.getText(), Integer.parseInt(jtfNchildren.getText()), jtfLname.getText(), jtfDOB.getText());
                        
                        try {
                            DTM.setRowCount(0);//for clare the table
                            boolean ss = db.serchByID(emp.getId(), DTM);
                            if (ss == true) {
                               db.updateEmoplyee(emp);
                            }else {
                                 JOptionPane.showMessageDialog(managerForm.this, "the employee id not found", "error", 0);
                            }
                        } catch (SQLException ex) {
                            Logger.getLogger(managerForm.class.getName()).log(Level.SEVERE, null, ex);
                        } 
                }
            }
        });

        Delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                boolean s = m.ValidateTextField(jtfID.getText(), jtfSalary.getText(), jtfFname.getText(), jtfNchildren.getText(), jtfLname.getText(), jtfDOB.getText());
                if (s == false) {
                    JOptionPane.showMessageDialog(managerForm.this, "please enter all fields", "error", 0);
                }else{
                      DBconnection db = new DBconnection();
                       float f =(float)Float.parseFloat(jtfSalary.getText());
                   employee emp = new employee(Integer.parseInt(jtfID.getText()), f, jtfFname.getText(), Integer.parseInt(jtfNchildren.getText()), jtfLname.getText(), jtfDOB.getText());
                         try {
                            DTM.setRowCount(0);//for clare the table
                            boolean ss = db.serchByID(emp.getId(), DTM);
                            if (ss == true) {
                                db.DeleteEmoploee(emp);
                            }else {
                                 JOptionPane.showMessageDialog(managerForm.this, "the employee id not found", "error", 0);
                            }
                        } catch (SQLException ex) {
                            Logger.getLogger(managerForm.class.getName()).log(Level.SEVERE, null, ex);
                        }  
                }
            }
        });
 
        Export.addActionListener(new ActionListener() {
          
            @Override
            public void actionPerformed(ActionEvent ae) {             
              DBconnection db = new DBconnection(); 
              method m = new method();
                try {
                   ArrayList<employee> emp = db.getDataAsArrayList();
                    // JOptionPane.showMessageDialog(managerForm.this, emp.get(1).getFirstName(), "error", 0);
                   m .Writer(f, emp);
                } catch (SQLException ex) {
                    Logger.getLogger(managerForm.class.getName()).log(Level.SEVERE, null, ex);
                }
                    
             

            }
        });

        Refrech.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                DBconnection db = new DBconnection();
                try {
                    DTM.setRowCount(0);
                    db.getData(DTM);
					
                    jtfID.setText(null);
                    jtfSalary.setText(null);
                    jtfFname.setText(null);
                    jtfNchildren.setText(null);
                    jtfLname.setText(null);
                    jtfDOB.setText(null);
                     update.setEnabled(false);
                Delete.setEnabled(false);
                    
                } catch (SQLException ex) {
                    Logger.getLogger(managerForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        ///// //////      
        PanelFlow.add(input);
        MainPanel.add(PanelFlow);
        MainPanel.add(PSerch);
        MainPanel.add(operation);
        MainPanel.add(Ptable);

        this.add(MainPanel);//
        this.setSize(500, 500);

    }

}
