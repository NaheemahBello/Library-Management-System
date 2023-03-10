package lms.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.javatpoint.beans.BookBean;
import com.javatpoint.dao.BookDao;
@WebServlet("/AddBook")
public class AddBook extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
                String callno=request.getParameter("callno");
                String name=request.getParameter("name");
                String author=request.getParameter("author");
                String publisher=request.getParameter("publisher");
                String squantity=request.getParameter("quantity");
                int quantity=Integer.parseInt(squantity);
                BookBean bean=new BookBean(callno,name,author,publisher,quantity);
                int i=BookDao.save(bean);
                if(i>0){
                    out.println("<h3>Book saved successfully</h3>");
                }
                request.getRequestDispatcher("addbookform.html").include(request, response);
                out.println("</div>");
                
                
                request.getRequestDispatcher("footer.html").include(request, response);
            }
	}

}