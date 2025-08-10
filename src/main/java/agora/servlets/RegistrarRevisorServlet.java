/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package agora.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import agora.dao.UsuarioRevisorDAO;
import agora.dao.modelo.UsuarioRevisor;

/**
 *
 * @author CAMILA
 */
@WebServlet("/RegistrarRevisorServlet")
public class RegistrarRevisorServlet extends HttpServlet {
    
    private UsuarioRevisorDAO usuarioRevisorDAO;

    @Override
    public void init() throws ServletException {
        usuarioRevisorDAO = new UsuarioRevisorDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nombreCompleto = request.getParameter("nombreCompletoRevisor");
        String usuarioAcceso = request.getParameter("usuarioAcceso");
        String tipoUsuario = request.getParameter("tipoUsuario");

        if (nombreCompleto == null || nombreCompleto.trim().isEmpty() ||
            usuarioAcceso == null || usuarioAcceso.trim().isEmpty() ||
            tipoUsuario == null || tipoUsuario.trim().isEmpty()) {
            
            response.sendRedirect("registrar_revisor.jsp?error=Campos obligatorios vacíos.");
            return;
        }

        try {
            UsuarioRevisor revisor = new UsuarioRevisor();
            revisor.setNombreCompletoRevisor(nombreCompleto);
            revisor.setUsuarioAcceso(usuarioAcceso);
            revisor.setTipoUsuario(tipoUsuario);

            usuarioRevisorDAO.insertarRevisor(revisor);

            response.sendRedirect("mensaje_exito.jsp?mensaje=Revisor registrado correctamente.");

        } catch (SQLException e) {
            response.sendRedirect("registrar_revisor.jsp?error=Error al registrar el revisor.");
        }
    }
}