package com.am.servers;

public class SingletonDemo 
{
	public static void main(String[] args)
	{
		SingletonClass obj  = SingletonClass.getInstance();
		System.out.println(obj);
		SingletonClass obj2  = SingletonClass.getInstance();
		System.out.println(obj2);
		/*SingletonClass obj3  = new SingletonClass();
		System.out.println(obj3);*///shows error
	}
}
