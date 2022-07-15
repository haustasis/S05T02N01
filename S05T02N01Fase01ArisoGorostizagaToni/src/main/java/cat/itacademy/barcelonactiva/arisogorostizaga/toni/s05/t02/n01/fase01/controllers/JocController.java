package cat.itacademy.barcelonactiva.arisogorostizaga.toni.s05.t02.n01.fase01.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cat.itacademy.barcelonactiva.arisogorostizaga.toni.s05.t02.n01.fase01.model.domain.Jugador;
import cat.itacademy.barcelonactiva.arisogorostizaga.toni.s05.t02.n01.fase01.model.services.JocService;
import cat.itacademy.barcelonactiva.arisogorostizaga.toni.s05.t02.n01.fase01.model.services.JugadorService;

@RestController
@RequestMapping("/players/{id}/games/")
public class JocController {
	
	@Autowired
	JocService jocService;
	
	@Autowired
	JugadorService jugadorService;
	
	@PostMapping
	 public ResponseEntity<?> crearJoc(@PathVariable(value="id") Integer idJugador) {
	      Jugador jugador= jugadorService.obtenirJugadorPerID(idJugador);
	       return ResponseEntity.status(HttpStatus.CREATED).body(jocService.tiradaDaus(jugador));
	   }
	

}
