/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 *
 */
@WebServlet(urlPatterns = {"/submitFeedback"})
public class submitFeedback extends HttpServlet {

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
        // Initialize the database
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Submit FeedBack</title>");
        out.println("</head>");
        out.println("<body>");
        String err = "";
        try {
            Connection con = DatabaseConnection.initializeDatabase();
            PreparedStatement st = con.prepareStatement("INSERT INTO `web_db`.`feedback` (`type`, `feedback`, `name`, `email`) VALUES (?, ?, ?, ?)");
            st.setString(1, request.getParameter("type"));
            st.setString(2, request.getParameter("feedback"));
            st.setString(3, request.getParameter("name"));
            st.setString(4, request.getParameter("email"));
            st.executeUpdate();

            st.close();
            con.close();
            out.println("<h3>Feedback insert successfully!</h3>");
        } catch (Exception e) {
            System.out.println("Error 2 :" + e.getMessage());
            out.println("<h3>Feedback insert faild!</h3>");
        }
        out.println("<br/><a href='./seeFeedback'>See all feedbacks</a>");
        out.println("<br/><br/><a href='index.html'>New Feedback</a>");
        out.println("</body>");
        out.println("</html>");
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
