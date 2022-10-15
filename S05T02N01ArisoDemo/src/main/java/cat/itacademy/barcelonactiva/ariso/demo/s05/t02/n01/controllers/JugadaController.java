package cat.itacademy.barcelonactiva.ariso.demo.s05.t02.n01.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cat.itacademy.barcelonactiva.ariso.demo.s05.t02.n01.model.domain.Jugada;
import cat.itacademy.barcelonactiva.ariso.demo.s05.t02.n01.model.services.JugadaService;

@RestController
@RequestMapping("/players")
public class JugadaController {

	@Autowired
	private JugadaService jugadaService;

	@PostMapping("/{id}/games")
	public ResponseEntity<?> crearJugada(@RequestBody Jugada jugada, @PathVariable(value = "id") long id) {
		try {
			jugadaService.crearJugada(jugada, id);
			return new ResponseEntity<>("Jugada creada.", HttpStatus.CREATED);
		} catch (Exception ex) {
			return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	/*
	 * @PostMapping("/{id}/games") public ResponseEntity<?>
	 * jugar(@PathVariable(value = "id") long id) { try { jugadaService.jugar(id);
	 * return new ResponseEntity<>("Jugada creada.", HttpStatus.CREATED); } catch
	 * (Exception ex) { return new ResponseEntity<>(ex.getMessage(),
	 * HttpStatus.BAD_REQUEST); } }
	 */

}
