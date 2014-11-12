package com.mounesh.service;
//import com.mounesh.service.insertServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;
import java.util.logging.Level;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;

public class loginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
 * 
 */
	public static Connection con;
    public static Statement stmt,stmt1;
    public static ResultSet rs;
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
    	
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        HttpSession hp = request.getSession(false);
        
        String usernae=request.getParameter("user_name");
        String pwd=request.getParameter("password1");
        
        String fn = (String) hp.getAttribute("firstName");	
        
        String chk="False";
            String url = "jdbc:mysql://localhost/test2";
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, "root", "root123");
            stmt = con.createStatement();
            String sql="SELECT * FROM signup where user_name='"+usernae+"' AND password1='"+pwd+"'";
            System.out.println("TABLE VIEW");
            System.out.println(sql);
            rs= stmt.executeQuery(sql);
            while(rs.next())
            {
                chk="True";
            }
            if(chk=="True"){
                out.println("Welcome "+fn);
                //RequestDispatcher rd = request.getRequestDispatcher("homeServlet");
               //rd.forward(request, response); 
                RequestDispatcher rd=request.getRequestDispatcher("/Home.jsp");  
                rd.include(request, response);
                /*if ("include".equalsIgnoreCase(chk)) {
    				rd.include(request, response);
    			} else if ("forward".equalsIgnoreCase(chk)) {
    				rd.forward(request, response);
    			}*/
            }
            else{
            	 out.println("login has not successful");
                RequestDispatcher rd=request.getRequestDispatcher("/Login.jsp"); 
    
                rd.include(request, response);  
            }
             try {
                 /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet login</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet login at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
             */
        } finally {            
            out.close();
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
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(loginServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(loginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    //@Override
    /*protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(loginServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(loginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
