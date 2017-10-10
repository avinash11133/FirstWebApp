<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Item</title>
</head>
<body>

<form action="/FirstWebApp/AddItem" method="post">
<table>
<tr><td>Item Id</td><td><input type="text" name="itemId"></td></tr>
<tr><td>Item Name</td><td><input type="text" name="itemName"></td></tr>
<tr><td>Item Quantity</td><td><input type="text" name="iQuantity" required></td></tr>
<tr><td>Item Price</td><td><input type="text" name="iPrice" required></td></tr>
<tr><td>Discount Percentage</td><td><input type="text" name="percentage" required></td></tr>
<tr><td><input type="submit" value="Add item"></td></tr>
</table>
</form>

</body>
</html>