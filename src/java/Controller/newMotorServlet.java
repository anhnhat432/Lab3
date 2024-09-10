/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.MotorDAO;
import DTO.AccountRentMotorDTO;
import Model.Motor;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 *
 * @author datng
 */
public class newMotorServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet newMotorServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet newMotorServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        request.getRequestDispatcher("newMotor.jsp").forward(request, response);
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
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String img = request.getParameter("img");
        MotorDAO m = new MotorDAO();
        boolean check = true;
        double priceDouble=0;
        try {
             priceDouble = Double.parseDouble(price);
            // Nếu không có ngoại lệ xảy ra, có nghĩa là price là một số thực hợp lệ
            check = true;
        } catch (NumberFormatException e) {
            // Nếu ngoại lệ xảy ra, có nghĩa là price không phải là số thực hợp lệ
            check = false;
        }
        if(check){
             m.createAccountRentMotor(new Motor(0, name, priceDouble, img));
        ArrayList<Motor> listMotor = m.getAllMotor();
        request.setAttribute("listMotor", listMotor);
        request.getRequestDispatcher("home.jsp").forward(request, response);
        }
        else{
             request.setAttribute("name", name);
             request.setAttribute("price", price);
             request.setAttribute("img", img);
                request.setAttribute("error", "Giá xe phải là số");
             request.getRequestDispatcher("newMotor.jsp").forward(request, response);
        }
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
