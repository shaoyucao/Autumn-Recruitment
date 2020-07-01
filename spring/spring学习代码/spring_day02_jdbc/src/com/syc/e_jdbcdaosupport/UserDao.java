package com.syc.e_jdbcdaosupport;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.syc.a_domain.User;

public class UserDao extends JdbcDaoSupport{

	//父类中用final修饰的方法不能被子类重写
//	private JdbcTemplate jdbcTemplate;
//	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
//		this.jdbcTemplate = jdbcTemplate;
//	}
	
	public void update(User user){
		String sql = "update t_user set username = ?, password = ? where id = ?";
		Object[] args = {user.getUsername(),user.getPassword(),user.getId()};
		this.getJdbcTemplate().update(sql, args);
	}
	
	public List<User> queryAll(){
		String sql = "select * from t_user";
		return this.getJdbcTemplate().query(sql, ParameterizedBeanPropertyRowMapper.newInstance(User.class));
	}

}
