/*
 * Created by Chandana
 * this files handles all the operations related to User role table
 */
package DataAccessLayer;


import BankingDomain.Account;
import BankingDomain.UserRole;
import BankingExceptions.RecordsNotFoundException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

/**
 *
 * @author gorilla
 */
public class UserRoleDB {
    // this method is used to fetch UserRole values
    public static boolean fetchUserRole(UserRole objUserRole) throws RecordsNotFoundException{
       boolean userRoleexists = false;
       EntityManager objEntity = BankingDBConnect.getEntityManager().createEntityManager();
       try{
           
               String sql = "Select a " 
                    + "from UserRole a where a.userRole = :u ";
            
                 TypedQuery<UserRole> strQuery  = objEntity.createQuery(sql,UserRole.class);
            strQuery.setParameter("u", objUserRole.getUserRole());
            
            UserRole objRole = strQuery.getSingleResult();
            
            if(null!=objRole){
                userRoleexists = true;
            }else{
                 throw new RecordsNotFoundException("UserRole does not exist");
            }
       }catch(RecordsNotFoundException e){
            throw new RecordsNotFoundException("UserRole does not exist");
       }finally{
           objEntity.close();
       }
        return userRoleexists;
   }
    //This method is used to Update UserRole
   public static String UpdateUserRole(UserRole objUserRole) throws RecordsNotFoundException{
       EntityManager objEntity = BankingDBConnect.getEntityManager().createEntityManager();
       EntityTransaction objEntityTran = objEntity.getTransaction();
       String strMessage = "";
       boolean userRoleExists = false;
       
       try{
          
           userRoleExists = fetchUserRole(objUserRole);
            
           if(userRoleExists){
               System.out.println("Entity " +objEntity);
            String sql = "Update  UserRole SET accAccess = :account ,userAccess =:user , access_userRole =:role" 
                    + " where userRole = :userRole";


            System.out.println("SQl Customer DA " +sql);
            try{
            TypedQuery<UserRole> query = objEntity.createQuery(sql,UserRole.class);
                    query.setParameter("userRole", objUserRole.getUserRole());
                    query.setParameter("account", objUserRole.getAccAccess());
                    query.setParameter("user", objUserRole.getUserAccess());
                    query.setParameter("role", objUserRole.getAccess_userRole());
                    objEntityTran.begin();
             int executed = query.executeUpdate();
             objEntityTran.commit();
             strMessage ="Updated "+ objUserRole.getUserRole(); 
           }catch(Exception e){
           objEntityTran.rollback();
           System.out.println(e.getMessage());
           }
           }
           else{
               UserRoleDB.insertUserRole(objUserRole);
               strMessage ="Inserted "+ objUserRole.getUserRole(); 
           }
           
          
       }catch(Exception e){
           throw new RecordsNotFoundException("UserRole does not exist");
           
       }finally{
           objEntity.close();
       }
        return strMessage;
   }
   //This method is used to insert user role
    public static String insertUserRole(UserRole objUserRole){
        String  strMessage = null;
       EntityManager objEntity = BankingDBConnect.getEntityManager().createEntityManager();
       EntityTransaction objEntityTran = objEntity.getTransaction();
       try{
          objEntityTran.begin();
            objEntity.persist(objUserRole);
            objEntityTran.commit();
             strMessage ="Inserted "+ objUserRole.getUserRole(); 
       }catch(Exception e){
           objEntityTran.rollback();
           System.out.println(e.getMessage());
       }finally{
           objEntity.close();
       }
        return strMessage;
   }
}
