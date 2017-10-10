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
public class ItemTable extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
	private static String  connectionUrl = "";
	private static Properties dbprops = null;
		       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemTable() 
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
		ItemDAO idao=new ItemDAO();
		ArrayList<Item> itemList=idao.itemList();
		//Item item=ii.returnItem();
		out.append("<html>");
		out.append("  <head>");
		out.append("    <title>Items</title>");
		out.append("  </head>");
		out.append("  <body>");
		out.append("<table border=\"1\">");
		out.append("<tr>");
		out.append("<th>Name</th>");
		out.append("<th>Quantity</th>");
		out.append("<th>Price</th>");
		out.append("</tr>");
		for(Item item:itemList)
		{
			out.append("<tr>");
			out.append("<td>"+item.getName()+"</td>");
			out.append("<td>"+item.getQuantity()+"</td>");
			out.append("<td>"+item.getPrice()+"</td>");
			out.append("</tr>");
		}
		out.append("</table>");
		out.append("  </body>");
		out.append("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		doGet(request, response);
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
	
	public Item returnItem()
	{
		Connection con = null;
		Item item = null;
		int i1=0;
		String s1="";
		double d1=0;
		try 
		{
			con = getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from Item");
			while(rs.next())
			{
				s1=rs.getString(2);
				i1=rs.getInt(3);
				d1=rs.getDouble(4);
			}
			
			item=new Item(s1,i1,d1);
		}
		
		catch (Exception e) 
		{
			System.out.println(e);
		}
		
		finally
		{
			if(con != null)
			{
				try 
				{
					con.close();
				} 
				catch (SQLException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return item;
	}

}