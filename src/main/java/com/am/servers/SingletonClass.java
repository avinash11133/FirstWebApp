package com.am.servers;

public class SingletonClass 
{
	private SingletonClass()
	{
		
	}
	
	private static SingletonClass obj = new SingletonClass();
	
	static SingletonClass getInstance()
	{
		return obj;
	}
}