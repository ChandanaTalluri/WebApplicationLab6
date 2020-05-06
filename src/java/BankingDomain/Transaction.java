/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
*4/17/2020 Commented code as persistent layer is implemented
*and added annotations 
 */
package BankingDomain;

import DataAccessLayer.AccountTransactionDBA;
import DataAccessLayer.AccountDBA;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author Chandana
 */
@Entity
@Table(name="ACCOUNT_TRANSACTION")
public class Transaction implements Serializable{
    @Id
    @Column(name="Transaction_ID")
    private int transactionID;
    @Column(name="Date_Of_Transcation")
    @Temporal(TemporalType.DATE)
    private Date dateOfTranscation;
    @Column(name="Account_Number")
    private String strAccountNumber;
    @Column(name="Trasaction_Amount")
    private double trasactionAmount;
    @Column(name="Description")
    private String strDescription;
    @Column(name="Balance_Amount")
    private double balanceAmount;
    @Transient
    private boolean blisCredited;
    @Transient
    private String strFormatedDate;

    public String getStrFormatedDate() {
        return strFormatedDate;
    }

    public void setStrFormatedDate(String strFormatedDate) {
        this.strFormatedDate = strFormatedDate;
    }

    public boolean isBlisCredited() {
        return blisCredited;
    }

    public void setBlisCredited(boolean blisCredited) {
        this.blisCredited = blisCredited;
    }

    public double getBalanceAmount() {
        return balanceAmount;
    }

    public void setBalanceAmount(double balanceAmount) {
        this.balanceAmount = balanceAmount;
    }
    

    public int getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(int transactionID) {
        this.transactionID = transactionID;
    }

    public Date getDateOfTranscation() {
        return dateOfTranscation;
    }

    public void setDateOfTranscation(Date dateOfTranscation) {
        this.dateOfTranscation = dateOfTranscation;
    }

    public String getStrAccountNumber() {
        return strAccountNumber;
    }

    public void setStrAccountNumber(String strAccountNumber) {
        this.strAccountNumber = strAccountNumber;
    }

    public double getTrasactionAmount() {
        return trasactionAmount;
    }

    public void setTrasactionAmount(double trasactionAmount) {
        this.trasactionAmount = trasactionAmount;
    }

    public String getStrDescription() {
        return strDescription;
    }

    public void setStrDescription(String strDescription) {
        this.strDescription = strDescription;
    }
    
    /*public static void init(){
        AccountTransactionDBA.init();
    }*/

    @Override
    public String toString() {
        String strCustomizeToString = null;
        strCustomizeToString =  "Trasaction details for account Number: "+ strAccountNumber + "\n" +
                                "   Transaction ID: "+ transactionID + "\n" +
                                "   Transaction Date: "+ dateOfTranscation + "\n" +
                                "   Amount: $." +trasactionAmount +"\n "+
                                "  Message for Customer: " +strDescription;
        return strCustomizeToString;
    }
    /*public static ArrayList<Transaction> getTransaction(){
        
        return AccountTransactionDBA.getTransaction();
        
    }*/
     public static ArrayList<Transaction> findTransactions(String strAccountNumber){
          return AccountTransactionDBA.findTransactionDetails(strAccountNumber);
     }
}
