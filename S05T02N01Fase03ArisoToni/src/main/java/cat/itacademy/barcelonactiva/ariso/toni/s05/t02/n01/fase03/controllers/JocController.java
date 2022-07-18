package cat.itacademy.barcelonactiva.ariso.toni.s05.t02.n01.fase03.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cat.itacademy.barcelonactiva.ariso.toni.s05.t02.n01.fase03.model.domain.Jugador;
import cat.itacademy.barcelonactiva.ariso.toni.s05.t02.n01.fase03.model.services.JocService;
import cat.itacademy.barcelonactiva.ariso.toni.s05.t02.n01.fase03.model.services.JugadorService;

@RestController
@RequestMapping("/players/{id}/games/")
public class JocController {

	@Autowired
	JocService jocService;

	@Autowired
	JugadorService jugadorService;

	@PostMapping
	public ResponseEntity<?> crearJoc(@PathVariable(value = "id") Integer id) {
		Jugador jugador = jugadorService.obtenirJugadorPerID(id);
		return ResponseEntity.status(HttpStatus.CREATED).body(jocService.tiradaDaus(jugador));
	}

	@GetMapping
	public ResponseEntity<?> llistaJocsPerJugadorID(@PathVariable(value = "id") Integer id) {
		return ResponseEntity.status(HttpStatus.OK).body(jocService.llistaJocsPerJugadorID(id));
	}

	@DeleteMapping
	public ResponseEntity<?> eliminarJocs(@PathVariable(value = "id") Integer id) {
		Jugador jugador = jugadorService.obtenirJugadorPerID(id);
		jocService.eliminarJocs(jugador);
		return ResponseEntity.ok().build();
	}

}
