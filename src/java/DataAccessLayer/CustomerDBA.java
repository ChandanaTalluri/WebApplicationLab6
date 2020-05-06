/*
 * This file fetches customer details from database
*4/7/2020 Commented code as DB connection is made
*4/17/2020 Commented code as persistent layer is implemented
 */
package DataAccessLayer;

import BankingDomain.Customer;
import BankingExceptions.LoginException;
import BankingExceptions.RecordsNotFoundException;

//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.Statement;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;


/**
 *
 * @author Chandana
 */
public class CustomerDBA {
    //Modified method using typed query to fetch results from DB
    public static Customer findCustomerByID(String userID) throws RecordsNotFoundException{
        Customer objCustomer = new Customer();
        EntityManager objEntity = BankingDBConnect.getEntityManager().createEntityManager();
        try{
             //this method is used to find user id
           
            System.out.println("Entity " +objEntity);
            String sql = "Select  c " 
                    + "from Customer c where c.userID = :u";


            System.out.println("SQl Customer DA " +sql);
            TypedQuery<Customer> query = objEntity.createQuery(sql,Customer.class);
                    query.setParameter("u", userID);
                    
            objCustomer = query.getSingleResult();
         
             
            System.out.println("Customer DA print"+objCustomer);
        }catch(NoResultException e){
             System.out.println(e.getMessage());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        finally{
            objEntity.close();
        }
        
        return objCustomer;
    }
  
   public static Customer checklogin(String userID, String password) throws LoginException{
        Customer objCustomer = new Customer(); ;
        try{
            
            objCustomer = findCustomerByID(userID);
            if(null== objCustomer.getUserID()){
                 throw new LoginException("User ID and password is incorrect"+" \n"+" Please try again!!");   
            }
            else if(!password.equals(objCustomer.getStrPassword())){
                     throw new LoginException("Password incorrect"+" \n"+" Please try again!!");
            }
          
            return objCustomer;
        }catch(Exception e){
              throw new LoginException(e.getMessage());
        }
        
    }
    public static Customer checkUserID(String userID) throws LoginException{
     
        Customer objCustomer = new Customer();
        try{
            
            objCustomer = findCustomerByID(userID);
           
            if(null== objCustomer.getUserID()){
                objCustomer.setBlUserIDExits(false);
            }
            else{
                objCustomer.setBlUserIDExits(true);
                throw new LoginException("User ID already exists" +"\n"+" Please try with other User ID !!");
            }

        }catch(Exception e){
            throw new LoginException(e.getMessage());
        }  
        return objCustomer;
    }
   //this method is used to insert customer into DB
   public static void insertCustomer(Customer objnewCustomer){
       EntityManager objEntity = BankingDBConnect.getEntityManager().createEntityManager();
       EntityTransaction objEntityTran = objEntity.getTransaction();
       try{
          objEntityTran.begin();
           int custID = getCustID()+1;
           objnewCustomer.setCustID(custID);
            objEntity.persist(objnewCustomer);
            objEntityTran.commit();
            
       }catch(Exception e){
           objEntityTran.rollback();
           System.out.println(e.getMessage());
       }finally{
           objEntity.close();
       }
   }
   //this method is used to get highest customer id
   public static int getCustID(){
        int custID = 0;
        //Customer objCustomer = new Customer();
        EntityManager objEntity = BankingDBConnect.getEntityManager().createEntityManager();
        try{
            String sql = "select max(c.custID) from Customer c";
            TypedQuery strQuery = objEntity.createQuery(sql,Customer.class);
            int count = (int) strQuery.getSingleResult();
            custID = count;
       }catch(Exception e){
           System.out.println(e.getMessage());
       }finally{
            objEntity.close();
        }
        return custID;
   }
   public static Customer UpdateCustomer(Customer objnewCustomer) throws LoginException{
       EntityManager objEntity = BankingDBConnect.getEntityManager().createEntityManager();
       EntityTransaction objEntityTran = objEntity.getTransaction();
       try{
           Customer objCustomer = checkUserIDandCustID(objnewCustomer.getUserID(),objnewCustomer.getCustID());
           if(!objCustomer.isBlUserIDExits()){
                 try{
           System.out.println("Entity " +objEntity);
            String sql = "Update  Customer SET userID =:user, strFirstName = :firstName,"
                    + " strLastName=:lastName, strPhoneNumber= :phone , emialID = :email ,strUserRole =:role " 
                    + " where custID = :u";


            System.out.println("SQl Customer DA " +sql);
            TypedQuery<Customer> query = objEntity.createQuery(sql,Customer.class);
            query.setParameter("u", objnewCustomer.getCustID());
            query.setParameter("user", objnewCustomer.getUserID());
            query.setParameter("firstName", objnewCustomer.getStrFirstName());
            query.setParameter("lastName", objnewCustomer.getStrLastName());
            query.setParameter("phone", objnewCustomer.getStrPhoneNumber());
            query.setParameter("email", objnewCustomer.getEmialID());
            query.setParameter("role", objnewCustomer.getStrUserRole());
            
            objEntityTran.begin();
             int executed = query.executeUpdate();
            objEntityTran.commit();
           }catch(Exception e){
           
           System.out.println(e.getMessage());
           objEntityTran.rollback();
            }
           }
           else{
               throw new LoginException("User ID already exists" +"\n"+" Please try with other User ID !!");
           }
       }catch(Exception login){
            throw new LoginException(login.getMessage());
       
       }finally{
           objEntity.close();
       }
       return objnewCustomer;
   }
   public static Customer checkUserIDandCustID(String userID,int custID) throws LoginException{
     
        Customer objCustomer = new Customer();
        try{
            
            objCustomer = findCustomerByID(userID);
           
            if(null!= objCustomer && objCustomer.getCustID()== custID ){
                objCustomer.setBlUserIDExits(false);
            }
            else{
                objCustomer.setBlUserIDExits(true);
                throw new LoginException("User ID already exists" +"\n"+" Please try to upadte with other User ID !!");
            }

        }catch(Exception e){
            throw new LoginException(e.getMessage());
        }  
        return objCustomer;
    }
    /*public static Customer findCustomerByID(String userID){
        Customer objCustomer = new Customer();;
        Connection connection;
        Statement statement;
        try{
             //this method is used to find user id
        connection= BankingDBConnect.getConnection();
            statement = connection.createStatement();
            ResultSet rs;
            
            String sql = "Select USER_ID,FIRST_NAME,LAST_NAME,PHONENUMBER,EMAIL_ID,CUSTOMER_ID " 
                    + "from Customer where USER_ID = '"+userID+"'";
            
            /rs = statement.executeQuery(sql);
            while (rs.next()) {
                
                objCustomer.setUserID(rs.getString(1));
                objCustomer.setStrFirstName(rs.getString(2));
                objCustomer.setStrLastName(rs.getString(3));
                objCustomer.setStrPhoneNumber(rs.getString(4));
                objCustomer.setEmialID(rs.getString(5));
                String strCustID = rs.getString(6);
                int custID = Integer.parseInt(strCustID);
                objCustomer.setCustID(custID);
            }
          
        }catch(Exception e){
            
        }
//        Customer objCustomer = new Customer();
//        if(null != arrObjCustomer && arrObjCustomer.size()>0){
//            int iSize = arrObjCustomer.size();
//            for(int iCount = 0 ; iCount<iSize ; iCount++){
//                if(userID.equals(arrObjCustomer.get(iCount).getUserID())){
//                    objCustomer.setUserID(arrObjCustomer.get(iCount).getUserID());
//                    objCustomer.setStrFirstName(arrObjCustomer.get(iCount).getStrFirstName());
//                    objCustomer.setStrPhoneNumber(arrObjCustomer.get(iCount).getStrPhoneNumber());
//                    objCustomer.setStrLastName(arrObjCustomer.get(iCount).getStrLastName());
//                    objCustomer.setEmialID(arrObjCustomer.get(iCount).getEmialID());
//                     break;
//                    }
//            }
//        }
        return objCustomer;
    }*/
    /*public static Customer checkUserID(String userID) throws LoginException{
        Connection connection;
        Statement statement;
        Customer objCustomer = new Customer();
        try{
            connection= BankingDBConnect.getConnection();           
            statement = connection.createStatement();
            ResultSet rs;
            
            String sql = "Select USER_ID from Customer where USER_ID = '"+userID+"'";
            
            rs = statement.executeQuery(sql); 
           
            if (rs.next()) {
                objCustomer.setBlUserIDExits(true);
                throw new LoginException("User ID already exists" +"\n"+" Please try with other User ID !!");
            }
            
//        if(null != arrObjCustomer && arrObjCustomer.size()>0){
//            int iSize = arrObjCustomer.size();
//            for(int iCount = 0 ; iCount<iSize ; iCount++){
//                if(userID.equals(arrObjCustomer.get(iCount).getUserID())){
//                    objCustomer.setBlUserIDExits(true);
//                    throw new LoginException("User ID already exists" +"\n"+" Please try with other User ID !!");
//                    }      
//            }
//        }
        }catch(Exception e){
            throw new LoginException(e.getMessage());
        }  
        return objCustomer;
    }*/
   
    //Changed login methos uding DB
   /* public static Customer checklogin(String userID, String password) throws LoginException{
        Customer objCustomer = null ;
        try{
            Connection connection = BankingDBConnect.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs;
            
            String sql = "Select USER_ID,FIRST_NAME,LAST_NAME,PHONENUMBER,EMAIL_ID,PASSWORD,CUSTOMER_ID " 
                    + "from Customer where USER_ID = '"+userID+"'";
            
            rs = statement.executeQuery(sql);
            
            objCustomer = new Customer();
           
            while (rs.next()) {
                
                objCustomer.setUserID(rs.getString(1));
                objCustomer.setStrFirstName(rs.getString(2));
                objCustomer.setStrLastName(rs.getString(3));
                objCustomer.setStrPhoneNumber(rs.getString(4));
                objCustomer.setEmialID(rs.getString(5));
                if(!password.equals(rs.getString(6))){
                     throw new LoginException("Password incorrect"+" \n"+" Please try again!!");
                }
                objCustomer.setCustID(Integer.parseInt(rs.getString(7)));
                String strCustID = rs.getString(7);
                int custID = Integer.parseInt(strCustID);
                objCustomer.setCustID(custID);
            }
            rs = statement.executeQuery(sql);
            if(!rs.next()){
                 throw new LoginException("User ID and password is incorrect"+" \n"+" Please try again!!");   
            }
            return objCustomer;
        }catch(Exception e){
              throw new LoginException(e.getMessage());
        }
        
    }*/
    //this method is used to insert customer into DB
   /*public static void insertCustomer(Customer objnewCustomer){
       try{
           Connection connection = BankingDBConnect.getConnection();
            Statement statement = connection.createStatement();
           int custID = getCustID()+1;
            String sql = "INSERT INTO CUSTOMER"
                    + " (USER_ID,FIRST_NAME,LAST_NAME,PHONENUMBER,EMAIL_ID,PASSWORD,CUSTOMER_ID) \n" 
                    +"VALUES\n" 
                    +"('"+ objnewCustomer.getUserID()+"','"+objnewCustomer.getStrFirstName()+"','"
                    + objnewCustomer.getStrLastName() +"','"+objnewCustomer.getStrPhoneNumber()+"','"
                    +objnewCustomer.getEmialID()+"','"+objnewCustomer.getStrPassword()+"','"+ custID+"')";
            int result = statement.executeUpdate(sql);
       }catch(Exception e){
           System.out.println(e.getMessage());
       }
   }
   //this method is used to get highest customer id
   public static int getCustID(){
        int custID = 0;
        try{
           Connection connection = BankingDBConnect.getConnection();
            Statement statement = connection.createStatement();
          
            String sql = "select max(customer_id) from customer";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
              custID = Integer.parseInt(rs.getString(1));
            }
       }catch(Exception e){
           System.out.println(e.getMessage());
       }
        return custID;
   }
   */
    /* private static ArrayList<Customer> objArrListCustomer = new ArrayList<Customer>();
    public static void init(){
       Customer objCustomer = new Customer();
        objCustomer.setUserID("Cust1");
        objCustomer.setStrFirstName("Customer");
        objCustomer.setStrLastName("ONE");
        objCustomer.setEmialID("one@cust");
        objCustomer.setStrPhoneNumber("1116358945");
        objCustomer.setStrPassword("cust1");
        objCustomer.setCustID(1);
        add(objCustomer);
        Customer objCustomer1 = new Customer();
        objCustomer1.setUserID("Cust2");
        objCustomer1.setStrFirstName("Customer");
        objCustomer1.setStrLastName("TWO");
        objCustomer1.setEmialID("two@cust");
        objCustomer1.setStrPhoneNumber("2226358945");
        objCustomer1.setStrPassword("cust2");
        objCustomer1.setCustID(2);
        add(objCustomer1);
        Customer objCustomer2 = new Customer();
        objCustomer2.setUserID("Cust3");
        objCustomer2.setStrFirstName("Customer");
        objCustomer2.setStrLastName("Three");
        objCustomer2.setEmialID("three@cust");
        objCustomer2.setStrPhoneNumber("3336358945");
        objCustomer2.setStrPassword("cust3");
        objCustomer2.setCustID(3);
        add(objCustomer2);
        
    }
    public static ArrayList<Customer> getCustomers(){
        
        return objArrListCustomer;
        
    }
    public static void add(Customer c){
        //everytime a new customer is added increments customer id by one
        int custID = c.getCustID();
        if(custID==1){
            c.setCustID(1 +objArrListCustomer.size());
        }
        objArrListCustomer.add(c);
    }*/
   /* public static Customer checklogin(String userID, String strPassword) throws LoginException {
        //this method check if user id and password is correct or not if not will return error message
        Customer objCustomer = new Customer();
        Customer objDBCust = checkloginDB(userID, strPassword);
        ArrayList<Customer> arrObjCustomer = Customer.getCustomers();
        try{
             if(null != arrObjCustomer && arrObjCustomer.size()>0){
            int iSize = arrObjCustomer.size();
            for(int iCount = 0 ; iCount<iSize ; iCount++){
                if(userID.equals(arrObjCustomer.get(iCount).getUserID())
                        && strPassword.equals(arrObjCustomer.get(iCount).getStrPassword())
                        ){
                    objCustomer.setUserID(arrObjCustomer.get(iCount).getUserID());
                    objCustomer.setStrFirstName(arrObjCustomer.get(iCount).getStrFirstName());
                    objCustomer.setStrPhoneNumber(arrObjCustomer.get(iCount).getStrPhoneNumber());
                    objCustomer.setStrLastName(arrObjCustomer.get(iCount).getStrLastName());
                    return objCustomer;
                    }
            }
            for(int jCount = 0 ; jCount<iSize ; jCount++){
                 if(userID.equals(arrObjCustomer.get(jCount).getUserID())
                        && !strPassword.equals(arrObjCustomer.get(jCount).getStrPassword())
                        ){
                    
                    throw new LoginException("Password incorrect"+" \n"+" Please try again!!");
                    
                }
                else if(!userID.equals(arrObjCustomer.get(jCount).getUserID())
                        && !strPassword.equals(arrObjCustomer.get(jCount).getStrPassword())
                        ){
                    
                    throw new LoginException("User ID and password is incorrect"+" \n"+" Please try again!!");
                }
            }
        }
          return objCustomer;    
        }catch(Exception e){
            throw new LoginException(e.getMessage());
        }
    }*/
}

    

