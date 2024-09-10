/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller;

import DAO.AccountRentMotorDAO;
import DAO.MotorDAO;
import Model.Account;
import Model.AccountRentMotor;
import Model.Motor;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
public class rentServlet extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet rentServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet rentServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
//        processRequest(request, response);
        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("account");
        if (session.getAttribute("account") == null) {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }

        String motorId = request.getParameter("id"); 
        MotorDAO m = new MotorDAO();
        Motor motorGet = m.getMotorById(Integer.parseInt(motorId));
        
        request.setAttribute("motorGet", motorGet);
        request.getRequestDispatcher("rent.jsp").forward(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
//        processRequest(request, response);
        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("account");
        
        String motorId = request.getParameter("motorId"); 
        String name = request.getParameter("name"); 
        String email = request.getParameter("email"); 
        String phone = request.getParameter("phone"); 
        String rentdate = request.getParameter("rentdate"); 
        
        
        
       
        AccountRentMotor accountRentMotor = new AccountRentMotor(0, account.getId(), Integer.parseInt(motorId), name, email, phone, rentdate);
//         request.getRequestDispatcher("homeServlet").forward(request, response);
        AccountRentMotorDAO a = new AccountRentMotorDAO();
        boolean rs = a.createAccountRentMotor(accountRentMotor);
        if(rs){
            request.setAttribute("toastStatus", "Rent successfully.");
            request.getRequestDispatcher("homeServlet").forward(request, response);
        }else{
            MotorDAO m = new MotorDAO();
            Motor motorGet = m.getMotorById(Integer.parseInt(motorId));

            request.setAttribute("motorGet", motorGet);
            request.getRequestDispatcher("rent.jsp").forward(request, response);
        }
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
