package com.syc.dao;

public interface AccountDao {
	
	/**
	 * 付款
	 * @param outer
	 * @param money
	 */
	public void out(String outer, Integer money);
	
	/**
	 * 收款
	 * @param inner
	 * @param money
	 */
	public void in(String inner, Integer money);

}
