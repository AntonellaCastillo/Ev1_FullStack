

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.castillo.antonella.model.Evento;
import com.castillo.antonella.service.EventoService;

import jakarta.validation.Valid;

public class EventoController 
{
    @RestController
    @RequestMapping("api/v1/eventos")

    public class EventoController
    {
        @Autowired
        private EventoService eventoService;

        @PostMapping 
        public ResponseEntity<String> postEvento(@valid @RequestBody Evento evento)
        {
            eventoService.create(evento);
            return ResponseEntity.ok("Evento agregado correctamente");

        }

        @GetMapping 
        public ResponseEntity<?> getEventos()
        {
            List<Evento> lista = eventoService.readAll();

            if(lista.isEmpty())
                {
                    return ResponseEntity.status(400).body("Recursos no encontrados");
                }
                return ResponseEntity.ok(lista);
        }   


        @GetMapping("/{id}")
        public ResponseEntity<?> getEventoById(@PathVariable int id)
        {   Evento evento = eventoService.readById(id);
            
            if (evento == null)
            {
                return ResponseEntity.status(400).body("Evento no encontrado");
            }
            return ResponseEntity.ok(evento);
            
        }
        
        @PutMapping("/{id}")

        public ReponseEntity<?> putEvento(@PathVariable int id, @Valid @RequestBody Evento evento)
        {
            Evento actualizado = eventoService.update(id, evento);

            if (actualizado == null)
            {
                return ResponseEntity.status(404).body("Evento no encontrado");
            }
            return ResponseEntity.ok(actualizado);
        }

        @DeleteMapping("/{id}")

        public ReponseEntity<?> deleteEvento(@PathVariable int id)
        {
            boolean eliminado = eventoService.delete(id);

            if (!eliminado)
            {
                return ResponseEntity.status(404).body("Evento no encontrado");
            }
            return ResponseEntity.ok("Evento eliminado correctamente");
        }

        @GetMapping("/tipo/{tipoEvento}")
        public ResponseEntity<?> getEventosPorTipo(@PathVariable String tipoEvento)
        {   List<Evento> lista = eventoService.readByTipo(tipoEvento);
            
            if (lista.isEmpty())
            {
                return ResponseEntity.status(400).body("No hay eventos de este tipo");
            }
            return ResponseEntity.ok(lita);
            
        }

        @GetMapping("/ordenar/fecha")
        public ResponseEntity<?> getEventosOrdenadosPorFecha(@PathVariable int id)
        {   List<Evento> lista = eventoService.orderByFecha();
            
            if (lista.isEmpty())
            {
                return ResponseEntity.status(400).body("No hay eventos registrados");
            }
            return ResponseEntity.ok(lista);
            
        }
    }   

}
