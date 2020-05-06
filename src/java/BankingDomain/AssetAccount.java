/*
 * 
*4/17/2020 Commented code as persistent layer is implemented and added annotations
 */
package BankingDomain;

import DataAccessLayer.AccountDBA;
import DataAccessLayer.CustomerDBA;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import javax.persistence.Entity;
import javax.persistence.Transient;

/**
 *
 * @author Chandana
 */
@Entity
public class AssetAccount extends Account implements Serializable {
    
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

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getStrAccountNumber() {
        return strAccountNumber;
    }

    public void setStrAccountNumber(String strAccountNumber) {
        this.strAccountNumber = strAccountNumber;
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
    
//    public static void init(){
//        AssetAccountDBA.init();
//    }

    @Override
    public String toString() {
        String strCustomizeToString = null;
        strCustomizeToString = "Customer account name: "+ strAccountName+"\n"+
                                "   Customer ID: "+ userID + "\n"+
                                "   Account Number: "+ strAccountNumber + "\n" +
                                "   Account Opening date: " +dateOpened;
        return strCustomizeToString;
    }
    /* public static ArrayList<AssetAccount> getAssetAccount(){
        
        return AssetAccountDBA.getAssetAccount();
        
    }
     public static HashMap findAccountDetails(String strUserID){
        
        return AssetAccountDBA.findAccountDetails(strUserID);
        
    }*/
    /* public static double getAccontBalance(String strAccountNumber){
         AssetAccount objAccount = AssetAccountDBA.getAccontBalance(strAccountNumber);
         return objAccount.getBalanceAmount();
     }*/
}
