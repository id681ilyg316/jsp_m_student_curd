package com.deng.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtil {
	
	static String driverClass = null;
	static String url = null;
	static String name = null;
	static String password= null;
	
	static{
		try {
			//1. 创建一个属性配置对象

			//使用类加载器，去读取src底下的资源文件。 后面在servlet
			//InputStream is = JDBCUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
			//导入输入流。

			
			//读取属性
			driverClass = "com.mysql.cj.jdbc.Driver";
			url = "jdbc:mysql://www.icodedock.com/m_student_curd?useSSL=false&serverTimezone=Asia/Shanghai";
			name = "m_student_curd";
			password = "m_student_curd";
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取连接对象
	 * @return
	 */
	public static Connection getConn(){
		Connection conn = null;
		try {
			Class.forName(driverClass);
			//静态代码块 ---> 类加载了，就执行。 java.sql.DriverManager.registerDriver(new Driver());
			//DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			//DriverManager.getConnection("jdbc:mysql://localhost/test?user=monty&password=greatsqldb");
			//2. 建立连接 参数一： 协议 + 访问的数据库 ， 参数二： 用户名 ， 参数三： 密码。
			conn = DriverManager.getConnection(url, name, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	/**
	 * 释放资源
	 * @param conn
	 * @param st
	 * @param rs
	 */
	public static void release(Connection conn , Statement st , ResultSet rs){
		closeRs(rs);
		closeSt(st);
		closeConn(conn);
	}
	public static void release(Connection conn , Statement st){
		closeSt(st);
		closeConn(conn);
	}

	
	private static void closeRs(ResultSet rs){
		try {
			if(rs != null){
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			rs = null;
		}
	}
	
	private static void closeSt(Statement st){
		try {
			if(st != null){
				st.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			st = null;
		}
	}
	
	private static void closeConn(Connection conn){
		try {
			if(conn != null){
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			conn = null;
		}
	}
}
