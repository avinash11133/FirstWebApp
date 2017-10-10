package com.am.servers;

import java.io.IOException;
import java.util.Properties;
public class DatabaseProperties
{
	private static DatabaseProperties instance = null;
	
	private Properties dbprops = new Properties();
	
	private DatabaseProperties()
	{
		try 
		{
				dbprops.load(DatabaseProperties.class.getClassLoader().getResourceAsStream("\\db.properties"));
		} 
		
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public synchronized static DatabaseProperties getInstance()
	{
		if(instance == null)
		{
			instance = new DatabaseProperties();
		}
		return instance;
	}
	
	public Properties getProperties()
	{
		return dbprops;
	}
}