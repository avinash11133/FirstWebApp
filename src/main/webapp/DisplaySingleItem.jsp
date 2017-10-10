<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.am.Item" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Display Single Item</title>
</head>
<body>
<table>
<tr>
<th>Name</th>
<th>Quantity</th>
<th>Price</th>
<th>Percentage</th>
</tr>
<% Item item=(Item)(request.getAttribute("item"));%>
		<tr>
		<td><%=item.getName()%></td>
		<td><%=item.getQuantity()%></td>
		<td><%=item.getPrice()%></td>
		<td><%=item.getPercentage()%></td>
		</tr>
</table>
</body>
</html>