package com.syc.dao.impl;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.syc.dao.UserDao;
import com.syc.domain.User;

public class UserDaoImpl implements UserDao{

	//��Ҫspringע��ģ��
	private HibernateTemplate hibernateTemplate;
	
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}


	@Override
	public void save(User user) {
		this.hibernateTemplate.save(user);
	}

}
