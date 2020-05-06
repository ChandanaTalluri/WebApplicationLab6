/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BankingDomain;

import DataAccessLayer.AccountDBA;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Chandana
 */
@Entity
public abstract class Account implements Serializable {
    @Id
    @Column(name="Account_Number")
    private String strAccountNumber;
    @Column(name="USER_ID")
    private String userID;
    @Column(name="Account_Name")
    private String strAccountName;
    @Column(name="Date_Opened ")
    @Temporal(TemporalType.DATE)
    private Date dateOpened;
    @Column(name="CUSTOMER_ID")
    private String custID;
    @Column(name="Account_Balance")
    private double balanceAmount;
    @Column(name="Account_type")
    private char account_type;
    
    public Account(){
        
    }
 
    public String getCustID() {
        return custID;
    }

    public void setCustID(String custID) {
        this.custID = custID;
    }

    public double getBalanceAmount() {
        return balanceAmount;
    }

    public void setBalanceAmount(double balanceAmount) {
        this.balanceAmount = balanceAmount;
    }

    public char getAccount_type() {
        return account_type;
    }

    public void setAccount_type(char account_type) {
        this.account_type = account_type;
    }
    public String getStrAccountNumber() {
        return strAccountNumber;
    }

    public void setStrAccountNumber(String strAccountNumber) {
        this.strAccountNumber = strAccountNumber;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

   

    public String getStrAccountName() {
        return strAccountName;
    }

    public void setStrAccountName(String strAccountName) {
        this.strAccountName = strAccountName;
    }

    public Date getDateOpened() {
        return dateOpened;
    }

    public void setDateOpened(Date dateOpened) {
        this.dateOpened = dateOpened;
    }
    public static HashMap findAccountDetails(String strUserID){
        
        return AccountDBA.findAccountDetails(strUserID);
        
    }
    public static double getAccontBalance(String strAccountNumber){
         double balance = AccountDBA.getAccontBalance(strAccountNumber);
         return balance;
     }
    
     public static HashMap findAllAccountDetails(){
        
        return AccountDBA.findAllAccountDetails();
        
    }
}
