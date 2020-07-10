## 设计模式七大原则

1.单一职责原则（一个类只负责一项职责；类中方法足够少时，可以在方法级别保持单一职责原则）

2.接口隔离原则（客户端不应该依赖它不需要的接口）

3.依赖倒转原则（抽象不应该依赖细节，细节依赖抽象；面向接口编程；多态；人接收邮箱和微信信息）

4.迪米特法则（最少知道原则，一个类对自己依赖的类知道的越少越好）

5.开闭原则（对扩展开放，对修改关闭；多态）

6.里式替换原则（加减运算程序引发的问题和思考，子类尽量不要重写父类的方法，父类和子类都继承一个更通俗的基类，采用依赖，聚合，组合等关系替换原有的直接继承关系）

7.合成复用原则（尽量使用合成、聚成，而不是使用继承）



## 设计模式有哪几种？

设计模式有23种，分为三大类：**创建型、结构性、行为型**

创建型中有**单例模式**（分饿汉式、懒汉式）、**工厂模式**（分简单工厂模式、工厂方法模式、抽象工厂模式）等；

结构型模式中有**装饰模式**、**代理模式**等；

行为型模式有**观察者模式**、**模板方法模式**等。

![image-20200709201642146](images/image-20200709201642146.png)



### 1.单例模式

### 单例模式-饿汉式（*）

**步骤：**

1. 构造器私有化 (防止 new )
2. 类的内部创建对象
3. 向外暴露一个静态的公共方法。getInstance

```java
//饿汉式(静态常量)
class Singleton {
	
	//1. 构造器私有化, 外部不能new
	private Singleton() {
		
	}
	
	//2.类的内部创建对象实例
	private final static Singleton instance = new Singleton();
	
	//3. 向外暴露一个静态的公共方法，返回实例对象
	public static Singleton getInstance() {
		return instance;
	}
	
}
```

**优点：**类装载的时候完成实例化，避免了线程同步问题。

**缺点：**没有达到懒加载的效果，如果至始至终都没有使用过这个实例，可能会造成内存浪费。

### 单例模式-懒汉式（双重检查）（*）

使用volatile和synchronized保证线程安全

```java
// 双重检查
class Singleton {
	private static volatile Singleton instance;
	
	private Singleton() {}
	
	//提供一个静态的公有方法，加入双重检查代码，解决线程安全问题, 同时解决懒加载问题
	//同时保证了效率, 推荐使用
	public static Singleton getInstance() {
		if(instance == null) {
			synchronized (Singleton.class) {
				if(instance == null) {
					instance = new Singleton();
				}
			}
			
		}
		return instance;
	}
}
```

**优点：**线程安全；延迟加载；效率较高

### 单例模式-静态内部类方式

```java
// 静态内部类完成， 推荐使用
class Singleton {
	private static volatile Singleton instance;
	
	//构造器私有化
	private Singleton() {}
	
	//写一个静态内部类,该类中有一个静态属性 Singleton
	private static class SingletonInstance {
		private static final Singleton INSTANCE = new Singleton(); 
	}
	
	//提供一个静态的公有方法，直接返回SingletonInstance.INSTANCE
	public static synchronized Singleton getInstance() {
		return SingletonInstance.INSTANCE;
	}
}
```

优点：保证了线程安全，利用静态内部类特点实现延迟加载，效率高

### 单例模式-在JDK中的应用

**JDK中的Runtime类用的就是单例模式中的饿汉式**

![image-20200709204623431](images/image-20200709204623431.png)

### 单例模式-使用场景

