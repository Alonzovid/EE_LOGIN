<%-- 
    Document   : login
    Created on : 2/09/2016, 08:38:24 PM
    Author     : dajua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="js/jquery.min.js"></script>
        <script src="js/main.js"></script>
        <title>Login</title>
        
    </head>
    <body>
        <h1>Iniciar Sesion</h1>
        <form name="form1" id="frm-login" action="iniciar_sesion" method="POST">
            <table border="1">
                
                <tbody>
                    <tr>
                        <td>Usuario: </td>
                        <td><input type="text" name="usuario" value="" id="usuario"/></td>
                    </tr>
                    <tr>
                        <td>Password:</td>
                        <td><input type="password" name="password" value="" id="password" /></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" value="Iniciar Sesion" name="btnIniciarSesion" id="btn-iniciar-sesion" /></td>
                    </tr>
                </tbody>
            </table>

        </form>
        
        
    </body>
</html>
