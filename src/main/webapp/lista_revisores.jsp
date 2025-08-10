<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="agora.dao.modelo.UsuarioRevisor" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Revisores</title>
    <style>
        body { font-family: Arial, sans-serif; }
        table { width: 80%; border-collapse: collapse; margin-top: 20px; }
        th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }
        th { background-color: #f2f2f2; }
    </style>
</head>
<body>
    <h2>Usuarios Registrados</h2>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Nombre Completo</th>
                <th>Usuario de Acceso</th>
                <th>Tipo de Usuario</th>
            </tr>
        </thead>
        <tbody>
            <% 
            List<UsuarioRevisor> listaRevisores = (List<UsuarioRevisor>) request.getAttribute("listaRevisores");
            if (listaRevisores != null && !listaRevisores.isEmpty()) {
                for (UsuarioRevisor revisor : listaRevisores) {
            %>
            <tr>
                <td><%= revisor.getIdRevisor() %></td>
                <td><%= revisor.getNombreCompletoRevisor() %></td>
                <td><%= revisor.getUsuarioAcceso() %></td>
                <td><%= revisor.getTipoUsuario() %></td>
            </tr>
            <%
                }
            } else {
            %>
            <tr>
                <td colspan="4">No hay revisores registrados.</td>
            </tr>
            <%
            }
            %>
        </tbody>
    </table>
</body>
</html>
