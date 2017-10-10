package com.am.servers;

import com.am.*;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
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
 * Servlet implementation class ItemSearch
 */
public class ItemSearch extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
	private static String  connectionUrl = "";
	private static Properties dbprops = null;
	static String s1="";
	static int i1=0;
	static double d1=0.0;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemSearch() 
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
	}
	
	static
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("");
			dbprops = DatabaseProperties.getInstance().getProperties();
					connectionUrl = "jdbc:mysql://" 
					+ dbprops.getProperty("server") 
					+ ":" + dbprops.getProperty("port")
					+ "/" + dbprops.getProperty("database");
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	{
		System.out.println("Called when the class is initialized");
	}
	
	public static Connection getConnection() throws Exception
	{
		Connection con = DriverManager.getConnection(connectionUrl, dbprops.getProperty("userid"), dbprops.getProperty("password"));
		return con;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		doGet(request, response);
		int itemId=Integer.parseInt(request.getParameter("itemId"));
		Item item;
		ItemDAO idao=new ItemDAO();
		item=idao.checkItemId(itemId);				
		if(item!=null)
		{
			request.setAttribute("item", item);
	        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/DisplaySingleItem.jsp");
	        dispatcher.forward(request, response);
		}	
		
		else
		{
			response.sendRedirect("http://www.google.co.in/");
		}

	}

}