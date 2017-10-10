<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="com.am.Item" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List of items</title>
</head>
<body>
<table>
<tr>
<th>Id</th>
<th>Name</th>
<th>Quantity</th>
<th>Price</th>
<th>Percentage</th>
</tr>
<%--
	1ArrayList<Item> itemList=(ArrayList)(request.getAttribute("itemList"));
	for(Item item:itemList)
	{
		<tr>
		<td><%=item.getId()%></td>
		<td><%=item.getName()%></td>
		<td><%=item.getQuantity()%></td>
		<td><%=item.getPrice()%></td>
		<td><%=item.getPercentage()%></td>
		</tr>
    } --%>
<%	ArrayList<Item> itemList1=(ArrayList)(request.getSession().getAttribute("itemList"));
	for(Item item:itemList1)
	{%>
		<tr>
		<td><%=item.getId()%></td>
		<td><%=item.getName()%></td>
		<td><%=item.getQuantity()%></td>
		<td><%=item.getPrice()%></td>
		<td><%=item.getPercentage()%></td>
		</tr>
  <%}
	%>
</table>
</body>
</html>