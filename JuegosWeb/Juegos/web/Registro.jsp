
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" type="image/x-icon" href="Images/dispositivo-de-juego.ico.png"/>
        <link rel="stylesheet" href="css/estilos1.css"/>
        <script src="js/script1.js"></script> 
        <title>Registro</title>
    </head>
    <body>
            <div class="caja">
                <form action="registrar" method="post">
                <h2>Registro</h2>
                <p>Usuario: <input type="text" name="user" id="user"></p>
                <p>Contraseña: <input type="password" name="password" id="pass"></p>
                <p>Confirma tu contraseña: <input type="password" name="passconfirm" id="pass2"></p>
                <c:if test="${error}">
                    <label>Error en la contraseña</label>
                </c:if>
                <p><input type="submit" name="Entrar" id="Entrar" value="Registrar"></p>
                <input type="button" name="Iniciar Sesion" id="Sesion" value="Iniciar Sesion" onclick="location.href='iniciar-sesion'"/>
            </form>
            </div>
    </body>
</html>
