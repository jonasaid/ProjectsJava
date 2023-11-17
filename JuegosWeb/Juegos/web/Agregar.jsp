<%-- 
    Document   : Agregar
    Created on : 7/04/2019, 05:06:23 AM
    Author     : igomez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" type="image/x-icon" href="Images/dispositivo-de-juego.ico.png"/>
        <link rel="stylesheet" href="css/estilos1.css"/>
        <title>Agregar</title>
        
    </head>
    <body>
    <div>
        <div>
            <form action="Agregar" method="POST">
                Nombre del juego: <input class="botones" type="text" name="nombre" placeholder="Aqui va el titulo del juego">
                <p>Descripcion:</p>
                <input class="botones" type="text" placeholder="Aqui va la descripcion" name="descripcion">
                <p>Link de la imagen:</p>
                <input class="botones" type="text" placeholder="Aqui va el link de tu imagen" name="link"> 
                <input type="submit" name="Entrar" id="Entrar" value="Entrar">
            </form>
        </div>
    </div>
    </body>
</html>
