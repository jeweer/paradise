package com.springmvc.demo;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MainApp {
	public static void main(String[] args) {

		try {
			ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:spring/spring-mybatis.xml");
			DruidDataSource dataSource = (DruidDataSource) context.getBean("dataSource");
			System.out.println(dataSource.getUrl());
			System.out.println(dataSource.getUsername());
			System.out.println(dataSource.getPassword());
			System.out.println(dataSource.getActiveCount());
			System.out.println(dataSource.getMaxActive());
			System.out.println(dataSource.getDriverClassName());
			System.out.println(dataSource.getVersion());
			System.out.println(dataSource.getRollbackCount());
			Connection connection = dataSource.getConnection();
			PreparedStatement st = connection.prepareStatement("select * from active_dashboards");
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString("userid"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 获取连接
	}
}
