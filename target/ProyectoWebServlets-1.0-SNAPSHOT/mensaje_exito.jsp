<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Mensaje de Éxito</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 50px; }
        .mensaje-exito {
            color: green;
            font-weight: bold;
            font-size: 1.2em;
        }
    </style>
</head>
<body>
    <h2>¡Operación Exitosa!</h2>
    <p class="mensaje-exito"><%= request.getParameter("mensaje") %></p>
    <br>
    <a href="registrar_revisor.jsp">Volver al formulario de registro</a>
    <br>
    <a href="listarRevisores">Ver lista de revisores</a>
</body>
</html>