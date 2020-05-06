/*
 * This file has the database connection details
 */
package DataAccessLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Chandana
 */
public class BankingDBConnect {
    private static Connection connection=null;
    private BankingDBConnect(){}
    public static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("WebAppLab5");
    
    public static EntityManagerFactory getEntityManager(){
        return emf;
    }
    /*public static Connection getConnection(){
		if (connection == null) {
			try{
			connection = (Connection)DriverManager.getConnection("jdbc:derby://localhost:1527/BankingSystemDB","CIS640","cis640");
			}
    
			catch(Exception e){
				System.out.println(e.getMessage());
			}

            
		}
		
		return connection;
	}
    */
}
