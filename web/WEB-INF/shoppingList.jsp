<%-- 
    Document   : shoppingList
    Created on : Apr 8, 2020, 1:27:12 PM
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
        Hello, ${username} <a href="ShoppingList?action=logout">Logout</a><br>
        <form method="POST">
            <h2>Items</h2>
            Add item: <input name="inputItem" type="text"/> <input type="submit" value="Add" formaction="ShoppingList?action=add">
            <table>
                <c:forEach var="oneItem" items="${items}">
                    <tr>
                        <td><input type="radio" value="${oneItem}" name="radioButton"/></td>
                        <td>${oneItem}</td>
                    </tr>
                </c:forEach>
                <c:if test="${items.size() > 0}">
                    <tr>
                        <td colspan="2"><input type="submit" value="Delete" formaction="ShoppingList?action=delete"</td>
                    </tr>
                </c:if>
            </table>
            <p>${message}</p>
        </form>
    </body>
</html>
