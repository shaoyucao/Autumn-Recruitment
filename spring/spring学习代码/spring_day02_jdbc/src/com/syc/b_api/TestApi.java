package com.syc.b_api;

import java.util.Map;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class TestApi {
	public static void main(String[] args) {
		//1.�������ӳأ�����Դ��dbcp
		BasicDataSource dataSource = new BasicDataSource();
		//����4��
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/spring_day02");
		dataSource.setUsername("root");
		dataSource.setPassword("123456");
		
		//2.����ģ��
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource);
		
		//3.ͨ��api����
		jdbcTemplate.update("insert into t_user (username, password) values (?,?)", "Tom","998");
	}
}
