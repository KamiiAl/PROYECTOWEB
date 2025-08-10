/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package agora.dao.modelo;

/**
 *
 * @author CAMILA
 */
public class UsuarioRevisor {
    // Atributos de la clase que representan los campos de la tabla
    private int idRevisor;
    private String nombreCompletoRevisor;
    private String usuarioAcceso;
    private String tipoUsuario;
    
    // --- Constructor y métodos Getter y Setter ---

    // Constructor vacío (necesario para algunos frameworks)
    public int getIdRevisor() {
        return idRevisor;
    }

    public void setIdRevisor(int idRevisor) {
        this.idRevisor = idRevisor;
    }

    public String getNombreCompletoRevisor() {
        return nombreCompletoRevisor;
    }

    public void setNombreCompletoRevisor(String nombreCompletoRevisor) {
        this.nombreCompletoRevisor = nombreCompletoRevisor;
    }

    public String getUsuarioAcceso() {
        return usuarioAcceso;
    }

    public void setUsuarioAcceso(String usuarioAcceso) {
        this.usuarioAcceso = usuarioAcceso;
    }
    
    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
}