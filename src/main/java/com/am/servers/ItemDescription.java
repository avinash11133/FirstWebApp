package com.am.servers;

import java.util.ArrayList;

import com.am.*;

public class ItemDescription 
{
	int id;
	String description;
	
	private ItemDescription()
	{
		
	}
	
	private static ItemDescription obj;

	public static ItemDescription getInstance()
	{
		ItemDescriptionDAO id=new ItemDescriptionDAO();
		ArrayList alist=id.getDescription();
		return obj;
	}
}