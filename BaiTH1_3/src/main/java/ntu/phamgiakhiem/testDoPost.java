package ntu.phamgiakhiem;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/testDoPost")
public class testDoPost extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter traVe = response.getWriter();
		
		traVe.append("Bạn vừa gửi yêu cầu dạng GET, đây là đáp ứng của tôi");
		String noiDungHTML = "<form method = POST action = \"/BaiTH1_3/testDoPost\""
					+ 		"	<label>Ho: </label>"
					+ 		"<input type=\"text\" name=\"fname\" ><br>\r\n"
					+ 		"<label>Ten: </label>"
					+ 		"<input type=\"text\" name=\"lname\"><br>"
					+ 		"<input type=\"submit\" value=\"Gửi đi\">"
					+ "</form>";
		traVe.append(noiDungHTML);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		
		String value1 = request.getParameter("fname");
		String value2 = request.getParameter("lname");
		
		PrintWriter traVe = response.getWriter();
		traVe.append("Bạn vừa gửi yêu cầu dạng POST, đây là đáp ứng của tôi").append("<br>");
		traVe.append("\nGiá trị tham số fname = ").append(value1).append("<br>");
		traVe.append("\nGiá trị tham số lname = ").append(value2);
	}

}
