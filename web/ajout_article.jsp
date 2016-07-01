<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <c:import url="_STYLESHEET.jsp"/>            
    </head>
    <body>
        <div class="titre">
            <c:import url="_TITRE.jsp"/>
        </div>
        <div class="menu">
            <c:import url="_MENU.jsp"/>
        </div>
        <div class="contenu">
            <h1>Ajouter article</h1>
            <form method="post">
                <label for="nom">Nom :</label>
                <input name="nom" type="text" width="150">
                <br />
                <br />
                <label for="stock">Quantité en stock :</label>
                <input name="stock" type="text" width="400">
                <br />
                <br />
                <label for="prix">Prix :</label>
                <input name="prix" type="text" width="150">
                <br />
                <br />
                <input type="submit">
            </form>
        </div>
        <div class="pied">
            <c:import url="_PIED.jsp"/>
        </div>
    </body>
</html>