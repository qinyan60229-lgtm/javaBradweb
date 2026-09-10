package tw.brad.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@WebServlet("/Brad09")
public class Brad09 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
	
		response.setContentType("text/html; charset=UTF-8");
		
		String upload = getServletContext().getRealPath("/upload");  //取得「目前這整個 Web 應用程式」的資訊。找 Web App 裡 /upload 對應到電腦硬碟上的「真正實體路徑」
		System.out.println(upload);
		
		String uuid = UUID.randomUUID().toString();  //產生一個幾乎不會重複的識別碼
		System.out.println(uuid);
		
		System.out.println(System.getProperty("user.dir"));  //我這個 Java 程式目前是在哪個工作目錄下執行？
		System.out.println(request.getServletContext().getRealPath("/"));  //Web App 根目錄
		System.out.println(getServletContext().getRealPath("/"));  //same
		
		
	}

}