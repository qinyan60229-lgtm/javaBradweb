package tw.brad.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tw.brad.listener.InitListener;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@WebServlet("/Brad15")
public class Brad15 extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		String sql = """
				SELECT id, cname
				FROM cust
				""";
		try (Connection conn = InitListener.getDataSource().getConnection();  //共用的 HikariDataSource 拿出來,從 Connection Pool 借一條資料庫連線
				Statement stmt = conn.createStatement();  //使用這條資料庫連線，建立一個可以送 SQL 給 MySQL 的物件
				ResultSet rs = stmt.executeQuery(sql)){  //把這句 SELECT 送到 MySQL 執行
			
			while (rs.next()) {
				System.out.printf("%d:%s\n", 
									rs.getLong("id"), 	
									rs.getString("cname"));
			}
		}catch(Exception e) { 
			e.printStackTrace();
		}
		
		
	}

}