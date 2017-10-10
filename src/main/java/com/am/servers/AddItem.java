package com.am.servers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.am.ItemDAO;
import java.util.Properties;

/**
 * Servlet implementation class PrinItem
 */
public class AddItem extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
	private static String  connectionUrl = "";
	private static Properties dbprops = null;
		       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddItem() 
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
		//1PrintWriter out=response.getWriter();
		//1out.println(request.getMethod());
		//response.setStatus(401);
		//response.setStatus(405);
		//response.setStatus(405,"not found");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		doGet(request, response);
		int itemId=Integer.parseInt(request.getParameter("itemId"));
		String itemName=request.getParameter("itemName");
		//int iQuantity=Integer.parseInt(request.getParameter("iQuantity"));
		int iQuantity = Integer.parseInt(request.getParameter("iQuantity"));
		//int iQuantity= 3;
		double iPrice=Double.parseDouble(request.getParameter("iPrice"));
		double percentage=Double.parseDouble(request.getParameter("percentage"));
		//double iPrice = 2.2;
		//double percentage = 2.3;
		ItemDAO idao=new ItemDAO();
		idao.insert(itemId,itemName,iQuantity,iPrice,percentage);
		System.out.println(request.getMethod());
		out.print(request.getSession().getCreationTime());
	}
	
}