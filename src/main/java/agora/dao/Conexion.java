/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package agora.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author CAMILA
 */
public class Conexion {
    // URL de la base de datos (se conecta a localhost en el puerto 3306)
    private static final String URL = "jdbc:mysql://localhost:3306/evidencia";
    private static final String USUARIO = "root";
    private static final String CLAVE = "Lore#1107";

    // Método para obtener la conexión a la base de datos
    public static Connection getConnection() throws SQLException {
        try {
            // Se carga el controlador JDBC de MySQL de forma explícita
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
        }
        // Se establece y retorna la conexión
        return DriverManager.getConnection(URL, USUARIO, CLAVE);
    }
}
