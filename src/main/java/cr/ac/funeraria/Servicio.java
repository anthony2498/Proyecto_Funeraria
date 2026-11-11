package cr.ac.funeraria;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "FIDE_SERVICIOS_TB")
public class Servicio {

    @Id
    @Column(name = "ID_SERVICIO")
    private Long id;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Column(name = "PRECIO")
    private BigDecimal precio;
    @Column(name = "ESTADO")
    private String estado;

    public Servicio() {
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public String getEstado() {
        return estado;
    }
}
