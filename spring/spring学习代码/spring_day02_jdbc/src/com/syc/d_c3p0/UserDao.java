package com.syc.d_c3p0;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;

import com.syc.a_domain.User;

public class UserDao {
	
	private JdbcTemplate jdbcTemplate;
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public void update(User user){
		String sql = "update t_user set username = ?, password = ? where id = ?";
		Object[] args = {user.getUsername(),user.getPassword(),user.getId()};
		jdbcTemplate.update(sql, args);
	}
	
	public List<User> queryAll(){
		String sql = "select * from t_user";
		return jdbcTemplate.query(sql, ParameterizedBeanPropertyRowMapper.newInstance(User.class));
	}

}
