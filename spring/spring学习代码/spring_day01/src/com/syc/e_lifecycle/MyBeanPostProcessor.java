package com.syc.e_lifecycle;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		if(beanName.equals("userServiceId")){
			System.out.println("ǰ������" + beanName);
		}		
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(final Object bean, String beanName)
			throws BeansException {
		System.out.println("�󷽷���" + beanName);
		//beanΪĿ�����
		//����jdk�������
		return Proxy.newProxyInstance(
				MyBeanPostProcessor.class.getClassLoader(), //�������
				bean.getClass().getInterfaces(), //Ŀ�����Ľӿ�
				new InvocationHandler() {//InvocationHandlerΪһ���ӿڣ���������Ҫд�����ڲ���
					
					@Override
					public Object invoke(Object proxy, Method method, Object[] args)
							throws Throwable {
						System.out.println("��������...");
						Object obj = method.invoke(bean, args);
						System.out.println("�ύ����...");
						return obj;
					}
				});
	}	
}
