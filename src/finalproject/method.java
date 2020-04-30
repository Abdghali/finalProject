/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author ABDGHALI
 */
public class method {
    
    
    
    public boolean ValidateTextField(String id,String Salary,String Fname,String NomberChild,String Lname,String DateOFBirth){
        boolean valid =true;
      if(id.length()<=0){
          valid =false;
      }else if(Salary.equals("")){
         valid =false;
     } else if(Fname.equals("")){
           valid =false;
      }else if(NomberChild.equals("")){
        valid =false;
     } else if(Lname.equals("")){
            valid =false;
      }else if(DateOFBirth.equals("")){
        valid =false;
    } 
        
     return valid;   
    }
    
//     public void Writer(File f,ArrayList<employee> emp) {
//        if (f.exists() ) {
//                    FileWriter r = null;
//                    try {
//                        
//                           r = new FileWriter(f);
//                         BufferedWriter   bf = new BufferedWriter(r);
//                        for (employee em : emp) {
//                           bf.write("id : "+em.getId()+"- First Name : "+em.getFirstName()+"- LastName : "+em.getLastName()+"- salary : "+em.getSalary()+"- nomber of chiledren : "+em.getNumberOfChildren()+"- Date of berth : "+em.getDateOfBirth()+"/n");   
//                        }
//                           bf.close();
//                         
//                          r.close();
//                          
//                    } catch (IOException ex) {
//                        System.out.println("You don't have permission to Write in the file");
//                    }
//        } else {
//            try {
//                f.createNewFile();
//                System.out.println("Created Successfully...");
//            } catch (IOException ex) {
//                System.out.println("You don't have permission to create file");
//            }
//        }
//    }
//    
     public void Writer(File f, ArrayList<employee> emp) {
        if (f.exists()) {
            try {
                FileWriter r = new FileWriter(f);
                System.out.println(f.getAbsolutePath());
                for (int count =0;count<emp.size();count++) {
                    employee em=emp.get(count);
                    System.out.println(em.getLastName());
                
                    r.write("id : " + em.getId() + "- First Name : " + em.getFirstName() + "- LastName : " + em.getLastName() + "- salary : " + em.getSalary() + "- nomber of chiledren : " + em.getNumberOfChildren() + "- Date of berth : " + em.getDateOfBirth() + "\n");
                  
                }
                r.close();

            } catch (IOException ex) {
                System.out.println("You don't have permission to Write in the file");
            } finally {
            }
        } else {
            try {
                f.createNewFile();
                System.out.println("Created Successfully...");
            } catch (IOException ex) {
                System.out.println("You don't have permission to create file");
            }
        }
    }

}

    
    
    
    
    
    
