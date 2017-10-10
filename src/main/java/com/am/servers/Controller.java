package com.am.servers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.am.*;
import java.util.ArrayList;

/**
 * Servlet implementation class Controller
 */
public class Controller extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() 
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
	
		ItemDAO idao=new ItemDAO();
		ArrayList<Item> itemList=idao.itemList();
		
		/*1request.setAttribute("itemList", itemList);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/displayItems.jsp");
        dispatcher.forward(request, response);*/
        
        HttpSession session1=request.getSession();
        session1.setAttribute("itemList", itemList);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		doGet(request, response);
		/*1ItemDAO idao=new ItemDAO();
		ArrayList<Item> itemList=idao.itemList();
		
		request.setAttribute("itemList", itemList);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/FirstWebApp/displayItems.jsp");
        dispatcher.forward(request, response);*/
	}

}