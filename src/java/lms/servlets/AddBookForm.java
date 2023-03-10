package lms.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//import com.javatpoint.beans.LibrarianBean;
//import com.javatpoint.dao.LibrarianDao;
@WebServlet("/AddBookForm")
public class AddBookForm extends HttpServlet {
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
            try (PrintWriter out = response.getWriter()) {
                out.print("<!DOCTYPE html>");
                out.print("<html>");
                out.println("<head>");
                out.println("<title>Add Book Form</title>");
                out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
                out.println("</head>");
                out.println("<body>");
                request.getRequestDispatcher("navlibrarian.html").include(request, response);
                
                out.println("<div class='container'>");
                request.getRequestDispatcher("addbookform.html").include(request, response);
                out.println("</div>");
                
                
                request.getRequestDispatcher("footer.html").include(request, response);
            }
	}

}
