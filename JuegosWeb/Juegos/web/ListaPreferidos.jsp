<%-- 
    Document   : Buscador
    Created on : 7/04/2019, 12:22:35 AM
    Author     : igomez
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" type="image/x-icon" href="Images/dispositivo-de-juego.ico.png"/>
        <link rel="stylesheet" href="css/estilos2.css"/>
        <title>Lista Preferidos</title>
    </head>
    <body>
        <header>
            <div class="buscar" >
                <table class="buscar-tabla">
                    <c:forEach items="${juegos}" var="juego">
                        <tr>
                            <td>${juego.nameJuego}</td>
                            <td><input onclick="window.location='quitar?id=${juego.id}';" type="button" value="Quitar de lista"></td>
                        </tr>
                    </c:forEach>
                </table>
                <div><input class="botones" type="button" placeholder="Aqui va la descripcion" value="buscador" onclick="location.href='buscar'"/></div>
            </div>
        </header>
    </body>
</html>
