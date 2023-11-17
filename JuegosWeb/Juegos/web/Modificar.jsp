<%-- 
    Document   : Modificar
    Created on : 7/04/2019, 03:48:24 AM
    Author     : igomez
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" type="image/x-icon" href="Images/dispositivo-de-juego.ico.png"/>
        <link rel="stylesheet" href="css/estilos1.css"/>
        <title>Modificar</title>
    </head>
    <div>
        <form action="actualizar" method="post">
            <input type="hidden" value="${juego.id}" name="id">
            <h1>${juego.nameJuego}</h1>
            <p>Aqui va la descripcion:</p>
            <textarea rows="5" cols="150" id="botones" type="text" name="descripcion">${juego.descripcion}</textarea>
            <p>Link de la imagen:</p>
            <input id="botones" type="text" name="link" value="${juego.link}">
            <input type="submit" value="Actualizar informacion">
        </form>
    </div>
</html>
