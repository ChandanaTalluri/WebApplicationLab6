/*
 * Created by Chandana Talluri
* this file handles login operations
 */
package servlet;

import BankingDomain.Account;
import BankingDomain.AssetAccount;
import BankingDomain.Customer;
import BankingDomain.LiabilityAccount;
import BankingDomain.UserRole;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class AppLoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            Customer objCustomer = new Customer();
            String url = "/login.html";
            HttpSession session = request.getSession();
               
           try{
             
               String userID = request.getParameter("userID");
               String password = request.getParameter("strPassword");
               System.out.println("userID in servelet"+userID);
              session.setAttribute("message", "");
              session.setAttribute("userID", userID);
                //to avoid printing error message from last session
                session.setAttribute("asset", "");
                session.setAttribute("assetTitle", "");
                session.setAttribute("LiabilityTitle", "");
                   session.setAttribute("liability", "");
                
             objCustomer = Customer.loginCustomer(userID, password);
               
               session.setAttribute("customer", objCustomer);

               ArrayList<AssetAccount> arrAAResult = new ArrayList<AssetAccount>();
               
                HashMap objHmp = Account.findAccountDetails(userID);
                arrAAResult = (ArrayList<AssetAccount>) objHmp.get("A");
               if(null != arrAAResult && arrAAResult.size()>0){
                   
                   session.setAttribute("assetTitle", "Asset Account Details");
                   session.setAttribute("asset", arrAAResult);
               }

               ArrayList<LiabilityAccount> arrLiabilityResult =  new ArrayList<LiabilityAccount>();
               arrLiabilityResult = (ArrayList<LiabilityAccount>) objHmp.get("L");
               if(null != arrLiabilityResult && arrLiabilityResult.size()>0){
                   session.setAttribute("LiabilityTitle", "Liability Account Details");
                   session.setAttribute("liability", arrLiabilityResult);
               }
               
                // set User object in request object and set URL*/
            
            if(objCustomer.getStrUserRole().equalsIgnoreCase("Admin")){
               session.setAttribute("customer", "");
                url = "/adminBank.jsp"; 
            }else if(objCustomer.getStrUserRole().equalsIgnoreCase("Mgt")){
               session.setAttribute("customer", "");
                url = "/mgtjsp.jsp"; 
            }
            else{
                request.setAttribute("message", "Your Accounts");
            url = "/loginSuccess.jsp"; 
            }
            getServletContext()
            .getRequestDispatcher(url)
            .forward(request, response);
           }catch(Exception e){
               url = "/login.jsp"; 
               request.setAttribute("message", e.getMessage());
              // HttpSession session = request.getSession();
               session.setAttribute("message", e.getMessage());
               getServletContext()
            .getRequestDispatcher(url)
            .forward(request, response);
           }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
