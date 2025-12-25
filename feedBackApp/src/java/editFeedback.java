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
@WebServlet(urlPatterns = {"/editFeedback"})
public class editFeedback extends HttpServlet {

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
            out.println("<title>Edit Feedback</title>");
            out.println("</head>");
            out.println("<body>");

            int key = 0;
            String fbType = "";
            String fbDesc = "";
            String name = "";
            String email = "";

            try {
                Connection con = DatabaseConnection.initializeDatabase();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("Select id,type,feedback,name,email from feedback where id=" + request.getParameter("key"));

                if (rs.isBeforeFirst()) {
                    while (rs.next()) {
                        key = rs.getInt(1);
                        fbType = rs.getString(2);
                        fbDesc = rs.getString(3);
                        name = rs.getString(4);
                        email = rs.getString(5);
                    }

                    out.println("<form id='form' method='post' action='./updateFeedBack'>"
                            + "<h3 align='center' size='30' >Edit Feedback</h3>"
                            + "<h3>Feedback Type</h3><br>"
                            + "<input style='display:none' type='text' id='id' name='id' value='" + key + "' readonly>"
                            + "<input type='text' id='v' name='type' value='" + fbType + "' required>"
                            + "<br>"
                            + "<label for='feedback'><h4>Feedback:</h4></label>"
                            + "<br>"
                            + "<textarea class='txt' id='feedback' name='feedback' rows='10' cols='60' required>"
                            + fbDesc
                            + "</textarea>"
                            + "<div class='class1'>"
                            + "<label for='name'><h4>Name:</h4></label>"
                            + "<input type='text' id='name' name='name' value='" + name + "' required>"
                            + "<label for='email'><h4>Your Email Address:</h4></label>"
                            + "<input type='text' id='email' name='email' value='" + email + "' required>"
                            + "<button type='submit' id='submit'>UPDATE</button>"
                            + "<br/><br/>"
                            + "<button onclick=\"location.href='./deleteFeedback?key=" + key + "&del=false'\" type=\"button\">\n"
                            + "         Delete</button>"
                            + "</pre>"
                            + "</div>"
                            + "</form> ");
                } else {
                    out.println("<h3>-No data found-</h3>");
                }

                rs.close();
                stmt.close();
                con.close();

            } catch (Exception e) {
                System.out.println("Error 5 :" + e.getMessage());
            }
            out.println("<br/><a href='./seeFeedback'>See all feedbacks</a>");
            out.println("<br/><br/><a href='index.html'>New Feedback</a>");
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
