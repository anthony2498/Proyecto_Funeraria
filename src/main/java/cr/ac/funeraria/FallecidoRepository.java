package cr.ac.funeraria;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FallecidoRepository extends JpaRepository<Fallecido, Long> {

    @Query(value = "SELECT NVL(MAX(ID_FALLECIDO),0)+1 FROM FIDE_FALLECIDOS_TB", nativeQuery = true)
    Long siguienteId();

    boolean existsByCedula(String cedula);
}
