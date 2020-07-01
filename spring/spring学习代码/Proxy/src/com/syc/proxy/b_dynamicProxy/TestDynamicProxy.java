package com.syc.proxy.b_dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//��̬����ģʽ
public class TestDynamicProxy {
	public static void main(String[] args) {
		//1.����Ŀ�����
		final Subject subject = new SubjectImpl();
		
		//2.����������������
		ProxyHandler proxyHandler = new ProxyHandler(subject);
		
		//3.��̬���ɴ������
		Subject proxySubject = (Subject) Proxy.newProxyInstance(
				subject.getClass().getClassLoader(), //�������
				subject.getClass().getInterfaces(), //����Ľӿ�
				proxyHandler);	//���������Ҫ�����������󣬴���������д��invoke����	

		//4.�ͻ���ͨ�����������÷��������ε��ý��Զ��ر�����������invoke��������
		proxySubject.request();
		
		System.out.println(proxySubject.getClass().getName());
	}

}
