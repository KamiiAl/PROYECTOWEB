/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package agora.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import agora.dao.modelo.UsuarioRevisor;
/**
 *
 * @author CAMILA
 */
public class UsuarioRevisorDAO {
    // Método que ya tenías para insertar un nuevo revisor
    public void insertarRevisor(UsuarioRevisor revisor) throws SQLException {
        String sql = "INSERT INTO usuario_revisor (nombre_completo_revisor, usuario_acceso) VALUES (?, ?)";

        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, revisor.getNombreCompletoRevisor());
            ps.setString(2, revisor.getUsuarioAcceso());
            ps.executeUpdate();
        }
    }

    /* Este método obtiene todos los revisores de la base de datos.
     * @return Una lista de objetos UsuarioRevisor.
     * @throws SQLException Si ocurre un error de acceso a la base de datos.
     */
    public List<UsuarioRevisor> listarRevisores() throws SQLException {
        // Se crea una lista para guardar los revisores que se obtengan
        List<UsuarioRevisor> revisores = new ArrayList<>();
        // Consulta SQL para seleccionar todos los revisores
        String sql = "SELECT id_revisor, nombre_completo_revisor, usuario_acceso FROM usuario_revisor";
        
        // Se usa try-with-resources para asegurar que los recursos se cierren automáticamente
        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            // Se recorre cada fila del resultado
            while (rs.next()) {
                // Se crea un nuevo objeto UsuarioRevisor
                UsuarioRevisor revisor = new UsuarioRevisor();
                // Se llenan los atributos del objeto con los datos de la fila actual
                revisor.setIdRevisor(rs.getInt("id_revisor"));
                revisor.setNombreCompletoRevisor(rs.getString("nombre_completo_revisor"));
                revisor.setUsuarioAcceso(rs.getString("usuario_acceso"));
                // Se agrega el objeto a la lista
                revisores.add(revisor);
            }
        }
        return revisores;
    }

    public int registrarUsuarioRevisor(UsuarioRevisor nuevoRevisor) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
