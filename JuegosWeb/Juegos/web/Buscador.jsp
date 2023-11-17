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
        <title>Buscador</title>
    </head>
    <body>
        <header>
            <div class="header-top">
                <form action="buscar" method="post">
                    <div class="navegacion">
                        <input type="search" placeholder="Buscar " name="nombre"/>
                    </div>
                </form>
            </div>
            <div class="buscar" >
                <table class="buscar-tabla">
                    <c:forEach items="${juegos}" var="juego">
                        <tr>
                            <td>${juego.nameJuego}</td>
                            <td><input onclick="window.location='ver-juego?id=${juego.id}';" type="submit" value="Ver detalle"></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </header>
    </body>
</html>
