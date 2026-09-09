package tw.brad.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Brad01")
public class Brad01 extends HttpServlet {

	public Brad01() {
		System.out.println("Brad01()");
	}

	@Override // 原本的初始化功能 (Servlet 開始工作前，只做一次的準備工作
	public void init(ServletConfig config) 
			throws ServletException {
		System.out.println("intit()");
		super.init(config);
	}

	@Override // 原本處理請求的功能   (Request 進來我先印 service()，然後剩下的交回 HttpServlet 原本的 service 處理。
	protected void service(
			HttpServletRequest req, 
			HttpServletResponse resp) 
			throws ServletException, IOException {
		System.out.println("service()");
		super.service(req, resp);
	}

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doGet()");
		response.getWriter().append("Brad Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doPost()");
		// doGet(request, response);
	}

}
