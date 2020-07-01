package com.syc.proxy.b_juheProxy;

import org.junit.Test;

public class TestJuhe {
	@Test
	public void demo01() {
		UserDao userDao = new UserDaoImpl();//目标对象，打印出query
		UserDao proxy = new LogUserProxy(userDao);//代理对象，打印出log
		UserDao proxy2 = new TimerUserProxy(proxy);//代理对象，打印出timer
		proxy2.query("syc");
	}

}
