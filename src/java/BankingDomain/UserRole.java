/*
 * Created by Chandana on 5/4/2020
* User role entity with setter and  getters
 */
package BankingDomain;


import BankingExceptions.LoginException;
import DataAccessLayer.CustomerDBA;
import DataAccessLayer.UserRoleDB;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="USER_ROLE")
public class UserRole {
    @Id
    @Column(name="USER_ROLE")
    private String userRole ;
    @Column(name="Accounts_Access")
    private char accAccess ;
    @Column(name="User_Access")
    private char userAccess ;
      @Column(name="UserRole_Access")
    private char access_userRole ;
      
    public UserRole(String userRole,char accAccess,char userAccess , char accessRole ){
        this.userRole=userRole;
        this.accAccess = accAccess;
        this.userAccess = userAccess;
        this.access_userRole = accessRole;
    }
    public UserRole(){
        
    }
    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public char getAccAccess() {
        return accAccess;
    }

    public void setAccAccess(char accAccess) {
        this.accAccess = accAccess;
    }

    public char getUserAccess() {
        return userAccess;
    }

    public void setUserAccess(char userAccess) {
        this.userAccess = userAccess;
    }

    public char getAccess_userRole() {
        return access_userRole;
    }

    public void setAccess_userRole(char access_userRole) {
        this.access_userRole = access_userRole;
    }
    @Override
    public String toString() {
        String strCustomizeToString = null;
        strCustomizeToString = "User Role: "+ userRole + "\n"+
                                "Access User "+ userAccess +"\n"+
                                "Access User role: "+ access_userRole +"\n"+
                                "Access Accounts: "+ accAccess +"\n";
        
        return strCustomizeToString;
    }
      
  
    public static String  updateUserRole(UserRole objUserRole){
        return UserRoleDB.UpdateUserRole(objUserRole);
    }
}
