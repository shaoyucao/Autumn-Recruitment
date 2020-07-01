package com.syc.proxy.b_dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/*
 * ����������ʵ����InvocationHandler�ӿ�
 * */
public class ProxyHandler implements InvocationHandler {
	//����Ŀ�����ľ��
	private Subject subject;
	
	public ProxyHandler(Subject subject){
		this.subject = subject;
	}

	/*
	 * invoke()����
	 * �˷����ڴ����������κ�һ������ʱ���ᱻ����
	 * 
	 * ��һ��������proxy �������
	 * �ڶ���������method ���������Method�࣬�鿴��������ĸ�����
	 * ������������args ������β�
	 * */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		//��������������
		System.out.println(proxy.getClass().getName());//�����������������������Զ����ɵ�
		
		//����Ԥ����������ȻҲ���Ը���method�Ĳ�ͬ���в�ͬ��Ԥ������
		System.out.println("=========before========");
		//������ʵ��Ŀ����������й���
		Object result = method.invoke(subject, args);
		System.out.println("=========before========");
		return result;//���ؽ��
	}

}
