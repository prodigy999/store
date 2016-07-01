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
                        <th width="150">ID de la commande</th>
                        <th width="150">Date de la commande</th>
                        <th width="150">Client</th>
                        <th width="150">Etat de la commande</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${commandes}" var="commande">
                        <tr>
                            <td style="text-align: center">${commande.id}</td>
                            <td style="text-align: center">${commande.dateCommande}</td>
                            <td style="text-align: center">${commande.utilisateur.login}</td>
                            <td style="text-align: center">${commande.etat}</td>
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
