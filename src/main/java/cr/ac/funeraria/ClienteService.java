package cr.ac.funeraria;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    private final ClienteRepository repo;

    public ClienteService(ClienteRepository repo) {
        this.repo = repo;
    }

    public List<Cliente> getClientes() {
        return repo.findAll();
    }

    public long getTotal() {
        return repo.count();
    }

    public boolean existeCedula(String cedula) {
        return repo.existsByCedula(cedula);
    }

    public void guardar(String cedula, String nombre, String telefono, String correo, String direccion) {
        repo.save(new Cliente(repo.siguienteId(), cedula, nombre, telefono, correo, direccion, "ACTIVO"));
    }

    public boolean existeId(Long id) {
        return repo.existsById(id);
    }
}
