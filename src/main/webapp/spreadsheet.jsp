<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
    <meta charset="UTF-8">
    <title>Tarot spreadsheet</title>
</head>

<body>
<h1>Feuille de calcul Tarot </h1>
<c:forEach var="i" begin="1" end="${spreadsheet.nbPlayer}">
    <p>Joueur ${i}</p>
</c:forEach>

<form method="post" action="/addScore">

    <table>
        <tr>
            <td>
                Preneur
            </td>
            <td>
                <select name="joueur">
                    <c:forEach var="i" begin="1" end="${spreadsheet.nbPlayer}">
                        <option value="joueur${i}">${i}</option>
                    </c:forEach>
                </select>
            </td>

        </tr>
        <tr>
            <td> Appelé</td>
            <td><select name="appele">
                <c:forEach var="i" begin="1" end="${spreadsheet.nbPlayer}">
                    <option value="joueur${i}">${i}</option>
                </c:forEach>
            </select></td>
        </tr>
        <tr>
            <td>
                Points
            </td>
            <td>
            <td>
                <input type="text" name="point"/>
            </td>
            </td>
        </tr>
        <tr>
            <td>
                Nombre de bout
            </td>
            <td>
                <select name="nb_bout">
                    <option value="0">0</option>
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>Contrat</td>
            <td>
                <select name="contrat">
                    <option value="0">Prise</option>
                    <option value="1">Garde</option>
                    <option value="2">Garde sans</option>
                    <option value="3">Garde contre</option>
                </select>
            </td>
        <tr>
        <tr>
            <td>
                Petit au bout
            </td>
            <td>
                <select name="petit_au_bout">
                    <option value="none">Aucun</option>
                    <option value="attaque">Attaque</option>
                    <option value="defense">Defense</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>
                Poignée
            </td>
            <td>
                <select name="poignee">
                    <option value="0">Aucune</option>
                    <option value="1">Simple</option>
                    <option value="2">Double</option>
                    <option value="3">Triple</option>
                </select>
            </td>
            <td>
                <select name="poignee_equipe">
                    <option value="none">Aucune</option>
                    <option value="attaque">Attaque</option>
                    <option value="defense">Defense</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>
                Chelem
            </td>
            <td>
                <select name="chelem_equipe">
                    <option value="none">Aucune</option>
                    <option value="attaque">Attaque</option>
                    <option value="defense">Defense</option>
                </select>
            </td>
            <td>
                <select name="chelem_score">
                    <option value="callButNotDone">Annoncé mais non faite</option>
                    <option value="notCallButDone">Non annoncé et faite</option>
                    <option value="CallAndDone">Annoncé et faite</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>
                Misère
            </td>
            <td>
                <select name="misere_1">
                    <option value="0">Aucune</option>
                    <c:forEach var="i" begin="1" end="${spreadsheet.nbPlayer}">
                        <option value="joueur${i}">${i}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td>
                Misère
            </td>
            <td>
                <select name="misere_2">
                    <option value="0">Aucune</option>
                    <c:forEach var="i" begin="1" end="${spreadsheet.nbPlayer}">
                        <option value="joueur${i}">${i}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td>
                Misère
            </td>
            <td>
                <select name="misere_3">
                    <option value="0">Aucune</option>
                    <c:forEach var="i" begin="1" end="${spreadsheet.nbPlayer}">
                        <option value="joueur${i}">${i}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
    </table>

    <input type="submit" value="Create"/>
</form>
</body>

</html>
