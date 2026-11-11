package cr.ac.funeraria;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "FIDE_FALLECIDOS_TB")
public class Fallecido {

    @Id
    @Column(name = "ID_FALLECIDO")
    private Long id;
    @Column(name = "CEDULA")
    private String cedula;
    @Column(name = "NOMBRE_COMPLETO")
    private String nombre;
    @Column(name = "FECHA_DEFUNCION")
    private LocalDate fecha;
    @Column(name = "LUGAR_DEFUNCION")
    private String lugar;
    @Column(name = "CAUSA_DEFUNCION")
    private String causa;
    @Column(name = "ID_CLIENTE")
    private Long clienteId;

    public Fallecido() {
    }

    public Fallecido(Long id, String cedula, String nombre, LocalDate fecha, String lugar, String causa, Long clienteId) {
        this.id = id;
        this.cedula = cedula;
        this.nombre = nombre;
        this.fecha = fecha;
        this.lugar = lugar;
        this.causa = causa;
        this.clienteId = clienteId;
    }

    public Long getId() {
        return id;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public String getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String getLugar() {
        return lugar;
    }

    public String getCausa() {
        return causa;
    }
}
