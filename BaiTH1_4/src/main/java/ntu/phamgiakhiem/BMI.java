package ntu.phamgiakhiem;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class BMI
 */
@WebServlet("/BMI")
public class BMI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        out.println("<h2>Tính chỉ số BMI</h2>");
        out.println("<form method='post' action='" + request.getContextPath() + "/BMI'>");
        out.println("Cân nặng (kg): <input type='number' step='0.1' name='weight' required><br><br>");
        out.println("Chiều cao (m): <input type='number' step='0.01' name='height' required><br><br>");
        out.println("<input type='submit' value='Tính BMI'>");
        out.println("</form>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        double weight = Double.parseDouble(request.getParameter("weight"));
        double height = Double.parseDouble(request.getParameter("height"));

        double bmi = weight / (height * height);

        String ketLuan;
        if (bmi < 18.5) {
            ketLuan = "Gầy";
        } else if (bmi < 25) {
            ketLuan = "Bình thường";
        } else if (bmi < 30) {
            ketLuan = "Thừa cân";
        } else {
            ketLuan = "Béo phì";
        }

        out.println("<h2>Kết quả BMI</h2>");
        out.println("BMI của bạn là: <b>" + String.format("%.2f", bmi) + "</b><br>");
        out.println("Phân loại: <b>" + ketLuan + "</b><br><br>");
        out.println("<a href='" + request.getContextPath() + "/BMI'>Quay lại</a>");
    }
}
