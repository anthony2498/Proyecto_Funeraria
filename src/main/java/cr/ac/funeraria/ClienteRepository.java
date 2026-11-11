package cr.ac.funeraria;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Query(value = "SELECT NVL(MAX(ID_CLIENTE),0)+1 FROM FIDE_CLIENTES_TB", nativeQuery = true)
    Long siguienteId();

    boolean existsByCedula(String cedula);
}
