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
import java.util.List;
@WebServlet("/ViewIssuedBook")
public class ViewIssuedBook extends HttpServlet {
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
            try (PrintWriter out = response.getWriter()) {
                out.print("<!DOCTYPE html>");
                out.print("<html>");
                out.println("<head>");
                out.println("<title>View Issued Book</title>");
                out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
                out.println("</head>");
                out.println("<body>");
                request.getRequestDispatcher("navlibrarian.html").include(request, response);
                
                out.println("<div class='container'>");
                
                List<IssueBookBean> list=BookDao.viewIssuedBooks();
                
                out.println("<table class='table table-bordered table-striped'>");
                out.println("<tr><th>Callno</th><th>Student Id</th><th>Student Name</th><th>Student Mobile</th><th>Issued Date</th><th>Return Status</th></tr>");
                for(IssueBookBean bean:list){
                    out.println("<tr><td>"+bean.getCallno()+"</td><td>"+bean.getStudentid()+"</td><td>"+bean.getStudentname()+"</td><td>"+bean.getStudentmobile()+"</td><td>"+bean.getIssueddate()+"</td><td>"+bean.getReturnstatus()+"</td></tr>");
                }
                out.println("</table>");
                
                out.println("</div>");
                
                
                request.getRequestDispatcher("footer.html").include(request, response);
            }
	}
}
