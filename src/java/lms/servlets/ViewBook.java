package lms.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.javatpoint.beans.BookBean;
//import com.javatpoint.beans.LibrarianBean;
import com.javatpoint.dao.BookDao;
import java.util.List;
//import com.javatpoint.dao.LibrarianDao;
@WebServlet("/ViewBook")
public class ViewBook extends HttpServlet {
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
            try (PrintWriter out = response.getWriter()) {
                out.print("<!DOCTYPE html>");
                out.print("<html>");
                out.println("<head>");
                out.println("<title>View Book</title>");
                out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
                out.println("</head>");
                out.println("<body>");
                request.getRequestDispatcher("navlibrarian.html").include(request, response);
                
                out.println("<div class='container'>");
                
                List<BookBean> list=BookDao.view();
                
                out.println("<table class='table table-bordered table-striped'>");
                out.println("<tr><th>Callno</th><th>Name</th><th>Author</th><th>Publisher</th><th>Quantity</th><th>Issued</th><th>Delete</th></tr>");
                for(BookBean bean:list){
                    out.println("<tr><td>"+bean.getCallno()+"</td><td>"+bean.getName()+"</td><td>"+bean.getAuthor()+"</td><td>"+bean.getPublisher()+"</td><td>"+bean.getQuantity()+"</td><td>"+bean.getIssued()+"</td><td><a href='DeleteBook?callno="+bean.getCallno()+"'>Delete</a></td></tr>");
                }
                out.println("</table>");
                
                out.println("</div>");
                
                
                request.getRequestDispatcher("footer.html").include(request, response);
            }
	}
}
