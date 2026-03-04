<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Kết quả tính toán</title>
    <style>
        body { font-family: sans-serif; display: flex; justify-content: center; align-items: center; height: 100vh; background-color: #f4f4f9; }
        .result-box { background: white; padding: 30px; border-radius: 15px; text-align: center; box-shadow: 0 5px 15px rgba(0,0,0,0.1); }
        .success { color: #28a745; font-size: 24px; font-weight: bold; }
        .error { color: #dc3545; }
        .back-btn { display: inline-block; margin-top: 20px; text-decoration: none; color: #007bff; }
    </style>
</head>
<body>

<div class="result-box">
    <%
        // 1. Lấy dữ liệu từ Request
        String s1 = request.getParameter("num1");
        String s2 = request.getParameter("num2");
        String op = request.getParameter("operator");
        
        String displayMessage = "";
        boolean isError = false;

        try {
            double n1 = Double.parseDouble(s1);
            double n2 = Double.parseDouble(s2);
            double res = 0;

            // 2. Logic xử lý
            switch(op) {
                case "add": res = n1 + n2; break;
                case "sub": res = n1 - n2; break;
                case "mul": res = n1 * n2; break;
                case "div": 
                    if(n2 != 0) res = n1 / n2; 
                    else { isError = true; displayMessage = "Không thể chia cho số 0!"; }
                    break;
            }

            if(!isError) {
                displayMessage = n1 + " " + op + " " + n2 + " = " + res;
                String symbol = op.equals("add") ? "+" : op.equals("sub") ? "-" : op.equals("mul") ? "*" : "/";
                displayMessage = String.format("%.1f %s %.1f = %.1f", n1, symbol, n2, res);
            }
        } catch (Exception e) {
            isError = true;
            displayMessage = "Đã xảy ra lỗi dữ liệu!";
        }
    %>

    <h2>Kết quả của bạn</h2>
    <p class="<%= isError ? "error" : "success" %>">
        <%= displayMessage %>
    </p>
    
    <a href="Index.html" class="back-btn">← Quay lại tính tiếp</a>
</div>

</body>
</html>