package com.syc.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class TestReflect {
	public static void main(String[] args) throws Exception {
		
		//�����������䣬��̬�ԣ���Ӳ����
		Object obj = Class.forName("com.syc.reflect.A").newInstance();//����A.class���ļ���Ȼ��new��һ������
		Method m = Class.forName("com.syc.reflect.A").getMethod("sayHello");
		m.invoke(obj);
		
		A obj2 = (A) Class.forName("com.syc.reflect.A").newInstance();//����A.class���ļ���ǿת
		obj2.sayHello();
		
		//�����������䣬ͨ�����췽������ʽ
		Constructor<A> constructor = A.class.getConstructor();
		A a = constructor.newInstance();
		a.sayHello();
		
		String s1 = "abc";
		Class c1 = s1.getClass();//ͨ�������getclass()������ȡ���ͱ�ʶ��Ϣ
		System.out.println(c1.getName());
		
		Class c2 = Class.forName("java.lang.String");//����String�ൽJVM�У��Ϳ��Ի�ȡ�������������Ϣ
		System.out.println(c2.getName());
		
		Class c3 = String.class;
		System.out.println(c3.getName());
	}
}
