/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

/**
 *
 * @author ABDGHALI
 */
public class employee {
    
 int id;
 float Salary;
 String FirstName;
 int NumberOfChildren;
 String LastName;
 String  dateOfBirth;  

    public employee(int id, float Salary, String FirstName, int NumberOfChildren, String LastName, String dateOfBirth) {
        this.id = id;
        this.Salary = Salary;
        this.FirstName = FirstName;
        this.NumberOfChildren = NumberOfChildren;
        this.LastName = LastName;
        this.dateOfBirth = dateOfBirth;
    }
public employee(){}
   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getSalary() {
        return Salary;
    }

    public void setSalary(float Salary) {
        this.Salary = Salary;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public int getNumberOfChildren() {
        return NumberOfChildren;
    }

    public void setNumberOfChildren(int NumberOfChildren) {
        this.NumberOfChildren = NumberOfChildren;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void DateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
 
 
 
    
    
}
