<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<jsp:useBean id= "item" class= "com.am.Item" >  
</jsp:useBean>

<jsp:setProperty name="item" property="*"/>

<jsp:getProperty name="item" property= "id" /><br>
<jsp:getProperty name="item" property= "name" /><br>
<jsp:getProperty name="item" property= "quantity" /><br>
<jsp:getProperty name="item" property= "price" /><br>
<jsp:getProperty name="item" property= "percentage" />
</body>
</html>