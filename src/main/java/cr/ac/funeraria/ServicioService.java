package cr.ac.funeraria;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ServicioService {

    private final ServicioRepository repo;

    public ServicioService(ServicioRepository repo) {
        this.repo = repo;
    }

    public List<Servicio> getServicios() {
        return repo.findAll();
    }

    public long getTotal() {
        return repo.count();
    }
}
