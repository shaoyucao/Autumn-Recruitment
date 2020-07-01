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
			System.out.println("前方法：" + beanName);
		}		
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(final Object bean, String beanName)
			throws BeansException {
		System.out.println("后方法：" + beanName);
		//bean为目标对象
		//生成jdk代理对象
		return Proxy.newProxyInstance(
				MyBeanPostProcessor.class.getClassLoader(), //类加载器
				bean.getClass().getInterfaces(), //目标对象的接口
				new InvocationHandler() {//InvocationHandler为一个接口，我们这需要写匿名内部类
					
					@Override
					public Object invoke(Object proxy, Method method, Object[] args)
							throws Throwable {
						System.out.println("开启事务...");
						Object obj = method.invoke(bean, args);
						System.out.println("提交事务...");
						return obj;
					}
				});
	}	
}