需要**频繁的进行创建和销毁**的对象、创建对象时耗时过多或耗费资源过多(即：重量级对象），但又经常用到的对象、工具类对象、频繁访问数据库或文件的对象(比如**数据源**、**session 工厂**等)

### 2.工厂模式

### 工厂模式-简单工厂模式（*）

简单工厂模式是由一个**工厂对象决定创建出哪一种产品类的实例**。定义了一个创建对象的类，由这个类来**封装实例化对象的行为**，在简单工厂模式中，无需修改客户端的代码。

简单工厂类：

```java
public class SimpleFactory {
 
	//根据orderType 返回对应的Pizza 对象
	public static Pizza createPizza(String orderType) {
 
		Pizza pizza = null;
 
		System.out.println("使用简单工厂模式");
		if (orderType.equals("greek")) {
			pizza = new GreekPizza();
			pizza.setName(" 希腊披萨 ");
		} else if (orderType.equals("cheese")) {
			pizza = new CheesePizza();
			pizza.setName(" 奶酪披萨 ");
		} else if (orderType.equals("pepper")) {
			pizza = new PepperPizza();
			pizza.setName("胡椒披萨");
		}
		return pizza;
	}
}
```

客户端代码无需修改：

```java
public class OrderPizza {
 
	Pizza pizza = null;
	String orderType = "";
 
	public OrderPizza() {
		
		do {
			orderType = getType();
			pizza = SimpleFactory.createPizza(orderType);
 
			// 输出pizza
			if (pizza != null) { // 订购成功
				pizza.prepare();
				pizza.bake();
				pizza.cut();
				pizza.box();
			} else {
				System.out.println(" 订购披萨失败 ");
				break;
			}
		} while (true);
	}
 
	// 写一个方法，可以获取客户希望订购的披萨种类
	private String getType() {
		try {
			BufferedReader strin = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("input pizza 种类:");
			String str = strin.readLine();
			return str;
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		}
	}
}
```

测试：new OrderPizza();

### 工厂模式-工厂方法模式

定义了一个创建对象的**抽象方法**，由子类决定要实例化的类。工厂方法模式**将对象的实例化推迟到子类**。

```java
public abstract class OrderPizza {
 
	//定义一个抽象方法，createPizza , 让各个工厂子类自己实现
	abstract Pizza createPizza(String orderType);
	
	// 构造器
	public OrderPizza() {
		Pizza pizza = null;
		String orderType; // 订购披萨的类型
		do {
			orderType = getType();
			pizza = createPizza(orderType); //抽象方法，由工厂子类完成
			//输出pizza 制作过程
			pizza.prepare();
			pizza.bake();
			pizza.cut();
			pizza.box();
			
		} while (true);
	}
 
    pulbic String getType(){
        //参考以上简单工厂...
    }
}
```

BJOrderPizza和LDOrderPizza继承该类

```java
public class BJOrderPizza extends OrderPizza {
 
	@Override
	Pizza createPizza(String orderType) {
	
		Pizza pizza = null;
		if(orderType.equals("cheese")) {
			pizza = new BJCheesePizza();
		} else if (orderType.equals("pepper")) {
			pizza = new BJPepperPizza();
		}
		return pizza;
	}
 
}
```

测试：new BJOrderPizza();

### 工厂模式-抽象工厂模式（*）

定义了一个 **interface** 用于创建相关或有依赖关系的对象簇，而无需指明具体的类

抽象工厂模式可以将**简单工厂模式和工厂方法模式进行整合**

接口：

```java
public interface AbsFactory {
	//让下面的工厂子类来 具体实现
	public Pizza createPizza(String orderType);
}
```

BJFactory和LDFactory：

```java
public class BJFactory implements AbsFactory {
 
	@Override
	public Pizza createPizza(String orderType) {
		System.out.println("~使用的是抽象工厂模式~");
		Pizza pizza = null;
		if(orderType.equals("cheese")) {
			pizza = new BJCheesePizza();
		} else if (orderType.equals("pepper")){
			pizza = new BJPepperPizza();
		}
		return pizza;
	}
 
}
```

OrderPizza类

```java
public class OrderPizza {
 
	AbsFactory factory;
 
	// 构造器
	public OrderPizza(AbsFactory factory) {
		setFactory(factory);
	}
 
	private void setFactory(AbsFactory factory) {
		Pizza pizza = null;
		String orderType = ""; // 用户输入
		this.factory = factory;
		do {
			orderType = getType();
			// factory 可能是北京的工厂子类，也可能是伦敦的工厂子类
			pizza = factory.createPizza(orderType);
			if (pizza != null) { // 订购ok
				pizza.prepare();
				pizza.bake();
				pizza.cut();
				pizza.box();
			} else {
				System.out.println("订购失败");
				break;
			}
		} while (true);
	}
 
	// 写一个方法，可以获取客户希望订购的披萨种类
	private String getType() {
		try {
			BufferedReader strin = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("input pizza 种类:");
			String str = strin.readLine();
			return str;
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		}
	}
}
```

测试：new OrderPizza(new LDFactory());

### 工厂模式在JDK中的应用

JDK中的Calender类，使用到了简单工厂模式

![image-20200709225457008](images/image-20200709225457008.png)

### 工厂模式的意义

将**实例化对象的代码提取出来**，放到一个类中统一管理和维护，达到和主项目的依赖关系的解耦。从而提高项目的扩展和维护性。

### 3.装饰者模式

- 装饰器模式（Decorator Pattern）允许向一个现有的对象添加新的功能，同时又不改变其结构。这种类型的设计模式属于结构型模式，它是作为现有的类的一个包装。这种模式创建了一个装饰类，用来包装原有的类，并在保持类方法签名完整性的前提下，提供了额外的功能。

- 装饰者模式是动态的将新功能附加到对象上。在对象功能扩展方面，它比继承更有弹性，装饰者模式也体现了开闭原则(ocp)。
- 装饰者模式使用**继承+组合**的方式

**装饰者模式的设计方案**



![image-20200709231208541](images/image-20200709231208541.png)

抽象类：

```java
package com.syc.decorator;

public abstract class Drink {

	public String des; // 描述
	private float price = 0.0f;
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	//计算费用的抽象方法
	//子类来实现
	public abstract float cost();
	
}

```

抽象层：

```java
package com.syc.decorator;

public class Coffee  extends Drink {

	@Override
	public float cost() {
		return super.getPrice();
	}
}

```

美式咖啡：

```java
package com.syc.decorator;

public class LongBlack extends Coffee {

	public LongBlack() {
		setDes(" longblack ");
		setPrice(5.0f);
	}
}

```

意大利咖啡：

```java
package com.syc.decorator;

public class Espresso extends Coffee {
	
	public Espresso() {
		setDes("意大利咖啡 ");
		setPrice(6.0f);
	}
}

```

装饰器类：

```java
package com.syc.decorator;

public class Decorator extends Drink {
	private Drink obj;
	
	public Decorator(Drink obj) { //组合
		this.obj = obj;
	}
	
	@Override
	public float cost() {
		// getPrice 自己价格
		return super.getPrice() + obj.cost();
	}
	
	@Override
	public String getDes() {
		// obj.getDes() 输出被装饰者的信息
		return des + " " + getPrice() + " && " + obj.getDes();
	}
}

```

调料牛奶：

```java
package com.atguigu.decorator;

public class Milk extends Decorator {

	public Milk(Drink obj) {
		super(obj);
		setDes(" 牛奶 ");
		setPrice(2.0f); 
	}
}

```

调料豆浆：

```java
package com.atguigu.decorator;

public class Soy extends Decorator{

	public Soy(Drink obj) {
		super(obj);
		setDes(" 豆浆  ");
		setPrice(1.5f);
	}
}

```

测试类：

```java
package com.syc.decorator;

public class CoffeeBar {

	public static void main(String[] args) {
		// 装饰者模式下的订单：2份巧克力+一份牛奶的LongBlack

		// 1. 点一份 LongBlack
		Drink order = new LongBlack();
		System.out.println("费用1=" + order.cost());
		System.out.println("描述=" + order.getDes());

		// 2. order 加入一份牛奶
		order = new Milk(order);

		System.out.println("order 加入一份牛奶 费用 =" + order.cost());
		System.out.println("order 加入一份牛奶 描述 = " + order.getDes());

		// 3. order 加入一份巧克力
		order = new Chocolate(order);

		System.out.println("order 加入一份牛奶 加入一份巧克力  费用 =" + order.cost());
		System.out.println("order 加入一份牛奶 加入一份巧克力 描述 = " + order.getDes());

		// 3. order 加入一份巧克力
		order = new Chocolate(order);

		System.out.println("order 加入一份牛奶 加入2份巧克力   费用 =" + order.cost());
		System.out.println("order 加入一份牛奶 加入2份巧克力 描述 = " + order.getDes());
	
		System.out.println("===========================");
		
		Drink order2 = new DeCaf();
		
		System.out.println("order2 无因咖啡  费用 =" + order2.cost());
		System.out.println("order2 无因咖啡 描述 = " + order2.getDes());
		
		order2 = new Milk(order2);
		
		System.out.println("order2 无因咖啡 加入一份牛奶  费用 =" + order2.cost());
		System.out.println("order2 无因咖啡 加入一份牛奶 描述 = " + order2.getDes());
	}
}


```

### 装饰者模式在JDK中的应用

在JDK的源码中，InputStream使用的就是装饰者模式，其中InputString是抽象类（如Drink类），FilterInputStream是装饰者（如上面的Decorator），DataInputStream是FilterInputStream的子类（如上面的Milk）


![image-20200709231949070](images/image-20200709231949070.png)

测试类：

![image-20200709232019478](images/image-20200709232019478.png)

### 4.观察者模式

观察者模式用于定义对象间的一种一对多的依赖关系，当一个对象的状态发生改变时，所有依赖于它的对象都得到通知并被自动更新。当对象间存在一对多关系时，则使用观察者模式（Observer Pattern）。比如，当一个对象被修改时，则会自动通知依赖它的对象。观察者模式属于行为型模式。

**观察者模式原理图**

![image-20200710093922093](images/image-20200710093922093.png)

在观察者模式中，有一个WeatherData核心类，还有一个Observer观察者接口，需要将Observer写到WeatherData中，其中的Subject为接口，提供注册观察者，移除观察者和通知观察者三个主要的方法，由WeatherData来具体实现。Observer为接收输入，可以通过第三方具体实现。


WeatherData：

```java
package com.atguigu.observer.improve;

import java.util.ArrayList;

/**
 * 类是核心
 * 1. 包含最新的天气情况信息 
 * 2. 含有 观察者集合，使用ArrayList管理
 * 3. 当数据有更新时，就主动的调用   ArrayList, 通知所有的（接入方）就看到最新的信息
 * @author Administrator
 *
 */
public class WeatherData implements Subject {
	private float temperatrue;
	private float pressure;
	private float humidity;
	//观察者集合
	private ArrayList<Observer> observers;
	
	//加入新的第三方

	public WeatherData() {
		observers = new ArrayList<Observer>();
	}

	public float getTemperature() {
		return temperatrue;
	}

	public float getPressure() {
		return pressure;
	}

	public float getHumidity() {
		return humidity;
	}

	public void dataChange() {
		//调用 接入方的 update
		
		notifyObservers();
	}

	//当数据有更新时，就调用 setData
	public void setData(float temperature, float pressure, float humidity) {
		this.temperatrue = temperature;
		this.pressure = pressure;
		this.humidity = humidity;
		//调用dataChange， 将最新的信息 推送给 接入方 currentConditions
		dataChange();
	}

	//注册一个观察者
	@Override
	public void registerObserver(Observer o) {
		// TODO Auto-generated method stub
		observers.add(o);
	}

	//移除一个观察者
	@Override
	public void removeObserver(Observer o) {
		// TODO Auto-generated method stub
		if(observers.contains(o)) {
			observers.remove(o);
		}
	}

	//遍历所有的观察者，并通知
	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub
		for(int i = 0; i < observers.size(); i++) {
			observers.get(i).update(this.temperatrue, this.pressure, this.humidity);
		}
	}
}


```

Observer接口：

```java
package com.atguigu.observer.improve;

//观察者接口，有观察者来实现
public interface Observer {

	public void update(float temperature, float pressure, float humidity);
}

```

第三方接入：

```java
package com.syc.observer.improve;

public class CurrentConditions implements Observer {

	// 温度，气压，湿度
	private float temperature;
	private float pressure;
	private float humidity;

	// 更新 天气情况，是由 WeatherData 来调用，我使用推送模式
	public void update(float temperature, float pressure, float humidity) {
		this.temperature = temperature;
		this.pressure = pressure;
		this.humidity = humidity;
		display();
	}

	// 显示
	public void display() {
		System.out.println("***Today mTemperature: " + temperature + "***");
		System.out.println("***Today mPressure: " + pressure + "***");
		System.out.println("***Today mHumidity: " + humidity + "***");
	}
}
```

测试类：

```java
package com.syc.observer.improve;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//创建一个WeatherData
		WeatherData weatherData = new WeatherData();
		
		//创建观察者
		CurrentConditions currentConditions = new CurrentConditions();
		BaiduSite baiduSite = new BaiduSite();
		
		//注册到weatherData
		weatherData.registerObserver(currentConditions);
		weatherData.registerObserver(baiduSite);
		
		//测试
		System.out.println("通知各个注册的观察者, 看看信息");
		weatherData.setData(10f, 100f, 30.3f);
		
		
		weatherData.removeObserver(currentConditions);
		//测试
		System.out.println();
		System.out.println("通知各个注册的观察者, 看看信息");
		weatherData.setData(10f, 100f, 30.3f);
	}

}
```

### 观察者模式在JDK中的应用

JDK中的Observable类就使用了观察者模式

![image-20200710094525221](images/image-20200710094525221.png)

这里的Observable相当于气象台，而Observer就相当于观察者接口，Observable中提供的方法如下：

![image-20200710094659637](images/image-20200710094659637.png)

而在Observer中同样是提供了一个update方法

![image-20200710094721172](images/image-20200710094721172.png)

若我们需要使用观察者模式，可以直接将某个类继承自Observable类。