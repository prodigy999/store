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
            <table>
                <thead>
                    <tr>
                        <th width="150">Nom</th>
                        <th width="150">Quantité commandé</th>
                        <th width="150">Prix à l'unité</th>
                    </tr>
                </thead>
                <tbody>
                    <h1 style="text-align: center">Total panier : ${total} €</h1>
                    <c:forEach items="${articles}" var="article">
                            <tr>
                            <td style="text-align: center">${article.nom}</td>
                            <td style="text-align: center">${article.stock}</td>
                            <td style="text-align: center">${article.prix} €</td>
                            </tr>
                    </c:forEach>
                </tbody>
            </table>
            <form method="post">
                <input type="submit" value="Valider la commande">
            </form>
        </div>
        <div class="pied">
            <c:import url="_PIED.jsp"/>
        </div>
    </body>
</html>
