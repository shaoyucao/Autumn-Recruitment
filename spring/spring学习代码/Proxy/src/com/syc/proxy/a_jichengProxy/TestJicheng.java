package com.syc.proxy.a_jichengProxy;

import org.junit.Test;

public class TestJicheng {
	@Test
	public void demo01() {
		UserDaoImpl userDaoImpl = new LogUserProxy();
		userDaoImpl.query("syc");
	}

}
