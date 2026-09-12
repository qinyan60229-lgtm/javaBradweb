package tw.brad.listener;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class InitListener implements ServletContextListener{
	private static HikariDataSource dataSource;  //資料庫連線池
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");  //載入 MySQL JDBC Driver
			System.out.println("Load Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static HikariDataSource getDataSource() {
		return dataSource;  //呼叫這個方法
	}
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("init");
		ServletContextListener.super.contextInitialized(sce);
		
		HikariConfig config = new HikariConfig();
		config.setJdbcUrl("jdbc:mysql://localhost:8889/brad?useSSL=false");
		config.setUsername("root");
		config.setPassword("root");
		
		// 優化
		config.setMaximumPoolSize(10);
		config.setMinimumIdle(4);
		config.setConnectionTimeout(10*1000);
		
		dataSource = new HikariDataSource(config);
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		ServletContextListener.super.contextDestroyed(sce);
		if (dataSource != null && !dataSource.isClosed()) {  //如果連線池存在，而且還沒關閉，就把它關掉
			dataSource.close();
		}
	}


}