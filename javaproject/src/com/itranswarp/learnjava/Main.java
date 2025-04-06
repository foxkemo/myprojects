package com.itranswarp.learnjava;
import com.itranswarp.learnjava.*;
import java.lang.reflect.*;
/**
 * Learn Java from https://www.liaoxuefeng.com/
 *
 * @author liaoxuefeng
 */
public class Main {

	public static void main(String[] args) throws Exception {
		String name = "Xiao Ming";
		int age = 20;
		Person p = new Person();
		// TODO: 利用反射调用setName和setAge方法:
		Class cls= p.getClass();
		Method met=cls.getMethod("setName",String.class);
		Method met2=cls.getMethod("setAge",int.class);
		met.setAccessible(true);
		met2.setAccessible(true);
		met2.invoke(p,age);
		met.invoke(p,name);
		System.out.println(p.getName()); // "Xiao Ming"
		System.out.println(p.getAge()); // 20
		System.out.println(met); // 20	
			
	}
}
