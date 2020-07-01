package com.syc.proxy.b_juheProxy;

import org.junit.Test;

public class TestJuhe {
	@Test
	public void demo01() {
		UserDao userDao = new UserDaoImpl();//Ŀ����󣬴�ӡ��query
		UserDao proxy = new LogUserProxy(userDao);//������󣬴�ӡ��log
		UserDao proxy2 = new TimerUserProxy(proxy);//������󣬴�ӡ��timer
		proxy2.query("syc");
	}

}
