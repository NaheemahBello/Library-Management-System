package lms.servlets;

import java.io.IOException;
//import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.javatpoint.dao.BookDao;
@WebServlet("/DeleteBook")
public class DeleteBook extends HttpServlet {
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookDao.delete(request.getParameter("callno"));
		response.sendRedirect("ViewBook");
	}
}
