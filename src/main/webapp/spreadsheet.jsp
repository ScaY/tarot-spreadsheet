<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>

<head>
    <meta charset="UTF-8">
    <title>Feuille de calcul Tarot</title>
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
        <h1>Feuille de calcul Tarot - <c:out value="${spreadsheet.name}"/></h1>
        <caption><a href="${pageContext.request.contextPath}/index.jsp">Home</a></caption>
    </div>

    <div class="row content body">
        <div class="container">
            <div class="container-left">
                <form method="post" action="${pageContext.request.contextPath}/addScore/${spreadsheet.token}">

                    <table class="formTarot">
                        <tr>
                            <td>
                                <label for="joueur_taken">Preneur</label>
                                <select name="joueur" class="form-control" id="joueur_taken">
                                    <c:forEach var="i" begin="1" end="${spreadsheet.nbPlayer}">
                                        <option value="${i}">${spreadsheet.players[i-1].name}</option>
                                    </c:forEach>
                                </select>
                            </td>
                            <td>
                                <label for="joueur_called">Appelé</label>
                                <select name="appele" class="form-control" id="joueur_called">
                                    <option value="-1">Aucun</option>
                                    <c:forEach var="i" begin="1" end="${spreadsheet.nbPlayer}">
                                        <option value="${i-1}">${spreadsheet.players[i-1].name}</option>
                                    </c:forEach>
                                </select>
                            </td>
                            <td>
                                <label for="point">Points</label>
                                <input type="text" class="form-control" name="point" id="point"
                                       placeholder="Points...">

                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="nb_bout"> Nombre de bouts</label>
                                <select name="nb_bout" class="form-control" id="nb_bout">
                                    <option value="0">0</option>
                                    <option value="1">1</option>
                                    <option value="2">2</option>
                                    <option value="3">3</option>
                                </select>
                            </td>
                            <td>
                                <label for="contrat">Contrat</label>
                                <select name="contrat" class="form-control" id="contrat">
                                    <option value="0">Prise</option>
                                    <option value="1">Garde</option>
                                    <option value="2">Garde sans</option>
                                    <option value="3">Garde contre</option>
                                </select>
                            </td>
                            <td>
                                <label for="petit_au_bout">Petit au bout</label>
                                <select name="petit_au_bout" class="form-control" id="petit_au_bout">
                                    <option value="none">Aucun</option>
                                    <option value="attaque">Attaque</option>
                                    <option value="defense">Defense</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="poignee">Poignée</label>
                                <select name="poignee" class="form-control" id="poignee">
                                    <option value="0">Aucune</option>
                                    <option value="1">Simple</option>
                                    <option value="2">Double</option>
                                    <option value="3">Triple</option>
                                </select>
                            </td>
                            <td>
                                <label for="poignee_equipe">Equipe</label>
                                <select name="poignee_equipe" class="form-control" id="poignee_equipe">
                                    <option value="none">Aucune</option>
                                    <option value="attaque">Attaque</option>
                                    <option value="defense">Defense</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="chelem_score">Chelem</label>
                                <select name="chelem_score" class="form-control" id="chelem_score">
                                    <option value="none">Aucun</option>
                                    <option value="callButNotDone">Annoncé mais non faite</option>
                                    <option value="notCallButDone">Non annoncé et faite</option>
                                    <option value="CallAndDone">Annoncé et faite</option>
                                </select>
                            </td>
                            <td>
                                <label for="chelem_equipe">Equipe</label>
                                <select name="chelem_equipe" class="form-control" id="chelem_equipe">
                                    <option value="none">Aucune</option>
                                    <option value="attaque">Attaque</option>
                                    <option value="defense">Defense</option>
                                </select>
                            </td>

                        </tr>
                    </table>

                    <button type="submit" id="add_score" class="btn btn-primary btn-lg btn-block">Ajouter</button>
                </form>
            </div>
            <div class="container-right">
                <table id="table_point" class="table table-striped">
                    <c:forEach var="player" items="${spreadsheet.players}">
                        <th>${player.name}</th>
                    </c:forEach>
                    <c:forEach var="i" begin="0" end="${fn:length(spreadsheet.players[0].scores)}">
                        <tr>
                            <c:forEach var="player" items="${spreadsheet.players}">
                                <td>${player.scores[i].point}</td>
                            </c:forEach>
                        </tr>
                    </c:forEach>
                    <tfoot>
                    <tr>
                        <c:forEach var="player" items="${spreadsheet.players}">
                            <td>${player.getTotalScore()}</td>
                        </c:forEach>
                    </tr>
                    </tfoot>
                </table>
            </div>
        </div>
    </div>
</div>
</body>

</html>
