/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package agora.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import agora.dao.UsuarioRevisorDAO;
import agora.dao.modelo.UsuarioRevisor;

/**
 *
 * @author CAMILA
 */
// Se mapea este Servlet a la URL /listarRevisores
@WebServlet("/listarRevisores")
public class ListarRevisoresServlet extends HttpServlet {

    private UsuarioRevisorDAO usuarioRevisorDAO;

    // Este método se ejecuta cuando se inicializa el Servlet
    @Override
    public void init() {
        usuarioRevisorDAO = new UsuarioRevisorDAO();
    }

    // Este método maneja las peticiones GET (cuando se accede a la URL desde el navegador)

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Se usa el DAO para obtener la lista de todos los revisores de la base de datos
            List<UsuarioRevisor> listaRevisores = usuarioRevisorDAO.listarRevisores();
            // Se guarda la lista en el objeto request para que la página JSP la pueda usar
            request.setAttribute("listaRevisores", listaRevisores);
            // Se envía la solicitud a la página JSP para que muestre los datos
            request.getRequestDispatcher("lista_revisores.jsp").forward(request, response);
        } catch (SQLException e) {
// Si hay un error en la base de datos, se imprime en la consola y se muestra en la página
                        response.getWriter().println("Error al obtener la lista de revisores: " + e.getMessage());
        }
    }
}
