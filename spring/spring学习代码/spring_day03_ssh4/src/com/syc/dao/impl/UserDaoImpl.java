package com.syc.dao.impl;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.syc.dao.UserDao;
import com.syc.domain.User;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao{

	@Override
	public void save(User user) {
		this.getHibernateTemplate().save(user);
	}

}
