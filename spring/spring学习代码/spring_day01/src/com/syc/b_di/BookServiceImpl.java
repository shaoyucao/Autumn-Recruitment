package com.syc.b_di;

import org.junit.Test;

public class BookServiceImpl implements BookService {	
	/*
	 * 
	//����1����ǰ�ķ������ӿ�=ʵ����
	private BookDao bookDao = new BookDaoImpl();
		
	@Test
	@Override
	public void addBook(){
		bookDao.addBook();		
	}
	*/
	
	//����2������setter����������ע��	
	//�ӿ�+setter����
	private BookDao bookDao;
	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}
	@Override
	public void addBook() {
		bookDao.addBook();
		
	}
	
	public BookServiceImpl() {
		System.out.println("��new��");
	}
}
