package cat.itacademy.barcelonactiva.arisogorostizaga.toni.s05.t02.n01.fase01.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@PostMapping("/players")
	public ResponseEntity<?> crearJugador(@RequestBody Jugador jugador) {
		return ResponseEntity.status(HttpStatus.CREATED).body(jugadorService.crearJugador(jugador));
	}

}
