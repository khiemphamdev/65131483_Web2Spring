package ntu.phamgiakhiem;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class testDoGet
 */
@WebServlet("/testDoGet")
public class testDoGet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String value1 = request.getParameter("name");
		String value2 = request.getParameter("class");
		
		PrintWriter traVe = response.getWriter();
		
		traVe.append("Ten sinh vien: ");
		traVe.append(value1);
		traVe.append("\nLop: ");
		traVe.append(value2);
	}

}
