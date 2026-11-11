package cr.ac.funeraria;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ServicioRepository extends JpaRepository<Servicio, Long> {

    @Query(value = "SELECT NVL(MAX(ID_SERVICIO),0)+1 FROM FIDE_SERVICIOS_TB", nativeQuery = true)
    Long siguienteId();

}
