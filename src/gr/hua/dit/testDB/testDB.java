package gr.hua.dit.testDB;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/**
* Servlet implementation class TestDbServlet
*/
	
	@WebServlet("/TestDbServlet")
	public class testDB extends HttpServlet {
	        private static final long serialVersionUID = 1L;

	        /**
	         * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	         */
	        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	                // setup connection variables
	                String jdbcUrl = "";
	                String user = "";
	                String pass = "";
	                String driver= "com.mysql.jdbc.Driver";
	                
	                // get connection to DB
	                try {
	                        PrintWriter out = response.getWriter();
	                        out.println("Connecting to db: " + jdbcUrl);
	                        
	                        Class.forName(driver);
	                        Connection con = DriverManager.getConnection(jdbcUrl,user,pass);
	                        out.println("Connection Success!");
	                        con.close();
	                }
	                catch (Exception e) {
	                        e.printStackTrace();
	                        throw new ServletException(e);
	                }
	                
	        }

}

