/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
*4/17/2020 Commented code as persistent layer is implemented
and added annotations
 */
package BankingDomain;

import BankingExceptions.LoginException;
import BankingExceptions.RecordsNotFoundException;
import DataAccessLayer.CustomerDBA;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 *
 * @author Chandana
 */
@Entity
public class Customer implements Serializable{
    @Id
    @Column(name="CUSTOMER_ID")
    private int custID;
    @Column(name="USER_ID")
    private String userID = null;
    @Column(name="FIRST_NAME")
    private  String strFirstName = null;
    @Column(name="LAST_NAME")
    private  String strLastName = null;
    @Column(name="PHONENUMBER")
    private String strPhoneNumber = null;
    @Column(name="EMAIL_ID")
    private String emialID = null;
    @Column(name="PASSWORD")
    private String strPassword = null;
    @Column(name="USER_ROLE")
    private String strUserRole;
    @Transient
    private boolean blUserIDExits;//boolean used to avoid registration with same user id

    public boolean isBlUserIDExits() {
        return blUserIDExits;
    }

    public void setBlUserIDExits(boolean blUserIDExits) {
        this.blUserIDExits = blUserIDExits;
    }
    public String getStrUserRole() {
        return strUserRole;
    }

    public void setStrUserRole(String strUser_role) {
        this.strUserRole = strUser_role;
    }
    public int getCustID() {
        return custID;
    }

    public void setCustID(int custID) {
        this.custID = custID;
    }

   

    public String getStrFirstName() {
        return strFirstName;
    }

    public void setStrFirstName(String strFirstName) {
        this.strFirstName = strFirstName;
    }

    public String getStrLastName() {
        return strLastName;
    }

    public void setStrLastName(String strLastName) {
        this.strLastName = strLastName;
    }

    public String getEmialID() {
        return emialID;
    }

    public void setEmialID(String emialID) {
        this.emialID = emialID;
    }
    
    public Customer(){
        
    }
    public Customer(String userID,String strFirstName,String strLastName,String emialID,String strPhoneNumber,String strPassword,String strUserRole ){
        this.userID = userID;
        this.strFirstName = strFirstName;
        this.strLastName= strLastName;
        this.strPhoneNumber= strPhoneNumber;
        this.strPassword = strPassword;
        this.emialID = emialID;
        this.strUserRole = strUserRole;
    }
    public String getStrPassword() {
        return strPassword;
    }

    public void setStrPassword(String strPassword) {
        this.strPassword = strPassword;
    }
    
    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getStrPhoneNumber() {
        return strPhoneNumber;
    }

    public void setStrPhoneNumber(String strPhoneNumber) {
        this.strPhoneNumber = strPhoneNumber;
    }
   
    
//    public static void init(){
//        CustomerDBA.init();
//    }

    @Override
    public String toString() {
        String strCustomizeToString = null;
        strCustomizeToString = "User ID: "+ userID + "\n"+
                                "Customer ID: "+ custID +"\n"+
                                "Customer First Name: "+ strFirstName +"\n"+
                                "Customer Last Name: "+ strLastName +"\n"+
                                "Customer Contact: "+ strPhoneNumber + "\n";
        
        return strCustomizeToString;
    }
//    public static ArrayList<Customer> getCustomers(){
//        return CustomerDBA.getCustomers();
//    }
    
     public static Customer loginCustomer(String custID,String strPassword) throws LoginException{
        //this method is used to check login
         Customer objCust = CustomerDBA.checklogin(custID, strPassword);
         System.out.println(objCust);
         return objCust;
     }
       public static Customer findCustomer(String strUserID) throws LoginException, RecordsNotFoundException{
        //this method is used to check login
         Customer objCust = CustomerDBA.findCustomerByID(strUserID);
         System.out.println(objCust);
         return objCust;
     }
    public  Customer insertCustomer() throws LoginException, RecordsNotFoundException{
         //this method is used to insert a new user
         Customer objnewCustomer = new Customer(userID, strFirstName, strLastName, emialID, strPhoneNumber, strPassword , strUserRole);
         Customer objCustomer = null ;
         
         Customer objCustomerExists = CustomerDBA.checkUserID(userID);
         if(!objCustomerExists.isBlUserIDExits()){
             CustomerDBA.insertCustomer(objnewCustomer);
             
             objCustomer = CustomerDBA.findCustomerByID(userID);
         }
        return objCustomer;
     }
     public static Customer updateCustomer(Customer objCustomer) throws LoginException{
        //this method is used to check login
         Customer objCust = CustomerDBA.UpdateCustomer(objCustomer);
         System.out.println(objCust);
         return objCust;
     }
}
