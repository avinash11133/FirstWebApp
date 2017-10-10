package com.am.servers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.am.Item;
import com.am.ItemDAO;
import com.am.LoginDAO;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() 
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		doGet(request, response);
		LoginDAO ldao=new LoginDAO();
		HashMap<String,String> idPwdMap=ldao.getIdPwdMap();
		String id=request.getParameter("userId");
		String pwd=request.getParameter("password");
		HttpSession session1;
		int flag=0;
		ItemDAO idao= new ItemDAO();
		RequestDispatcher dispatcher=null;
		
		for(Map.Entry<String, String> entry:idPwdMap.entrySet())
		{
			if(((entry.getKey()).equals(id))&&((entry.getValue()).equals(pwd)))
			{
				flag=1;
			}
		}
		
		if(flag==1)
		{
			ArrayList<Item> itemList=idao.itemList();
			session1=request.getSession(true);
			session1.setAttribute("itemList", itemList);
			dispatcher = getServletContext().getRequestDispatcher("/displayItems.jsp");
	        dispatcher.forward(request, response);
		}
		
		else
		{
        	dispatcher = getServletContext().getRequestDispatcher("/Error.jsp");
        	dispatcher.forward(request, response);
		}
	}
}