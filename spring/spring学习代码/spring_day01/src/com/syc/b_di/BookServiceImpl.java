package com.syc.b_di;

import org.junit.Test;

public class BookServiceImpl implements BookService {	
	/*
	 * 
	//方法1：以前的方法，接口=实现类
	private BookDao bookDao = new BookDaoImpl();
		
	@Test
	@Override
	public void addBook(){
		bookDao.addBook();		
	}
	*/
	
	//方法2：基于setter方法的依赖注入	
	//接口+setter方法
	private BookDao bookDao;
	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}
	@Override
	public void addBook() {
		bookDao.addBook();
		
	}
	
	public BookServiceImpl() {
		System.out.println("被new了");
	}
}
