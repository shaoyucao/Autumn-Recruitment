package com.syc.b_factory_bean;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;


/*
 * ��ΪҪ��spring��aop������Ҫ�ù淶����������ȷ��֪ͨ����Ҫʵ�ֲ�ͬ�Ľӿڣ��ӿھ��ǹ淶������ȷ����ͬ�ķ���
 * ���û���֪ͨ������֪ͨ�����ֶ���ִ��Ŀ�귽����
 */
public class MyAspect implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation mi) throws Throwable {		
		System.out.println("ǰ����");
		//�ֶ�ִ��Ŀ�귽��
		Object obj = mi.proceed();
		System.out.println("�󷽷�");
		return obj;
	}

}
