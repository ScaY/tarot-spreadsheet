<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Tarot spreadsheet</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
          integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
            integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS"
            crossorigin="anonymous"></script>
</head>

<body>

<div class="box">
    <div class="row header">
        <h1>Tarot Spreadsheet</h1>
    </div>

    <div class="row content body">
        <div class="container">
            <div class="container-left">
                <form method="post" action="./createSpreadsheet">
                    <div class="form-group">
                        <label for="inputName">Nom</label>
                        <input type="text" class="form-control" name="nom_feuille" id="inputName" placeholder="Nom...">
                    </div>
                    <div class="form-group">
                        <label for="selectNbPlayer">Nombre de joeur</label>
                        <select name="nb_joueur" class="form-control" id="selectNbPlayer">
                            <option value="3">3</option>
                            <option value="4">4</option>
                            <option value="5">5</option>
                        </select>
                    </div>
                    <button type="submit" class="btn btn-default">Créer</button>
                </form>
            </div>
            <div class="container-right">
                <table class="table table-striped" >
                    <th>Name</th>
                    <th>Edit</th>
                    <th>Delete</th>
                    <c:forEach var="nameSpreadsheet" items="${listSpreadsheet.spreadsheetList}">
                        <tr>
                            <td>${nameSpreadsheet.value}</td>
                            <td><a href="./s/${nameSpreadsheet.key}">Edit</a></td>
                            <td><a href="./deleteSpreadsheet/${nameSpreadsheet.key}">Delete</a></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
</div>
</body>

</html>
<div>



