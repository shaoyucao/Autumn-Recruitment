package com.syc.a_proxy.b_cglib;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class MyBeanFactory {
	public static UserServiceImpl createService(){
		//1.Ŀ����
		final UserServiceImpl userServiceImpl = new UserServiceImpl();
		//2.������
		final MyAspect myAspect = new MyAspect();
		//3.������ ������cglib���ײ㴴��Ŀ���������
		
		//3.1������
		Enhancer enhancer = new Enhancer();
		//3.2ȷ������
		enhancer.setSuperclass(userServiceImpl.getClass());
		/* 3.3 ���ûص����� , 
		 * setCallback��Ҫ����һ��Callback�ӿڣ�MethodInterceptorΪ���ӽӿڣ��ܶԷ���������ǿ
		 * MethodInterceptor�ӿ� ��Ч jdk InvocationHandler�ӿ�
		 * 	intercept() ��Ч jdk  invoke()
		 * 		����1������2������3����invokeһ��
		 * 		����4��methodProxy �����Ĵ���
		 */
		
		enhancer.setCallback(new MethodInterceptor() {
			
			@Override
			public Object intercept(Object proxy, Method method, Object[] args,
					MethodProxy methodProxy) throws Throwable {
				
				myAspect.before();
				method.invoke(userServiceImpl, args);
				// * ִ�д�����ĸ��� ��ִ��Ŀ���� ��Ŀ����ʹ����� ���ӹ�ϵ��
				methodProxy.invokeSuper(proxy, args);
				myAspect.after();
				return null;
			}
		});
		
		//3.4��������
		UserServiceImpl proxyService = (UserServiceImpl) enhancer.create();
		return proxyService;
	}
}
