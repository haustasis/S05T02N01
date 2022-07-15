package cat.itacademy.barcelonactiva.arisogorostizaga.toni.s05.t02.n01.fase01.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cat.itacademy.barcelonactiva.arisogorostizaga.toni.s05.t02.n01.fase01.model.domain.Jugador;
import cat.itacademy.barcelonactiva.arisogorostizaga.toni.s05.t02.n01.fase01.model.services.JugadorService;

@RestController
@RequestMapping("/players")
public class JugadorController {
	
	@Autowired
	private JugadorService jugadorService;
	
	@PostMapping
    public ResponseEntity<?> crearJugador(@RequestBody Jugador jugador){

		return ResponseEntity.status(HttpStatus.CREATED)
				.body(jugadorService.crearJugador(jugadorService.existeixNomJugador(jugador)));
        
    }
	
	@GetMapping
	public List<Jugador> llistaJugadors() {
		return jugadorService.llistaJugadors();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> obtenirJugadorPerID(@PathVariable(value = "id") Integer id) {
		return ResponseEntity.status(HttpStatus.OK).body(jugadorService.obtenirJugadorPerID(id));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> modificarNomJugador(@RequestBody Jugador jugador, @PathVariable(value = "id") Integer id){
		Jugador jugadorPerModificar = jugadorService.obtenirJugadorPerID(id);
		
		if(jugadorPerModificar != null) {
			jugadorPerModificar.setNomJugador(jugador.getNomJugador());
			return ResponseEntity.status(HttpStatus.OK).body(jugadorService.modificarNomJugador(jugadorPerModificar));
		} else {
			return (ResponseEntity.status(HttpStatus.BAD_REQUEST)).body("Nom duplicat.");
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> eliminarJugadorPerID(@PathVariable("id") Integer id) {
		jugadorService.eliminarJugadorPerID(id);
		return new ResponseEntity<>("Jugador eliminat",HttpStatus.OK);
				
	}
	
	

}
