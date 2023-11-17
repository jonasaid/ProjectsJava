<%-- 
    Document   : Descipcion
    Created on : 7/04/2019, 01:28:48 AM
    Author     : igomez
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" type="image/x-icon" href="Images/dispositivo-de-juego.ico.png"/>
        <title>Descripcion</title>
    </head>
    <body>
        <div>
        <h1>${juego.nameJuego}</h1>
        <img src="${juego.link}" alt="Aparecera una imagen"/>
        <div class="descrip">
            ${juego.descripcion}
        </div>
        </div>
        <form action="actualizar" method="get">
            <input type="hidden" value="${juego.id}" name="id">
            <input type="submit" value="Actualizar informacion">
        </form>
        <br/>
        <form action="agregar-lista" method="post">
            <input type="hidden" value="${juego.id}" name="id">
            <input type="submit" value="Agregar a lista de preferidos">
        </form>
    </body>
</html>
