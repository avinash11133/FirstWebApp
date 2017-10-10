package com.am.servers;

import com.am.*;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.am.servers.DatabaseProperties;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

/**
 * Servlet implementation class PrinItem
 */
public class ItemsInventory extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
	private static String  connectionUrl = "";
	private static Properties dbprops = null;
		       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemsInventory() 
    {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out=response.getWriter();
		ItemsInventory ii=new ItemsInventory();
		ItemDAO idao=new ItemDAO();
		ArrayList<Item> itemList=idao.itemList();
		out.append("<html>");
		out.append("  <head>");
		out.append("    <title>Items</title>");
		out.append("  </head>");
		out.append("  <body>");
		for(Item item:itemList)
		{
			out.print(item.getId()+" ");
			out.append(item.getName()+" ");
			out.print(item.getQuantity()+" ");
			out.print(item.getPrice()+" ");
			out.print(item.getPercentage()+" ");
			out.append("<br>");
		}
		out.append("  </body>");
		out.append("</html>");
		out.print(request.getSession().getCreationTime());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		doGet(request, response);		
	}

}