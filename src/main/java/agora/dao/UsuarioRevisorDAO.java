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

    // --- CÓDIGO MODIFICADO PARA INCLUIR tipo_usuario ---
    public void insertarRevisor(UsuarioRevisor revisor) throws SQLException {
        String sql = "INSERT INTO usuario_revisor (nombre_completo_revisor, usuario_acceso, tipo_usuario) VALUES (?, ?, ?)";

        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, revisor.getNombreCompletoRevisor());
            ps.setString(2, revisor.getUsuarioAcceso());
            ps.setString(3, revisor.getTipoUsuario());
            ps.executeUpdate();
        }
    }

    public List<UsuarioRevisor> listarRevisores() throws SQLException {
        List<UsuarioRevisor> revisores = new ArrayList<>();
        String sql = "SELECT id_revisor, nombre_completo_revisor, usuario_acceso, tipo_usuario FROM usuario_revisor";
        
        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                UsuarioRevisor revisor = new UsuarioRevisor();
                revisor.setIdRevisor(rs.getInt("id_revisor"));
                revisor.setNombreCompletoRevisor(rs.getString("nombre_completo_revisor"));
                revisor.setUsuarioAcceso(rs.getString("usuario_acceso"));
                revisor.setTipoUsuario(rs.getString("tipo_usuario"));
                revisores.add(revisor);
            }
        }
        return revisores;
    }
}