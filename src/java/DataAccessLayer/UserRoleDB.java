/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayer;

import BankingDomain.Customer;
import BankingDomain.UserRole;
import BankingExceptions.RecordsNotFoundException;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

/**
 *
 * @author gorilla
 */
public class UserRoleDB {
    public static UserRole findUserRoles(String userID) throws RecordsNotFoundException{
        UserRole objUserRole = new UserRole();
        EntityManager objEntity = BankingDBConnect.getEntityManager().createEntityManager();
        try{
             //this method is used to find user id
           
            System.out.println("Entity " +objEntity);
            String sql = "Select  c " 
                    + "from UserRole c where c.userRole = :u";
            System.out.println("SQl Customer DA " +sql);
            TypedQuery<UserRole> query = objEntity.createQuery(sql,UserRole.class);
                    query.setParameter("u", userID);
            objUserRole = query.getSingleResult();
         
            System.out.println("objUserRole DA print"+objUserRole);
        }catch(NoResultException e){
             System.out.println(e.getMessage());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        finally{
            objEntity.close();
        }
        
        return objUserRole;
    }
  
  
   public static String UpdateUserRole(UserRole objUserRole){
       EntityManager objEntity = BankingDBConnect.getEntityManager().createEntityManager();
       EntityTransaction objEntityTran = objEntity.getTransaction();
       String strMessage = "";
       try{
           if(objUserRole.getUserRole().equalsIgnoreCase("Admin") || objUserRole.getUserRole().equalsIgnoreCase("User")
                   || objUserRole.getUserRole().equalsIgnoreCase("Mgt")
                   ){
               System.out.println("Entity " +objEntity);
            String sql = "Update  UserRole SET accAccess = :account ,userAccess =:user , access_userRole =:role" 
                    + " where userRole = :userRole";


            System.out.println("SQl Customer DA " +sql);
            TypedQuery<UserRole> query = objEntity.createQuery(sql,UserRole.class);
                    query.setParameter("userRole", objUserRole.getUserRole());
                    query.setParameter("account", objUserRole.getAccAccess());
                    query.setParameter("user", objUserRole.getUserAccess());
                    query.setParameter("role", objUserRole.getAccess_userRole());
                    objEntityTran.begin();
             int executed = query.executeUpdate();
             objEntityTran.commit();
             strMessage ="Updated "+ objUserRole.getUserRole(); 
           }
           else{
               UserRoleDB.insertUserRole(objUserRole);
               strMessage ="Inserted "+ objUserRole.getUserRole(); 
           }
           
            
       }catch(Exception e){
           objEntityTran.rollback();
           System.out.println(e.getMessage());
       }finally{
           objEntity.close();
       }
        return strMessage;
   }
    public static void insertUserRole(UserRole objUserRole){
       EntityManager objEntity = BankingDBConnect.getEntityManager().createEntityManager();
       EntityTransaction objEntityTran = objEntity.getTransaction();
       try{
          objEntityTran.begin();
            objEntity.persist(objUserRole);
            objEntityTran.commit();
            
       }catch(Exception e){
           objEntityTran.rollback();
           System.out.println(e.getMessage());
       }finally{
           objEntity.close();
       }
   }
}
