/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * 
 */
@WebServlet(urlPatterns = {"/seeFeedback"})
public class seeFeedback extends HttpServlet {

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
        try {
            Connection con = DatabaseConnection.initializeDatabase();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("Select id,type,feedback,name from feedback");

            PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Update FeedBack</title>");
            out.println("</head>");
            out.println("<body>"
                    + "<table>"
                    + "<h2>All Feedbacks</h2>"
            );
            while (rs.next()) {

                out.println("<div style='border:1px solid;padding:5px;margin-bottom: 10px;width:50%'>\n"
                        + "<div style='margin-bottom:-30px;'>\n"
                        + "<h3 style='display: inline-block;padding-right: 10px;'>" + rs.getString(4) + "</h3><h5 style='display: inline-block;'>" + rs.getString(2) + "</h4>\n"
                        + "</div>\n"
                        + "<p style='padding-left:20px;'>" + rs.getString(3) + "</p><a href='./editFeedback?key=" + rs.getString(1) + "'>Edit</a>\n"
                        + "</div>");

            }
            out.println("<br/><a href='index.html'>New Feedback</a>");
            out.println("</table></body></html>");
            rs.close();
            stmt.close();
            con.close();

        } catch (Exception e) {
            System.out.println("Error 4 :" + e.getMessage());
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
