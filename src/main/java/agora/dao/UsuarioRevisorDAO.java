/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package agora.dao;

import agora.dao.modelo.UsuarioRevisor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author CAMILA
 */
public class UsuarioRevisorDAO {
    private static final String INSERT_SQL = "INSERT INTO usuario_revisor (nombre_completo_revisor, usuario_acceso) VALUES (?, ?)";

    public int registrarUsuarioRevisor(UsuarioRevisor usuarioRevisor) throws SQLException {
        int idGenerado = -1;
        try (Connection conexion = Conexion.getConnection();
             PreparedStatement preparedStatement = conexion.prepareStatement(INSERT_SQL, PreparedStatement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, usuarioRevisor.getNombreCompletoRevisor());
            preparedStatement.setString(2, usuarioRevisor.getUsuarioAcceso());

            preparedStatement.executeUpdate();

            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                idGenerado = rs.getInt(1);
            }
        }
        return idGenerado;
    }
}
