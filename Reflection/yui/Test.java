package yui;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * The basic class to test Reflection
 * 
 * @author Octobershiner
 * @since 2012 3 17
 */
public class Test {

	/**
	 * 利用类类型class
	 * 1获得构造函数Construtor
	 * 2获得成员变量Field
	 * 3获得方法Method
	 * */

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		//获得类类型的两种方式
        Class cls1 = Role.class;
        Class cls2 = Class.forName("yui.Role");
        
        Object o = cls1.newInstance(); //创建一个实例
        //Object o1 = new Role();   //与上面的方法等价
        
        /**
         * 获取构造方法Constructor
         * getConstructor()  only for public 
         * getDeclaredConstructor()  global access all 
         * 
         * */
        
        //指定参数列表获取特定的方法
        Constructor con = cls1.getDeclaredConstructor(new Class[]{String.class});
        con.setAccessible(true); //设置可访问的权限
        Object obj = con.newInstance(new Object[]{"liyang",2});
        System.out.println(obj);  //打印一下这个对象的信息
        
        //获取所有的构造方法集合
        Constructor con1[] = cls1.getDeclaredConstructors();
        con1[1].setAccessible(true);
        Object obj1 = con1[1].newInstance(new Object[]{"tom"});
        System.out.println(obj1);
        
        
        /**
         * 获取成员变量Field
         * getField()
         * getDeclaredField()
         * */
        Field mem = cls1.getDeclaredField("name");
        mem.setAccessible(true);      
        System.out.println("we get form field :"+mem.get(obj));
         
        
        /**
         * 调用类的方法 Method
         * getMethod()
         * getDeclaredMethod()
         * 
         * */
        Method f = cls1.getMethod("getName", null);
        Object name = f.invoke(obj, null);
		System.out.println("we invoke method : "+ name);
		
	}
	


}
