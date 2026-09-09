package tw.brad.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Brad07")
@MultipartConfig(
		location = "C:\\Users\\User\\git\\Bradweb\\BradWeb\\src\\main\\webapp\\META-INF\\upload"
		)
public class Brad07 extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
	
		
		Part part = request.getPart("upload");
		String type = part.getContentType();
		String name = part.getName();
		long size = part.getSize();
		String sname = part.getSubmittedFileName();
		
		System.out.printf("%s:%s:%d:%s\n", type, name, size, sname);
		part.write(sname);
		
		
		response.setContentType("text/html; charset=UTF-8");
	}

}