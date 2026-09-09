package tw.brad.servlet;

import java.io.IOException;
import java.util.Collection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@WebServlet("/Brad08")
@MultipartConfig(    //這支 Servlet 要處理 multipart/form-data，也就是檔案上傳  指定的暫存位置
		location = "C:\\Users\\User\\git\\javaBradweb\\BradWeb\\src\\main\\webapp\\upload"
		)
public class Brad08 extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String urip = request.getRemoteAddr();
		
		Collection<Part> parts = request.getParts();
		for (Part part :parts) {    //每一個 Part 都處理一次。
//			String name = part.getName();
//			System.out.println(name);
			
			String type = part.getContentType();
			String name = part.getName();
			long size = part.getSize();
			String sname = part.getSubmittedFileName();
			
			System.out.printf("%s:%s:%s:%d:%s\n", urip, type, name, size, sname);			
			
			String sfname = String.format("%s_%s",
			        urip.replace(":", "_"),
			        part.getSubmittedFileName());
			if (type != null && part.getSize() > 0) {  //這個 Part 是不是真的檔案，而且裡面有內容。
				part.write(sfname);
			}			
		}
		
		
		response.setContentType("text/html; charset=UTF-8");
	}

}