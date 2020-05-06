/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import BankingDomain.Customer;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author gorilla
 */
public class UpdateUserServlet extends HttpServlet {

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
        request.setAttribute("message", "");
        String url = "/index.html"; 
        HttpSession session = request.getSession();
        session.setAttribute("message", ""); 
     try{
        String strUserID = request.getParameter("userID");
        String strFirstName = request.getParameter("strFirstName");
        String strLastName = request.getParameter("strLastName");
        String strEmailID = request.getParameter("emialID");
        String strPassword = request.getParameter("strPassword");
        String strPhoneNumber = request.getParameter("strPhoneNumber");
        String strUserRole = request.getParameter("strUserRole");
        int custID = Integer.parseInt(request.getParameter("custID")) ;

        Customer objCustomer = new Customer(strUserID, strFirstName, strLastName, strEmailID, strPhoneNumber, strPassword, strUserRole);
        objCustomer.setCustID(custID);
        Customer objNewCustomer = Customer.updateCustomer(objCustomer);
        request.setAttribute("message", "Customer details updated successfully");
     
        request.setAttribute("customer", objNewCustomer);
        
            url = "/updateUser.jsp"; 
           
            getServletContext()
            .getRequestDispatcher(url)
            .forward(request, response);
           }catch(Exception e){
               url ="/login.jsp"; 
               request.setAttribute("message", e.getMessage());
               
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
