package com.syc.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class TestReflect {
	public static void main(String[] args) throws Exception {
		
		//方法二：反射，动态性，非硬编码
		Object obj = Class.forName("com.syc.reflect.A").newInstance();//加载A.class的文件，然后new出一个对象
		Method m = Class.forName("com.syc.reflect.A").getMethod("sayHello");
		m.invoke(obj);
		
		A obj2 = (A) Class.forName("com.syc.reflect.A").newInstance();//加载A.class的文件，强转
		obj2.sayHello();
		
		//方法三：反射，通过构造方法的形式
		Constructor<A> constructor = A.class.getConstructor();
		A a = constructor.newInstance();
		a.sayHello();
		
		String s1 = "abc";
		Class c1 = s1.getClass();//通过对象的getclass()方法获取类型标识信息
		System.out.println(c1.getName());
		
		Class c2 = Class.forName("java.lang.String");//加载String类到JVM中，就可以获取到该类的类型信息
		System.out.println(c2.getName());
		
		Class c3 = String.class;
		System.out.println(c3.getName());
	}
}
