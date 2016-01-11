<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
			<td> Appelé </td>
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
				Nombre d'atout
			</td>
			<td>
				<select name="nb_atout">
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
					<option value="prise">Prise</option>
					<option value="garde">Garde</option>
					<option value="garde_sans">Garde sans</option>
					<option value="garde_contre">Garde contre</option>
				</select>
			</td>
		<tr>
		<tr>
			<td>
				Petit au bout
			</td>
			<td>
				<select name="petit_au_bout">
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
					<option value="simple">Simple</option>
					<option value="doule">Double</option>
					<option value="triple">Triple</option>
				</select>
			</td>
			<td>
				<select name="poignee_equipe">
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
					<option value="attaque">Attaque</option>
					<option value="defense">Defense</option>
				</select>
			</td>
		</tr>

	</table>

    <input type="submit" value="Create"/>
</form>
</body>

</html>
