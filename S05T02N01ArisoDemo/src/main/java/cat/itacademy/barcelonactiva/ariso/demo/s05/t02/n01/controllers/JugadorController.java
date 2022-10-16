package cat.itacademy.barcelonactiva.ariso.demo.s05.t02.n01.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cat.itacademy.barcelonactiva.ariso.demo.s05.t02.n01.model.dto.JugadorDTO;
import cat.itacademy.barcelonactiva.ariso.demo.s05.t02.n01.model.services.JugadorService;

@RestController
@RequestMapping("/players")
public class JugadorController {

	@Autowired
	private JugadorService jugadorService;

	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping
	public ResponseEntity<JugadorDTO> crearJugador(@RequestBody JugadorDTO jugadorDTO) {

		return new ResponseEntity<>(jugadorService.crearJugador(jugadorDTO), HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<?> obtenerJugadores() {
		jugadorService.obtenerJugadoresPorcentaje();
		return new ResponseEntity<>(jugadorService.obtenerJugadoresPorcentaje(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<JugadorDTO> obtenerJugadorPorId(@PathVariable(name = "id") long id) {
		return ResponseEntity.ok(jugadorService.obtenerJugadorPorId(id));
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/{id}")
	public ResponseEntity<JugadorDTO> actualizarJugador(@RequestBody JugadorDTO jugadorDTO,
			@PathVariable(name = "id") long id) {
		JugadorDTO jugadorRespuesta = jugadorService.actualizarJugador(jugadorDTO, id);
		return new ResponseEntity<>(jugadorRespuesta, HttpStatus.OK);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/{id}")
	public ResponseEntity<String> eliminarJugador(@PathVariable(name = "id") long id) {
		jugadorService.eliminarJugador(id);

		return new ResponseEntity<>("Jugador eliminado.", HttpStatus.OK);
	}

}
