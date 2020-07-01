package com.syc.b_api;

import java.util.Map;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class TestApi {
	public static void main(String[] args) {
		//1.创建连接池（数据源）dbcp
		BasicDataSource dataSource = new BasicDataSource();
		//基本4项
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/spring_day02");
		dataSource.setUsername("root");
		dataSource.setPassword("123456");
		
		//2.创建模板
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource);
		
		//3.通过api操作
		jdbcTemplate.update("insert into t_user (username, password) values (?,?)", "Tom","998");
	}
}
