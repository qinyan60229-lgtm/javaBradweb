package tw.brad.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Brad03")
public class Brad03 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");  //讀取 Request 裡的文字資料時，使用 UTF-8 解碼
		
		response.setContentType("text/html; charset=UTF-8");  //我等等回傳的資料 類型：text/html → HTML 編碼：UTF-8
		PrintWriter out = response.getWriter();   //跟 response 拿到一個「文字輸出工具」   out = 一支專門往 response 裡寫文字的筆
		out.println("<h1>Hello, World</h1>");
		
		response.flushBuffer();
		
	}

}