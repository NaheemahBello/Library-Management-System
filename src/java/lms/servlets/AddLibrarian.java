package lms.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.javatpoint.beans.LibrarianBean;
import lms.dao.LibrarianDao;
@WebServlet("/AddLibrarian")
public class AddLibrarian extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
            try (PrintWriter out = response.getWriter()) {
                out.print("<!DOCTYPE html>");
                out.print("<html>");
                out.println("<head>");
                out.println("<title>Add Librarian</title>");
                out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
                out.println("</head>");
                out.println("<body>");
                
                request.getRequestDispatcher("navadmin.html").include(request, response);
                out.println("<div class='container'>");
                
                String name=request.getParameter("name");
                String email=request.getParameter("email");
                String password=request.getParameter("password");
                String smobile=request.getParameter("mobile");
                long mobile=Long.parseLong(smobile);
                LibrarianBean bean=new LibrarianBean(name, email, password, mobile);
                LibrarianDao.save(bean);
                out.print("<h4>Librarian added successfully</h4>");
                request.getRequestDispatcher("addlibrarianform.html").include(request, response);
                
                
                out.println("</div>");
                request.getRequestDispatcher("footer.html").include(request, response);
            }
	}

}
