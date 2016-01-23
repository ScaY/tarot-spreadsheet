<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Tarot spreadsheet</title>
</head>

<body>
<h1>Create a Tarot spreadsheet</h1>

<form method="post" action="./createSpreadsheet">
    <table>
        <tr>
            <td>Nom</td>
            <td><input type="text" name="nom_feuille"/></td>
        </tr>
        <tr>
            <td>Nombre de joueur</td>
            <td><select name="nb_joueur">
                <option value="3">3</option>
                <option value="4">4</option>
                <option value="5">5</option>
            </select></td>
        </tr>
    </table>
    <input type="submit" value="Create"/>
</form>


<table>
    <c:forEach var="nameSpreadsheet" items="${listSpreadsheet.spreadsheetList}">
        <tr>
            <td>${nameSpreadsheet}</td>
            <td><a href="./">Edit</a></td>
            <td><a href="./">Delete</a></td>
        </tr>
    </c:forEach>
</table>

</body>

</html>
