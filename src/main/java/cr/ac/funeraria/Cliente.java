package cr.ac.funeraria;

import jakarta.persistence.*;

@Entity
@Table(name = "FIDE_CLIENTES_TB")
public class Cliente {

    @Id
    @Column(name = "ID_CLIENTE")
    private Long id;
    @Column(name = "CEDULA")
    private String cedula;
    @Column(name = "NOMBRE_COMPLETO")
    private String nombre;
    @Column(name = "TELEFONO")
    private String telefono;
    @Column(name = "CORREO")
    private String correo;
    @Column(name = "DIRECCION")
    private String direccion;
    @Column(name = "ESTADO")
    private String estado;

    public Cliente() {
    }

    public Cliente(Long id, String cedula, String nombre, String telefono, String correo, String direccion, String estado) {
        this.id = id;
        this.cedula = cedula;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public String getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getEstado() {
        return estado;
    }
}
