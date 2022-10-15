package cat.itacademy.barcelonactiva.ariso.demo.s05.t02.n01.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cat.itacademy.barcelonactiva.ariso.demo.s05.t02.n01.model.dto.JugadaDTO;
import cat.itacademy.barcelonactiva.ariso.demo.s05.t02.n01.model.services.JugadaService;

@RestController
@RequestMapping("/players")
public class JugadaController {

	@Autowired
	private JugadaService jugadaService;

	@PostMapping("/{jugadorId}/games")
	public ResponseEntity<JugadaDTO> crearJugada(@PathVariable(value = "jugadorId") long jugadorId,
			@RequestBody JugadaDTO jugadaDTO) {
		return new ResponseEntity<>(jugadaService.crearJugada(jugadorId, jugadaDTO), HttpStatus.CREATED);
	}

}
