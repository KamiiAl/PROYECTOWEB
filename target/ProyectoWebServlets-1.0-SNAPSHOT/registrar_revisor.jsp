<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registrar Usuario</title>
</head>
<body>
    <h2>Formulario de Registro de Usuario</h2>

    <%-- Se muestra un mensaje de error si existe --%>
    <% String error = request.getParameter("error");
    if (error != null) { %>
        <p style="color: red;"><%= error %></p>
    <% } %>

    <form action="RegistrarRevisorServlet" method="post">
        <label for="nombreCompletoRevisor">Nombre Completo:</label><br>
        <input type="text" id="nombreCompletoRevisor" name="nombreCompletoRevisor" required><br><br>

        <label for="usuarioAcceso">Usuario de Acceso:</label><br>
        <input type="text" id="usuarioAcceso" name="usuarioAcceso" required><br><br>

        <label for="tipoUsuario">Tipo de Usuario:</label><br>
        <select id="tipoUsuario" name="tipoUsuario" required>
            <option value="">Seleccione...</option>
            <option value="Administrador">Administrador</option>
            <option value="Revisor">Revisor</option>
            <option value="Supervisor de campo">Supervisor de campo</option>
            <option value="Coordinador">Coordinador</option>
            <option value="Director">Director</option>
        </select><br><br>

        <input type="submit" value="Registrar Usuario">
    </form>
</body>
</html>