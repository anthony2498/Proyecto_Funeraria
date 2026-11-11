package cr.ac.funeraria;

import java.util.List;
import java.time.LocalDate;
import org.springframework.stereotype.Service;

@Service
public class FallecidoService {

    private final FallecidoRepository repo;

    public FallecidoService(FallecidoRepository repo) {
        this.repo = repo;
    }

    public List<Fallecido> getFallecidos() {
        return repo.findAll();
    }

    public long getTotal() {
        return repo.count();
    }

    public boolean existeCedula(String cedula) {
        return repo.existsByCedula(cedula);
    }

    public void guardar(String cedula, String nombre, LocalDate fecha, String lugar, String causa, Long clienteId) {
        repo.save(new Fallecido(repo.siguienteId(), cedula, nombre, fecha, lugar, causa, clienteId));
    }
}
