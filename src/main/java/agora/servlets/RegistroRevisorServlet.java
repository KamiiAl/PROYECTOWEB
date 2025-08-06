/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package agora.servlets;

import agora.dao.UsuarioRevisorDAO;
import agora.dao.modelo.UsuarioRevisor;
import java.io.IOException;
import java.sql.SQLException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author CAMILA
 */
@WebServlet("/registro-revisor")
public class RegistroRevisorServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombre = request.getParameter("nombre_completo_revisor");
        String usuario = request.getParameter("usuario_acceso");

        UsuarioRevisor nuevoRevisor = new UsuarioRevisor(nombre, usuario);
        UsuarioRevisorDAO revisorDAO = new UsuarioRevisorDAO();

        try {
            int idGenerado = revisorDAO.registrarUsuarioRevisor(nuevoRevisor);

            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().println("<h1>Revisor registrado con éxito!</h1>");
            response.getWriter().println("<p>ID del revisor: " + idGenerado + "</p>");
            response.getWriter().println("<a href='index.html'>Volver al formulario</a>");

        } catch (SQLException e) {
            response.getWriter().println("<h1>Error al registrar el revisor</h1>");
            response.getWriter().println("<p>Hubo un problema con la base de datos: " + e.getMessage() + "</p>");
        }
    }
}
