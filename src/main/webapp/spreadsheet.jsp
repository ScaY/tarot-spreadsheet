<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <meta charset="UTF-8">
    <title>Tarot spreadsheet</title>
</head>

<body>
<h1>Tarot spreadsheet </h1>
    <c:forEach var="i" begin="1" end="${spreadsheet.nbPlayer}">
        <p>Player ${i}</p>
    </c:forEach>
</body>

</html>
