package com.am.servers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EvaluateRequest
 */
public class EvaluateRequest extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EvaluateRequest() 
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
		/*response.getWriter().append("Served at: ").append(request.getContextPath());
		int i1=request.getContentLength();
		String s1=request.getContentType();
		System.out.println(i1+s1);*/
		PrintWriter out=response.getWriter();
		out.print(request.getMethod());
		out.println("\n");
		out.print(request.getPathInfo());
		out.println("\n");
		out.println(request.getRequestURL());
		out.println("\n");
		out.println(request.getRequestURI());
		out.println("\n");
		out.println(request.getSession());
		out.println("\n");
		out.println(request.getSession(false));
		out.println("\n");
		out.println(request.getLocale());
		out.println("\n");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		doGet(request, response);
		System.out.println(request.getMethod());
	}

}
