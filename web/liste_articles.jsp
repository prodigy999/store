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
                        <th width="150">Quantité en stock</th>
                        <th width="150">Prix à l'unité</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${articles}" var="article">
                        <tr>
                            <td style="text-align: center">${article.nom}</td>
                            <td style="text-align: center">${article.stock}</td>
                            <td style="text-align: center">${article.prix} €</td>
                            <c:if test="${UtilConnecte.typeUtil=='CLIENT'}">
                                <td><a href="ajout_panier?idArticle=${article.id}">Ajouter au panier</a></td>
                            </c:if>
                            <c:if test="${UtilConnecte.typeUtil=='ADMIN'}">
                                <td><a href="ajout_panier?idArticle=${article.id}">Ajouter au panier</a></td>
                                <td><a href="ajout_stock?idArticle=${article.id}">Ajouter quantité en stock</a></td>
                            </c:if>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="pied">
            <c:import url="_PIED.jsp"/>
        </div>
    </body>
</html>
