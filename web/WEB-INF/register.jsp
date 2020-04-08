<%-- 
    Document   : register
    Created on : Apr 8, 2020, 1:27:00 PM
    Author     : 798794
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lab5</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <form method="POST" action="ShoppingList?action=register">
            Username: <input type="text" name="username" required/> 
            <input type="submit" value="Register name"/>
        </form>
    </body>
</html>
