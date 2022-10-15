package cat.itacademy.barcelonactiva.ariso.demo.s05.t02.n01.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cat.itacademy.barcelonactiva.ariso.demo.s05.t02.n01.model.domain.Jugador;
import cat.itacademy.barcelonactiva.ariso.demo.s05.t02.n01.model.services.JugadorService;

@RestController
@RequestMapping("/players")
public class JugadorController {

	@Autowired
	private JugadorService jugadorService;

	@PostMapping
	public ResponseEntity<?> crearJugador(@RequestBody Jugador jugador) {
		try {
			jugadorService.crearJugador(jugador);
			return new ResponseEntity<>("Jugador creado.", HttpStatus.CREATED);
		} catch (Exception ex) {
			return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> actualizarJugador(@RequestBody Jugador jugador, @PathVariable(name = "id") long id) {
		try {
			jugadorService.actualizarJugador(jugador, id);
			return new ResponseEntity<>("Jugador creado.", HttpStatus.CREATED);
		} catch (Exception ex) {
			return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

}
