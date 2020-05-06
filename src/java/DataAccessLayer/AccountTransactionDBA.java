/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
*4/7/2020 commented all the hard coded data as DB is connected
*4/17/2020 Commented code as persistent layer is implemented
 */
package DataAccessLayer;


import BankingDomain.Transaction;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Chandana
 */
public class AccountTransactionDBA {
    
    //this method will return list of transactions using account number
    public static ArrayList<Transaction> findTransactionDetails(String strAccountNumber) {
        ArrayList<Transaction> objArrTransaction = new ArrayList<Transaction>();
        
        EntityManager objEntity = BankingDBConnect.getEntityManager().createEntityManager();
        try{
           
            String sql = "Select t " 
                    + " from Transaction t where t.strAccountNumber = :accountNo";
           
            System.out.println("sql :"+sql);
            TypedQuery strQuery = objEntity.createQuery(sql,Transaction.class);
            strQuery.setParameter("accountNo", strAccountNumber);
            List objList = strQuery.getResultList();
           
            for(int i= 0; i<objList.size();i++){
                Transaction objTransaction = new Transaction();
                objTransaction = (Transaction) objList.get(i);
                SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
                String strFormate = sdf2.format(objTransaction.getDateOfTranscation());
                System.out.println("strFormate "+strFormate);
                objTransaction.setStrFormatedDate(strFormate);
                objArrTransaction.add(objTransaction);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }finally{
            objEntity.close();
        }
        
        return objArrTransaction;
    }
    //private static ArrayList<Transaction> objArrListTranscation = new ArrayList<Transaction>();
    //This method is used to get trasaction details from ACCOUNT_TRANSACTION table based on account number
    /* public static ArrayList<Transaction> findTransactionDetails(String strAccountNumber) {
        ArrayList<Transaction> objArrTransaction = new ArrayList<Transaction>();
        try{
           
            Connection connection= BankingDBConnect.getConnection();
            Statement statement = connection.createStatement();
            String sql = "Select Transaction_ID,Date_Of_Transcation,Account_Number,Trasaction_Amount,Description,Balance_Amount" 
                    + " from ACCOUNT_TRANSACTION  where Account_Number = '"+strAccountNumber+"'";
            System.out.println("sql :"+sql);
            ResultSet rs = statement.executeQuery(sql);
          
            while(rs.next()){
                Transaction objTransaction = new Transaction();
                objTransaction.setTransactionID(Integer.parseInt(rs.getString(1)));
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                 System.out.println("RS Date "+rs.getString(2));
                Date mydate = sdf.parse(rs.getString(2));
                System.out.println("Date "+mydate);
                
                SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
                String strFormate = sdf2.format(mydate);
                System.out.println("strFormate "+strFormate);
                objTransaction.setStrFormatedDate(strFormate);
                objTransaction.setDateOfTranscation(mydate);
                objTransaction.setStrAccountNumber(rs.getString(3));
                objTransaction.setTrasactionAmount(Double.valueOf(rs.getString(4)));
                objTransaction.setStrDescription(rs.getString(5));
                objTransaction.setBalanceAmount(Double.valueOf(rs.getString(6)));
                objArrTransaction.add(objTransaction);
            }
        }catch(Exception e){}
        
        return objArrTransaction;
    }*/
    /*public static void init(){
            //Addeing strMethodName to trace error in future.
        String strMethodName =" Entereed method AccountTransactionDBA.init()";
        try{
            //Adding transactions 
            //1
            Transaction objTransaction = new Transaction();
            SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
            String dateInString = "07-08-2019 10:20:56";
            Date mydate = sdf.parse(dateInString);
            objTransaction.setDateOfTranscation(mydate);
            objTransaction.setStrAccountNumber("AA111922236561");
            objTransaction.setTransactionID(201);
            objTransaction.setTrasactionAmount(120);
            objTransaction.setBlisCredited(false);
            objTransaction.setStrDescription("Amount debited successfully");
            add(objTransaction);
            //2
            Transaction objTransaction2 = new Transaction();
            SimpleDateFormat sdf2 = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
            String dateInString2 = "13-08-2019 12:20:56";
            Date mydate2 = sdf2.parse(dateInString2);
            objTransaction2.setDateOfTranscation(mydate2);
            objTransaction2.setStrAccountNumber("AA111922236561");
            objTransaction2.setTransactionID(301);
            objTransaction2.setTrasactionAmount(102.97);
            objTransaction2.setBlisCredited(true);
            objTransaction2.setStrDescription("Amount Credited Successfully!!");
            add(objTransaction2);
            //3
            Transaction objTransaction3 = new Transaction();
            SimpleDateFormat sdf3 = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
            String dateInString3 = "14-08-2019 11:20:56";
            Date mydate3 = sdf3.parse(dateInString3);
            objTransaction3.setDateOfTranscation(mydate3);
            objTransaction3.setStrAccountNumber("AA111922236561");
            objTransaction3.setTransactionID(401);
            objTransaction3.setTrasactionAmount(20.26);
            objTransaction3.setBlisCredited(false);
            objTransaction3.setStrDescription("Amount debited successfully");
            add(objTransaction3);
            //4
            Transaction objTransaction4 = new Transaction();
            SimpleDateFormat sdf4 = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
            String dateInString4 = "03-05-2019 09:30:16";
            Date mydate4 = sdf4.parse(dateInString4);
            objTransaction4.setDateOfTranscation(mydate4);
            objTransaction4.setStrAccountNumber("AA222922236561");
            objTransaction4.setTransactionID(109);
            objTransaction4.setTrasactionAmount(27.32);
            objTransaction4.setBlisCredited(false);
            objTransaction4.setStrDescription("Amount debited successfully");
            add(objTransaction4);
            //5
            Transaction objTransaction5 = new Transaction();
            SimpleDateFormat sdf5 = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
            String dateInString5 = "11-05-2019 08:10:36";
            Date mydate5 = sdf5.parse(dateInString5);
            objTransaction5.setDateOfTranscation(mydate5);
            objTransaction5.setStrAccountNumber("AA222922236561");
            objTransaction5.setTransactionID(156);
            objTransaction5.setTrasactionAmount(50.23);
            objTransaction5.setBlisCredited(false);
            objTransaction5.setStrDescription("Amount debited successfully");
            add(objTransaction5);
            //6
            Transaction objTransaction6 = new Transaction();
            SimpleDateFormat sdf6 = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
            String dateInString6 = "30-05-2019 07:30:56";
            Date mydate6 = sdf6.parse(dateInString6);
            objTransaction6.setDateOfTranscation(mydate6);
            objTransaction6.setStrAccountNumber("AA222922236561");
            objTransaction6.setTransactionID(189);
            objTransaction6.setTrasactionAmount(287.72);
            objTransaction6.setBlisCredited(true);
            objTransaction6.setStrDescription("Amount Credited Successfully!!");
            add(objTransaction6);
            //7
            Transaction objTransaction7 = new Transaction();
            SimpleDateFormat sdf7 = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
            String dateInString7 = "14-01-2020 07:30:56";
            Date mydate7 = sdf7.parse(dateInString7);
            objTransaction7.setDateOfTranscation(mydate7);
            objTransaction7.setStrAccountNumber("LA333922236561");
            objTransaction7.setTransactionID(789);
            objTransaction7.setTrasactionAmount(87.72);
            objTransaction7.setBlisCredited(false);
            objTransaction7.setStrDescription("Amount debited successfully!!");
            add(objTransaction7);
            //8
             Transaction objTransaction8 = new Transaction();
            SimpleDateFormat sdf8 = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
            String dateInString8 = "20-01-2020 07:30:56";
            Date mydate8 = sdf8.parse(dateInString8);
            objTransaction8.setDateOfTranscation(mydate8);
            objTransaction8.setStrAccountNumber("LA333922236561");
            objTransaction8.setTransactionID(889);
            objTransaction8.setTrasactionAmount(15);
            objTransaction8.setBlisCredited(false);
            objTransaction8.setStrDescription("Amount debited successfully!!");
            add(objTransaction8);
            //9
            Transaction objTransaction9 = new Transaction();
            SimpleDateFormat sdf9 = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
            String dateInString9 = "21-01-2020 07:30:56";
            Date mydate9 = sdf9.parse(dateInString9);
            objTransaction9.setDateOfTranscation(mydate9);
            objTransaction9.setStrAccountNumber("LA333922236561");
            objTransaction9.setTransactionID(789);
            objTransaction9.setTrasactionAmount(187.72);
            objTransaction9.setBlisCredited(true);
            objTransaction9.setStrDescription("Amount credited successfully!!");
            add(objTransaction9);
            //10
            Transaction objTransaction10 = new Transaction();
            SimpleDateFormat sdf10 = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
            String dateInString10 = "14-02-2020 07:30:56";
            Date mydate10 = sdf10.parse(dateInString10);
            objTransaction10.setDateOfTranscation(mydate10);
            objTransaction10.setStrAccountNumber("LA111922236561");
            objTransaction10.setTransactionID(1089);
            objTransaction10.setTrasactionAmount(287.72);
            objTransaction10.setBlisCredited(true);
            objTransaction10.setStrDescription("Amount credited successfully!!");
            add(objTransaction10);
            //11
            Transaction objTransaction11 = new Transaction();
            SimpleDateFormat sdf11 = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
            String dateInString11 = "21-02-2020 07:30:56";
            Date mydate11 = sdf11.parse(dateInString11);
            objTransaction11.setDateOfTranscation(mydate11);
            objTransaction11.setStrAccountNumber("LA111922236561");
            objTransaction11.setTransactionID(1289);
            objTransaction11.setTrasactionAmount(87.72);
            objTransaction11.setBlisCredited(false);
            objTransaction11.setStrDescription("Amount debited successfully");
            add(objTransaction11);
            //12
            Transaction objTransaction12 = new Transaction();
            SimpleDateFormat sdf12 = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
            String dateInString12 = "14-02-2020 07:30:56";
            Date mydate12 = sdf12.parse(dateInString12);
            objTransaction12.setDateOfTranscation(mydate12);
            objTransaction12.setStrAccountNumber("LA111922236561");
            objTransaction12.setTransactionID(1389);
            objTransaction12.setTrasactionAmount(28.20);
            objTransaction12.setBlisCredited(false);
            objTransaction12.setStrDescription("Amount debited successfully!!");
            add(objTransaction12);
            
        }catch(Exception e){
            System.out.println(strMethodName);
            System.out.println(e.getMessage());
        }

        
    }
    public static ArrayList<Transaction> getTransaction(){
        
        return objArrListTranscation;
        
    }
    public static void add(Transaction objTranscation){
        objArrListTranscation.add(objTranscation);
    }

    public static ArrayList<Transaction> findTransactionDetails(String strAccountNumber) {
        ArrayList<Transaction> objTransaction = new ArrayList<Transaction>();
        if(null != arrListTranscation && arrListTranscation.size()>0){
            int iSize = arrListTranscation.size();
            for(int iCount = 0 ; iCount<iSize ; iCount++){
                if(strAccountNumber.equalsIgnoreCase(arrListTranscation.get(iCount).getStrAccountNumber())){
                    objTransaction.add(arrListTranscation.get(iCount));
                }
            }
        }
        return objTransaction;
    }*/
    
    
}
