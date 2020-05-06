/*
*4/17/2020 Commented code as persistent layer is implemented
 */
package DataAccessLayer;

import BankingDomain.Account;
import BankingDomain.AssetAccount;
import BankingDomain.LiabilityAccount;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Chandana
 */
public class AccountDBA {
    //This method is used to fetch acoount details using userID
     public static HashMap findAccountDetails(String userID) {
        ArrayList<AssetAccount> objArrAsset = new ArrayList<AssetAccount>();
        ArrayList<LiabilityAccount> objArrLiability = new ArrayList<LiabilityAccount>();
        EntityManager objEntity = BankingDBConnect.getEntityManager().createEntityManager();
        String strAsset="A";
        String strLiability = "L";
        HashMap objHmp = new HashMap();
        try{
           
            String sql = "Select a.strAccountNumber,a.userID,a.strAccountName,a.dateOpened,a.custID,a.balanceAmount,a.account_type " 
                    + "from Account a where a.userID = :u ";
            
                 TypedQuery strQuery  = objEntity.createQuery(sql,Account.class);
            strQuery.setParameter("u", userID);
            
            List objList = strQuery.getResultList();
            for(int i=0;i<objList.size();i++){
                Object[] objArray = (Object[])objList.get(i);
                    String strAccountNumber = (String) objArray[0];
                    String strUserID = (String) objArray[1];
                    String strAccountName = (String) objArray[2];
                    Date  dateOpened = (Date) objArray[3];
                    String custID = ((String) objArray[4]);
                    double  balanceAmount = (double) objArray[5];
                    String account_type =Character.toString((char)  objArray[6]);
                    if(strAsset.equals(account_type)){
                        AssetAccount objA = new AssetAccount();
                    objA.setStrAccountNumber(strAccountNumber);
                    objA.setUserID(strUserID);
                    objA.setStrAccountName(strAccountName);
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    
                    objA.setDateOpened(dateOpened);
                    
                    String strFormate = sdf.format(dateOpened);
                    objA.setStrFormattedOpeningDate(strFormate);
                
                    objA.setCustID(custID);
                    objA.setBalanceAmount(balanceAmount);
                    objArrAsset.add(objA);
                    }
                    if(strLiability.equals(account_type)){
                        LiabilityAccount objLA = new LiabilityAccount();
                        objLA.setStrAccountNumber(strAccountNumber);
                    objLA.setUserID(strUserID);
                    objLA.setStrAccountName(strAccountName);
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    
                    objLA.setDateOpened(dateOpened);
                    
                    String strFormate = sdf.format(dateOpened);
                    objLA.setStrFormattedOpeningDate(strFormate);
                
                    objLA.setCustID(custID);
                    objLA.setBalanceAmount(balanceAmount);
                    objArrLiability.add(objLA);
                    } 
            }
                  
        
        
            objHmp.put("A", objArrAsset);
            objHmp.put("L", objArrLiability);
           
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        finally{
            objEntity.close();
        }
         return objHmp;
    }
      //thus method is used to get balance from account number
    public static double getAccontBalance(String strAccountNo) {
        EntityManager objEntity = BankingDBConnect.getEntityManager().createEntityManager();
        
      double balance = 0;
     try{
            
            String sql = "Select a.balanceAmount " 
                    + "from Account a where a.strAccountNumber = :u ";
            
            TypedQuery strQuery  = objEntity.createQuery(sql,Account.class);
            strQuery.setParameter("u", strAccountNo);
            balance = (double) strQuery.getSingleResult();
            
      }catch(Exception e){
          System.out.println(e.getMessage());
      }finally{
         objEntity.close();
     }
        return balance;
    }
    public static HashMap findAllAccountDetails() {
        ArrayList<AssetAccount> objArrAsset = new ArrayList<AssetAccount>();
        ArrayList<LiabilityAccount> objArrLiability = new ArrayList<LiabilityAccount>();
        EntityManager objEntity = BankingDBConnect.getEntityManager().createEntityManager();
        String strAsset="A";
        String strLiability = "L";
        HashMap objHmp = new HashMap();
        try{
           
            String sql = "Select a.strAccountNumber,a.userID,a.strAccountName,a.dateOpened,a.custID,a.balanceAmount,a.account_type " 
                    + "from Account a ";
            
                 TypedQuery strQuery  = objEntity.createQuery(sql,Account.class);
            
            List objList = strQuery.getResultList();
            for(int i=0;i<objList.size();i++){
                Object[] objArray = (Object[])objList.get(i);
                    String strAccountNumber = (String) objArray[0];
                    String strUserID = (String) objArray[1];
                    String strAccountName = (String) objArray[2];
                    Date  dateOpened = (Date) objArray[3];
                    String custID = ((String) objArray[4]);
                    double  balanceAmount = (double) objArray[5];
                    String account_type =Character.toString((char)  objArray[6]);
                    if(strAsset.equals(account_type)){
                        AssetAccount objA = new AssetAccount();
                    objA.setStrAccountNumber(strAccountNumber);
                    objA.setUserID(strUserID);
                    objA.setStrAccountName(strAccountName);
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    
                    objA.setDateOpened(dateOpened);
                    
                    String strFormate = sdf.format(dateOpened);
                    objA.setStrFormattedOpeningDate(strFormate);
                
                    objA.setCustID(custID);
                    objA.setBalanceAmount(balanceAmount);
                    objArrAsset.add(objA);
                    }
                    if(strLiability.equals(account_type)){
                        LiabilityAccount objLA = new LiabilityAccount();
                        objLA.setStrAccountNumber(strAccountNumber);
                    objLA.setUserID(strUserID);
                    objLA.setStrAccountName(strAccountName);
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    
                    objLA.setDateOpened(dateOpened);
                    
                    String strFormate = sdf.format(dateOpened);
                    objLA.setStrFormattedOpeningDate(strFormate);
                
                    objLA.setCustID(custID);
                    objLA.setBalanceAmount(balanceAmount);
                    objArrLiability.add(objLA);
                    } 
            }
                  
        
        
            objHmp.put("A", objArrAsset);
            objHmp.put("L", objArrLiability);
           
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        finally{
            objEntity.close();
        }
         return objHmp;
    }
   /* private static ArrayList<AssetAccount> objArrListAssetAccount = new ArrayList<AssetAccount>();
    
     public static HashMap findAccountDetails(String userID) {
        ArrayList<AssetAccount> objArrAsset = new ArrayList<AssetAccount>();
        ArrayList<LiabilityAccount> objArrLiability = new ArrayList<LiabilityAccount>();
        HashMap objHmp = new HashMap();
        try{
            Connection connection;
            Statement statement;
            connection= BankingDBConnect.getConnection();
            statement = connection.createStatement();
            ResultSet rs;
            
            String sql = "Select Account_Number,USER_ID,Account_Name,Date_Opened,CUSTOMER_ID,Account_Balance,Account_type " 
                    + "from ACCOUNT where USER_ID = '"+userID+"'";
            rs = statement.executeQuery(sql);
          
            while(rs.next()){
                System.out.println("Account type : "+rs.getString(7));
                System.out.println("Account Number : "+rs.getString(1));
                if("A".equals(rs.getString(7))){
                    AssetAccount objA = new AssetAccount();
                    objA.setStrAccountNumber(rs.getString(1));
                    objA.setUserID(rs.getString(2));
                    objA.setStrAccountName(rs.getString(3));
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    Date mydate = sdf.parse(rs.getString(4));
                    objA.setDateOpened(mydate);
                    
                    String strFormate = sdf.format(mydate);
                    objA.setStrFormattedOpeningDate(strFormate);
                
                    objA.setCustID(rs.getString(5));
                    objA.setBalanceAmount(Double.valueOf(rs.getString(6)));
                    objArrAsset.add(objA);
                    
                }
                if("L".equals(rs.getString(7))){
                    LiabilityAccount objLA = new LiabilityAccount();
                    objLA.setStrAccountNumber(rs.getString(1));
                    objLA.setUserID(rs.getString(2));
                    objLA.setStrAccountName(rs.getString(3));
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    Date mydate = sdf.parse(rs.getString(4));
                    objLA.setDateOpened(mydate);
                    
                    String strFormate = sdf.format(mydate);
                    objLA.setStrFormattedOpeningDate(strFormate);
                    
                    objLA.setCustID(rs.getString(5));
                    objLA.setBalanceAmount(Double.valueOf(rs.getString(6)));
                    objArrLiability.add(objLA);
                    
                }
           
            }
            objHmp.put("A", objArrAsset);
            objHmp.put("L", objArrLiability);
        }catch(Exception e){
            
        }
        return objHmp;
    }
     //thus method is used to get balance from account number
    public static double getAccontBalance(String strAccountNo) {
      
      double balance = 0;
     try{
            Connection connection;
            Statement statement;
            connection= BankingDBConnect.getConnection();
            statement = connection.createStatement();
            ResultSet rs;
            
            String sql = "Select Account_Balance " 
                    + "from ACCOUNT where Account_Number = '"+strAccountNo+"'";
            rs = statement.executeQuery(sql);
          
            while(rs.next()){
                balance= Double.valueOf(rs.getString(1));
            }
        
      }catch(Exception e){
          System.out.println(e.getMessage());
      }
        return balance;
    }
     */
}
