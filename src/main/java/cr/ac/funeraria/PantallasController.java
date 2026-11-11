package cr.ac.funeraria;

import java.time.LocalDate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.format.annotation.DateTimeFormat;

@Controller
public class PantallasController {

    private final ClienteService clienteService;
    private final ServicioService servicioService;
    private final FallecidoService fallecidoService;

    public PantallasController(ClienteService clienteService, ServicioService servicioService, FallecidoService fallecidoService) {
        this.clienteService = clienteService;
        this.servicioService = servicioService;
        this.fallecidoService = fallecidoService;
    }

    private void datosBase(Model model, String pagina) {
        model.addAttribute("actual", pagina);
    }

    @GetMapping("/")
    public String inicio(Model model) {
        datosBase(model, "inicio");
        model.addAttribute("totalClientes", clienteService.getTotal());
        model.addAttribute("totalServicios", servicioService.getTotal());
        model.addAttribute("totalFallecidos", fallecidoService.getTotal());
        return "inicio";
    }

    @GetMapping("/clientes")
    public String clientes(Model model) {
        datosBase(model, "clientes");
        model.addAttribute("clientes", clienteService.getClientes());
        return "clientes";
    }

    @PostMapping("/clientes/guardar")
    public String guardarCliente(@RequestParam String cedula, @RequestParam String nombre, @RequestParam String telefono, @RequestParam(defaultValue = "") String correo, @RequestParam(defaultValue = "") String direccion, RedirectAttributes mensaje) {
        if (clienteService.existeCedula(cedula)) {
            mensaje.addFlashAttribute("error", "La cédula ya está registrada.");
            return "redirect:/clientes";
        }
        clienteService.guardar(cedula, nombre, telefono, correo, direccion);
        mensaje.addFlashAttribute("mensaje", "Cliente guardado en Oracle.");
        return "redirect:/clientes";
    }

    @GetMapping("/servicios")
    public String servicios(Model model) {
        datosBase(model, "servicios");
        model.addAttribute("servicios", servicioService.getServicios());
        return "servicios";
    }

    @GetMapping("/fallecidos")
    public String fallecidos(Model model) {
        datosBase(model, "fallecidos");
        model.addAttribute("fallecidos", fallecidoService.getFallecidos());
        model.addAttribute("clientes", clienteService.getClientes());
        return "fallecidos";
    }

    @PostMapping("/fallecidos/guardar")
    public String guardarFallecido(@RequestParam String cedula, @RequestParam String nombre, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha, @RequestParam(defaultValue = "") String lugar, @RequestParam(defaultValue = "") String causa, @RequestParam Long clienteId, RedirectAttributes mensaje) {
        if (fallecidoService.existeCedula(cedula)) {
            mensaje.addFlashAttribute("error", "La cédula ya está registrada.");
            return "redirect:/fallecidos";
        }
        if (!clienteService.existeId(clienteId)) {
            mensaje.addFlashAttribute("error", "El cliente seleccionado no existe.");
            return "redirect:/fallecidos";
        }
        fallecidoService.guardar(cedula, nombre, fecha, lugar, causa, clienteId);
        mensaje.addFlashAttribute("mensaje", "Fallecido guardado en Oracle.");
        return "redirect:/fallecidos";
    }
}
