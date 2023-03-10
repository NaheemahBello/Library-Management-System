package lms.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//import com.javatpoint.beans.BookBean;
import com.javatpoint.beans.IssueBookBean;
import com.javatpoint.dao.BookDao;
@WebServlet("/IssueBook")
public class IssueBook extends HttpServlet {
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
                String callno=request.getParameter("callno");
                String studentid=request.getParameter("studentid");
                String studentname=request.getParameter("studentname");
                String sstudentmobile=request.getParameter("studentmobile");
                long studentmobile=Long.parseLong(sstudentmobile);
                
                IssueBookBean bean=new IssueBookBean(callno,studentid,studentname,studentmobile);
                int i=BookDao.issueBook(bean);
                if(i>0){
                    out.println("<h3>Book issued successfully</h3>");
                }else{
                    out.println("<h3>Sorry, unable to issue book.</h3><p>We may have sortage of books. Kindly visit later.</p>");
                }
                out.println("</div>");
                
                
                request.getRequestDispatcher("footer.html").include(request, response);
            }
	}

}
