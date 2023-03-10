package lms.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//import com.javatpoint.beans.IssueBookBean;
import com.javatpoint.dao.BookDao;
@WebServlet("/ReturnBook")
public class ReturnBook extends HttpServlet {
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
            try (PrintWriter out = response.getWriter()) {
                out.print("<!DOCTYPE html>");
                out.print("<html>");
                out.println("<head>");
                out.println("<title>Return Book</title>");
                out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
                out.println("</head>");
                out.println("<body>");
                request.getRequestDispatcher("navlibrarian.html").include(request, response);
                
                out.println("<div class='container'>");
                String callno=request.getParameter("callno");
                String sstudentid=request.getParameter("studentid");
                int studentid=Integer.parseInt(sstudentid);
                
                int i=BookDao.returnBook(callno,studentid);
                if(i>0){
                    out.println("<h3>Book returned successfully</h3>");
                }else{
                    out.println("<h3>Sorry, unable to return book.</h3><p>We may have sortage of books. Kindly visit later.</p>");
                }
                out.println("</div>");
                
                
                request.getRequestDispatcher("footer.html").include(request, response);
            }
	}

}
