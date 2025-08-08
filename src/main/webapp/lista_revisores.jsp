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
    <h2>Revisores Registrados</h2>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Nombre Completo</th>
                <th>Usuario de Acceso</th>
            </tr>
        </thead>
        <tbody>
            <% 
            // Se obtiene la lista de revisores que fue enviada por el Servlet
            List<UsuarioRevisor> listaRevisores = (List<UsuarioRevisor>) request.getAttribute("listaRevisores");
            // Se verifica si la lista tiene datos
            if (listaRevisores != null && !listaRevisores.isEmpty()) {
                // Se recorre la lista para crear una fila de la tabla por cada revisor
                for (UsuarioRevisor revisor : listaRevisores) {
            %>
            <tr>
                <td><%= revisor.getIdRevisor() %></td>
                <td><%= revisor.getNombreCompletoRevisor() %></td>
                <td><%= revisor.getUsuarioAcceso() %></td>
            </tr>
            <%
                }
            } else {
            %>
            <tr>
                <td colspan="3">No hay revisores registrados.</td>
            </tr>
            <%
            }
            %>
        </tbody>
    </table>
</body>
</html>
