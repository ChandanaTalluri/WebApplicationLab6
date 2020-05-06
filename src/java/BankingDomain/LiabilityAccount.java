/*
 * 
*4/17/2020 Commented code as persistent layer is implemented and added annotations
 */
package BankingDomain;

import DataAccessLayer.AccountDBA;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Transient;


/**
 *
 * @author Chandana
 */
@Entity
public class LiabilityAccount extends Account implements Serializable {

      
    private String strAccountNumber;
    private String userID;
    private String strAccountName;
    private Date dateOpened;
    private String custID;
    private double balanceAmount;
    @Transient
    private String strFormattedOpeningDate;

    public String getStrFormattedOpeningDate() {
        return strFormattedOpeningDate;
    }

    public void setStrFormattedOpeningDate(String strFormattedOpeningDate) {
        this.strFormattedOpeningDate = strFormattedOpeningDate;
    }

    public double getBalanceAmount() {
        return balanceAmount;
    }

    public void setBalanceAmount(double balanceAmount) {
        this.balanceAmount = balanceAmount;
    }
    public String getCustID() {
        return custID;
    }

    public void setCustID(String custID) {
        this.custID = custID;
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
    
    

    @Override
    public String toString() {
        String strCustomizeToString = null;
        strCustomizeToString = "Customer account name: "+ strAccountName+"\n"+
                                "   Customer ID: "+ userID + "\n"+
                                "   Account Number: "+ strAccountNumber + "\n" +
                                "   Account Opening date: " +dateOpened;
        return strCustomizeToString;
    }
    /* 
    
     public static void init(){
        LiabilityAccountDBA.init();
    }
    public static ArrayList<LiabilityAccount> getLiabilityAccount(){
        
        return LiabilityAccountDBA.getLiabilityAccount();
        
    }
     public static ArrayList<LiabilityAccount> findAccountDetails(String userID, ArrayList<LiabilityAccount> arrLAccount) {
        return LiabilityAccountDBA.findAccountDetails(userID, arrLAccount);
    }
     public static double getAccountDetails(String strAccountNumber) {
        LiabilityAccount objAccount = LiabilityAccountDBA.getAccountDetails(strAccountNumber);
         return objAccount.getBalanceAmount();
    }*/
}
